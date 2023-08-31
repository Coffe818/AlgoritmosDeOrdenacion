package Tarea4;

import Tarea1.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ArreglosString {

    static ArrayList<String> Nombres = new ArrayList<>();

    public static String ImprimirArray() {
        StringBuilder StringArray = new StringBuilder();
        for (int i = 0; i < Nombres.size(); i++) {
            int espacios = (Nombres.get(i).length()) - 55;
            StringArray.append(String.format("[%3d] %" + espacios + "s", i, Nombres.get(i)));
            // le da un espacio de 3 caracteres para poner a i, y le da 30 espacios para
            // poner al nombre
            if ((i + 1) % 2 == 0) {
                StringArray.append("\n");
            } // hace que de salto de linea cada 2 nombres, es decir hace dos columnas
        } // end for
        return StringArray.toString();

    }// end imprimir array

    public static void main(String[] args) {
        int opcion;
        String nombre = JOptionPane.showInputDialog(null, "Agrega un nombre: ").trim();
        Nombres.add(nombre);
        
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "=======MENU ARREGLOS STRING ======="
                    + "\n1. Agregar String\n2. Datos del Sting \n3. Convertir e Invertir \n4. Encriptamiento"));
            switch (opcion) {
                case 0:

                    break;
                case 1:
                    nombre = JOptionPane.showInputDialog(null, "Agrega un nombre: ").trim();
                    Nombres.add(nombre);
                    break;
                case 2:
                    int valor;
                    valor = Integer.parseInt(
                            JOptionPane.showInputDialog(null, "Seleccione un numero de la lista:\n" + ImprimirArray()));
                    String nom = Nombres.get(valor);
                    JOptionPane.showMessageDialog(null,
                            "======Datos del nombre=====\nNombre: " + nom + "\nLongitud del String: " + nom.length() + "\n" + CaracteresString.NumLetras(nom) + "\n"
                                    + CaracteresString.NumPalabras(nom));
                    break;
                case 3:

                    break;
                case 4:

                    break;
                default:
                    break;
            }// end switch

        } while (opcion != 0);

    }// end main
}// end class