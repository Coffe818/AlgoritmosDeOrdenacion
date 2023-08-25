package CaracteresString;

public class EncriptacionJulioVerne {
    static String string = "buenos dias estrellitas, la tierra les dice ho";
    static String clave = "clave";
    static int Columnas = clave.length();
    static int Filas = (int) Math.ceil(string.length() / (double) Columnas);
    static String[][] nombreArray = new String[Filas][Columnas];

    public static void LlenarArray(String[][] array, String mensaje) {
        int index = 0;

        for (int fila = 0; fila < Filas; fila++) {
            for (int col = 0; col < Columnas; col++) {
                if (index < mensaje.length()) {
                    array[fila][col] = String.valueOf(mensaje.charAt(index));
                    index++;
                }// end if para agregar letra por letra en horizontal
            }//end for para moverme en columnas
        }//end for para moverme en filas
    }//end llenar Array

    public static void ImprimirArray(String[][] array) {
        for (int fila = 0; fila < Filas; fila++) {
            for (int col = 0; col < Columnas; col++) {
                System.out.print(array[fila][col] + " ");
            }//end for que se mueve en columas y va imprimiendo
            System.out.println();
        }// end for que se mueve ne filas
    }// end imprimir array

    public static String Encriptar(String[][] array) {
        StringBuilder mensajeEncriptado = new StringBuilder();

        for (int col = 0; col < Columnas; col++) {
            for (int fila = 0; fila < Filas; fila++) {
                if (array[fila][col] != null) {
                    mensajeEncriptado.append(array[fila][col]);
                }// agrega la letra del array en esa posicion solo si tiene algun valor
            }//end for para moverse en filas
        }//end for para moverse en columnas

        return mensajeEncriptado.toString();
    }//end Encriptar



    public static void main(String[] args) {
        LlenarArray(nombreArray, string);
        ImprimirArray(nombreArray);
        System.out.println("fials: " + Filas + " Columnas: " + Columnas);

        String mensajeEncriptado = Encriptar(nombreArray);
        System.out.println("\nMensaje encritado: " + mensajeEncriptado);
        
       
    }// end main
}// end clas