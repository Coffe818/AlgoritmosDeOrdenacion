package Tarea20;

import java.util.Random;
import javax.swing.JOptionPane;
import Tarea20.Ordanamiento.QuickSort;

public class Busqueda {

    static int tamano = 100;
    static int[] ArrayNumRan = new int[tamano];

    public static void LlenarArray() {

        Random random = new Random();
        for (int i = 0; i < tamano; i++) {
            int numRandom = random.nextInt(tamano);
            // no valida
            ArrayNumRan[i] = numRandom;
        } // end for
        System.out.println("termine ");
    }// end llenar array

    public static void ImprimirArray(int[] array) {
        System.out.println("\n");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " , ");
        } // end for
    }// end llenar array

    public static void busquedaSecuencialNoOrdenada(int[] datos, int valor) {
        int comparaciones = 0;
        for (int i = 0; i < datos.length; i++) {
            comparaciones++;
            if (datos[i] == valor) {
                JOptionPane.showMessageDialog(null, "El valor " + valor + " fue encontrado en la posición " + i
                        + "\n Comparaciones: " + comparaciones);
                return;
            } // end if
        } // end for
        JOptionPane.showMessageDialog(null,
                "El valor " + valor + " no fue encontrado" + "\n Comparaciones: " + comparaciones);

    }// end busqueda secuencial no ordenada

    public static void busquedaSecuencialOrdenada(int[] datos, int valor) {
        int comparaciones = 0;
        for (int i = 0; i < datos.length; i++) {
            comparaciones++;
            if (datos[i] == valor) {
                JOptionPane.showMessageDialog(null, "El valor " + valor + " fue encontrado en la posición " + i
                        + "\n Comparaciones: " + comparaciones);
                return;
            } else if (datos[i] > valor) {
                JOptionPane.showMessageDialog(null,
                        "El valor " + valor + " no fue encontrado" + "\n Comparaciones: " + comparaciones);
                return;
            } // end else if
        } // end for
        JOptionPane.showMessageDialog(null,
                "El valor " + valor + " no fue encontrado" + "\n Comparaciones: " + comparaciones);

    }// end busqueda secuancial ordenada

    public static void busquedaBinaria(int[] datos, int valor) {
        int comparaciones = 0;
        int inicio = 0;
        int fin = datos.length - 1;

        while (inicio <= fin) {
            comparaciones++;
            int medio = (inicio + fin) / 2;

            if (datos[medio] == valor) {
                JOptionPane.showMessageDialog(null, "El valor " + valor + " fue encontrado en la posición " + medio
                        + "\n Comparaciones: " + comparaciones);
                return;
            } // end if

            if (datos[medio] < valor) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            } // end if else
        } // end while

        JOptionPane.showMessageDialog(null,
                "El valor " + valor + " no fue encontrado" + "\n Comparaciones: " + comparaciones);

    }// end busqueda binaria

    public static void busquedaIndexada(int[] datos, int[] indice, int valor) {
        int comparaciones = 0;
        int indiceActual = -1;

        for (int i = 0; i < indice.length; i++) {
            comparaciones++;
            if (indice[i] == valor) {
                indiceActual = i;
                break;
            } // end if
        } // end for

        if (indiceActual != -1) {
            int posicionDato = indiceActual; 
            if (datos[posicionDato] == valor) {
                JOptionPane.showMessageDialog(null, "El valor " + valor + " fue encontrado en la posición "
                        + posicionDato + "\n Comparaciones: " + comparaciones);
                return;
            } // end if
        } // end if

        JOptionPane.showMessageDialog(null,
                "El valor " + valor + " no fue encontrado" + "\n Comparaciones: " + comparaciones);

    }// end busqueda indexada

    public static int[] QuickSort(int[] array) {

        int[] ArrayPrueba = new int[array.length];
        System.arraycopy(array, 0, ArrayPrueba, 0, array.length);

        QuickSort.quickSort(ArrayPrueba, 0, tamano - 1);

        return ArrayPrueba;
    }// end quicksort de a devis

    public static void main(String[] args) {

        LlenarArray();
        ImprimirArray(ArrayNumRan);
        int[] ArrarOrdenado = QuickSort(ArrayNumRan);
        ImprimirArray(ArrarOrdenado);

        int opcion;
        int valor;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "======= Busqueda =====\n" +
                    "1. BUSQUEDA SECUENCIAL CON DATOS NO ORDENADOS\n" +
                    "2. BUSQUEDS SECUENCIAL CON DATOS ORDENADOS\n" +
                    "3. BUSQUEDA BINARIA\n" +
                    "4. BUSQUEDA INDEXADA\n" +
                    "0. SALIR"));
            switch (opcion) {
                case 1:
                    valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Valor a buscar: "));
                    busquedaSecuencialNoOrdenada(ArrayNumRan, valor);
                    break;
                case 2:
                    valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Valor a buscar: "));
                    busquedaSecuencialOrdenada(ArrarOrdenado, valor);
                    break;
                case 3:
                    valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Valor a buscar: "));
                    busquedaBinaria(ArrarOrdenado, valor);
                    break;  
                case 4:
                    valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Valor a buscar: "));
                    busquedaIndexada(ArrayNumRan, ArrayNumRan, valor);
                    break;

                default:
                    break;
            }

        } while (opcion != 0);

    }// end main

}// end class
