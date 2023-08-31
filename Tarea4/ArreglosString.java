package Tarea4;

import Tarea1.*;
import java.util.ArrayList;

import javax.print.DocFlavor.STRING;
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
        String nombre;
        for (int i = 0; i < 10; i++) {
            nombre = JOptionPane.showInputDialog(null, "Agrega un nombre: ").trim();
            Nombres.add(nombre);
        }
        int valor;
        String nom;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "=======MENU ARREGLOS STRING ======="
                    + "\n0.Salir \n1. Agregar String\n2. Datos del Sting \n3. Convertir e Invertir \n4. Encriptamiento"));
            switch (opcion) {
                case 0:

                    break;
                case 1:
                    nombre = JOptionPane.showInputDialog(null, "Agrega un nombre: ").trim();
                    Nombres.add(nombre);
                    break;
                case 2:
                    valor = Integer.parseInt(
                            JOptionPane.showInputDialog(null, "Seleccione un numero de la lista:\n" + ImprimirArray()));
                    nom = Nombres.get(valor);
                    JOptionPane.showMessageDialog(null,
                            "======Datos del nombre=====\nNombre: " + nom + "\nLongitud del String: " + nom.length()
                                    + "\n" + CaracteresString.NumLetras(nom) + "\n"
                                    + CaracteresString.NumPalabras(nom));
                    break;
                case 3:
                    valor = Integer.parseInt(
                            JOptionPane.showInputDialog(null, "Seleccione un numero de la lista:\n" + ImprimirArray()));
                    nom = Nombres.get(valor);
                    JOptionPane.showMessageDialog(null,
                            "======Converir e Invertir=====\nNombre: " + nom + "\nConverit Mayus: " + nom.toUpperCase()
                                    + "\nConvertir Minus: " + nom.toLowerCase() + "\n"
                                    + CaracteresString.PalabrasVocal(nom)
                                    + "\nPalabra invertida: " + CaracteresString.InvertirCaracteres(nom));
                    break;
                case 4:
                valor = Integer.parseInt(
                            JOptionPane.showInputDialog(null, "Seleccione un numero de la lista:\n" + ImprimirArray()));
                    nom = Nombres.get(valor);
                String clave=JOptionPane.showInputDialog(null, "Ingrese una clave para encriptar");
                String encriptadoCesar = CaracteresString.Encriptar(nom, 5);
                String desencriptadoCesar =CaracteresString.Desencriptar(encriptadoCesar, 5);
                String mensajeEncriptado = EncriptacionJulioVerne.Encriptar(nom, clave);
                String mensajeDesencriptado = EncriptacionJulioVerne.Desencriptar(mensajeEncriptado, clave);
                
                JOptionPane.showMessageDialog(null,
                            "======Encriptados y Desencriptados =====\nNombre: " + nom +"\nMensaje ecnriptado: " + encriptadoCesar
                            + "\nMensaje desncriptado: " + desencriptadoCesar + "\nEncriptado Julio Verne: "
                            + mensajeEncriptado
                            + "\nDesencriptado Julio Verne: " + mensajeDesencriptado);

                    break;
                default:
                    break;
            }// end switch

        } while (opcion != 0);

    }// end main
}// end class