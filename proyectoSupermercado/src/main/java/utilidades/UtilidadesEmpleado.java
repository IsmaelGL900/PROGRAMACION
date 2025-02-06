package utilidades;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelos.Empleado;
import modelos.Empresa;
import modelos.TipoEmpresa;


public class UtilidadesEmpleado {
    /*V4 2.A*/
    public Map<String, List<Empleado>> getEmpleadosPorLetraDNI(List<Empleado> empleados) {
        Map<String, List<Empleado>> empleadosPorLetraDNI = new HashMap<String, List<Empleado>>();

        for (Empleado empleado : empleados) {
            String dni = empleado.getDni();
            for (char letra : dni.toCharArray()) {
                String letraLetra = String.valueOf(letra);
                empleadosPorLetraDNI.computeIfAbsent(letraLetra, l -> new ArrayList<>()).add(empleado);
            }

        }
        return empleadosPorLetraDNI;
    }

    /*V4 2.B*/
    public Map<Empresa, List<Empleado>> getEmpleadosPorEmpresa(List<Empleado> empleados) {
        Map<Empresa, List<Empleado>> empleadosPorEmpresa = new HashMap<>();

        for (Empleado empleado : empleados) {
            Empresa empresa = empleado.getEmpresa();
            empleadosPorEmpresa.putIfAbsent(empresa, new ArrayList<>());
            empleadosPorEmpresa.get(empresa).add(empleado);
        }
        return empleadosPorEmpresa;
    }

}
