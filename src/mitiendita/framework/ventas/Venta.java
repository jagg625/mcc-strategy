/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mitiendita.framework.ventas;

import java.util.List;
import java.util.function.Predicate;
import mitiendita.app.Pedido;
import mitiendita.app.ResumenVenta;

/**
 *
 * @author jesusarmandoguerragarcia
 */
public abstract class Venta {

    private final Double IVA = 0.16d;

    public Double obtenerIVA() {
        return IVA;
    }

    public Double sumaTotalPrecioUnitario(List<Pedido> ticket, Predicate<Pedido> predicate) {
        
        Double sumaTotalPrecioUnitario = ticket.stream()
                .filter(predicate)
                .mapToDouble(pedido -> pedido.obtenerCantidad() * pedido.obtenerProducto().obtenerPrecioUnitario())
                .sum();
  
        return sumaTotalPrecioUnitario;       
    }

    public abstract ResumenVenta realizarVenta(List<Pedido> ticket);
}
