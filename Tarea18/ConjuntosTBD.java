
package Tarea18;

import java.time.LocalDate;// para la fecha
import java.time.Period;// y calcular la edad
import java.util.Iterator;// se ncesita un iterator
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import Tarea10.FormatoTabla;

public class ConjuntosTBD {
    static Set<alumnos> HashSet = new HashSet<>();
    static Set<alumnos> LinkedHashSet = new LinkedHashSet<>();
    static Set<alumnos> TreeSet = new TreeSet<>();

    public static class alumnos implements Comparable<alumnos> {
        int matricula;
        String nombre;
        int grupo;
        int dia, mes, year; // dd/mm/aaaa
        String carrera;
        int edad;

        public alumnos(int matricula, String nombre, int grupo, int dia, int mes, int year, String carrera) {
            this.matricula = matricula;
            this.nombre = nombre;
            this.grupo = grupo;
            this.dia = dia;
            this.mes = mes;
            this.year = year;
            this.carrera = carrera;
            this.edad = calcularEdad(dia, mes, year);
        }// end constructor

        // se necesita este comper para el TreeSet ya que el Treeset ordena y necesita
        // saber por cual dato/columna va a ordenar
        public int compareTo(alumnos otroAlumno) {
            return this.nombre.compareTo(otroAlumno.nombre);
        }// end compare to
    }// end class alumnos

    static alumnos NuevoAlumno;

    public static int calcularEdad(int diaNacimiento, int mesNacimiento, int yearNacimiento) {
        LocalDate fechaNacimiento = LocalDate.of(yearNacimiento, mesNacimiento, diaNacimiento);
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();
    }// end calcular edad

    public static boolean exitenciaMatricula(Set<alumnos> conjunto, int matricula) {
        for (alumnos alu : conjunto) {
            if (alu.matricula == matricula) {
                return true;
            } // end if
        } // end for
        return false;
    }// end validar matricula

    public static void altaAlumno(Set<alumnos> conjuntos, int matricula, String nombre, int grupo, int dia, int mes,
            int year, String carrera) {
        NuevoAlumno = new alumnos(matricula, nombre, grupo, dia, mes, year, carrera);
        conjuntos.add(NuevoAlumno);
    }// end alta alumno

    public static void bajaAlumno(Set<alumnos> conjunto, int matricula) {
        Iterator<alumnos> iterator = conjunto.iterator();
        while (iterator.hasNext()) {
            alumnos alu = iterator.next();
            if (alu.matricula == matricula) {
                iterator.remove();
            }
        }
    }// end baja alumno

    public static String localizarAlumno(Set<alumnos> conjunto) {
        for (alumnos alu : conjunto) {
            if (conjunto.contains(alu)) {
                return "El alumno si se encuetra";
            } else {
                return "El alumno no se encuetra";
            } // end if else
        } // end for para recorrer conjunto
        return "El alumno no se encuetra (No debe llegar a imprimir esto)";
    }// end localizar alumno

    public static void ImprimirJOption(Set<alumnos> conjunto, String nombre) {
        FormatoTabla Ft = new FormatoTabla();
        Ft.AgregarColumnas(Ft.Columnas(nombre));
        for (alumnos num : conjunto) {
            Ft.AgregarDatos(Ft.Datos(num));
        } // end for para agregar datos
        Ft.ImprimirTabla();
    }// end Imprimir en Joption pane

    public static void main(String[] args) {
        int opcion;
        do {
            int matricula;
            String nombre;
            int grupo;
            int dia, mes, year; // dd/mm/aaaa
            String carrera;
            boolean segir = true;
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "=========== Menu ConjutnosTBD ==========="
                    + "\n1. Alta alumno \n2. Baja alumno \n3. Imprimir alumno \n4. Localizar"));

            switch (opcion) {
                case 1:
                    do {
                        matricula = Integer.parseInt(JOptionPane.showInputDialog("Introduce la matrícula:"));
                        if (!exitenciaMatricula(LinkedHashSet, matricula)) {
                            segir = false;
                        } else {
                            JOptionPane.showMessageDialog(null, "La matricula " + matricula + " ya existe");
                            segir = true;
                        } // end if else
                    } while (segir);// do while para que pida una matricula que no exista

                    nombre = JOptionPane.showInputDialog("Introduce el nombre:");
                    grupo = Integer.parseInt(JOptionPane.showInputDialog("Introduce el grupo:"));
                    dia = Integer.parseInt(JOptionPane.showInputDialog("Introduce el día de nacimiento:"));
                    mes = Integer.parseInt(JOptionPane.showInputDialog("Introduce el mes de nacimiento:"));
                    year = Integer.parseInt(JOptionPane.showInputDialog("Introduce el año de nacimiento:"));
                    carrera = JOptionPane.showInputDialog("Introduce la carrera:");
                    altaAlumno(HashSet, matricula, nombre, grupo, dia, mes, year, carrera);
                    altaAlumno(TreeSet, matricula, nombre, grupo, dia, mes, year, carrera);
                    altaAlumno(LinkedHashSet, matricula, nombre, grupo, dia, mes, year, carrera);
                    break;
                case 2:
                    do {
                        matricula = Integer.parseInt(JOptionPane.showInputDialog("Introduce la matrícula:"));
                        if (!exitenciaMatricula(LinkedHashSet, matricula)) {
                            JOptionPane.showMessageDialog(null, "La matricula " + matricula + " no existe");
                            segir = true;
                        } else {
                            segir = false;
                        } // end if else
                    } while (segir);// do while para que pida una matricula que si oexista
                    bajaAlumno(HashSet, matricula);
                    bajaAlumno(TreeSet, matricula);
                    bajaAlumno(LinkedHashSet, matricula);

                    break;
                case 3:
                    int opcion2 = Integer.parseInt(JOptionPane.showInputDialog("      Que set quieres imprimir?"
                            + "\n1. Hashset \n2.TreeSet \n3.LinkedHashSet"));
                    ;
                    switch (opcion2) {
                        case 1:
                            // ImprimirJOption(HashSet, "Hasset");
                            break;
                        case 2:
                            break;
                        case 3:
                            break;

                        default:
                            break;
                    }

                    break;

                default:
                    break;
            }
        } while (opcion != 0);
    }// end main
}// end class