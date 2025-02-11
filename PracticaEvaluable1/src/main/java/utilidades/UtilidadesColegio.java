package utilidades;

import modelos.Alumno;
import modelos.Colegio;
import modelos.TipoCurso;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesColegio {
    public static Integer totalAlumnos(List <Colegio> colegios) {
        Integer total = 0;
        for (Colegio colegio : colegios) {
            int numeroAlumnos = colegio.getAlumnos().size();
            total += numeroAlumnos;
        }
        return total;
    }

    public static List<Alumno> mayoresEdad(Colegio colegio) {
        List<Alumno> alumnosmayores = new ArrayList<Alumno>();
        for (Alumno alumno : colegio.getAlumnos()) {
            /*Tambien con Period.between valia*/
            if (ChronoUnit.YEARS.between(alumno.getFechaNacimiento(), LocalDate.now()) >= 18 && alumno.getTipoCurso() == TipoCurso.CICLOS) {
                alumnosmayores.add(alumno);
            }
        }
        return alumnosmayores;
    }

    public static Map<Colegio, Integer> totalAlumnosPorColegio(List <Colegio> colegios) {
        Map<Colegio, Integer> totalAlumnos = new HashMap<Colegio, Integer>();

        for (Colegio colegio : colegios) {
            int numeroAlumnos = colegio.getAlumnos().size();
            totalAlumnos.put(colegio, numeroAlumnos);
        }
        return totalAlumnos;
    }

    public static Map<TipoCurso, List<Alumno>> alumnosPorCurso(Colegio colegio) {
        Map<TipoCurso, List<Alumno>> alumnotipocurso = new HashMap<TipoCurso, List<Alumno>>();

        for (Alumno alumno : colegio.getAlumnos()) {
            if (alumnotipocurso.containsKey(alumno.getTipoCurso())) {
                alumnotipocurso.get(alumno.getTipoCurso()).add(alumno);
            } else {
                alumnotipocurso.put(alumno.getTipoCurso(), new ArrayList<>(List.of(alumno)));
            }
        }
        return alumnotipocurso;
    }
}
