package modelos;

import java.time.LocalDate;
import java.util.Objects;

public class Alumno {

    private int identificador;
    private String dni;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private TipoCurso tipoCurso;

    public Alumno(int identificador, String dni, String nombre, String apellidos, LocalDate fechaNacimiento, TipoCurso tipoCurso) {
        this.identificador = identificador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoCurso = tipoCurso;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public TipoCurso getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(TipoCurso tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return identificador == alumno.identificador && Objects.equals(dni, alumno.dni) && Objects.equals(nombre, alumno.nombre) && Objects.equals(apellidos, alumno.apellidos) && Objects.equals(fechaNacimiento, alumno.fechaNacimiento) && tipoCurso == alumno.tipoCurso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, dni, nombre, apellidos, fechaNacimiento, tipoCurso);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "identificador=" + identificador +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", tipoCurso=" + tipoCurso +
                '}';
    }
}
