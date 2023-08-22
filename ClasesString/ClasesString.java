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

    public static void main(String[] args) {

        s = JOptionPane.showInputDialog(null, "Primer String: ");
        t = JOptionPane.showInputDialog(null, "Segundo String: ");

    }// end main

}// end class