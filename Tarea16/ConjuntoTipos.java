package Tarea16;

import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

public class ConjuntoTipos {
    static MetodosDeConjuntos mConjuntos = new MetodosDeConjuntos();

    static Set<Integer> ConjuntoUniversal = new TreeSet<>();

    static Set<Integer> NumerosPares = new TreeSet<>();
    static Set<Integer> NumerosImpares = new TreeSet<>();
    static Set<Integer> NumerosPrimos = new TreeSet<>();

    static Set<Integer> UnionImparesPrimos = new TreeSet<>();
    static Set<Integer> UnionParesPrimos = new TreeSet<>();

    static Set<Integer> InterseccionImparesPrimos = new TreeSet<>();
    static Set<Integer> InterseccionParesPrimos = new TreeSet<>();

    static Set<Integer> DiferenciaImparesPrimos = new TreeSet<>();
    static Set<Integer> DiferenciaParesPrimos = new TreeSet<>();

    static Set<Integer> ComplementoImparesPrimos = new TreeSet<>();
    static Set<Integer> ComplementoParesPrimos = new TreeSet<>();

    public static void LLenarConjuntoUniversal() {
        for (int i = 0; i < 2001; i++) {
            ConjuntoUniversal.add(i);
        } // end for
    }// end llenar conjunto universak

    public static void ParesImpares() {
        for (int num : ConjuntoUniversal) {
            if (num % 2 == 0) {
                NumerosPares.add(num);
            } else {
                NumerosImpares.add(num);
            } // end if para agreagar
        } // end for para recorer
    }// end pares impares

    public static boolean EsPrimo(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            } // end if
        } // end for
          // si no sale en ninugna de estas significa que si es primo
        return true;
    }// end es primo

    public static void Primo() {
        for (int num : ConjuntoUniversal) {
            if (EsPrimo(num)) {
                NumerosPrimos.add(num);
            } // end if para agregar numero
        } // end for para recorrer
    }// end primo

    public static void ElimiarBuscando(Set<Integer> conjunto, int valor) {
        if (conjunto.contains(valor)) {
            conjunto.remove(valor);
        } else {
            System.out.println("Ese valor no existe en ese Conjunto");
        } //
    }// end eleminar buscando dato

    public static void UnionImparesPrimos() {
        UnionImparesPrimos.addAll(mConjuntos.Union(NumerosImpares, NumerosPrimos));
    }// end union impares primos

    public static void UnionParesPrimos() {
        UnionParesPrimos.addAll(mConjuntos.Union(NumerosPares, NumerosPrimos));
    }// end union impares primos

    public static void InterseccionImparesPrimos() {
        InterseccionImparesPrimos.addAll(mConjuntos.Interseccion(NumerosImpares, NumerosPrimos));
    }// end interseccion impares primos

    public static void InterseccionParesPrimos() {
        InterseccionParesPrimos.addAll(mConjuntos.Interseccion(NumerosPares, NumerosPrimos));
    }// end interseccion impares primos

    public static void DiferenciaImparesPrimos() {
        DiferenciaImparesPrimos.addAll(mConjuntos.Diferencia(NumerosImpares, NumerosPrimos));
    }// end union impares primos

    public static void DiferenciaParesPrimos() {
        DiferenciaParesPrimos.addAll(mConjuntos.Diferencia(NumerosPares, NumerosPrimos));
    }// end union impares primos

    public static void ComplementoImparesPrimos() {
        ComplementoImparesPrimos.addAll(mConjuntos.Complemento(NumerosImpares, NumerosPrimos));
    }// end interseccion impares primos

    public static void ComplementoParesPrimos() {
        ComplementoParesPrimos.addAll(mConjuntos.Complemento(NumerosPares, NumerosPrimos));
    }// end interseccion impares primos

    public static void Limpiar() {// borra todo lo que este en los Set
        ConjuntoUniversal.clear();
        NumerosPares.clear();
        NumerosImpares.clear();
        NumerosPrimos.clear();
        UnionImparesPrimos.clear();
        UnionParesPrimos.clear();
        InterseccionImparesPrimos.clear();
        InterseccionParesPrimos.clear();
        DiferenciaImparesPrimos.clear();
        DiferenciaParesPrimos.clear();
        ComplementoImparesPrimos.clear();
        ComplementoParesPrimos.clear();
    }// end limpiar

    public static void Reset() {// Limpia y vuelve a llenar
        Limpiar();
        LLenarConjuntoUniversal();
        ParesImpares();
        Primo();
        UnionImparesPrimos();
        UnionParesPrimos();
        InterseccionImparesPrimos();
        InterseccionParesPrimos();
        DiferenciaImparesPrimos();
        DiferenciaParesPrimos();
        ComplementoImparesPrimos();
        ComplementoParesPrimos();
    }// end reset

    public static void main(String[] args) {

        int opcion;
        do {
            Reset();
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "======= Tipos de conjuntos ========"
                    + "\n1.Imprimir Conjuto universal "
                    + "\n2.Imprimir Numeros Pares"
                    + "\n3.Imprimir Numeros Impares"
                    + "\n4.Imprimir Numeros Primos"
                    + "\n5.Imprimir Union Impares Primos"
                    + "\n6.Imprimir Union Pares Primos"
                    + "\n7.Imprimir Intrseccion Impares Primos"
                    + "\n8.Imprimir Inteseccion Pares Primos"
                    + "\n9.Imprimir Diferencia Impares Primos"
                    + "\n10.Imprimir Difrencia Pares Pirmos"
                    + "\n11.Imprimir Complemento Impares Primos"
                    + "\n12.Imprimir Complemento pares Primos"
                    + "\n0. Salir"));

            switch (opcion) {
                case 1:
                    mConjuntos.ImprimirJOption(ConjuntoUniversal, "Conjunto Universal");
                    break;
                case 2:
                    mConjuntos.ImprimirJOption(NumerosPares, "Numeros Pares");
                    break;
                case 3:
                    mConjuntos.ImprimirJOption(NumerosImpares, "Numeros Impares");
                    break;
                case 4:
                    mConjuntos.ImprimirJOption(NumerosPrimos, "Numeros Primos");
                    break;
                case 5:
                    mConjuntos.ImprimirJOption(UnionImparesPrimos, "Union Impares Primos");
                    break;
                case 6:
                    mConjuntos.ImprimirJOption(UnionParesPrimos, "Union Pares Primos");
                    break;
                case 7:
                    mConjuntos.ImprimirJOption(InterseccionImparesPrimos, "Interseccion Impares Primos");
                    break;
                case 8:
                    mConjuntos.ImprimirJOption(InterseccionParesPrimos, "Interseccion Pares Primos");
                    break;
                case 9:
                    mConjuntos.ImprimirJOption(DiferenciaImparesPrimos, "Difrencia Impares Primos");
                    break;
                case 10:
                    mConjuntos.ImprimirJOption(DiferenciaParesPrimos, "Diferencia Pares Primos");
                    break;
                case 11:
                    mConjuntos.ImprimirJOption(ComplementoImparesPrimos, "Complemetno Impares Primos");
                    break;
                case 12:
                    mConjuntos.ImprimirJOption(ComplementoParesPrimos, "Complemento Pares Primos");
                    break;

                default:
                    break;
            }// end switch

        } while (opcion != 0);

    }// end main

}// end class
