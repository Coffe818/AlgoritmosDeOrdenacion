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
    }//end palabras comunes

    public static String AutocompletarPalabra(String dosletras) {
        for (String palabra : palabrasComunes) {
            if (palabra.startsWith(dosletras)) {
                return palabra;
            }//if para regresar la palabra si esta agregada
        }//end for para recorrer palabra por palabra que esten agregadas
        return null;
    }//end Autocompletar

    public static void main(String[] args) {
        palabrasComunes();

    
    }//end main
}//end class
