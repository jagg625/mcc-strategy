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
public class DiaEmbutidosYLacteosEstrategia extends Venta {

    @Override
    public ResumenVenta realizarVenta(List<Pedido> ticket) {

        Predicate<Pedido> predicateEmbutido = pedido -> pedido.obtenerProducto().obtenerTipoProducto() == TipoProducto.EMBUTIDO;
        Predicate<Pedido> predicateLacteos = pedido -> pedido.obtenerProducto().obtenerTipoProducto() == TipoProducto.LACTEO;

        Double sumaTotalPrecioUnitarioEmbutidos = sumaTotalPrecioUnitario(ticket, predicateEmbutido);
        Double sumaTotalPrecioUnitarioLacteos = sumaTotalPrecioUnitario(ticket, predicateLacteos);
        Double sumaTotalPrecioUnitarioNoEmbutidoNoLacteo = sumaTotalPrecioUnitario(ticket, predicateEmbutido.negate().and(predicateLacteos).negate());

        Double descuentoEnEmbutidos = sumaTotalPrecioUnitarioEmbutidos * 0.05;
        Double descuentoEnLacteos = sumaTotalPrecioUnitarioLacteos * 0.15;

        Double descuentoTotal = descuentoEnEmbutidos + descuentoEnLacteos;

        Double subTotal = sumaTotalPrecioUnitarioEmbutidos + sumaTotalPrecioUnitarioLacteos + sumaTotalPrecioUnitarioNoEmbutidoNoLacteo;
        Double iva = subTotal * obtenerIVA();
        Double total = subTotal + iva - descuentoTotal;
        String descripcionDelaVenta = " (Día de embutidos y lácteos), 5% en embutidos y 15% en lácteos.";

        return new ResumenVenta(descripcionDelaVenta, subTotal, total, iva, descuentoTotal);
    }
}
