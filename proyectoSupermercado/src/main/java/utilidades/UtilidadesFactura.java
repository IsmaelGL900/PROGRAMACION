package utilidades;
import modelos.Factura;
import modelos.LineaFactura;
import java.time.LocalDate;

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
}
