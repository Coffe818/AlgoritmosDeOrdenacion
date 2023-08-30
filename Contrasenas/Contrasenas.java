package Contrasenas;

import java.util.Random;

import javax.swing.JOptionPane;

public class Contrasenas {
    private static final String SPECIAL_CHARACTERS = "$#@.&!";
    static int calificacion = 0;
    static boolean mayus = false, minus = false, digitos = false, caracteres = false;

    public static void Calificar(boolean bolean) {
        if (bolean) {
            calificacion += 2;
        }
    }// end calificar

    public static String Resultado() {
        if (calificacion == 0) {
            return "Algo slaio mal 1";// la calificaion no puede ser 0
        } else if (calificacion == 2) {
            return "contasena incorrecta";
        } else if (calificacion == 4) {
            return "contasena debil";
        } else if (calificacion == 6) {
            return "contasena fuerte";
        } else if (calificacion == 8) {
            return "contasena muy fuerte";
        }
        return "Algo slaio mal 2";// la calificacion no puede tener algun otro valor
    }// end resultado

    public static void ValidarGeneral(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                mayus = true;
            } else if (Character.isLowerCase(c)) {
                minus = true;
            } else if (Character.isDigit(c)) {
                digitos = true;
            } else if (SPECIAL_CHARACTERS.contains(String.valueOf(c))) {
                caracteres = true;
            } // para ver si algun caracter este dentrod e la contrasena
        } // end for para comparar caracter por caracter
        Calificar(mayus);
        Calificar(minus);
        Calificar(digitos);
        Calificar(caracteres);
    }// end Validar

    public static String GenerarContrasena() {
        StringBuilder passwordBuilder = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < 14; i++) {// la contrasena sera de 14 caracteres
            int NumRandom = random.nextInt(4); // Genera un número aleatorio entre 0 y 3

            switch (NumRandom) {
                case 0: // Agregar letra minúscula
                    char lowercase = (char) (random.nextInt(26) + 'a');
                    passwordBuilder.append(lowercase);
                    break;
                case 1: // Agregar letra mayúscula
                    char uppercase = (char) (random.nextInt(26) + 'A');
                    passwordBuilder.append(uppercase);
                    break;
                case 2: // Agregar número
                    char digit = (char) (random.nextInt(10) + '0');
                    passwordBuilder.append(digit);
                    break;
                case 3: // Agregar caracter especial
                    char specialChar = SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length()));
                    passwordBuilder.append(specialChar);
                    break;
            }// end switch
        } // end for
        return passwordBuilder.toString();
    }// end GenerarContrasena

    public static void main(String[] args) {

        int opcion;
        String password;
        // Solicitar contraseña hasta que tenga el tamano correcto
        do {
            password = JOptionPane.showInputDialog(null, "Ingrese contraseña para validar:");
            password = password.trim(); // Recortar espacios en blanco al inicio y al final
        } while (password.length() < 8 || password.length() > 17);
        ValidarGeneral(password);
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "=======MENU VALIDAR CONTRASEÑAS ======="
                    + "\nContraseña: " + password + "\nCalificación: " + Resultado()
                    + "\n1. Cambiar Contraseña \n2. Crear Contraseña segura \n0. Salir"));

            switch (opcion) {
                case 0:
                    break;
                case 1:
                    do {
                        password = JOptionPane.showInputDialog(null, "Ingrese contraseña para validar:");
                        password = password.trim(); // Recortar espacios en blanco al inicio y al final
                    } while (password.length() < 8 || password.length() > 17);
                    ValidarGeneral(password);
                    break;
                case 2:
                    password = GenerarContrasena();
                    JOptionPane.showMessageDialog(null, "Contraseña segura generada: " + password);
                    ValidarGeneral(password);
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
    }// end main
}// end class
