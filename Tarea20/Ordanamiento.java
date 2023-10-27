package Tarea20;

import java.util.Random;

import javax.swing.JOptionPane;

public class Ordanamiento {
    static int tamano = 50;
    static int[] ArrayNumRan = new int[tamano];

    public static boolean ContieneValor(int[] array, int valor) {
        for (int elemento : array) {
            if (elemento == valor) {
                return true;
            } // si tiene el dato
        } // en for que compara cada elemento
        return false;
    }// end contiene valr

    public static void LlenarArray() {
        Random random = new Random();
        for (int i = 0; i < ArrayNumRan.length; i++) {
            int numRandom = random.nextInt(tamano + 1);

            if (!ContieneValor(ArrayNumRan, numRandom)) {
                ArrayNumRan[i] = numRandom;
            } else {
                i--;
            } // si contiene el valor se regresa hasta que meta un valor que no este
        } // end for
    }// end llenar array

    public static void ImprimirArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " , ");
        } // end for
    }// end llenar array

    /*
     * PARA COPYAR UN ARRAY
     * public static void arraycopy(Object src, int srcPos, Object dest, int
     * destPos, int length)
     * 
     * src: es el array de origen del cual quieres copiar elementos.
     * srcPos: es la posición inicial en el array de origen desde donde se comenzará
     * a copiar.
     * dest: es el array de destino al cual se copiarán los elementos.
     * destPos: es la posición inicial en el array de destino donde se empezarán a
     * copiar los elementos.
     * length: es la cantidad de elementos que se copiarán.
     */

    public static void InsercionDirecta() {
        long startTime = System.nanoTime();
        StringBuilder text = new StringBuilder();

        int[] ArrayPrueba = new int[ArrayNumRan.length];
        System.arraycopy(ArrayNumRan, 0, ArrayPrueba, 0, tamano);

        int aux = 0, mov = 0, comp = 0;
        for (int i = 1; i < ArrayPrueba.length; i++) {
            aux = ArrayPrueba[i];// guarda el dato
            int j = i - 1;// le da la posicion anterior
            while ((j >= 0) && (aux < ArrayPrueba[j])) { // compara
                ArrayPrueba[j + 1] = ArrayPrueba[j];// mueve los datos
                j--;// se va a una posicion anterios para luego volver acomparar
                mov++;
                comp++;
            } // end while
            ArrayPrueba[j + 1] = aux;
            comp++;
            mov++;
        } // end for recorre todo el array

            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            text.append("Comparaciones: " + comp + "\n Movimientos: " + mov + "\nTiempo de ejecución (nanosegundos): "
                    + duration);
            JOptionPane.showMessageDialog(null, text.toString());
    }// end insercion directa

    public static void Seleccion() {
        long startTime = System.nanoTime();
        StringBuilder text = new StringBuilder();

        int[] ArrayPrueba = new int[ArrayNumRan.length];
        System.arraycopy(ArrayNumRan, 0, ArrayPrueba, 0, tamano);
        int comp = 0, mov = 0;

        for (int i = 0; i < ArrayPrueba.length - 1; i++) {
            int men = i;
            for (int j = i + 1; j < ArrayPrueba.length; j++) {

                if (ArrayPrueba[j] < ArrayPrueba[men]) {
                    men = j;
                } // revisa cual es el menor
            } // end for para ir viendo cual es el menot
            comp++;

            int aux = ArrayPrueba[i];
            ArrayPrueba[i] = ArrayPrueba[men];
            ArrayPrueba[men] = aux;
            mov++;
        } // for para recorrer hasta el penultimo

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        text.append("Comparaciones: " + comp + "\n Movimientos: " + mov + "\nTiempo de ejecución (nanosegundos): "
                + duration);
        JOptionPane.showMessageDialog(null, text.toString());
    }// end Seleccion

    public static void Burbuja() {
        long startTime = System.nanoTime();
        StringBuilder text = new StringBuilder();

        int[] ArrayPrueba = new int[ArrayNumRan.length];
        System.arraycopy(ArrayNumRan, 0, ArrayPrueba, 0, tamano);
        int comp = 0, mov = 0;
        for (int i = 0; i < ArrayPrueba.length; i++) {

            for (int j = 0; j < ArrayPrueba.length - 1; j++) {
                int elementoActual = ArrayPrueba[j];
                int elementoSiguiente = ArrayPrueba[j + 1];
                comp++;
                if (elementoActual > elementoSiguiente) {

                    ArrayPrueba[j] = elementoSiguiente;
                    ArrayPrueba[j + 1] = elementoActual;
                    mov++;
                } // end if para que el mayor valla " subiendo "
            } // end for paramover el elemento
        } // end for para recorrer todo el arreglo

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
       
        text.append("Comparaciones: " + comp + "\n Movimientos: " + mov + "\nTiempo de ejecución (nanosegundos): "
                + duration);
        JOptionPane.showMessageDialog(null, text.toString());
    }// end burbujas

    public static void main(String[] args) {
        LlenarArray();
        // InsercionDirecta();
        // Seleccion();
        //Burbuja();
    }// end main
}// end class
