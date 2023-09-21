package Tarea10;

import javax.swing.JOptionPane;
import Tarea1.*;

public class Principal {
    static int opcion;
    static String clave = JOptionPane.showInputDialog("Ingrese la clave:");
    static boolean encriptado = true;
    static ArbolBinarioString arbol = new ArbolBinarioString();
    static String textoCompleto = "";

    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            int nump = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de parrafo: "));
            String texto = JOptionPane.showInputDialog(null, "Ingrese texto: ");
            String textoEncriptado = EncriptacionJulioVerne.Encriptar(texto, clave);
            arbol.AgregarNodo(nump, textoEncriptado);
        } // primero agregamos i nodos

        String menu1 = "====== MENU PRINCIPAL (ENCRIPTADOS)======\n"
                + "1. Alta de elemento\n"
                + "2. Contar caracteres y palabras \n"
                + "3. Cambiar texto de un párrafo\n"
                + "4. Recorrido INORDER\n"
                + "5. Recorrido PREORDER\n"
                + "6. Recorrido POSTORDER\n"
                + "7. Cantidad de nodos\n"
                + "8. Profundidad\n"
                + "9. Mostrar párrafos encriptados\n"
                + "10. Desencriptar párrafos\n"
                + "0. Salir\n";

        String menu2 = "====== MENU PRINCIPAL (DESENCRIPTADOS)======\n"
                + "1. Alta de elemento\n"
                + "2. Contar caracteres y palabras\n"
                + "3. Recorrido INORDER\n"
                + "4. Recorrido PREORDER\n"
                + "5. Recorrido POSTORDER\n"
                + "6. Cantidad de nodos\n"
                + "7. Profundidad\n"
                + "8. Eliminar nodo\n"
                + "9. Buscar texto\n"
                + "10. Convertir a mayúsculas\n"
                + "11. Convertir a minúsculas\n"
                + "12. Encriptar\n"
                + "13. Encontrar frase escondida\n"
                + "0. Salir\n"
                + "Ingrese opción: \n";

        do {
            textoCompleto = "";
            if (encriptado) {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu1));
                switchEncriptado(opcion);
            } else {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu2));
                switchDesencriptado(opcion);
            }

        } while (opcion != 0);
    }// end main

    public static void switchEncriptado(int op) {
        switch (op) {
            case 1:
                int nump = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de parrafo: "));
                String texto = JOptionPane.showInputDialog(null, "Ingrese texto: ");
                String textoEncriptado = EncriptacionJulioVerne.Encriptar(texto, clave);
                arbol.AgregarNodo(nump, textoEncriptado);
                break;
            case 2:
                textoCompleto = arbol.JuntarTexto(ArbolBinarioString.raiz);
                JOptionPane.showMessageDialog(null,
                        CaracteresString.NumLetras(textoCompleto) + "\n" + CaracteresString.NumPalabras(textoCompleto));
                break;
            case 3:
                int numpModificar = Integer
                        .parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de parrafo a modificar: "));
                String nuevoTexto = JOptionPane.showInputDialog(null, "Ingrese el nuevo texto: ");
                textoEncriptado = EncriptacionJulioVerne.Encriptar(nuevoTexto, clave);
                arbol.Modificar(numpModificar, textoEncriptado);
                break;
            case 4:
                arbol.ImprimirInOrder();
                break;
            case 5:
                arbol.ImprimirPreOrder();
                break;
            case 6:
                arbol.ImprimirPostOrder();
                break;
            case 7:
                int cantidadNodos = arbol.CantidadNodos(ArbolBinarioString.raiz);
                JOptionPane.showMessageDialog(null, "Cantidad de nodos: " + cantidadNodos);
                break;
            case 8:
                int profundidad = arbol.Profundidad(ArbolBinarioString.raiz);
                JOptionPane.showMessageDialog(null, "Profundidad del árbol: " + profundidad);
                break;
            case 9:
                arbol.ImprimirPreOrder();
                break;
            case 10:
                encriptado = false;
                arbol.Desencriptar(ArbolBinarioString.raiz, clave);
                break;
            case 0:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida");
                break;
        }// end switch
    }// end metodo

    public static void switchDesencriptado(int op) {
        switch (op) {
            case 1:
                int nump = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de parrafo: "));
                String texto = JOptionPane.showInputDialog(null, "Ingrese texto: ");
                String textoEncriptado = EncriptacionJulioVerne.Encriptar(texto, clave);
                arbol.AgregarNodo(nump, textoEncriptado);
                break;
            case 2:
                textoCompleto = arbol.JuntarTexto(ArbolBinarioString.raiz);
                JOptionPane.showMessageDialog(null,
                        CaracteresString.NumLetras(textoCompleto) + "\n" + CaracteresString.NumPalabras(textoCompleto));
                break;
            case 3:
                arbol.ImprimirInOrder();
                break;
            case 4:
                arbol.ImprimirPreOrder();
                break;
            case 5:
                arbol.ImprimirPostOrder();
                break;
            case 6:
                int cantidadNodos = arbol.CantidadNodos(ArbolBinarioString.raiz);
                JOptionPane.showMessageDialog(null, "Cantidad de nodos: " + cantidadNodos);
                break;
            case 7:
                int profundidad = arbol.Profundidad(ArbolBinarioString.raiz);
                JOptionPane.showMessageDialog(null, "Profundidad del árbol: " + profundidad);
                break;
            case 8:
                int numpEliminar = Integer
                        .parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de parrafo a eliminar: "));
                arbol.BajaFisica(numpEliminar);
                break;
            case 9:
                String text = JOptionPane.showInputDialog(null, "Ingrese texto a buscar: ");
                arbol.ImprimirBuscarPorTextoInOrder(text);
                break;
            case 10:
                arbol.ConvertirMayusculas(ArbolBinarioString.raiz);
                break;
            case 11:
                arbol.ConvertirMinusculas(ArbolBinarioString.raiz);
                break;
            case 12:
                encriptado = true;
                arbol.Encriptar(ArbolBinarioString.raiz, clave);
                break;
            case 13:
                JOptionPane.showMessageDialog(null,
                        "La palabra coulta del arbol es: " + arbol.PalaraOculta(ArbolBinarioString.raiz));
                break;
            case 0:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida");
                break;
        }// end switch
    }// end metodo

}// end class
