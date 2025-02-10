import modelos.Alumno;
import modelos.Colegio;
import modelos.TipoCurso;

import java.time.LocalDate;
import java.util.ArrayList;

public class PruebasPracticaEvaluable1 {
    public static void main(String[] args) {
        Colegio colegio = new Colegio(1,"Safa Reyes","Calle Calatrava", LocalDate.of(1980,10,10),new ArrayList<>());
        Alumno alumno = new Alumno(1,"77863963Q","Ismael","Guerrero López",LocalDate.of(2006,2,26), TipoCurso.CICLOS);
        colegio.getAlumnos().add(alumno);

        System.out.println(colegio);
        System.out.println(alumno);
    }
}
