package Tarea20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

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

        System.out.println(ArrayListnum.toString());

        // pasa los numreo de arraylist<string> a un int array[]
        int[] ArrayNum = new int[ArrayListnum.size()];

        for (int i = 0; i < ArrayListnum.size(); i++) {
            ArrayNum[i] = Integer.parseInt(ArrayListnum.get(i));
        } // end for

        
        Ordanamiento.InsercionDirecta(ArrayNum);
    }// end Palabra random

    public static void InsercionDirecta(int[] array) {
        StringBuilder text = new StringBuilder();

        int[] ArrayPrueba = new int[array.length];
        System.arraycopy(array, 0, ArrayPrueba, 0, array.length);
        long startTime = System.currentTimeMillis();

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

        long endTime = System.currentTimeMillis();
        double duration = (endTime - startTime) / 1000.0;

        text.append("Comparaciones: " + comp + "\n Movimientos: " + mov + "\nTiempo de ejecución (segundos): "
                + duration);
        JOptionPane.showMessageDialog(null, text.toString());
    }// end insercion directa

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
