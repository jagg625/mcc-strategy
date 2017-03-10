/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mitiendita.framework.ventas.VentasEstrategias;

import java.util.List;
import java.util.function.Predicate;
import mitiendita.app.Pedido;
import mitiendita.app.ResumenVenta;
import mitiendita.app.TipoProducto;
import mitiendita.framework.ventas.Venta;

/**
 *
 * @author jesusarmandoguerragarcia
 */
public class DiaMenonitaEstrategia extends Venta{

    @Override
    public ResumenVenta realizarVenta(List<Pedido> ticket) {
        Predicate<Pedido> predicateLacteo = pedido -> pedido.obtenerProducto().obtenerTipoProducto() == TipoProducto.LACTEO;

        Double sumaTotalPrecioUnitarioLacteo = sumaTotalPrecioUnitario(ticket, predicateLacteo);
        Double sumaTotalPrecioUnitarioNoLacteo = sumaTotalPrecioUnitario(ticket, predicateLacteo.negate());
        
        Double descuentoTotal = sumaTotalPrecioUnitarioLacteo * 0.10 ;
        
        Double subTotal = sumaTotalPrecioUnitarioLacteo + sumaTotalPrecioUnitarioNoLacteo;
        Double iva = subTotal * obtenerIVA();
        Double total = subTotal + iva - descuentoTotal;
        String descripcionVenta = "(Día menonita) 10% en lácteos";
        
        return new ResumenVenta(descripcionVenta, subTotal, total, iva, descuentoTotal);
    }
}
