package Tarea1;

public class EncriptacionJulioVerne {
    
    static int Columnas;
    static int Filas;
    static String[][] Array;

    public static void CrearArray(String mensaje, String clave) {
        Columnas = clave.length();
        Filas = (int) Math.ceil(mensaje.length() / (double) Columnas);
        Array = new String[Filas][Columnas];
    }// end metodo para crear el array

    // el metodod e imprimir lo pueden usar los dos encriptar y desencriptar, el
    // llenar no, porque para encriptar se va llenando horizontalmente(por filas)y
    // el
    // desencrpitar se va llenando verticalmete(por columnas)
    public static void ImprimirArray(String[][]array) {
        for (int fila = 0; fila < Filas; fila++) {
            for (int col = 0; col < Columnas; col++) {
                System.out.print(array[fila][col] + " ");
            } // end for que se mueve en columas y va imprimiendo
            System.out.println();
        } // end for que se mueve ne filas
    }// end imprimir array

    // metodos para llenar array para encriptar
    public static void LlenarArrayE(String[][] array, String mensaje) {
        int tamano = 0;

        for (int fila = 0; fila < Filas; fila++) {
            for (int col = 0; col < Columnas; col++) {
                if (tamano < mensaje.length()) {
                    array[fila][col] = String.valueOf(mensaje.charAt(tamano));
                    tamano++;
                } // end if para agregar letra por letra en horizontal
            } // end for para moverme en columnas
        } // end for para moverme en filas
    }// end llenar Array

    public static String Encriptar(String mensaje, String clave) {
        StringBuilder mensajeEncriptado = new StringBuilder();
        CrearArray(mensaje, clave);
        LlenarArrayE(Array, mensaje);
        ImprimirArray(Array);
        for (int col = 0; col < Columnas; col++) {
            for (int fila = 0; fila < Filas; fila++) {
                if (Array[fila][col] != null) {
                    mensajeEncriptado.append(Array[fila][col]);
                } // agrega la letra del array en esa posicion solo si tiene algun valor
                else {
                    mensajeEncriptado.append("%");
                }// le pongo % en lugar de null al mensaje
            } // end for para moverse en filas
        } // end for para moverse en columnas

        return mensajeEncriptado.toString();
    }// end Encriptar

    // metods para llenar array para desencriptar
    public static void LlenarArrayD(String [][] array, String mensajeEncriptado) {
        int tamano = 0;
        for (int col = 0; col < Columnas; col++) {
            for (int fila = 0; fila < Filas; fila++) {
                if (tamano < mensajeEncriptado.length()) {
                    char agregar = mensajeEncriptado.charAt(tamano);
                    if (agregar != '%') {
                        array[fila][col] = String.valueOf(agregar);
                        tamano++;
                    } else {
                        array[fila][col] = null;
                        tamano++;
                    }//este if else , sierve para eliminar los % que pusimos en el mensaje 
                } // end if para agregar letra por letra en vertical
            } // end for para moverme en columnas
        } // end for para moverme en filas
    }

    public static String Desencriptar(String menseajeEncriptado, String clave) {
        StringBuilder mensajeDesencriptado = new StringBuilder();
        CrearArray(menseajeEncriptado, clave);
        LlenarArrayD(Array, menseajeEncriptado);
        ImprimirArray(Array);

        for (int fila = 0; fila < Filas; fila++) {
            for (int col = 0; col < Columnas; col++) {
                if (Array[fila][col] != null) {
                    mensajeDesencriptado.append(Array[fila][col]);
                }//agrega las letras siempre y cuando en esa posicion sea diferente a null
            } // end for para moverse en filas
        } // end for para moverse en columnas
        
        return mensajeDesencriptado.toString();

    }// end desencriptar

    public static void main(String[] args) {
        String s="buenos dias estrellitas, la tierra les dice ho";
        String c="clave";
        System.out.println("Mesnaje original:" + s);

        String mensajeEncriptado = Encriptar(s,c);
        System.out.println("Mensaje encritado: " + mensajeEncriptado);

        String mensajeDesencriptado = Desencriptar(mensajeEncriptado,c);
        System.out.println("Mensaje desencritado: " + mensajeDesencriptado);
    }// end main
}// end clas