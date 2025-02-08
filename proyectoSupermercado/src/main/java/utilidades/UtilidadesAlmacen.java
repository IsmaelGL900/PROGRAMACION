package utilidades;

import modelos.Almacen;
import modelos.Producto;

import java.util.List;

public class UtilidadesAlmacen {
    /*V5 5.A*/
    public boolean validarAlmacenes(List<Producto> productos){
        boolean resultado = true;
        int NumProductos = productos.size();

        for (Producto producto: productos){
            int CapAlmacen = producto.getAlmacen().getCapacidad();;
            if (NumProductos < CapAlmacen){
                resultado = true;
            } else
            { resultado = false; }
        }
        return resultado;

    }


}
