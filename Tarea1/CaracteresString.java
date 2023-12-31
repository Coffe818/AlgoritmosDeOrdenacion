package Tarea1;

import javax.swing.JOptionPane;

public class CaracteresString {
    static String s = "";
    static String[] palabras;
    static int vocales = 0;
    static int consonantes = 0;
    static int digito = 0;
    static int espacios = 0;
    static int especial = 0;
    static int totalLetras = 0;

    public static boolean isVowel(char c) {
        return "aeiouAEIOUàèìòùÀÈÌÒÙäáéíóúÉ".indexOf(c) != -1;
    }// regresa verdadero si el char que pide es una vocal, expetuando los acentos
     // porque no los se poner

    public static String NumLetras(String s) {
        vocales = 0;
        consonantes = 0;
        digito = 0;
        espacios = 0;
        especial = 0;
        totalLetras = 0;

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {// primero ques ea letra
                if (isVowel(c)) {
                    vocales++;
                } else {
                    consonantes++;
                } // lugo si es vocal o consonante
            } else if (Character.isDigit(c)) {
                digito++;
            } else if (Character.isWhitespace(c)) {
                espacios++;
            } else {
                especial++;
            } // y sino es letra sera algun digito, sino es espacio, sino es especial

            totalLetras = vocales + consonantes;
        } // end for
        return "Numero de letras: " + totalLetras + "\nVocales: " + vocales + "\nConsonantes: " + consonantes
                + "\nDigitos: " + digito + "\nEspacios: "
                + espacios + "\nCar. Especiales: " + especial;
    }// end NumLetras

    public static String NumPalabras(String s) {
        palabras = s.trim().split("\\s+");
        // aquie se crea un arreglo en el cual se agrega el string "s.trim()", y el
        // ".split()", es para dividir el String "s" dependiedno el patron
        // y el "\\s+" es epra buscar espacios "\\s" y el "+" es para si se repite mas
        // de una ves
        return "Num de palabras: " + palabras.length;
    }// end NumPalabras

    public static String PalabrasVocal(String s) {
        vocales = 0;
        for (String palabras : palabras) {
            if (!palabras.isEmpty() && isVowel(palabras.charAt(0))) {
                vocales++;
            }
        }
        return "Palabras que inician con vocal: " + vocales;
    }// end palabrasVocal

    public static String InvertirCaracteres(String s) {
        StringBuilder reversa = new StringBuilder();// el StringBuilder "ayuda a crear cadenas de texto ams eficientes"
        for (int i = s.length() - 1; i >= 0; i--) {// for de reversa
            reversa.append(s.charAt(i)); // el append es para agregar
        } // end for
        return reversa.toString();
    }// end reverseString

    // METODOS PARA ENCRIPTAR Y DESENCRIPTAR EN CIFRADO CESAR
    static int desplazar = 5;

    public static String Encriptar(String mensaje, int desplazar) {
        // Algoritmo de sustitución simple
        StringBuilder mensajeEncriptado = new StringBuilder();
        for (char c : mensaje.toCharArray()) {
            mensajeEncriptado.append((char) (c + desplazar)); // se desplaza esa cantidad de veces en la tabla ASCII
        } // end for para encriptar letra por letra despalzandoloas
        return mensajeEncriptado.toString();
    }

    public static String Desencriptar(String mensajeEncriptado, int desplazar) {
        // Desencriptar el mensaje usando el algoritmo inverso
        StringBuilder mensajeDesencriptado = new StringBuilder();
        for (char c : mensajeEncriptado.toCharArray()) {
            mensajeDesencriptado.append((char) (c - desplazar)); // se desplaza esa cantidad de veces en la tabla ASCII
        } // end for para desencriptar letra por letra despalzandoloas
        return mensajeDesencriptado.toString();
    }

    public static void main(String[] args) {

        s = JOptionPane.showInputDialog(null, "Ingrese el String: ");
        String clave = JOptionPane.showInputDialog(null, "Ingrese clave: ");

        int opcion;
        do {
            String encriptado = Encriptar(s, desplazar);
            String mensajeEncriptado = EncriptacionJulioVerne.Encriptar(s, clave);
            String mensajeDesencriptado = EncriptacionJulioVerne.Desencriptar(mensajeEncriptado, clave);
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "=======MENU CARACTARES STRING ======="
                    + "\nString: " + s + "\nLongitud del String: " + s.length() + "\n" + NumLetras(s) + "\n"
                    + NumPalabras(s)
                    + "\nConverit Mayus: " + s.toUpperCase() + "\nConvertir Minus: " + s.toLowerCase() + "\n"
                    + PalabrasVocal(s)
                    + "\nPalabra invertida: " + InvertirCaracteres(s) + "\nMensaje ecnriptado: " + encriptado
                    + "\nMensaje desncriptado: " + Desencriptar(encriptado, desplazar) + "\nEncriptado Julio Verne: "
                    + mensajeEncriptado
                    + "\nDesencriptado Julio Verne: " + mensajeDesencriptado + "\n1. Cambiar String "
                    + "\n0. Salir"));
            switch (opcion) {
                case 0:

                    break;
                case 1:
                    s = JOptionPane.showInputDialog(null, "Ingrese nuevo String: ");
                    break;

                default:
                    break;
            }

        } while (opcion != 0);

    }// end mainF
}// end calss
