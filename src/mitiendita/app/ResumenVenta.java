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
public class ResumenVenta {
    
    private final String descripcionVenta;
    private final Double subTotal;
    private final Double total;
    private final Double iva;
    private final Double descuento;

    public ResumenVenta(String descripcionVenta, Double subTotal, Double total, Double iva, Double descuento) {
        this.subTotal = subTotal;
        this.total = total;
        this.iva = iva;
        this.descuento = descuento;
        this.descripcionVenta = descripcionVenta;
    }

    public Double obtenerSubTotal() {
        return subTotal;
    }

    public Double obtenerTotal() {
        return total;
    }

    public Double obtenerIva() {
        return iva;
    }

    public Double obtenerDescuento() {
        return descuento;
    }
    
    public String obtenerDescripcionVenta(){
        return descripcionVenta;
    }
    
    @Override
    public String toString() {
        return "ResumenVenta{" + "subTotal=" + subTotal + ", iva=" + iva +", total=" + total +  "}";
    }
}
