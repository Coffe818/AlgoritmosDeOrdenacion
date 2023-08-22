package ClasesString;

import javax.swing.JOptionPane;

public class ClasesString {
    static String s = "", t = "";

    public void Comparacion(String s, String t, int x) {
        switch (x) {
            case 1:
                if (s.equals(t)) {// regresan true or false
                    JOptionPane.showMessageDialog(null, "SI son Excatamente iguales");
                } else {
                    JOptionPane.showMessageDialog(null, "NO son Excatamente iguales");
                } // end if para equals
                break;
            case 2:
                if (s.equalsIgnoreCase(t)) {// regresan true or false
                    JOptionPane.showMessageDialog(null, "SI son iguales, exeptuando minusculas y mayusculas");
                } else {
                    JOptionPane.showMessageDialog(null, "NO son iguales, exeptuando minusculas y mayusculas");
                } // end if para equals ignorando mayusculas/minusculas
                break;
            case 3:
                if (s.compareTo(t) == 0) {// te dan valores
                    JOptionPane.showMessageDialog(null, "SI son Excatamente iguales");
                } else if (s.compareTo(t) > 0) {
                    JOptionPane.showMessageDialog(null, "EL primer String es mayor que el segundo");
                } else if (s.compareTo(t) < 0) {
                    JOptionPane.showMessageDialog(null, "EL primer String es menor que el segundo");
                } // end if para compare to
                break;
            case 4:
                if (s.compareToIgnoreCase(t) == 0) {// te dan valores
                    JOptionPane.showMessageDialog(null, "SI son iguales, exeptuando minusculas y mayusculas");
                } else if (s.compareToIgnoreCase(t) > 0) {
                    JOptionPane.showMessageDialog(null, "EL primer String es mayor que el segundo");
                } else if (s.compareToIgnoreCase(t) < 0) {
                    JOptionPane.showMessageDialog(null, "EL primer String es menor que el segundo");
                } // end if para compare to
                break;
            default:
                System.out.println("Algo salio mal :(");
                break;
        }// end switch case para los metodos de comparacion
    }// end comparacion

    public void Busqueda(String s, String t, int x) {
        switch (x) {
            case 1:
                if (s.endsWith(t)) { // regresan true or false
                    JOptionPane.showMessageDialog(null, "El primer string SI termina igual que el segundo string");
                } else {
                    JOptionPane.showMessageDialog(null, "El primer string NO termina igual que el segundo string");
                } // end if para ends with
                break;
            case 2:
                if (s.startsWith(t)) { // regresan true or false
                    JOptionPane.showMessageDialog(null, "El primer string SI empieza igual que el segundo string");
                } else {
                    JOptionPane.showMessageDialog(null, "El primer string NO empieza igual que el segundo string");
                } // end if para ends with
                break;
            case 3:
                if (s.indexOf(t) == -1) { // regresa la poscion donde se encuentra la palabra y si no esta da -1
                    JOptionPane.showMessageDialog(null, "No existe");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Se encuentra en la posicion" + s.indexOf(t) + "/n" + s + "/n" + t);// la primera que se
                                                                                                // encuantra
                } // end if else par index of
                break;
            case 4:
                if (s.lastIndexOf(t) == -1) { // regresa la poscion donde se encuentra la palabra y si no esta da -1
                    JOptionPane.showMessageDialog(null, "No existe");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Se encuentra en la posicion" + s.indexOf(t) + "/n" + s + "/n" + t);// la segunda que se
                                                                                                // encuantra
                } // end if else par index of

                break;

            default:
                System.out.println("Algo salio mal");
                break;
        }// end switch

    }// end Busqueda

    public void Transformacion(String s, String t, int x) {
        switch (x) {
            case 1:
                JOptionPane.showMessageDialog(null, "Convertir a minusculas /n" + s + "/n" + s.toLowerCase());
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Convertir a mayusculas /n" + s + "/n" + s.toUpperCase());
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Concatena los Strings /n" + s + " + " + t + "/n" + s.concat(t));
                break;
            case 4:// remplaza letras
                String c1 = JOptionPane.showInputDialog(null, "Letra que queiras cambiar de la palabra " + s);
                String c2 = JOptionPane.showInputDialog(null, "Letra a la cual se remplazara");
                JOptionPane.showMessageDialog(null,
                        "Letra remplazada: " + c1 + " /nPor la letra: " + c2 + " /nPalabra " + s + "/nResultado: "
                                + s.replace(c1, c2));
                break;
            case 5:
                boolean flag = true;// para hacer que no agarren una poscion mayor al tamano de letra

                do {
                    int max = s.length();
                    String entrada1 = JOptionPane.showInputDialog("Ingresa la poscion 1 que sea menor a " + max + " :");
                    int numero1 = Integer.parseInt(entrada1);
                    String entrada2 = JOptionPane.showInputDialog("Ingresa la poscion 2 sea menor a " + max + " :");
                    int numero2 = Integer.parseInt(entrada2);

                    if (numero1 <= max && numero2 <= max) {
                        JOptionPane.showMessageDialog(null, s+"/n"+s.substring(numero1, numero2));
                        flag = false;
                    } else {
                        JOptionPane.showMessageDialog(null, "numeron menores a: " + max);
                        flag = true;
                    }// para que de la bandera verdadera o flsa ya sea si esta corecta
                } while (flag);

                break;

            default:
                System.out.println("Algo salio mal");
                break;
        }
    }

    public static void main(String[] args) {

        s = JOptionPane.showInputDialog(null, "Primer String: ");
        t = JOptionPane.showInputDialog(null, "Segundo String: ");
        s.trim();
        t.trim();// les aplico el trim desde le incio

    }// end main

}// end class