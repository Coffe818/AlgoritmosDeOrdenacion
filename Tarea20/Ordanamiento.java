package Tarea20;

import java.util.Arrays;
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

    public class QuickSort {
        static int comp = 0;
        static int mov = 0;

        public static void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int pi = Paricion(arr, low, high);
                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
            } // end if
        }// end quicksort

        private static int Paricion(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = (low - 1);
            for (int j = low; j < high; j++) {
                comp++; // Incrementa el contador de comparaciones
                if (arr[j] < pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    mov++; // Incrementa el contador de movimientos
                } // end fi
            } // end for
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;
            mov++; // Incrementa el contador de movimientos
            return i + 1;
        }// end particion
    }// end clas

    public static void QuickSort() {
        long startTime = System.nanoTime();
        StringBuilder text = new StringBuilder();

        int[] ArrayPrueba = new int[ArrayNumRan.length];
        System.arraycopy(ArrayNumRan, 0, ArrayPrueba, 0, tamano);

        QuickSort.quickSort(ArrayPrueba, 0, tamano - 1);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        text.append("Comparaciones: " + QuickSort.comp + "\n Movimientos: " + QuickSort.mov
                + "\nTiempo de ejecución (nanosegundos): "
                + duration);
        JOptionPane.showMessageDialog(null, text.toString());
    }// end quicksort de a devis

    public class BinSort {
        static int mov = 0;

        public static void binSort(int[] arr) {
            int max = Maximo(arr);
            int[] bins = new int[max + 1];

            for (int num : arr) {
                bins[num]++;
                mov++; // Incrementa el contador de movimientos
            } // end for

            int i = 0;
            for (int j = 0; j <= max; j++) {
                while (bins[j] > 0) {
                    arr[i++] = j;
                    bins[j]--;
                    mov++; // Incrementa el contador de movimientos
                } // end while
            } // end for
        }// end binsort

        private static int Maximo(int[] arr) {
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                } // end if
            } // end ofr
            return max;
        }// end Maximo
    }// end clas

    public static void BinSort() {
        long startTime = System.nanoTime();
        StringBuilder text = new StringBuilder();

        int[] ArrayPrueba = new int[ArrayNumRan.length];
        System.arraycopy(ArrayNumRan, 0, ArrayPrueba, 0, tamano);

        BinSort.binSort(ArrayPrueba);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        text.append("Comparaciones: "
                + "este metodo no hace comparaciones ya que utiliza un enfoque de conteo para ordenar los elementos"
                + "\n Movimientos: " + BinSort.mov
                + "\nTiempo de ejecución (nanosegundos): "
                + duration);
        JOptionPane.showMessageDialog(null, text.toString());
    }// end bin sort

    public class RadixSort {
        static int mov = 0;

        public static void radixSort(int[] arr) {
            int max = Maximo(arr);
            for (int exp = 1; max / exp > 0; exp *= 10) {
                contadorSort(arr, exp);
            } // end for
        }// end mai

        private static void contadorSort(int[] arr, int exp) {
            int n = arr.length;
            int[] output = new int[n];
            int[] count = new int[10];
            Arrays.fill(count, 0);

            for (int i = 0; i < n; i++) {
                count[(arr[i] / exp) % 10]++;
                mov++; // Incrementa el contador de movimientos
            } // end for

            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            } // end for

            for (int i = n - 1; i >= 0; i--) {
                output[count[(arr[i] / exp) % 10] - 1] = arr[i];
                count[(arr[i] / exp) % 10]--;
                mov++; // Incrementa el contador de movimientos
            } // end for

            System.arraycopy(output, 0, arr, 0, n);
        }// end contador sort

        private static int Maximo(int[] arr) {
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                } // end fi
            } // end for
            return max;
        }// end maximo
    }// end clas radix

    public static void Radix() {

        long startTime = System.nanoTime();
        StringBuilder text = new StringBuilder();

        int[] ArrayPrueba = new int[ArrayNumRan.length];
        System.arraycopy(ArrayNumRan, 0, ArrayPrueba, 0, tamano);

        RadixSort.radixSort(ArrayPrueba);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        text.append("Comparaciones: " + "No tiene comparaciones" + "\n Movimientos: " + RadixSort.mov
                + "\nTiempo de ejecución (nanosegundos): "
                + duration);
        JOptionPane.showMessageDialog(null, text.toString());

    }// end radix

    public class MergeSort {
        static int comp = 0;
        static int mov = 0;

        public static void mergeSort(int[] arr) {
            if (arr.length > 1) {
                int mid = arr.length / 2;
                int[] left = Arrays.copyOfRange(arr, 0, mid);
                int[] right = Arrays.copyOfRange(arr, mid, arr.length);

                mergeSort(left);
                mergeSort(right);

                merge(arr, left, right);
            } // end if
        }// end marge Sort

        private static void merge(int[] arr, int[] left, int[] right) {
            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                comp++; // Incrementa el contador de comparaciones
                if (left[i] <= right[j]) {
                    arr[k++] = left[i++];
                } else {
                    arr[k++] = right[j++];
                } // end if else
                mov++; // Incrementa el contador de movimientos
            } // end while
            while (i < left.length) {
                arr[k++] = left[i++];
                mov++; // Incrementa el contador de movimientos
            } // end while
            while (j < right.length) {
                arr[k++] = right[j++];
                mov++; // Incrementa el contador de movimientos
            } // end while
        }// end merge
    }// end clas MergeSort

    public static void MargeSort() {
        long startTime = System.nanoTime();
        StringBuilder text = new StringBuilder();

        int[] ArrayPrueba = new int[ArrayNumRan.length];
        System.arraycopy(ArrayNumRan, 0, ArrayPrueba, 0, tamano);

        MergeSort.mergeSort(ArrayPrueba);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        text.append("Comparaciones: " + MergeSort.comp + "\n Movimientos: " + MergeSort.mov
                + "\nTiempo de ejecución (nanosegundos): "
                + duration);
        JOptionPane.showMessageDialog(null, text.toString());
    }// end MargeSrot

    /*
      ImprimirArray(ArrayNumRan);
      System.out.println("====");
      ImprimirArray(ArrayPrueba);
     */
    public static void main(String[] args) {
        LlenarArray();
        // InsercionDirecta();
        // Seleccion();
        // Burbuja();
        // QuickSort();
        // BinSort();
        // Radix();
        MargeSort();
    }// end main
}// end class
