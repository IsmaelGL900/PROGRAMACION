package utilidades;

import modelos.Contrato;
import modelos.TipoContrato;

import java.util.*;

public class UtilidadesContrato {

    /*V4 1.A*/
    public Map<TipoContrato, Double> getSalarioMedioTipoContrato(List<Contrato> contratos) {
        Map<TipoContrato, Double> salarioMedioTipoContrato = new HashMap<>();

        for (Contrato c : contratos) {
            TipoContrato tipoContrato = c.getTipoContrato();
            double salario = c.getSalarioBase();
            salarioMedioTipoContrato.put(tipoContrato, salario);
        }
        System.out.println(salarioMedioTipoContrato);
        return salarioMedioTipoContrato;
    }

    /*V4 1.B*/
    public Map<TipoContrato, Integer> getNumContratosPorTipo(List<Contrato> contratos) {
        Map<TipoContrato, Integer> numContratosPorTipo = new HashMap<>();
        for (Contrato c : contratos) {
            TipoContrato tipoContrato = c.getTipoContrato();

            if (numContratosPorTipo.containsKey(tipoContrato)) {
                numContratosPorTipo.put(tipoContrato, numContratosPorTipo.get(tipoContrato) + 1);
            } else {
                numContratosPorTipo.put(tipoContrato, 1);
            }

        }
        return numContratosPorTipo;
    }

    /*V4 1.C*/
    public Map<TipoContrato, List<Contrato>> getListContratosPorTipo(List<Contrato> contratos) {
        Map<TipoContrato, List<Contrato>> listContratosPorTipo = new HashMap<>();

        for (Contrato c : contratos) {
            TipoContrato tipoContrato = c.getTipoContrato();
            listContratosPorTipo.putIfAbsent(tipoContrato, new ArrayList<>());
            listContratosPorTipo.get(tipoContrato).add(c);
        }
        return listContratosPorTipo;
    }


}
