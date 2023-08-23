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
        String p = "";
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
                p = JOptionPane.showInputDialog(null, "Palabra a buscar: ");
                if (s.indexOf(p) == -1) { // regresa la poscion donde se encuentra la palabra y si no esta da -1
                    JOptionPane.showMessageDialog(null, "No existe");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "La palabra "+p+" se encuentra en la posicion " + s.indexOf(p) + "\n" + s );// la primera que se
                                                                                                // encuantra
                } // end if else par index of
                break;
            case 4:
                p = JOptionPane.showInputDialog(null, "Palabra a buscar: ");
                if (s.lastIndexOf(p) == -1) { // regresa la poscion donde se encuentra la palabra y si no esta da -1
                    JOptionPane.showMessageDialog(null, "No existe");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "La palabra "+p+" se encuentra en la posicion " + s.lastIndexOf(p) + "\n" + s);// la segunda que se
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
                JOptionPane.showMessageDialog(null, "Convertir a minusculas \n" + s + "\n" + s.toLowerCase());
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Convertir a mayusculas \n" + s + "\n" + s.toUpperCase());
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Concatena los Strings \n" + s + " + " + t + "\n" + s.concat(t));
                break;
            case 4:// remplaza letras
                String c1 = JOptionPane.showInputDialog(null, "Letra que queiras cambiar de la palabra " + s);
                String c2 = JOptionPane.showInputDialog(null, "Letra a la cual se remplazara");
                JOptionPane.showMessageDialog(null,
                        "Letra remplazada: " + c1 + " \nPor la letra: " + c2 + " \nPalabra " + s + "\nResultado: "
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
                        JOptionPane.showMessageDialog(null, s + "\n" + s.substring(numero1, numero2));
                        flag = false;
                    } else {
                        JOptionPane.showMessageDialog(null, "Los numeros tiene que ser menores a: " + max);
                        flag = true;
                    } // para que de la bandera verdadera o flsa ya sea si esta corecta
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
        ClasesString cs = new ClasesString();
        int opcion;
        do {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "====== MENU Clases String======\n"
                    + "PALABRAS ACUTALMENTE\nPalabra 1: " + s + "\nPalabra 2: " + t
                    + "\nCOMPARACION \n1. equals() \n 2. equalsIgnoreCase() \n 3. compareTo() \n 4. compareToIgnoreCase()"
                    + "\nBUSQUEDA \n5. endsWith() \n6. startsWith() \n7. indexOf() \n8. lastIndexOf()"
                    + "\nTRANSFOMACION \n9. toLowerCase() \n10. toUpperCase() \n11. concat() \n12. replace() \n13. substring()"
                    + "\n0. salir \n 55 Cambiar Strings"));
            switch (opcion) {
                case 1:
                    cs.Comparacion(s, t, 1);
                    break;
                case 2:
                    cs.Comparacion(s, t, 2);
                    break;
                case 3:
                    cs.Comparacion(s, t, 3);
                    break;
                case 4:
                    cs.Comparacion(s, t, 4);
                    break;
                case 5:
                    cs.Busqueda(s, t, 1);
                    break;
                case 6:
                    cs.Busqueda(s, t, 2);
                    break;
                case 7:
                    cs.Busqueda(s, t, 3);
                    break;
                case 8:
                    cs.Busqueda(s, t, 4);
                    break;
                case 9:
                    cs.Transformacion(s, t, 1);
                    break;
                case 10:
                    cs.Transformacion(s, t, 2);
                    break;
                case 11:
                    cs.Transformacion(s, t, 3);
                    break;
                case 12:
                    cs.Transformacion(s, t, 4);
                    break;
                case 13:
                    cs.Transformacion(s, t, 5);
                    break;
                case 55:
                    s = JOptionPane.showInputDialog(null, "Primer String: ");
                    t = JOptionPane.showInputDialog(null, "Segundo String: ");
                    s.trim();
                    t.trim();// les aplico el trim desde le incio
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "opcion invalida");
                    break;
            }

        } while (opcion != 0);

    }// end main

}// end class