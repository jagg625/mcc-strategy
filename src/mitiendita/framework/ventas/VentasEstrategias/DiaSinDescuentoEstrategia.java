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
public class DiaSinDescuentoEstrategia extends Venta {

    @Override
    public ResumenVenta realizarVenta(List<Pedido> ticket) {

        Predicate<Pedido> predicateTodosLosProductos = producto -> true;
        Double subTotal = sumaTotalPrecioUnitario(ticket, predicateTodosLosProductos);
        Double iva = subTotal * obtenerIVA();
        Double total = subTotal + iva;
        String descripcionDelaVenta = "No hay descuentos.";

        return new ResumenVenta(descripcionDelaVenta, subTotal, total, iva, 0d);
    }
}
