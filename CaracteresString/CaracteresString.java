package CaracteresString;

import javax.swing.JOptionPane;

public class CaracteresString {
    String s = "";
    String[] palabras;
    int vocales = 0;
    int consonantes = 0;
    int digito = 0;
    int espacios = 0;
    int especial = 0;
    int totalLetras = 0;

    public static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }// regresa verdadero si el char que pide es una vocal, expetuando los acentos
     // porque no los se poner

    public void NumLetras(String s) {

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
    }// end NumLetras

    public void NumPalabras(String s) {
        palabras = s.trim().split("\\s+");
        // aquie se crea un arreglo en el cual se agrega el string "s.trim()", y el
        // ".split()", es para dividir el String "s" dependiedno el patron
        // y el "\\s+" es epra buscar espacios "\\s" y el "+" es para si se repite mas
        // de una ves
        JOptionPane.showMessageDialog(null, "El numeor de palabras que tiene es: " + palabras.length);
    }// end NumPalabras

    public void PalabrasVocal(String s) {
        vocales = 0;
        for (String palabras : palabras) {
            if (!palabras.isEmpty() && isVowel(palabras.charAt(0))) {
                vocales++;
            }
        }
        JOptionPane.showMessageDialog(null, "Palabras que inician con vocal: " + vocales);
    }// end palabrasVocal

    public static String InvertirCaracteres(String s) {
        StringBuilder reversa = new StringBuilder();// el StringBuilder "ayuda a crear cadenas de texto ams eficientes"
        for (int i = s.length() - 1; i >= 0; i--) {// for de reversa 
            reversa.append(s.charAt(i)); // el append es para agregar 
        } // end for
        return reversa.toString();
    }// end reverseString

    // METODOS PARA ENCRIPTAR Y DESENCRIPTAR EN CIFRADO CESAR
    int desplazar = 0;
    public static String Encriptar(String mensaje, int desplazar) {
        // Algoritmo de sustitución simple
        StringBuilder mensajeEncriptado = new StringBuilder();
        for (char c : mensaje.toCharArray()) {
            mensajeEncriptado.append((char) (c + desplazar)); // se desplaza esa cantidad de veces en la tabla ASCII
        }// end for para encriptar letra por letra despalzandoloas
        return mensajeEncriptado.toString();
    }

    public static String Desencriptar(String mensajeEncriptado, int desplazar) {
        // Desencriptar el mensaje usando el algoritmo inverso
        StringBuilder mensajeDesencriptado = new StringBuilder();
        for (char c : mensajeEncriptado.toCharArray()) {
            mensajeDesencriptado.append((char) (c - desplazar)); //  se desplaza esa cantidad de veces en la tabla ASCII
        }// end for para desencriptar letra por letra despalzandoloas
        return mensajeDesencriptado.toString();
    }

    public static void main(String[] args) {
        JOptionPane.showInputDialog(null, "Ingrese el String ");

    }// end main
}// end calss
