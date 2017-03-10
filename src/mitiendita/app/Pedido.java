/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mitiendita.app;

/**
 *
 * @author jesusarmandoguerragarcia
 */
public class Pedido {
    private final Integer cantidad;
    private final Producto Producto;

    public Pedido(Integer cantidad, Producto Producto) {
        this.cantidad = cantidad;
        this.Producto = Producto;
    }

    public Integer obtenerCantidad() {
        return cantidad;
    }

    public Producto obtenerProducto() {
        return Producto;
    }
}
