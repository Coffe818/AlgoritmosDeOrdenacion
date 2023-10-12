package Tarea16;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import Tarea10.FormatoTabla;

public class MetodosDeConjuntos {
    static MetodosDeConjuntos conjuntos = new MetodosDeConjuntos();
    // =============COMO DECLARARLOS// CREARLOS =============

    // HashSett : los va agregando y los imprime aleatoriamente
    static Set<Integer> HashSet = new HashSet<>();

    // LinkedHashSet: Mantiene el orden de como se agregaron
    static Set<String> set = new LinkedHashSet<>();

    // TreeSet: los ordena automaticamente
    static Set<Integer> TreeSet = new TreeSet<>();

    // =============TODOS AL SER CONJUNTOS SE PUEDEN USAR SIEMPRE Y CUANDO CONTENGAN EL MISMO
    // PARAMETRO=============

    public void AgregarDatos(Set<Integer> conjunto, int dato) {
        conjunto.add(dato);
    }// end agregar datos

    public void Imprimir(Set<Integer> conjunto) {
        for (int elemento : conjunto) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }// end imprimir

    public void ImprimirJOption(Set<Integer> conjunto, String nombre) {
        FormatoTabla Ft = new FormatoTabla();
        Ft.AgregarColumnas(Ft.Columnas(nombre));
        for(int num : conjunto){
            Ft.AgregarDatos(Ft.Datos(num));
        }// end for para agregar datos
        Ft.ImprimirTabla();
    }// end Imprimir en Joption pane

    public void BuscarValor(Set<Integer> conjunto, int valor) {
        // conjunto.contains(valor); regrese un boolean por lo tanto
        if (conjunto.contains(valor)) {
            System.out.println("si contiene ese valor");
        } else {
            System.out.println("No contiene ese valor");

        }
    }// end buscar valor

    public int BuscarPosicion(Set<Integer> conjunto, int valor) {
        // Primero verificamos si el conjunto es de tipo TreeSet
        if (conjunto instanceof TreeSet) {
            // Si es un TreeSet, no se puede buscar posición, así que lanzamos una excepción
            throw new UnsupportedOperationException("No se puede buscar posición en un TreeSet.");
        }

        int posicion = 1; // Inicializamos la variable de posición en 1

        // Iteramos a través del conjunto
        for (int elemento : conjunto) {
            // Comparamos cada elemento con el valor que estamos buscando
            if (elemento == valor) {
                return posicion; // Si encontramos el valor, retornamos la posición
            }// end if
            posicion++; // Si no es el valor que buscamos, incrementamos la posición
        }// end for

        return -1; // Si no se encontró el valor, retornamos -1
    }// end buscar posicion

    public void Modificar(Set<Integer> conjunto, int viejoValor, int nuevoValor) {
        if (conjunto.remove(viejoValor)) {
            conjunto.add(nuevoValor);
        }
    }// end Modificar

    public void BorrarUnDato(Set<Integer> conjunto, int valor) {
        conjunto.remove(valor);
    }// end borrar un dato

    public void BorrarTodo(Set<Integer> conjunto) {
        conjunto.clear();
    }// end borrar todo


    //============= METODOS DE CONJUNTOS =============
    public Set<Integer> Union(Set<Integer> conjunto1, Set<Integer> conjunto2){
        Set<Integer> union = new HashSet<>(conjunto1);
        union.addAll(conjunto2);
        return union;
    }// end union

    public Set<Integer> Interseccion(Set<Integer> conjunto1, Set<Integer> conjunto2){
        Set<Integer> interseccion = new HashSet<>(conjunto1);
        interseccion.retainAll(conjunto2);
        return interseccion;
    }// end interseccion

    public Set<Integer> Diferencia(Set<Integer> conjunto1, Set<Integer> conjunto2){
        Set<Integer> diferencia = new HashSet<>(conjunto1);
        diferencia.removeAll(conjunto2);
        return diferencia;
        //lo que esta en el conjunto 1 pero no en el 1
    }// end diferencia

    public Set<Integer> DiferenciaSimetrica(Set<Integer> conjunto1, Set<Integer> conjunto2){
        Set<Integer> diferenciaSimetrica = new HashSet<>(Union(conjunto1, conjunto2));
        diferenciaSimetrica.removeAll(Interseccion(conjunto1, conjunto2));
        return diferenciaSimetrica;
        //lo que no esta en ninguno de los dos
    }// end diferencia simetrica

    public Set<Integer> Complemento(Set<Integer> conjunto1, Set<Integer> conjunto2){
        return Diferencia(conjunto2, conjunto1);

        // el complemento es lo que esta en el conjunto 2 pero no en el 1
        //siendo conjunto 1 el "universo", y conjunto 2 "lo que ya sabemos que esta"
        // por lo tato el complemento es "lo que no sabemos" 
        // por eso se usa la diferencia
    }// end complemento


}// end class
