package Tarea20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class OrdenamientoExterno {
    static String directorio = "C:\\Users\\New\\OneDrive - Universidad Autonoma de Coahuila\\Workspace 818\\Java\\Escuela\\AlgoritmosDeOrdenacion\\Tarea20\\A\\";
    static ArrayList<String> ArrayListnum = new ArrayList<>();
    static int cantidadNumeros = 2000000;
    static int cantidadArchivos = 1;
    static int total = cantidadArchivos * cantidadNumeros;

    public static void Crear() {

        int[] numeros = new int[total];

        // Llenar el array con números 
        for (int i = 0; i < total; i++) {
            numeros[i] = i + 1;
        } // end for

        // Mezclar los números en el array
        Random rnd = new Random();
        for (int i = numeros.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int temp = numeros[index];
            numeros[index] = numeros[i];
            numeros[i] = temp;
        } // end for

        // cantidad de archivos
        for (int i = 0; i < cantidadArchivos; i++) {
            String nombreArchivo = directorio + "Archivo" + (i + 1) + ".txt";

            try {
                BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo));

                // Escribir la cantidad de datos por archivo
                for (int j = i * cantidadNumeros; j < (i + 1) * cantidadNumeros; j++) {
                    escritor.write(Integer.toString(numeros[j]));
                    escritor.newLine();
                } // end for

                escritor.close();
                System.out.println("Archivo " + "Archivo" + (i + 1) + ".txt creado exitosamente.");
            } catch (IOException e) {
                System.out.println("Error al crear el archivo " + "Archivo" + (i + 1) + ".txt: " + e.getMessage());
            } // end trycatch
        } // end for
    }// end class

    public static void LlenarArray() {
        for (int i = 0; i < cantidadArchivos; i++) {
            String nombreArchivo = directorio + "Archivo" + (i + 1) + ".txt";

            try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
                String line;
                while ((line = br.readLine()) != null) {
                    ArrayListnum.add(line);
                } // agrega las palabras en el array
            } catch (IOException e) {
                e.printStackTrace();
            } // end try cathc
        } // end for

      //  System.out.println(ArrayListnum.toString());

        // pasa los numreo de arraylist<string> a un int array[]
        int[] ArrayNum = new int[ArrayListnum.size()];

        for (int i = 0; i < ArrayListnum.size(); i++) {
            ArrayNum[i] = Integer.parseInt(ArrayListnum.get(i));
        } // end for

        
        Ordanamiento.QuickSort(ArrayNum);
        System.out.println("fin");
    }// end Palabra random

    public static void BorrarArchivos() {
        for (int i = 0; i < cantidadArchivos; i++) {
            String nombreArchivo = directorio + "Archivo" + (i + 1) + ".txt";
            File archivo = new File(nombreArchivo);

            if (archivo.exists()) {
                if (archivo.delete()) {
                    System.out.println("Archivo " + "Archivo" + (i + 1) + " borrado exitosamente.");
                } else {
                    System.out.println("No se pudo borrar el archivo " + "Archivo" + (i + 1));
                }// edn if else
            } else {
                System.out.println("El archivo " + "Archivo" + (i + 1) + " no existe.");
            }// end if else
        }// end for
    }// end borrar archivo

    public static void main(String[] args) {
        //Crear();
        LlenarArray();
        //BorrarArchivos();
    }// end main

}// end class
