package utilidades;

import modelos.Empleado;
import modelos.Empresa;
import modelos.TipoContrato;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UtilidadesEmpresa {
    public List<Empleado> getEmpleadosPorContrato(Empresa empresa, TipoContrato tipoContrato) {
        List<Empleado> empleadosporcontrato = new ArrayList<Empleado>();

        for (Empleado empleado : empresa.getEmpleados()) {
            if (tipoContrato == empleado.getContrato().getTipoContrato()) {
                empleadosporcontrato.add(empleado);
            }
        }
        return empleadosporcontrato;
    }

    public List<Empleado> getMileuristasOrdenadosPorSalario(Empresa empresa) {
        List<Empleado> mileuristas = new ArrayList<Empleado>();

        for (Empleado empleado : empresa.getEmpleados()) {
            if (empleado.getContrato().getSalarioBase() >= 1000 ){
                mileuristas.add(empleado);
            }
        }
        mileuristas.sort(Comparator.comparing (salario -> salario.getContrato().getSalarioBase()));

        return mileuristas;
    }

    public double fondoSalarialEmpresa(Empresa empresa) {
        double salariototal = 0;

        for (Empleado empleado : empresa.getEmpleados()) {
            double salario = empleado.getContrato().getSalarioBase();
            salariototal += salario;
        }
        return salariototal;
    }

    public Empleado getMejorPagado(List<Empresa> empresas) {
        List<Empleado> empleados = new ArrayList<>();

        for (Empresa empresa : empresas) {
            for (Empleado empleado : empresa.getEmpleados()) {
                empleados.add(empleado);
            }
        }
        empleados.sort(Comparator.comparing (empleado -> empleado.getContrato().getSalarioBase()));
        return empleados.get(0);
    }
}
