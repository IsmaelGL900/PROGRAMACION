package utilidades;

import modelos.Empleado;
import modelos.Empresa;
import modelos.TipoContrato;
import modelos.TipoEmpresa;

import java.util.*;

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

    /*V4 3.A*/
    public Map<TipoEmpresa, Integer> getNumEmpresasPorTipo(List<Empresa> empresas) {
        Map<TipoEmpresa, Integer> numEmpresasPorTipo = new HashMap<TipoEmpresa, Integer>();

        for (Empresa empresa : empresas) {
            TipoEmpresa tipoEmpresa = empresa.getTipoEmpresa();
            if (numEmpresasPorTipo.containsKey(tipoEmpresa)) {
                numEmpresasPorTipo.put(tipoEmpresa, numEmpresasPorTipo.get(tipoEmpresa) + 1);
            } else {
                numEmpresasPorTipo.put(tipoEmpresa, 1);
            }

        }
        return numEmpresasPorTipo;
    }

    /*V4 3.B & V5 3.C*/
    public Map<TipoEmpresa,Integer> getNumEmpleadosPorTipoEmpresa(List<Empresa> empresa) {
        Map<TipoEmpresa, Integer> numEmpleadosPorTipo = new HashMap<>();

        for (Empresa empresas : empresa) {
            TipoEmpresa tipoempresa = empresas.getTipoEmpresa();
            int numEmpleados = empresas.getEmpleados().size();
            empresas.getEmpleados().size();
            numEmpleadosPorTipo.put(tipoempresa, numEmpleadosPorTipo.getOrDefault(tipoempresa, 0) + numEmpleados);
        }

        return numEmpleadosPorTipo;
    }

    /*V5 2.A*/
    public List<Empleado> getEmpleadosPymePracticas(List<Empresa> empresas) {
        List<Empleado> empleadosPyme = new ArrayList<>();

        for (Empresa empresa : empresas) {
            if (empresa.getTipoEmpresa() == TipoEmpresa.valueOf("PYME")) {
                for (Empleado empleado : empresa.getEmpleados()) {
                    if (empleado.getContrato().getTipoContrato() == TipoContrato.valueOf("PRACTICAS")) {
                        empleadosPyme.add(empleado);
                    }
                }
            }
        }
        return empleadosPyme;
    }

    /*V5 2.B*/
    public Map<Empresa,Empleado> getLosMejorPagadosPorEmpresa(List<Empresa> empresas) {
        Map<Empresa,Empleado> losMejorPagados = new HashMap<>();

        for (Empresa empresa : empresas) {
            Empleado mejorpagado = null;
            for (Empleado empleado : empresa.getEmpleados()) {
                if (mejorpagado == null || empleado.getContrato().getSalarioBase() > mejorpagado.getContrato().getSalarioBase()) {
                    mejorpagado = empleado;
                }
            }

            if (mejorpagado != null) {
                losMejorPagados.put(empresa, mejorpagado);
            }
        }
        return losMejorPagados;
    }


}
