package utilidades;
import modelos.Cliente;
import modelos.Factura;
import modelos.LineaFactura;
import java.time.LocalDate;
import java.util.List;

public class UtilidadesFactura {

    public boolean esFacturaVencida(Factura factura){

        return factura.getFechaVencimiento().isAfter(LocalDate.now())
        ||
        factura.getFechaVencimiento().isEqual(LocalDate.now());
    }

    public double calcularBaseFactura(Factura factura) {
        double importeBase = 0.0;
        for (LineaFactura linea : factura.getLineaFacturas()){
            importeBase += (linea.getCantidad()*linea.getProducto().getPrecio());
        }
        return importeBase;
    }

    public double calcularTotalAPagar(Factura factura){
        double importeBase = calcularBaseFactura(factura);
        double totalAPagar = (importeBase - factura.getDescuento())*factura.getIva();
        return totalAPagar;
    }

    /*V5 3.A*/
    public Double gastoTotalCliente(List<Factura> facturas, Cliente cliente){
        Double totalCliente = 0.0;

        for (Factura factura : facturas){
            if( factura.getCliente().equals(cliente) ){
                totalCliente += calcularTotalAPagar(factura);
            }
        }
        return totalCliente;
    }

    /*V5 3.B*/
    public Double totalFacturadoPeriodo(List<Factura> facturas, LocalDate fechaInicio, LocalDate fechaFin) {
        Double totalFacturadoPeriodo = 0.0;

        for (Factura factura : facturas){
            if (fechaInicio.isAfter(factura.getFechaEmision()) || fechaFin.isBefore(factura.getFechaVencimiento())){
                totalFacturadoPeriodo += calcularTotalAPagar(factura);
            }
        }
        return totalFacturadoPeriodo;
    }

}
