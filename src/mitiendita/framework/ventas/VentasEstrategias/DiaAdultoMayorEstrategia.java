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
import mitiendita.framework.ventas.Venta;

/**
 *
 * @author jesusarmandoguerragarcia
 */
public class DiaAdultoMayorEstrategia extends Venta {
    
    @Override
    public ResumenVenta realizarVenta(List<Pedido> ticket) {
        Predicate<Pedido> predicateTodosLosPedidos = pedido -> true;
        
        Double sumaTotalPrecioUnitario = sumaTotalPrecioUnitario(ticket, predicateTodosLosPedidos);
        Double descuentoTotal = sumaTotalPrecioUnitario * 0.05;
        
        String descripcionVenta = "(Día del adulto mayor) 5% en el total de la venta para clientes de la 3ª. Edad.";
        Double subTotal = sumaTotalPrecioUnitario;
        Double iva = subTotal * obtenerIVA();
        Double total = subTotal + iva - descuentoTotal;
        
        return new ResumenVenta(descripcionVenta, subTotal, total, iva, descuentoTotal);
    }
}
