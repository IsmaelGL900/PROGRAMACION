package utilidades;
import modelos.Almacen;
import modelos.Producto;
import modelos.TipoProducto;

import java.util.ArrayList;
import java.util.List;

public class UtilidadesProducto {

    public List<Producto> getPorTipo(List<Producto> productos, TipoProducto tipo){
        List<Producto> productosTipo = new ArrayList<Producto>();
        for(Producto producto: productos){
            if(producto.getTipo().equals(tipo)){
                productosTipo.add(producto);
            }
        }
        return productosTipo;
    }

    public List<Producto> getPorAlmacen(List<Producto> productos, Almacen almacen){
        List<Producto> productosPorAlmacen = new ArrayList<Producto>();
        for(Producto producto: productos){
            if(producto.getAlmacen().equals(almacen)){
                productosPorAlmacen.add(producto);
            }
        }
        return productosPorAlmacen;
    }


}
