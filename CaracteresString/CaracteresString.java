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
        vocales=0;
        for (String palabras : palabras) {
            if (!palabras.isEmpty() && isVowel(palabras.charAt(0))) {
                vocales++;
            }
        }
        System.out.println("Palabras que inician con vocal: " + vocales);
    }

    public static void main(String[] args) {
        JOptionPane.showInputDialog(null, "Ingrese el String ");

    }// end main
}// end calss
