package Tarea5;

import Tarea1.*;
import Tarea10.FormatoTabla;

import java.util.Random;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SopaDeLetras {
    static String[][] ARRAY = new String[20][20];
    static int CantidadPalabras =5;
    static String[] palabrasArray = new String[CantidadPalabras];
    static int filaAleatoria;
    static int columnaAleatoria;
    static Random random = new Random();
    static FormatoTabla ft = new FormatoTabla();

    public static void AgregarHorizontal(String palabra, int filas, int columnas) {
        palabra = palabra.toUpperCase();

        if (columnas + palabra.length() <= ARRAY.length) {// sirve para ver si la palabra si cabe o no
            boolean espacioDisponible = true;

            for (int i = 0; i < palabra.length(); i++) {
                if (ARRAY[filas][columnas + i] != null) {
                    espacioDisponible = false;
                    break;
                } // end if para ver si la celda esta disponible o no
            } // end for para recorrerse por las celdas

            if (espacioDisponible) {// sirve para ver si la el espacio esta ocupado
                for (int i = 0; i < palabra.length(); i++) {
                    ARRAY[filas][columnas + i] = "" + palabra.charAt(i);
                } // end for para agregar la palabra
            } else {

                filaAleatoria = random.nextInt(20);
                columnaAleatoria = random.nextInt(20);
                AgregarHorizontal(palabra, filaAleatoria, columnaAleatoria);
                // System.out.println("Error de NO espacio disponible en HORIZONTAL con palabra
                // " + palabra);
            } // end if
        } else {

            filaAleatoria = random.nextInt(20);
            columnaAleatoria = random.nextInt(20);
            AgregarHorizontal(palabra, filaAleatoria, columnaAleatoria);
            // System.out.println(
            // "Error de NO cabe en el array en HORIZONTAL por la posicion que se le dio en
            // palabra" + palabra);
        } // end if
    }// end agregar horizontal

    public static void AgregarVertical(String palabra, int filas, int columnas) {
        palabra = palabra.toUpperCase();

        if (filas + palabra.length() <= ARRAY.length) {
            boolean espacioDisponible = true;

            for (int i = 0; i < palabra.length(); i++) {// sirve para ver si la palabra si cabe o no
                if (ARRAY[filas + i][columnas] != null) {
                    espacioDisponible = false;
                    break;
                } // end if para ver si la celda esta disponible o no
            } // end for para recorrerse por las celdas

            if (espacioDisponible) {// sirve para ver si la el espacio esta ocupado
                for (int i = 0; i < palabra.length(); i++) {
                    ARRAY[filas + i][columnas] = "" + palabra.charAt(i);
                } // sirve para ver si la el espacio esta ocupado
            } else {

                filaAleatoria = random.nextInt(20);
                columnaAleatoria = random.nextInt(20);
                AgregarVertical(palabra, filaAleatoria, columnaAleatoria);
                // System.out.println("Error de NO espacio disponible en VERTICAL con palabra "
                // + palabra);
            } // end if
        } else {

            filaAleatoria = random.nextInt(20);
            columnaAleatoria = random.nextInt(20);
            AgregarVertical(palabra, filaAleatoria, columnaAleatoria);
            // System.out.println(
            // "Error de NO cabe en el array en VERTICAL por la posicion que se le dio en
            // palabra" + palabra);
        } // end if
    }

    public static void AgregarDiagonal(String palabra, int filas, int columnas) {
        palabra = palabra.toUpperCase();

        if (filas + palabra.length() <= ARRAY.length && columnas + palabra.length() <= ARRAY.length) {
            boolean espacioDisponible = true;

            for (int i = 0; i < palabra.length(); i++) {
                if (ARRAY[filas + i][columnas + i] != null) {// sirve para ver si la palabra si cabe o no
                    espacioDisponible = false;
                    break;
                } // end if para ver si la celda esta disponible o no
            } // end for para recorrerse por las celdas

            if (espacioDisponible) {// sirve para ver si la el espacio esta ocupado
                for (int i = 0; i < palabra.length(); i++) {
                    ARRAY[filas + i][columnas + i] = "" + palabra.charAt(i);
                } // sirve para ver si la el espacio esta ocupado
            } else {

                filaAleatoria = random.nextInt(20);
                columnaAleatoria = random.nextInt(20);
                AgregarDiagonal(palabra, filaAleatoria, columnaAleatoria);
                // System.out.println("Error de NO espacio disponible en DIAGONAL con palabra "
                // + palabra);
            } // end if
        } else {

            filaAleatoria = random.nextInt(20);
            columnaAleatoria = random.nextInt(20);
            AgregarDiagonal(palabra, filaAleatoria, columnaAleatoria);
            // System.out.println(
            // "Error de NO cabe en el array en DIAGONAL por la posicion que se le dio en
            // palabra" + palabra);
        } // end if
    }// end agregar en diagonal

    public static JPanel ImprimirTabla(String[] palabrasArray) {
        String[] columnNames = new String[21]; // Añadimos una columna extra para los números de fila
        columnNames[0] = ""; // Dejamos la primera columna vacía para los números de fila
        for (int i = 0; i < 20; i++) {
            columnNames[i + 1] = String.valueOf(i + 1);
        } // end for para llenar las columnas

        DefaultTableModel model = new DefaultTableModel(columnNames, 20);

        JTable table = new JTable(model);

        for (int i = 0; i < ARRAY.length; i++) {
            for (int j = 0; j < ARRAY[i].length; j++) {
                if (ARRAY[i][j] == null) {
                   // char randomLetter = (char) (random.nextInt(26) + 'A');
                    model.setValueAt(".", i, j + 1); // Añadimos 1 para dejar espacio para los números de fila
                } else {
                    model.setValueAt(ARRAY[i][j], i, j + 1);
                } // end if para agregar los datos a la sopa de letras
            } // end for para recorrer horizontalmente

            model.setValueAt(i + 1, i, 0); // Números de fila
        } // end for para recorrer verticalmente

        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Palabras ingresadas:\n");
        for (String palabra : palabrasArray) {
            if (palabra != null) {
                mensaje.append(" " + palabra + " , ");
            }
        } // end for para recorrer y agregar palabras

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(new JLabel(mensaje.toString()), BorderLayout.EAST);

  
        return panel;

    }// end Imprimir tabla

    //metodos para buscar la palavra y verificar
    public static String BuscarPalabra(String palabra, int filaInicio, int columnaInicio, int filaFin, int columnaFin) {
        palabra = palabra.toUpperCase();

        String palabraHorizontal = obtenerPalabraHorizontal(filaInicio, columnaInicio, columnaFin);
        String palabraVertical = obtenerPalabraVertical(filaInicio, columnaInicio, filaFin);
        String palabraDiagonal = obtenerPalabraDiagonal(filaInicio, columnaInicio, filaFin, columnaFin);
        //las guarda en cada uno de los casos para ver si coincide
        //y estos son por si la palabra estan alrevez
        String palabraHorizontalInvertida = CaracteresString.InvertirCaracteres(palabraHorizontal);
        String palabraVerticalInvertida = CaracteresString.InvertirCaracteres(palabraVertical);
        String palabraDiagonalInvertida = CaracteresString.InvertirCaracteres(palabraDiagonal);

        if (palabra.equals(palabraHorizontal) || palabra.equals(palabraHorizontalInvertida)) {
            return "La palabra "+palabra+" esta en dirección horizontal.";
        } else if (palabra.equals(palabraVertical) || palabra.equals(palabraVerticalInvertida)) {
            return "La palabra "+palabra+" esta en dirección vertical.";
        } else if (palabra.equals(palabraDiagonal) || palabra.equals(palabraDiagonalInvertida)) {
            return "La palabra"+palabra+" esta en dirección diagonal.";
        } else {
            return "La palabra no fue encontrada en ninguna direccion.";
        }//en la que coinida regresa el return
    }//end Buscar palabra

    private static String obtenerPalabraHorizontal(int fila, int columnaInicio, int columnaFin) {
        StringBuilder palabraHorizontal = new StringBuilder();
        for (int j = columnaInicio; j <= columnaFin; j++) {
            if (ARRAY[fila][j] != null) {
                palabraHorizontal.append(ARRAY[fila][j]);
            }// end fi que va agregarndo las letras el StringBuilder
        }//end for para recorrer horizontalmente
        return palabraHorizontal.toString();
    }// end obener palabra horizontal

    private static String obtenerPalabraVertical(int filaInicio, int columna, int filaFin) {
        StringBuilder palabraVertical = new StringBuilder();
        for (int i = filaInicio; i <= filaFin; i++) {
            if (ARRAY[i][columna] != null) {
                palabraVertical.append(ARRAY[i][columna]);
            }//end if para agregar las letras
        }// end for para recorrer vertical
        return palabraVertical.toString();
    }//end obtener palabara vertical

    private static String obtenerPalabraDiagonal(int filaInicio, int columnaInicio, int filaFin, int columnaFin) {
        StringBuilder palabraDiagonal = new StringBuilder();
        int i = filaInicio;
        int j = columnaInicio;
        while (i <= filaFin && j <= columnaFin) {
            if (ARRAY[i][j] != null) {
                palabraDiagonal.append(ARRAY[i][j]);
            }// end if para agregar las letras
            i++;
            j++;
        }// end while para recorrer en diagonal
        return palabraDiagonal.toString();
    }//end obtener palara en diagonal

    public static void main(String[] args) {

        for (int i = 0; i < CantidadPalabras; i++) {
            String palabra = JOptionPane.showInputDialog("Ingresa una palabra:");
            palabrasArray[i] = palabra;
            filaAleatoria = random.nextInt(20);
            columnaAleatoria = random.nextInt(20);
            int opcionAleatoria = random.nextInt(3);
            int opcionAleatoria2 = random.nextInt(3) + 1;

            if (opcionAleatoria2 % 2 == 0) {// 1 de 3 para invertir la palabra
                palabra = CaracteresString.InvertirCaracteres(palabra);
            }

            if (opcionAleatoria == 0) {
                AgregarHorizontal(palabra, filaAleatoria, columnaAleatoria);
            } else if (opcionAleatoria == 1) {
                AgregarVertical(palabra, filaAleatoria, columnaAleatoria);
            } else {
                AgregarDiagonal(palabra, filaAleatoria, columnaAleatoria);
            } // end if que tambien puede ser con switch
        } // end por que pide las palabras
        int opcion;
        do {
            opcion = Integer.parseInt(
                    JOptionPane.showInputDialog(null, "=======Sopa de letras========\n1.buscar palabra\n0.salir"));
            switch (opcion) {
                case 1:
                JOptionPane.showMessageDialog(null,ImprimirTabla(palabrasArray));

                String palabraBuscar = JOptionPane.showInputDialog(null, "Ingresa la palabra a buscar:");
                int filaInicio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la fila inicial:")) - 1;
                int columnaInicio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la columna inicial:")) - 1;
                int filaFin = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la fila final:")) - 1;
                int columnaFin = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la columna final:")) - 1;

                /*String palabraBuscar = JOptionPane.showInputDialog(null, ImprimirTabla(palabrasArray) + "Ingresa la palabra a buscar:");
                int filaInicio = Integer.parseInt(JOptionPane.showInputDialog(null, ImprimirTabla(palabrasArray) + "Ingresa la fila inicial:")) - 1;
                int columnaInicio = Integer.parseInt(JOptionPane.showInputDialog(null, ImprimirTabla(palabrasArray) + "Ingresa la columna inicial:")) - 1;
                int filaFin = Integer.parseInt(JOptionPane.showInputDialog(null, ImprimirTabla(palabrasArray) + "Ingresa la fila final:")) - 1;
                int columnaFin = Integer.parseInt(JOptionPane.showInputDialog(null, ImprimirTabla(palabrasArray) + "Ingresa la columna final:")) - 1;
                */
                String resultado = BuscarPalabra(palabraBuscar, filaInicio, columnaInicio, filaFin, columnaFin);
                JOptionPane.showMessageDialog(null, resultado);
                

                    break;

                default:
                    break;
            }

        } while (opcion != 0);

    }// end main
}// end class