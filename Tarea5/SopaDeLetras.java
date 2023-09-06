package Tarea5;

public class SopaDeLetras {
    static String[][] ARRAY = new String[15][15];

    public static void AgregarHorizontal(String palabra, int filas, int columnas) {
        palabra.toUpperCase();
        for (int i = 0; i < palabra.length(); i++) {
            ARRAY[filas][columnas + i] = "" + palabra.charAt(i);
        } // agrega la palabra ne horizonal
    }// end agrega horizontal

    public static void AgregarVertical(String palabra, int filas, int columnas) {
        palabra.toUpperCase();
        for (int i = 0; i < palabra.length(); i++) {
            ARRAY[filas + i][columnas] = "" + palabra.charAt(i);
        } // agrega la palabra en vertical
    }// end agrega horizontal

    public static void AgregarDiagonal(String palabra, int filas, int columnas) {
        palabra.toUpperCase();
        for (int i = 0; i < palabra.length(); i++) {
            ARRAY[filas + i][columnas + i] = "" + palabra.charAt(i);
        } // agrega la palabra en vertical
    }// end agrega horizontal

    public static void ImprimirArray() {
        for (int i = 0; i < ARRAY.length; i++) {
            for (int j = 0; j < ARRAY[i].length; j++) {
                System.out.print(ARRAY[i][j] + " ");
            }
            System.out.println(); // Agrega una nueva línea después de imprimir una fila
        } // end for
    }// end imprimir array

    public static void main(String[] args) {
        String palabras = "Palabra";
        AgregarHorizontal(palabras, 0, 11);
        AgregarVertical(palabras, 0, 0);
        AgregarDiagonal(palabras, 0, 0);
        ImprimirArray();

    }// end main
}// end class