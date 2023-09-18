package Tarea9;

import javax.swing.JOptionPane;

//import javax.swing.JOptionPane;

/*todo esto me basare en el programa ya echo de Estructura llamado arbol binario,
  pero como lo quiero mas especifico, copiare y pegare los metodos,
  pero intentare dejarlos para luego poder usarlos en otros programas*/

public class ArbolBinarioString {
    static FormatoTabla FT = new FormatoTabla();

    public class Nodo {
        int numparrafo;
        String texto;
        char estatus;
        Nodo lchild;
        Nodo rchild;

        public Nodo(int np, String texto) {
            this.numparrafo = np;
            this.estatus = 'S';
            this.texto = texto;
            this.lchild = null;
            this.rchild = null;
        }//
    }// end clas nodo

    static Nodo raiz;
    Nodo NuevoNodo;

    public void AgregarNodo(int np, String texto) {
        NuevoNodo = new Nodo(np, texto);

        if (raiz == null) {
            raiz = NuevoNodo;
        } else {
            Nodo actual = raiz;
            Nodo padre;
            while (true) {
                padre = actual;
                if (np < actual.numparrafo) {
                    actual = actual.lchild;
                    if (actual == null) {
                        padre.lchild = NuevoNodo;
                        return;
                    } // end if para agregar el nodo
                } else {
                    actual = actual.rchild;
                    if (actual == null) {
                        padre.rchild = NuevoNodo;
                        return;
                    } // end if para agregar el nodo
                } // end if para agregar el nodo ya sea derecha o izquierda
            } // end while para saber a donde dirigirse
        } // end if else de raiz
    }// end Agregar Nodo

    public void BajaLogica(int nump) {
        Nodo actual = raiz;
        while (actual != null) {
            if (actual.numparrafo == nump) {
                actual.estatus = 'B';
                return;
            } else if (nump < actual.numparrafo) {
                actual = actual.lchild;
            } else {
                actual = actual.rchild;
            } // end if else que se recorre hasta encontrar el que queremos
        } // end while
    }// end Baja Logica

    private Nodo ObtenerSucesor(Nodo actual) {
        while (actual.lchild != null) {
            actual = actual.lchild;
        } // while para posicionar
        return actual;
    }// end Obtener Sucesor

    private Nodo Eliminar(Nodo actual, int nump) {// donde inicia , que nump eliminar
        if (actual == null) {
            return null;
        }

        if (nump == actual.numparrafo) {
            if (actual.lchild == null) {
                return actual.rchild;
            } else if (actual.rchild == null) {
                return actual.lchild;
            } else {
                Nodo sucesor = ObtenerSucesor(actual.rchild);
                actual.numparrafo = sucesor.numparrafo;
                actual.texto = sucesor.texto;
                actual.rchild = Eliminar(actual.rchild, sucesor.numparrafo);
                return actual;
            } // regresa actual que queremos eliminar
        } else if (nump < actual.numparrafo) {
            actual.lchild = Eliminar(actual.lchild, nump);
            return actual;
        } else {
            actual.rchild = Eliminar(actual.rchild, nump);
            return actual;
        } // recursividad hasta encontrar el nodo que queremos eliminar
    }// end Eliminar

    public void BajaFisica(int nump) {
        raiz = Eliminar(raiz, nump);
    }// Baja Fisica

    // RECORRIDOS//
    public void PreOrder(Nodo nodo) {
        if (nodo != null) {
            if (nodo.estatus != 'B') {
                FT.AgregarDatos(FT.Datos(nodo.numparrafo, nodo.texto));
            } // end if para agregar datos
            PreOrder(nodo.lchild);
            PreOrder(nodo.rchild);
        }
    }// end PreOrder

    public void InOrder(Nodo nodo) {
        if (nodo != null) {
            InOrder(nodo.lchild);
            if (nodo.estatus != 'B') {
                FT.AgregarDatos(FT.Datos(nodo.numparrafo, nodo.texto));
            } // end if para agregar datos
            InOrder(nodo.rchild);
        }
    }// end InOrder

    public void PostOrder(Nodo nodo) {
        if (nodo != null) {
            PostOrder(nodo.lchild);
            PostOrder(nodo.rchild);
            if (nodo.estatus != 'B') {
                FT.AgregarDatos(FT.Datos(nodo.numparrafo, nodo.texto));
            } // end if para agregar datos
        }
    }// end PostOrder
     // metodos para imprimir

    public void ImprimirPreOrder() {
        FT.AgregarColumnas(FT.Columnas("Num Parrafo", "Texto"));
        PreOrder(raiz);
        FT.ImprimirTabla();
    }// end ImprimirPreOrder

    public void ImprimirInOrder() {
        FT.AgregarColumnas(FT.Columnas("Num Parrafo", "Texto"));
        InOrder(raiz);
        FT.ImprimirTabla();
    }// end ImprimirInOrder

    public void ImprimirPostOrder() {
        FT.AgregarColumnas(FT.Columnas("Num Parrafo", "Texto"));
        PostOrder(raiz);
        FT.ImprimirTabla();
    }// end ImprimirPostOrder

    public int Profundidad(Nodo nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int leftDepth = Profundidad(nodo.lchild);
            int rightDepth = Profundidad(nodo.rchild);
            if (leftDepth > rightDepth) {
                return leftDepth + 1;
            } else {
                return rightDepth + 1;
            } // end if else que lleva el conteo
        } // end if else
    }// end Profundidad

    public void Raiz() {
        if (raiz != null) {
            JOptionPane.showMessageDialog(null, "Matrícula: " + raiz.numparrafo +
                    "\nTexto: " + raiz.texto + "\nEstatus: " + raiz.estatus);
        } // end if
    }// end Raiz

    public int CantidadNodos(Nodo nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int count = 0;
            if (nodo.estatus != 'B') {
                count = 1;
            }
            count += CantidadNodos(nodo.lchild);
            count += CantidadNodos(nodo.rchild);
            return count;
        } // end if else que lleva el conteo
    }// end CantidadNodos

    public void ImprimirBuscarPorNumParrafoInOrder(int nump) {
        FT.AgregarColumnas(FT.Columnas("Num Parrafo", "Texto"));
        BuscarPorNumParrafoInOrder(raiz, nump);
        FT.ImprimirTabla();
    }// hace que se imprima 

    private void BuscarPorNumParrafoInOrder(Nodo nodo, int nump) {
        if (nodo == null || nodo.estatus == 'B') {
            return;
        }// salir en caso de que tenga baja logica
        BuscarPorNumParrafoInOrder(nodo.lchild, nump);
        if (nodo.numparrafo == nump) {
            FT.AgregarDatos(FT.Datos(nodo.numparrafo, nodo.texto));
        }//agrega el nodo que coincida con el numpero de parrafo buscado
        BuscarPorNumParrafoInOrder(nodo.rchild, nump);
    }//end buscar parrafo

    // Agrega un método para buscar por texto usando recorrido inorder
    public void ImprimirBuscarPorTextoInOrder(String texto) {
        FT.AgregarColumnas(FT.Columnas("Num Parrafo", "Texto"));
        BuscarPorTextoInOrder(raiz, texto);
        FT.ImprimirTabla();
    }//hace que se imprima

    private void BuscarPorTextoInOrder(Nodo nodo, String texto) {
        if (nodo == null || nodo.estatus == 'B') {
            return;
        }// salir en caso de que tenga baja logica
        BuscarPorTextoInOrder(nodo.lchild, texto);
        if (nodo.texto.contains(texto)) {
            FT.AgregarDatos(FT.Datos(nodo.numparrafo, nodo.texto));
        }// agreaga los nodos que tengan el texto buscado
        BuscarPorTextoInOrder(nodo.rchild, texto);
    }// end biscar por texto

    public static void main(String[] args) {
        ArbolBinarioString Arbol = new ArbolBinarioString();
        int opcion;

        do {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "====== MENU ARBOL BINARIO STRING ======\n"
                    + "1. Alta de elemento\n"
                    + "2. Baja Logica de elemento\n"
                    + "3. Baja fisica\n"
                    + "4. Recorrido PREORDER \n"
                    + "5. Recorrido INORDER\n"
                    + "6. Recorrido POSTORDER\n"
                    + "7. Profundidad\n"
                    + "8. Imprimir Nodo Raiz\n"
                    + "9. Cantidad de Nodos\n"
                    + "10. Buscar por numero\n"
                    + "11. Buscar por texto\n"
                    + "0. Salir\n"
                    + "Ingrese opción: \n"));

            switch (opcion) {
                case 1:
                    int nump = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de parrafo: "));
                    String texto = JOptionPane.showInputDialog(null, "Ingrese texto: ");
                    Arbol.AgregarNodo(nump, texto);
                    break;
                case 2:
                    nump = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de parrafo: "));
                    Arbol.BajaLogica(nump);
                    break;
                case 3:
                    nump = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de parrafo: "));
                    Arbol.BajaFisica(nump);
                    break;
                case 4:
                    Arbol.ImprimirPreOrder();
                    break;
                case 5:
                    Arbol.ImprimirInOrder();
                    break;
                case 6:
                    Arbol.ImprimirPostOrder();
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, Arbol.Profundidad(raiz));
                    break;
                case 8:
                    Arbol.Raiz();
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, Arbol.CantidadNodos(raiz));
                    break;
                case 10:
                    int numpar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese número de párrafo: "));
                    Arbol.ImprimirBuscarPorNumParrafoInOrder(numpar);
                    break;
                case 11:
                    String text = JOptionPane.showInputDialog(null, "Ingrese texto a buscar: ");
                    Arbol.ImprimirBuscarPorTextoInOrder(text);

                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
                    break;

            }// end switch
            System.out.println();
        } while (opcion != 0);
    }// end main
}// end class