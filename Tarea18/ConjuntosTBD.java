
package Tarea18;

import java.time.LocalDate;// para la fecha
import java.time.Period;// y calcular la edad
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

    public static class alumnos {
        int matricula;
        String nombre;
        int grupo;
        int dia, mes, year; // dd/mm/aaaa
        String carrera;

        public alumnos(int matricula, String nombre, int grupo, int dia, int mes, int year, String carrera) {
            this.matricula = matricula;
            this.nombre = nombre;
            this.grupo = grupo;
            this.dia = dia;
            this.mes = mes;
            this.year = year;
            this.carrera = carrera;
        }// end constructor
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
        for (alumnos alu : conjunto) {
            if (alu.matricula == matricula) {
                conjunto.remove(alu);
            } // elimina el alumno si lo encuetra
        } // end for para recorrer alumno
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

    public static void ImprimirJOption(Set<String> conjunto, String nombre) {
        FormatoTabla Ft = new FormatoTabla();
        Ft.AgregarColumnas(Ft.Columnas(nombre));
        for (String num : conjunto) {
            Ft.AgregarDatos(Ft.Datos(num));
        } // end for para agregar datos
        Ft.ImprimirTabla();
    }// end Imprimir en Joption pane

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "=========== Menu ConjutnosTBD ==========="
                    + "\n1. Alta alumno \n2. Baja alumno \n3. Imprimir alumno \n4. Localizar"));

            switch (opcion) {
                case 1:
                        
                    break;
                case 2:

                    break;
                case 3:

                    break;

                default:
                    break;
            }
        } while (opcion != 0);
    }// end main
}// end class