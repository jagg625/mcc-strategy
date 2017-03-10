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
public class DiaFrutasEstrategia extends Venta{

    @Override
    public ResumenVenta realizarVenta(List<Pedido> ticket) {
        
        Predicate<Pedido> predicateFruta = pedido -> pedido.obtenerProducto().obtenerTipoProducto() == TipoProducto.FRUTA;

        Double sumaTotalPrecioUnitarioFrutas = sumaTotalPrecioUnitario(ticket, predicateFruta);
        Double sumaTotalPrecioUnitarioNoFrutas = sumaTotalPrecioUnitario(ticket, predicateFruta.negate());
        
        Double descuentoTotal = sumaTotalPrecioUnitarioFrutas * 0.15 ;
        
        Double subTotal = sumaTotalPrecioUnitarioFrutas + sumaTotalPrecioUnitarioNoFrutas;
        Double iva = subTotal * obtenerIVA();
        Double total =  subTotal + iva - descuentoTotal; 
        String descripcionVenta = "(Día de la fruta)15 % en frutas";
        
        return new ResumenVenta(descripcionVenta, subTotal, total, iva, descuentoTotal);
    }
}
