package Tarea14;

import Tarea12.JuegoAhorcado;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class JuegoAhorcadoTXT {

    public static String PalabraRandom(String eltxt) {
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(eltxt))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line);
            } // agrega las palabras en el array
        } catch (IOException e) {
            e.printStackTrace();
        }

        Random rand = new Random();
        int randomIndex = rand.nextInt(words.size());
        // regrea una palabra aleatoria del arrau
        return words.get(randomIndex);
    }// end Palabra random

    public static void Juego(String PalabraRandom) {
        JuegoAhorcado juego = new JuegoAhorcado(PalabraRandom);

        while (!juego.JuegoTerminado()) {
            String letraIngresada = JOptionPane.showInputDialog("Palabra actual: " + juego.ObtenerEstado() +
                    "\nIntentos restantes: " + juego.IntentosRestantes() +
                    "\nIngresa una letra:").toLowerCase();

            if (letraIngresada.length() == 1) {
                char letra = letraIngresada.charAt(0);

                if (Character.isLetter(letra)) {
                    if (!juego.AdivinarLetra(letra)) {// si regresa el false
                        JOptionPane.showMessageDialog(null, "Letra incorrecta.");
                    } // end if
                } else {
                    JOptionPane.showMessageDialog(null, "Ingresa una letra válida.");
                } // end if en caso de que nosea letra
            } else {
                JOptionPane.showMessageDialog(null, "Ingresa solo una letra.");
            } // end if en caso de que agregen mas de una letra
        } // while hasta que se termiene el juego

        if (juego.PalabraAdivinada()) {
            JOptionPane.showMessageDialog(null, "Ganaste: absolutamente nada");
        } else {
            JOptionPane.showMessageDialog(null, "Perdiste lero lero. La palabra era: " + PalabraRandom);
        } // end if para ganar o perder
    }

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("===== Ahorado ===== \n" +
                    "1. Animales\n2.Frutas\n3.Verduras\n4.NombrePersona\n0.Salir"));
            String PalabraRandom = "error";
            String filePath;
            switch (opcion) {
                case 1:
                    filePath ="C:\\Users\\New\\OneDrive - Universidad Autonoma de Coahuila\\Workspace 818\\Java\\Escuela\\AlgoritmosDeOrdenacion\\Ahorado\\Animales.txt" ; // Cambia esto por la ruta de tu archivo
                    PalabraRandom = PalabraRandom(filePath).toLowerCase();
                    Juego(PalabraRandom);

                    if (PalabraRandom != null) {
                        System.out.println("Palabra seleccionada al azar: " + PalabraRandom);
                    } else {
                        System.out.println("No se encontro el archivo.");
                    } // edn caso de que meta mal el archivo
                    break;
                case 2:
                    filePath = "C:\\Users\\New\\OneDrive - Universidad Autonoma de Coahuila\\Workspace 818\\Java\\Escuela\\AlgoritmosDeOrdenacion\\Ahorado\\Frutas.txt"; // Cambia esto por la ruta de tu archivo
                    PalabraRandom = PalabraRandom(filePath).toLowerCase();
                    Juego(PalabraRandom);

                    if (PalabraRandom != null) {
                        System.out.println("Palabra seleccionada al azar: " + PalabraRandom);
                    } else {
                        System.out.println("No se encontro el archivo.");
                    } // edn caso de que meta mal el archivo
                    break;
                case 3:
                    filePath = "C:\\Users\\New\\OneDrive - Universidad Autonoma de Coahuila\\Workspace 818\\Java\\Escuela\\AlgoritmosDeOrdenacion\\Ahorado\\Verduras.txt"; // Cambia esto por la ruta de tu archivo
                    PalabraRandom = PalabraRandom(filePath).toLowerCase();
                    Juego(PalabraRandom);

                    if (PalabraRandom != null) {
                        System.out.println("Palabra seleccionada al azar: " + PalabraRandom);
                    } else {
                        System.out.println("No se encontro el archivo.");
                    } // edn caso de que meta mal el archivo
                    break;
                case 4:
                    filePath = "C:\\Users\\New\\OneDrive - Universidad Autonoma de Coahuila\\Workspace 818\\Java\\Escuela\\AlgoritmosDeOrdenacion\\Ahorado\\NombrePersona.txt"; // Cambia esto por la ruta de tu archivo
                    PalabraRandom = PalabraRandom(filePath).toLowerCase();
                    Juego(PalabraRandom);

                    if (PalabraRandom != null) {
                        System.out.println("Palabra seleccionada al azar: " + PalabraRandom);
                    } else {
                        System.out.println("No se encontro el archivo.");
                    } // edn caso de que meta mal el archivo
                    break;
                case 0:

                    break;

                default:
                    break;
            }// end switch

        } while (opcion != 0);
    }// end main

}// end class
