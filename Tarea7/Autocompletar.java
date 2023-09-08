package Tarea7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;;

public class Autocompletar {

    private static ArrayList<String> palabrasComunes = new ArrayList<>();

    public static String AutocompletarPalabra(String dosletras) {
        CargarDesdeArchivo();
        StringBuilder palabraCoinciden = new StringBuilder();
        for (String palabra : palabrasComunes) {
            if ((palabra.toLowerCase().startsWith(dosletras.toLowerCase()))) {
                palabraCoinciden.append(palabra).append("\n");
            } // if para regresar la palabra si esta agregada
        } // end for para recorrer palabra por palabra que esten agregadas
        return palabraCoinciden.toString();
    }// end Autocompletar

    public static void EscribirEnArchivo(String palabra) {//sirve para agregar palabras al txt para poser usarlas
        if (!palabra.trim().isEmpty()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("palabras.txt", true))) {
                writer.write(palabra);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }//evita lineas vacias
    }//end escribir en Archivo

    // Método para leer las palabras del archivo .txt y cargarlas en la lista
    public static void CargarDesdeArchivo() {// mete las palabras que esten en el txt al arraylist
        palabrasComunes.clear(); // borra todo y las vuelve a agregar con las nuevas para que asi la que ya
                                 // estaban no se dupliquen
        try (BufferedReader reader = new BufferedReader(new FileReader("palabras.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (!linea.trim().isEmpty()) { 
                    palabrasComunes.add(linea.trim());
                }// Verificar si la línea no está vacía
            }//while para que lea las lineas del txt
        } catch (IOException e) {
            e.printStackTrace();
        }
    }// end cargar dede archivo

    public static void ImprimirPalabrasDelArchivo() {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("palabras.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (!linea.trim().isEmpty()) { 
                    contenido.append(linea).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        JOptionPane.showMessageDialog(null, "Palabras en el archivo:\n" + contenido.toString());
    }
    

    public static void main(String[] args) {

        int opcion;

        do {
            
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "=======MENU AUTOCOMPLETAR ======="
                    + "\n1. Autocompletar \n2. Agregar palabra \n3.Imprimir palabras guardadas \n0. Salir"));
            switch (opcion) {
                case 1:
                    String primerosdos = JOptionPane.showInputDialog(null, "Ingrese dos letras para autocompletar: ");
                    JOptionPane.showMessageDialog(null, "Las palabras que empiezan con " + primerosdos + " son:\n"
                            + AutocompletarPalabra(primerosdos));
                    break;
                case 2:
                    String linea = JOptionPane.showInputDialog(null, "ingrese la palabra para agregar: ");
                    EscribirEnArchivo(linea);
                    break;
                case 3:
                    ImprimirPalabrasDelArchivo();
                    break;

                default:
                    break;
            }// end switch
        } while (opcion != 0);

    }// end main
}// end class
