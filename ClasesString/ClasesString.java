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
        }//end switch

    }// end Busqueda

    public static void main(String[] args) {

        s = JOptionPane.showInputDialog(null, "Primer String: ");
        t = JOptionPane.showInputDialog(null, "Segundo String: ");

    }// end main

}// end class