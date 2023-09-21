package Tarea6;

import javax.swing.JOptionPane;

public class ReproducirAudio {

    public static boolean esNumero(String cadena) {
        try {
            Double.parseDouble(cadena);
            // significa que la conversion fue bien por ende si es un numero
            return true;
        } catch (NumberFormatException e) {
            // significa que cadena no se pudo representar como doble por lo cual es un
            // String
            return false;
        } // end try catch
    }// end es numero

    public static String ConvertirNumeroEnPalabras(double numero) {
        if (numero == 0) {
            return "cero";
        }

        String[] unidades = { "cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve" };
        String[] decenas = { "", "", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta",
                "noventa" };
        String[] especiales = { "diez", "once", "doce", "trece", "catorce", "quince", "dieciseis", "diecisiete",
                "dieciocho", "diecinueve" };

        String[] grupos = { "", "mil", "millones" };

        int parteEntera = (int) numero;
        int parteDecimal = (int) ((numero - parteEntera) * 100);

        String palabras = "";
        // 7,852,476
        int grupoActual = 0;
        while (parteEntera > 0) {
            int grupo = parteEntera % 1000; // 7,852,476%1000 = 476
            if (grupo > 0) {
                String grupoPalabras = "";

                int centenas = grupo / 100; // 476/100= 4
                int decenasUnidades = grupo % 100; // 476%100 =76

                if (centenas > 0) {
                    grupoPalabras += unidades[centenas] + " cientos "; // cuatro + cientos
                }

                if (decenasUnidades >= 20) {
                    grupoPalabras += decenas[decenasUnidades / 10]; // 76/10 = 7, = setenta

                    if (decenasUnidades % 10 != 0) { // 76%10 = 6
                        grupoPalabras += " y " + unidades[decenasUnidades % 10]; // = y + seis
                    }
                } else if (decenasUnidades >= 10) {
                    grupoPalabras += especiales[decenasUnidades - 10];
                } else if (decenasUnidades > 0) {
                    grupoPalabras += unidades[decenasUnidades];
                }

                if (grupoActual > 0) {
                    grupoPalabras += " " + grupos[grupoActual];
                }

                palabras = grupoPalabras + " " + palabras;
                /*
                 * palabras= "cuatro ciento setenta y seis" +" "+ palabras; grupo = 0
                 * palabras = "ochocientos cianuenta y dos mil" + " "+
                 * "cuatrocientos setenta y seis"; grupo=1
                 * palabras = "7 millones" + " " +
                 * "ochocientos cianuenta y dos mil cuatrocientos setenta y seis"; grupo =2
                 */
            } // end if

            parteEntera /= 1000;// 7852476/1000 = 7852 luego se repite con 852 y dara ocho ciento cincuenta y
                                // dos, pero como ahora grupo actual es 1, va a poner mil
            grupoActual++;
        } // end while para la parte entera

        // la parte decimal hace lo mismo que el de arriba
        if (parteDecimal > 0) {
            palabras += " punto ";
            if (parteDecimal < 10) {
                palabras += unidades[parteDecimal];
            } else if (parteDecimal < 20) {
                palabras += especiales[parteDecimal - 10];
            } else if (parteDecimal % 10 == 0) {
                palabras += decenas[parteDecimal / 10];
            } else {
                palabras += decenas[parteDecimal / 10] + " y " + unidades[parteDecimal % 10];
            }
        } // end if para parte decimal

        return palabras;
    }// end ConvertirNumeroEnPalabras

    public static void PalabraPorPalabra(String stx){
        String[] palabras = stx.trim().split("\\s+");
        
        for (int i = 0; i < palabras.length; i++) {
            TextToSpeech.Reproucir(palabras[i]);
        }//end for

    }//end palabra por palabra

    public static void main(String[] args) {
        String texto = JOptionPane.showInputDialog("Ingrese un número o un texto:");
        int opcion;
        String numeroEnPalabras;
        do {
            if (esNumero(texto)) {
                double numero = Double.parseDouble(texto);
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "=======MENU AUDIO =======" +
                        "\nNumero: " + numero 
                        + "\n1. Cambiar el texto \n2. Reproducir audio"));
            } else {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "=======MENU AUDIO =======" +
                        "\nTexto: " + texto + "\n1. Cambiar el texto \n2. Reproducir audio"));
            }

            switch (opcion) {
                case 1:
                    texto = JOptionPane.showInputDialog("Ingrese un número o un texto:");
                    break;
                case 2:
                    if (esNumero(texto)) {
                        double numero = Double.parseDouble(texto);
                        numeroEnPalabras = ConvertirNumeroEnPalabras(numero);
                        ReproducirAudio.PalabraPorPalabra(numeroEnPalabras);
                    } else {
                         ReproducirAudio.PalabraPorPalabra(texto);
                    }
                    break;
                default:
                    break;
            }

        } while (opcion != 0);
        // Verificar si el input es un número o un string

    }
}
