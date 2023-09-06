package Tarea5;

import java.util.Random;
import java.util.Scanner;

public class SopaDeLetras {
    static String[][] ARRAY = new String[15][15];

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
                System.out.println("Error de NO espacio disponible en HORIZONTAL con palabra " + palabra);
            } // end if
        } else {
            System.out.println(
                    "Error de NO cabe en el array en HORIZONTAL por la posicion que se le dio en palabra" + palabra);
        } // end if
    }

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
                System.out.println("Error de NO espacio disponible en VERTICAL con palabra " + palabra);
            } // end if
        } else {
            System.out.println(
                    "Error de NO cabe en el array en VERTICAL por la posicion que se le dio en palabra" + palabra);
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
                System.out.println("Error de NO espacio disponible en DIAGONAL con palabra " + palabra);
            } // end if
        } else {
            System.out.println(
                    "Error de NO cabe en el array en DIAGONAL por la posicion que se le dio en palabra" + palabra);
        } // end if
    }

    public static void ImprimirArray() {
        for (int i = 0; i < ARRAY.length; i++) {
            for (int j = 0; j < ARRAY[i].length; j++) {
                System.out.print(ARRAY[i][j] + " ");
            }
            System.out.println(); // Agrega una nueva línea después de imprimir una fila
        } // end for
    }// end imprimir array

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            System.out.print("Ingresa una palabra: ");
            String palabra = scanner.nextLine();
            int maxRandom = 21 - palabra.length();
            int filaAleatoria = random.nextInt(maxRandom);
            int columnaAleatoria = random.nextInt(maxRandom);
            int opcionAleatoria = random.nextInt(3);

            if (opcionAleatoria == 0) {
                AgregarHorizontal(palabra, filaAleatoria, columnaAleatoria);
            } else if (opcionAleatoria == 1) {
                AgregarVertical(palabra, filaAleatoria, columnaAleatoria);
            } else {
                AgregarDiagonal(palabra, filaAleatoria, columnaAleatoria);
            }
        }
        scanner.close();
        ImprimirArray();
    }// end main
}// end class