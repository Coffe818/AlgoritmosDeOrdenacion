package Tarea12;

import javax.swing.*;

public class JuegoAhorcado {
    private String palabraSecreta;
    private char[] ArrayLetras;
    private int intentosRestantes;

    public JuegoAhorcado(String palabraSecreta) {
        this.palabraSecreta = palabraSecreta;
        this.ArrayLetras = new char[palabraSecreta.length()];
        this.intentosRestantes = 2 * palabraSecreta.length();

        for (int i = 0; i < ArrayLetras.length; i++) {
            ArrayLetras[i] = '_';
        } // end for para llenar el array de _
    }// end constructor

    public boolean AdivinarLetra(char letra) {
        boolean letraAdivinada = false;

        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                ArrayLetras[i] = letra;//sustituye el "_" por la letra
                letraAdivinada = true;
            } // if para buscar la letra y regresar true si se encuentra
        } // end for para recorrer el array Letra

        if (!letraAdivinada) {
            intentosRestantes--;
        } // en caso de que no seste se resta a intentos

        return letraAdivinada;
    }// end Adivinar letra

    public boolean JuegoTerminado() {
        return intentosRestantes <= 0 || PalabraAdivinada();
    }// end Juego retmino en caso de que se acaben los intentos o se adivene la
     // palabra

    public boolean PalabraAdivinada() {
        return palabraSecreta.equals(String.valueOf(ArrayLetras));
    }// end palabra adivinda compara si la palabra es igual a todo lo que este en el
     // array

    public String ObtenerEstado() {
        
        return new String(ArrayLetras);
    }//end Obtener el Estado

    public int IntentosRestantes() {
        return intentosRestantes;
    }// intentos restantes

    public static void main(String[] args) {
        String palabraSecreta = JOptionPane.showInputDialog("Ingresa la palabra:").toLowerCase();

        JuegoAhorcado juego = new JuegoAhorcado(palabraSecreta);

        while (!juego.JuegoTerminado()) {
            String letraIngresada = JOptionPane.showInputDialog("Palabra actual: " + juego.ObtenerEstado() +
                    "\nIntentos restantes: " + juego.IntentosRestantes() +
                    "\nIngresa una letra:").toLowerCase();

            if (letraIngresada.length() == 1) {
                char letra = letraIngresada.charAt(0);

                if (Character.isLetter(letra)) {    
                    if (!juego.AdivinarLetra(letra)) {// si regresa el false
                        JOptionPane.showMessageDialog(null, "Letra incorrecta.");
                    } // end if
                } else {
                    JOptionPane.showMessageDialog(null, "Ingresa una letra válida.");
                } // end if en caso de que nosea letra
            } else {
                JOptionPane.showMessageDialog(null, "Ingresa solo una letra.");
            } // end if en caso de que agregen mas de una letra
        }// while hasta que se termiene el juego

        if (juego.PalabraAdivinada()) {
            JOptionPane.showMessageDialog(null, "Ganaste: absolutamentoe nada");
        } else {
            JOptionPane.showMessageDialog(null, "Perdiste lero lero. La palabra era: " + palabraSecreta);
        } // end if para ganar o perder

    }// end mmain
}// end class
