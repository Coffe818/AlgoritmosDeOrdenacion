package Tarea15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.JOptionPane;

import Tarea1.CaracteresString;

public class FrasesString {

   public static String PalabraRandom() {
      ArrayList<String> words = new ArrayList<>();

      try (BufferedReader br = new BufferedReader(new FileReader(
            "Tarea15/Frses.txt"))) {
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

   public static void main(String[] args) {
      int opcion;

      do {
         opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "===== FREASES STRIN =====" +
               "\n1. Datos de frase random \n2. Recorridos \n3. Sonido"));

         switch (opcion) {
            case 1:
               String PalabraRandom = PalabraRandom();
            JOptionPane.showMessageDialog(null,PalabraRandom+"\n"+
                        CaracteresString.NumLetras(PalabraRandom) + "\n" + CaracteresString.NumPalabras(PalabraRandom));
               break;
            case 2:

               break;
            case 3:

               break;

            default:
               break;
         }
      } while (opcion != 0);

   }// end main
}// end class
