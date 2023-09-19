package Tarea9;

import javax.swing.JOptionPane;
import Tarea1.*;

public class Principal {
    

    public static void main(String[] args) {
        ArbolBinarioString arbol = new ArbolBinarioString();

        int opcion;
        String clave;
        clave = JOptionPane.showInputDialog("Ingrese la clave:");
        do {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "====== MENU PRINCIPAL ======\n"
                    + "1. Alta de elemento\n"
                    + "2. Contar caracteres y palabras\n"//mejorar
                    + "3. Cambiar texto de un párrafo\n"
                    + "4. Recorrido INORDER\n"
                    + "5. Recorrido PREORDER\n"
                    + "6. Recorrido POSTORDER\n"
                    + "7. Cantidad de nodos\n"
                    + "8. Profundidad\n"
                    + "9. Eliminar nodo\n"
                    + "10. Buscar texto\n"
                    + "11. Convertir a mayúsculas\n"
                    + "12. Convertir a minúsculas\n"
                    + "13. Mostrar párrafos encriptados\n"
                    + "14. Desencriptar párrafos\n"
                    + "15. Encriptar"
                    + "16. Encontrar frase escondida\n"
                    + "0. Salir\n"
                    + "Ingrese opción: \n"));

            switch (opcion) {
                case 1:
                    int nump = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de parrafo: "));
                    String texto = JOptionPane.showInputDialog(null, "Ingrese texto: ");
                    String textoEncriptado = EncriptacionJulioVerne.Encriptar(texto, clave);
                    arbol.AgregarNodo(nump, textoEncriptado);
                    break;
                case 2:
                    String textoCompleto= arbol.JuntarTexto(ArbolBinarioString.raiz);
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
                    int numpEliminar = Integer
                            .parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de parrafo a eliminar: "));
                    arbol.BajaFisica(numpEliminar);
                    break;
                case 10:
                    String text = JOptionPane.showInputDialog(null, "Ingrese texto a buscar: ");
                    arbol.ImprimirBuscarPorTextoInOrder(text);
                    break;
                case 11:
                    arbol.ConvertirMayusculas(ArbolBinarioString.raiz);
                    break;
                case 12:
                    arbol.ConvertirMinusculas(ArbolBinarioString.raiz);
                    break;
                case 13:
                    arbol.ImprimirPreOrder();
                    break;
                case 14:
                    arbol.Desencriptar(ArbolBinarioString.raiz, clave);
                    break;
                case 15:
                    arbol.Encriptar(ArbolBinarioString.raiz, clave);
                    break;
                case 16:
                   JOptionPane.showMessageDialog(null, "La palabra coulta del arbol es: "+ arbol.PalaraOculta(ArbolBinarioString.raiz));
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
                    break;
            }//end switch
        } while (opcion != 0);
    }//end main
}//end class
