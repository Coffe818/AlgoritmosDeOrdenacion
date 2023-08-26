package CaracteresString;

public class EncriptacionJulioVerne {
    static String string = "buenos dias estrellitas, la tierra les dice ho";
    static String clave = "clave";// la clave solo se usa para saber el tamano del array
    static int Columnas = clave.length();
    static int Filas = (int) Math.ceil(string.length() / (double) Columnas);
    static String[][] Array = new String[Filas][Columnas];

    public static void LlenarArray(String[][] array, String mensaje) {
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

    public static void ImprimirArray(String[][] array) {
        for (int fila = 0; fila < Filas; fila++) {
            for (int col = 0; col < Columnas; col++) {
                System.out.print(array[fila][col] + " ");
            } // end for que se mueve en columas y va imprimiendo
            System.out.println();
        } // end for que se mueve ne filas
    }// end imprimir array

    public static String Encriptar(String[][] array) {
        StringBuilder mensajeEncriptado = new StringBuilder();

        for (int col = 0; col < Columnas; col++) {
            for (int fila = 0; fila < Filas; fila++) {
                if (array[fila][col] != null) {
                    mensajeEncriptado.append(array[fila][col]);
                } // agrega la letra del array en esa posicion solo si tiene algun valor
                else {
                    mensajeEncriptado.append("%");
                }
            } // end for para moverse en filas
        } // end for para moverse en columnas

        return mensajeEncriptado.toString();
    }// end Encriptar

    public static String Desencriptar(String menseajeEncriptado, String Clave) {
        StringBuilder mensajeDesencriptado = new StringBuilder();
        int Columnas = clave.length();
        int Filas = (int) Math.ceil(string.length() / (double) Columnas);
        String[][] Array = new String[Filas][Columnas];

        int tamano = 0;
        for (int col = 0; col < Columnas; col++) {
            for (int fila = 0; fila < Filas; fila++) {
                if (tamano < menseajeEncriptado.length()) {
                    char agregar = menseajeEncriptado.charAt(tamano);
                    if (agregar != '%') {
                        Array[fila][col] =String.valueOf(agregar);
                        tamano++;
                    }else{
                        Array[fila][col] = null;
                        tamano++;
                    }

                } // end if para agregar letra por letra en vertical
            } // end for para moverme en filas
        } // end for para moverme en columans

        for (int fila = 0; fila < Filas; fila++) {
            for (int col = 0; col < Columnas; col++) {
                System.out.print(Array[fila][col] + " ");
            } // end for que se mueve en columas y va imprimiendo
            System.out.println();
        } // end for que se mueve ne filas

        for (int fila = 0; fila < Filas; fila++) {
            for (int col = 0; col < Columnas; col++) {
                if (Array[fila][col] != null) {
                    mensajeDesencriptado.append(Array[fila][col]);
                }
            } // end for para moverse en filas
        } // end for para moverse en columnas
        System.out.println(mensajeDesencriptado.toString());
        return mensajeDesencriptado.toString();

    }// end desencriptar

    public static void main(String[] args) {
        LlenarArray(Array, string);
        ImprimirArray(Array);
        System.out.println("fials: " + Filas + " Columnas: " + Columnas);

        String mensajeEncriptado = Encriptar(Array);
        System.out.println("\nMensaje encritado: " + mensajeEncriptado);
        Desencriptar(mensajeEncriptado, clave);
    }// end main
}// end clas