package modelos;

import java.util.Objects;

public class Escalabilidad {

    private int id;
    private Double incrementoDañoNivel;
    private Double incrementoDefensaNivel;
    private Double incrementoSaludNivel;
    private Double incrementoManaNivel;

    public Escalabilidad(int id, Double incrementoDañoNivel, Double incrementoDefensaNivel, Double incrementoSaludNivel, Double incrementoManaNivel) {
        this.id = id;
        this.incrementoDañoNivel = incrementoDañoNivel;
        this.incrementoDefensaNivel = incrementoDefensaNivel;
        this.incrementoSaludNivel = incrementoSaludNivel;
        this.incrementoManaNivel = incrementoManaNivel;
    }

    public Escalabilidad() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getIncrementoDañoNivel() {
        return incrementoDañoNivel;
    }

    public void setIncrementoDañoNivel(Double incrementoDañoNivel) {
        this.incrementoDañoNivel = incrementoDañoNivel;
    }

    public Double getIncrementoDefensaNivel() {
        return incrementoDefensaNivel;
    }

    public void setIncrementoDefensaNivel(Double incrementoDefensaNivel) {
        this.incrementoDefensaNivel = incrementoDefensaNivel;
    }

    public Double getIncrementoSaludNivel() {
        return incrementoSaludNivel;
    }

    public void setIncrementoSaludNivel(Double incrementoSaludNivel) {
        this.incrementoSaludNivel = incrementoSaludNivel;
    }

    public Double getIncrementoManaNivel() {
        return incrementoManaNivel;
    }

    public void setIncrementoManaNivel(Double incrementoManaNivel) {
        this.incrementoManaNivel = incrementoManaNivel;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Escalabilidad that = (Escalabilidad) o;
        return id == that.id && Objects.equals(incrementoDañoNivel, that.incrementoDañoNivel) && Objects.equals(incrementoDefensaNivel, that.incrementoDefensaNivel) && Objects.equals(incrementoSaludNivel, that.incrementoSaludNivel) && Objects.equals(incrementoManaNivel, that.incrementoManaNivel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, incrementoDañoNivel, incrementoDefensaNivel, incrementoSaludNivel, incrementoManaNivel);
    }

    @Override
    public String toString() {
        return "Escalabilidad{" +
                "id=" + id +
                ", incrementoDañoNivel=" + incrementoDañoNivel +
                ", incrementoDefensaNivel=" + incrementoDefensaNivel +
                ", incrementoSaludNivel=" + incrementoSaludNivel +
                ", incrementoManaNivel=" + incrementoManaNivel +
                '}';
    }
}
