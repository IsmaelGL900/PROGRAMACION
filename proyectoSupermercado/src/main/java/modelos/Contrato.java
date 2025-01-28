package modelos;

import java.util.Objects;

public class Contrato {

    private int identificador;
    private double salarioBase;
    private TipoContrato tipoContrato;

    public Contrato(int identificador, double salarioBase, TipoContrato tipoContrato) {
        this.identificador = identificador;
        this.salarioBase = salarioBase;
        this.tipoContrato = tipoContrato;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contrato contrato = (Contrato) o;
        return identificador == contrato.identificador && Double.compare(salarioBase, contrato.salarioBase) == 0 && tipoContrato == contrato.tipoContrato;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, salarioBase, tipoContrato);
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "identificador=" + identificador +
                ", salarioBase=" + salarioBase +
                ", tipoContrato=" + tipoContrato +
                '}';
    }
}