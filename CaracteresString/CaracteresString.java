package CaracteresString;

import javax.swing.JOptionPane;

public class CaracteresString {
    static String s = "";

    public static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }// regresa verdadero si el char que pide es una vocal, expetuando los acentos
     // porque no los se poner

    public void NumLetras(String s) {
        int vocales = 0;
        int consonantes = 0;
        int digito = 0;
        int espacios = 0;
        int especial = 0;
        int totalLetras = 0;

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
            
            totalLetras=vocales+consonantes;
        }//end for
    }// end NumLetras

    public static void main(String[] args) {
        JOptionPane.showInputDialog(null, "Ingrese el String ");

    }// end main
}// end calss
