package Contrasenas;

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

    public static void main(String[] args) {

        int opcion;
        do {
            String password;

            // Solicitar contraseña hasta que tenga el tamaño deseado
            do {
                password = JOptionPane.showInputDialog(null, "Ingrese contraseña para validar:");
                password = password.trim(); // Recortar espacios en blanco al inicio y al final
            } while (password.length() < 8 || password.length() > 17);

            ValidarGeneral(password);

            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "=======MENU VALIDAR CONTRASEÑAS ======="
                    + "\nContraseña: " + password + "\nCalificación: " + Resultado()
                    + "\n1. Cambiar Contraseña \n2. Crear Contraseña segura \n0. Salir"));

            switch (opcion) {
                case 0:
                    break;
                case 1:
                    password = JOptionPane.showInputDialog(null, "Ingrese contraseña para validar?");
                    password = password.trim(); // Recortar espacios en blanco al inicio y al final
                    ValidarGeneral(password);
                    break;
                case 2:
                    // Aquí irá el método para crear contraseña segura cuando lo tengas
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
    }// end main
}// end class
