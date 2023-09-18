package Tarea9;

import javax.swing.JOptionPane;
import Tarea1.*;

public class Principal {
     public static void main(String[] args) {
        ArbolBinarioString arbol = new ArbolBinarioString();
        
        int opcion;
        String clave;
        do {
            clave = JOptionPane.showInputDialog("Ingrese la clave:");
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "====== MENU PRINCIPAL ======\n"
                    + "1. Alta de elemento\n"
                    + "2. Contar caracteres y palabras\n"
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
                    + "15. Encontrar frase escondida\n"
                    + "0. Salir\n"
                    + "Ingrese opción: \n"));

            switch (opcion) {
                case 1:
                    int nump = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de parrafo: "));
                    String texto = JOptionPane.showInputDialog(null, "Ingrese texto: ");
                    String textoEncriptado = EncriptacionJulioVerne.Encriptar(texto,clave);
                    arbol.AgregarNodo(nump, textoEncriptado);
                    break;
                case 2:
                    
                    break;
                case 3:
                    // Agregar código para cambiar texto de un párrafo
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
                    int numpEliminar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de parrafo a eliminar: "));
                    arbol.BajaFisica(numpEliminar);
                    break;
                case 10:
                  //  String textoBuscar = JOptionPane.showInputDialog(null, "Ingrese texto a buscar: ");
                    // Agregar código para buscar texto en los párrafos
                    break;
                case 11:
                    // Agregar código para convertir a mayúsculas
                    break;
                case 12:
                    // Agregar código para convertir a minúsculas
                    break;
                case 13:
                    // Agregar código para mostrar párrafos encriptados
                    break;
                case 14:
                    // Agregar código para desencriptar párrafos
                    break;
                case 15:
                    // Agregar código para encontrar frase escondida
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
                    break;
            }
        } while (opcion != 0);
    }
}
