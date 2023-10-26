package Tarea20;

import java.util.Random;

public class Ordanamiento {
    static int tamano = 10;
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
            int numRandom = random.nextInt(tamano );

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
        System.out.println("Comparaciones: " + comp + "\n Movimientos: " + mov + "\nArray original ");
        ImprimirArray(ArrayNumRan);
        System.out.println("\nArray original: ");
        ImprimirArray(ArrayPrueba);
    }// end insercion directa

    public static void main(String[] args) {
        LlenarArray();
        InsercionDirecta();
    }// end main
}// end class
