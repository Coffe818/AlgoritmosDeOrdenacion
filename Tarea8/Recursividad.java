package Tarea8;

import javax.swing.JOptionPane;

public class Recursividad {

    public static int Factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * Factorial(n - 1);
        }//end if eslse
    }//end factorial

    public static int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }//end if eslse
    }//end fivonacci

    public static int SumarDigitos(int n) {
        if (n < 10) {
            return n;
        } else {
            return n % 10 + SumarDigitos(n / 10);
        }//end if eslse
    }//end  sumar digitos

    public static String InvertirCadena(String s) {
        if (s.isEmpty()) {
            return s;
        } else {
            return InvertirCadena(s.substring(1)) + s.charAt(0);
        }//end if eslse
    }//end invertir cadena

    public static int Potencia(int x, int y) {
        if (y == 0) {
            return 1;
        } else {
            return x * Potencia(x, y - 1);
        }//end if eslse
    }//end  potencia

    public static int Sumar(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return 1 + Sumar(a, b - 1);
        }//end if eslse
    }//end sumar

    public static int EncontrarMaximo(int[] arreglo, int indice, int max) {
        if (indice == arreglo.length) {
            return max;
        } else {
            if (arreglo[indice] > max) {
                return EncontrarMaximo(arreglo, indice + 1, arreglo[indice]);
            } else {
                return EncontrarMaximo(arreglo, indice + 1, max);
            }//end if eslse
        }//end if eslse
    }// end Encontrar maximo

    public static void main(String[] args) {
        // Ejemplos de uso usando JOptionPane
        int opcion;
        int[] arreglo = { 10, 5, 8, 3, 12 };
        int maximo = EncontrarMaximo(arreglo, 0, arreglo[0]);

        do {
            String mensaje = "Seleccione una opcion:\n" +
                    "1. Factorial\n" +
                    "2. Fibonacci\n" +
                    "3. Sumar digitos\n" +
                    "4. Invertir cadena\n" +
                    "5. Potencia\n" +
                    "6. Sumar dos numeros\n" +
                    "7. Encontrar maximo en arreglo\n" +
                    "8. Agregar numero al arreglo\n" +
                    "0. Salir";

            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje));

            switch (opcion) {
                case 1:
                    int numFact = Integer.parseInt(
                            JOptionPane.showInputDialog(null, "Ingrese un numero para calcular su factorial:"));
                    JOptionPane.showMessageDialog(null, "El factorial de " + numFact + " es " + Factorial(numFact));
                    break;
                case 2:
                    int numFib = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingrese un numero para calcular su termino de Fibonacci:"));
                    JOptionPane.showMessageDialog(null,
                            "El término " + numFib + " de Fibonacci es " + Fibonacci(numFib));
                    break;
                case 3:
                    int numSumaDigitos = Integer
                            .parseInt(JOptionPane.showInputDialog(null, "Ingrese un numero para sumar sus digitos:"));
                    JOptionPane.showMessageDialog(null,
                            "La suma de digitos de " + numSumaDigitos + " es " + SumarDigitos(numSumaDigitos));
                    break;
                case 4:
                    String cadenaInvertir = JOptionPane.showInputDialog(null, "Ingrese una cadena para invertirla:");
                    JOptionPane.showMessageDialog(null, "La cadena invertida es: " + InvertirCadena(cadenaInvertir));
                    break;
                case 5:
                    int base = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la base:"));
                    int exponente = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el exponente:"));
                    JOptionPane.showMessageDialog(null,
                            base + " elevado a la " + exponente + " es " + Potencia(base, exponente));
                    break;
                case 6:
                    int num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el primer numero:"));
                    int num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el segundo numero:"));
                    JOptionPane.showMessageDialog(null,
                            "La suma de " + num1 + " y " + num2 + " es " + Sumar(num1, num2));
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "El valor maximo en el arreglo es: " + maximo);
                    break;
                case 8:
                    int nuevoNumero = Integer
                            .parseInt(JOptionPane.showInputDialog(null, "Ingrese un numero para agregar al arreglo:"));
                    int[] nuevoArreglo = new int[arreglo.length + 1];
                    for (int i = 0; i < arreglo.length; i++) {
                        nuevoArreglo[i] = arreglo[i];
                    }
                    nuevoArreglo[arreglo.length] = nuevoNumero;
                    arreglo = nuevoArreglo;
                    maximo = EncontrarMaximo(arreglo, 0, arreglo[0]);
                    JOptionPane.showMessageDialog(null, "numero agregado al arreglo.");
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no válida");
                    break;
            }//end switch

        } while (opcion != 0);
    }//end main
}//end class
