package Tarea4;

import Tarea1.*;
import java.util.ArrayList;
import java.util.List;

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

    public static void BuscarNombre(String nombre) {
        List<String> nombresEncontrados = new ArrayList<>();
        for (String nombreLista : Nombres) {
            if (nombreLista.equalsIgnoreCase(nombre)) { // Ignorar diferencias de mayúsculas y minúsculas
                nombresEncontrados.add(nombreLista);
            }//end if para agregar el nombre
        }//end for que recorre toda la lista, y los agreaga a nombreLista 

        if (nombresEncontrados.isEmpty()) {
            JOptionPane.showInputDialog(null, "No se encontraron nombres que coincidan con la búsqueda.");
        } else {
            System.out.println("Nombres encontrados que coinciden con la búsqueda:");
            for (String encontrado : nombresEncontrados) {
                JOptionPane.showInputDialog(null, encontrado);
            }//end for para imprimir los que encontro   
        }//end if para ver si esta vacia o no 
    }//end BuscarNombre

    public static void main(String[] args) {
        int opcion;
        String nombre;
        for (int i = 0; i < 10; i++) {
            nombre = JOptionPane.showInputDialog(null, "Agrega un nombre: ").trim();
            Nombres.add(nombre);
        }
        int valor;
        String num;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "=======MENU ARREGLOS STRING ======="
                    + "\n0.Salir \n1. Agregar String\n2. Datos del Sting \n3. Convertir e Invertir \n4. Encriptamiento \n5.Buscar nombre"
                    + "\n6. Nombres empiezan con x \n7  Nombres terminan con x\n8.  Nombres empieza con vocal"
                    + "\n9. Nombres empieza con consonante\n10. Nombre/Apellido "));
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
                    num = Nombres.get(valor);
                    JOptionPane.showMessageDialog(null,
                            "======Datos del nombre=====\nNombre: " + num + "\nLongitud del String: " + num.length()
                                    + "\n" + CaracteresString.NumLetras(num) + "\n"
                                    + CaracteresString.NumPalabras(num));
                    break;
                case 3:
                    valor = Integer.parseInt(
                            JOptionPane.showInputDialog(null, "Seleccione un numero de la lista:\n" + ImprimirArray()));
                    num = Nombres.get(valor);
                    JOptionPane.showMessageDialog(null,
                            "======Converir e Invertir=====\nNombre: " + num + "\nConverit Mayus: " + num.toUpperCase()
                                    + "\nConvertir Minus: " + num.toLowerCase() + "\n"
                                    + CaracteresString.PalabrasVocal(num)
                                    + "\nPalabra invertida: " + CaracteresString.InvertirCaracteres(num));
                    break;
                case 4:
                    valor = Integer.parseInt(
                            JOptionPane.showInputDialog(null, "Seleccione un numero de la lista:\n" + ImprimirArray()));
                    num = Nombres.get(valor);
                    String clave = JOptionPane.showInputDialog(null, "Ingrese una clave para encriptar");
                    String encriptadoCesar = CaracteresString.Encriptar(num, 5);
                    String desencriptadoCesar = CaracteresString.Desencriptar(encriptadoCesar, 5);
                    String mensajeEncriptado = EncriptacionJulioVerne.Encriptar(num, clave);
                    String mensajeDesencriptado = EncriptacionJulioVerne.Desencriptar(mensajeEncriptado, clave);

                    JOptionPane.showMessageDialog(null,
                            "======Encriptados y Desencriptados =====\nNombre: " + num + "\nMensaje ecnriptado: "
                                    + encriptadoCesar
                                    + "\nMensaje desncriptado: " + desencriptadoCesar + "\nEncriptado Julio Verne: "
                                    + mensajeEncriptado
                                    + "\nDesencriptado Julio Verne: " + mensajeDesencriptado);

                    break;
                case 5:
                    nombre = JOptionPane.showInputDialog(null, "Que nombre quieres buscar: ").trim();
                    BuscarNombre(nombre);
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;

                default:
                    break;
            }// end switch

        } while (opcion != 0);

    }// end main
}// end class