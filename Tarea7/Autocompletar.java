package Tarea7;

import java.util.ArrayList;
import javax.swing.JOptionPane;;

public class Autocompletar {

    private static ArrayList<String> palabrasComunes = new ArrayList<>();

    public static void palabrasComunes() {
        palabrasComunes.add("hola");
        palabrasComunes.add("adios");
        palabrasComunes.add("gracias");
        palabrasComunes.add("por");
        palabrasComunes.add("favor");
    }// end palabras comunes

    public static String AutocompletarPalabra(String dosletras) {
        StringBuilder palabraCoinciden = new StringBuilder();
        for (String palabra : palabrasComunes) {
            if (palabra.startsWith(dosletras)) {
                palabraCoinciden.append(palabra);
            } // if para regresar la palabra si esta agregada
        } // end for para recorrer palabra por palabra que esten agregadas
        return palabraCoinciden.toString();
    }// end Autocompletar

    public static void main(String[] args) {
        palabrasComunes();
        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "=======MENU AUTOCOMPLETAR ======="
                    + "\n1. Autocompletar \n2. Agregar palabra \n0. Salir"));
            switch (opcion) {
                case 1:
                    String primerosdos = JOptionPane.showInputDialog(null, "Ingrese dos letras para autocompletar: ");
                    JOptionPane.showMessageDialog(null, "Las palabras que empiezan con " + primerosdos + " son:"
                            + AutocompletarPalabra(primerosdos));

                    break;
                case 2:
                    String linea = JOptionPane.showInputDialog(null, "ingrese la palabra para agregar: ");
                    palabrasComunes.add(linea);
                    break;

                default:
                    break;
            }// end switch
        } while (opcion != 0);

    }// end main
}// end class
