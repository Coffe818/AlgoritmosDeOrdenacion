package EjercicioClase;

import java.util.*;

public class Ejercicio1 {
    static int[] arregloEnteros = new int[101];

    public static void LlenarArreglo() {
        for (int i = 0; i <= 100; i++) {
            arregloEnteros[i] = i;
        } // end for
    }// end llenar arrelgo

    public static TreeSet<Integer> CrearTreeSet(int[] arreglo) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < 15; i++) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(arreglo.length);
            treeSet.add(arregloEnteros[randomIndex]);
        }
        return treeSet;
    }// end crear treset

    public static LinkedHashSet<Integer> CrearLinkedHashSet(int[] arreglo) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i < 15; i++) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(arreglo.length);
            linkedHashSet.add(arregloEnteros[randomIndex]);
        }
        return linkedHashSet;
    }// end Crear linkedHashset

    public static void ImprimirElementos(String mensaje, int[] elementos) {
        System.out.println(mensaje);
        for (int num : elementos) {
            System.out.print(num + " ");
        } // va imprimiendo cada dato de un array
        System.out.println("\n");
    }// end imprimir elementeod del array

    public static void ImprimirElementos(String mensaje, Set<Integer> elementos) {
        System.out.println(mensaje);
        for (int num : elementos) {
            System.out.print(num + " ");
        } // va imprimiendo cada dato de un <Integer>
        System.out.println("\n");
    }// end Imprimir elemeto del set

    public static void UnionElementos(String mensaje, Set<Integer> elemetos1, Set<Integer> elemetos2) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int num : elemetos1) {
            treeSet.add(num);
        } // agrega lso elementod del elemento uno
        for (int num : elemetos2) {
            treeSet.add(num);
        } // agregar los elementos delelemeto dos

        System.out.println(mensaje);
        for (int num : treeSet) {
            System.out.print(num + " ");
        } // va imprimiendo cada dato de un <Integer>
        System.out.println("\n");
    }// end union elemets

    public static void InteseccionElementos(String mensaje, Set<Integer> elemetos1, Set<Integer> elemetos2) {
        System.out.println(mensaje);
        boolean vacio=true;
        for (Integer elemento : elemetos1) {
            if (elemetos2.contains(elemento)) {
                System.out.print(elemento +" ");
                vacio=false;
            }// end if para ver so coinciden
        }// end for para recorrer
        if(vacio){
            System.out.println("No hay inteseccion");
        }

    }// end interseccion elemtos

    public static void main(String[] args) {
        LlenarArreglo();
        TreeSet<Integer> treeSet = CrearTreeSet(arregloEnteros);
        LinkedHashSet<Integer> linkedHashSet = CrearLinkedHashSet(arregloEnteros);
        
        ImprimirElementos("Arreglo de entros:", arregloEnteros);
        ImprimirElementos("TreeSet:", treeSet);
        ImprimirElementos("LinkedHashSet:", linkedHashSet);
        UnionElementos("Union de los elements: ", treeSet, linkedHashSet);
        InteseccionElementos("Interseccion: ", treeSet, linkedHashSet);

    }// end main
}// end class
