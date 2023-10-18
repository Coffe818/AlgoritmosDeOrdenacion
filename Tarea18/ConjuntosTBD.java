
package Tarea18;

import java.time.LocalDate;// para la fecha
import java.time.Period;// y calcular la edad
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

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

    public static void bajaAlumno(Set<alumnos> conjunto , int matricula){
        for (alumnos alu : conjunto){
            if (alu.matricula == matricula) {
                conjunto.remove(alu);
            }// elimina el alumno si lo encuetra
        }// end for para recorrer alumno
    }// end baja alumno

    public static void localizarAlumno(Set<alumnos> conjunto){
        
    }


}
// end class