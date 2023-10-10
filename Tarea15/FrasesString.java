package Tarea15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.JOptionPane;

import Tarea1.CaracteresString;
import Tarea10.ArbolBinarioString;
import Tarea6.TextToSpeech;

public class FrasesString {
   static ArrayList<String> words = new ArrayList<>();
   static ArbolBinarioString arbol = new ArbolBinarioString();

   public static void AgregarDatos() {
      words.clear();
      try (BufferedReader br = new BufferedReader(new FileReader(
            "Tarea15/Frses.txt"))) {
         String line;
         while ((line = br.readLine()) != null) {
            words.add(line);
         } // agrega las palabras en el array
      } catch (IOException e) {
         e.printStackTrace();
      }
   }// end agregar datos

   public static String PalabraRandom() {
      AgregarDatos();
      Random rand = new Random();
      int randomIndex = rand.nextInt(words.size());
      // regrea una palabra aleatoria del arrau
      return words.get(randomIndex);
   }// end Palabra random

   public static void LimpiarARbol() {
      int nodos = arbol.CantidadNodos(ArbolBinarioString.raiz);
      for (int i = 0; i < nodos; i++) {
         arbol.BajaFisica(i);
      } // end for
   }// end Limpiar arbol

   public static void AgregarArbol() {
      AgregarDatos();
      LimpiarARbol();
      for (int i = 0; i < words.size(); i++) {
         arbol.AgregarNodo(i, words.get(i));
      }
   }

   public static void main(String[] args) {
      int opcion;

      do {
         opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "===== FRASES STRIN =====" +
               "\n1. Datos de frase random \n2. Recorridos \n3. Sonido\n0. Salir"));
         String PalabraRandom = PalabraRandom();
         switch (opcion) {
            case 1:

               JOptionPane.showMessageDialog(null, PalabraRandom + "\n" +
                     CaracteresString.NumLetras(PalabraRandom) + "\n" + CaracteresString.NumPalabras(PalabraRandom));
               // System.out.println(words.toString());
               break;
            case 2:
               AgregarArbol();
               int opcion2 = Integer.parseInt(JOptionPane.showInputDialog(null, "===== RECORIDOS =====" +
                     "\n1. INORDER \n2. PREORDER \n3. POSTORDER"));
               switch (opcion2) {
                  case 1:
                     arbol.ImprimirInOrder();
                     break;
                  case 2:
                     arbol.ImprimirPreOrder();
                     break;

                  case 3:
                     arbol.ImprimirPostOrder();
                     break;

                  default:
                     break;
               }// end swithc para los recorriods

               break;
            case 3:
            AgregarDatos();
            int opcion3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione el numero de la frase"));
            String frase = words.get(opcion3);
            TextToSpeech.Reproucir(frase);

               break;

            default:
               break;
         }
      } while (opcion != 0);

   }// end main
}// end class
