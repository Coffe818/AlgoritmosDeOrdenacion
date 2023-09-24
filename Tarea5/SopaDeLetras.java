package Tarea5;

import Tarea1.*;
import java.util.Random;
import javax.swing.JOptionPane;

public class SopaDeLetras {
    static String[][] ARRAY = new String[20][20];
    static String[]palabrasArray = new String[5];
    static int filaAleatoria;
    static int columnaAleatoria;
    static Random random = new Random();

    public static void AgregarHorizontal(String palabra, int filas, int columnas) {
        palabra = palabra.toUpperCase();

        if (columnas + palabra.length() <= ARRAY.length) {// sirve para ver si la palabra si cabe o no
            boolean espacioDisponible = true;

            for (int i = 0; i < palabra.length(); i++) {
                if (ARRAY[filas][columnas + i] != null) {
                    espacioDisponible = false;
                    break;
                } // end if para ver si la celda esta disponible o no
            } // end for para recorrerse por las celdas

            if (espacioDisponible) {// sirve para ver si la el espacio esta ocupado
                for (int i = 0; i < palabra.length(); i++) {
                    ARRAY[filas][columnas + i] = "" + palabra.charAt(i);
                } // end for para agregar la palabra
            } else {

                filaAleatoria = random.nextInt(20);
                columnaAleatoria = random.nextInt(20);
                AgregarHorizontal(palabra, filaAleatoria, columnaAleatoria);
                // System.out.println("Error de NO espacio disponible en HORIZONTAL con palabra
                // " + palabra);
            } // end if
        } else {

            filaAleatoria = random.nextInt(20);
            columnaAleatoria = random.nextInt(20);
            AgregarHorizontal(palabra, filaAleatoria, columnaAleatoria);
            // System.out.println(
            // "Error de NO cabe en el array en HORIZONTAL por la posicion que se le dio en
            // palabra" + palabra);
        } // end if
    }// end agregar horizontal

    public static void AgregarVertical(String palabra, int filas, int columnas) {
        palabra = palabra.toUpperCase();

        if (filas + palabra.length() <= ARRAY.length) {
            boolean espacioDisponible = true;

            for (int i = 0; i < palabra.length(); i++) {// sirve para ver si la palabra si cabe o no
                if (ARRAY[filas + i][columnas] != null) {
                    espacioDisponible = false;
                    break;
                } // end if para ver si la celda esta disponible o no
            } // end for para recorrerse por las celdas

            if (espacioDisponible) {// sirve para ver si la el espacio esta ocupado
                for (int i = 0; i < palabra.length(); i++) {
                    ARRAY[filas + i][columnas] = "" + palabra.charAt(i);
                } // sirve para ver si la el espacio esta ocupado
            } else {

                filaAleatoria = random.nextInt(20);
                columnaAleatoria = random.nextInt(20);
                AgregarVertical(palabra, filaAleatoria, columnaAleatoria);
                // System.out.println("Error de NO espacio disponible en VERTICAL con palabra "
                // + palabra);
            } // end if
        } else {

            filaAleatoria = random.nextInt(20);
            columnaAleatoria = random.nextInt(20);
            AgregarVertical(palabra, filaAleatoria, columnaAleatoria);
            // System.out.println(
            // "Error de NO cabe en el array en VERTICAL por la posicion que se le dio en
            // palabra" + palabra);
        } // end if
    }

    public static void AgregarDiagonal(String palabra, int filas, int columnas) {
        palabra = palabra.toUpperCase();

        if (filas + palabra.length() <= ARRAY.length && columnas + palabra.length() <= ARRAY.length) {
            boolean espacioDisponible = true;

            for (int i = 0; i < palabra.length(); i++) {
                if (ARRAY[filas + i][columnas + i] != null) {// sirve para ver si la palabra si cabe o no
                    espacioDisponible = false;
                    break;
                } // end if para ver si la celda esta disponible o no
            } // end for para recorrerse por las celdas

            if (espacioDisponible) {// sirve para ver si la el espacio esta ocupado
                for (int i = 0; i < palabra.length(); i++) {
                    ARRAY[filas + i][columnas + i] = "" + palabra.charAt(i);
                } // sirve para ver si la el espacio esta ocupado
            } else {

                filaAleatoria = random.nextInt(20);
                columnaAleatoria = random.nextInt(20);
                AgregarDiagonal(palabra, filaAleatoria, columnaAleatoria);
                // System.out.println("Error de NO espacio disponible en DIAGONAL con palabra "
                // + palabra);
            } // end if
        } else {

            filaAleatoria = random.nextInt(20);
            columnaAleatoria = random.nextInt(20);
            AgregarDiagonal(palabra, filaAleatoria, columnaAleatoria);
            // System.out.println(
            // "Error de NO cabe en el array en DIAGONAL por la posicion que se le dio en
            // palabra" + palabra);
        } // end if
    }

    public static void ImprimirArray() {
        StringBuilder mensaje = new StringBuilder();
        for (int i = 0; i < ARRAY.length; i++) {
            for (int j = 0; j < ARRAY[i].length; j++) {
                if (ARRAY[i][j] == null) {
                    char randomLetter = (char) (random.nextInt(26) + 'A'); // Genera una letra aleatoria en mayúsculas
                    mensaje.append(randomLetter).append(" ");
                } else {
                    mensaje.append(ARRAY[i][j]).append(" ");
                }
            }
            mensaje.append("\n"); // Agrega una nueva línea después de imprimir una fila
        } // end for
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Tablero de Letras", JOptionPane.PLAIN_MESSAGE);
    }// end imprimir array

    public static void main(String[] args) {
       

        for (int i = 0; i < 2; i++) {
             String palabra = JOptionPane.showInputDialog("Ingresa una palabra:");
            palabrasArray[i]=palabra;
            filaAleatoria = random.nextInt(20);
            columnaAleatoria = random.nextInt(20);
            int opcionAleatoria = random.nextInt(3);
            int opcionAleatoria2 = random.nextInt(3) + 1;

            if (opcionAleatoria2 % 2 == 0) {// 1 de 3 para invertir la palabra
                palabra = CaracteresString.InvertirCaracteres(palabra);
            }

            if (opcionAleatoria == 0) {
                AgregarHorizontal(palabra, filaAleatoria, columnaAleatoria);
            } else if (opcionAleatoria == 1) {
                AgregarVertical(palabra, filaAleatoria, columnaAleatoria);
            } else {
                AgregarDiagonal(palabra, filaAleatoria, columnaAleatoria);
            } // end if que tambien puede ser con switch
        } // end por que pide las palabras
        

        ImprimirArray();
       
        
    }// end main
}// end class