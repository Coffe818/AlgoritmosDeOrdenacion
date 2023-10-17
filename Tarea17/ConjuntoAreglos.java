
package Tarea17;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import Tarea10.FormatoTabla;

public class ConjuntoAreglos {

    private static final String colores[] = { "rojo", "blanco", "azul", "verde", "gris", "naranja", "carne", "blanco",
            "cyan", "gris", "naranja", "rojo", "ROJO", "magenta", "Rojo" };

    static Set<String> HashSet = new HashSet<>();
    static Set<String> LinkedHashSet = new LinkedHashSet<>();
    static Set<String> TreeSet = new TreeSet<>();

    public static void Duplicados(Set<String> conjunto, String dato){
        if (conjunto.contains(dato)) {// en caso de tener ek dato no hace nada
            
        }else{// si no contiene el dato lo agrega 
            conjunto.add(dato);
        }// end if else
    }// end Duplicados

    public static void LLenar() {
        HashSet.clear();
        LinkedHashSet.clear();
        TreeSet.clear();
        for (int i = 0; i < colores.length; i++) {
            String dato = colores[i].toUpperCase();
            Duplicados(HashSet, dato);
            Duplicados(LinkedHashSet, dato);
            Duplicados(TreeSet, dato);
        } // end for
    }// end llenar

    public static void ImprimirJOption(Set<String> conjunto, String nombre) {
        FormatoTabla Ft = new FormatoTabla();
        Ft.AgregarColumnas(Ft.Columnas(nombre));
        for (String num : conjunto) {
            Ft.AgregarDatos(Ft.Datos(num));
        } // end for para agregar datos
        Ft.ImprimirTabla();
    }// end Imprimir en Joption pane

    public static void main(String[] args) {
        LLenar();
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "======= MENU ====="
                    + "\n1. Imprimir HashSet \n2. Imprimir LinkedHashSet\n3. Imprimir TreeSet"));

            switch (opcion) {
                case 1:
                    ImprimirJOption(HashSet, "HashSet");
                    break;
                case 2:
                    ImprimirJOption(LinkedHashSet, "LinkedHashSet");
                    break;
                case 3:
                    ImprimirJOption(TreeSet, "TreeSet");
                    break;

                default:
                    break;
            } //end switch
        } while (opcion != 0);

    }// end main
}// end class