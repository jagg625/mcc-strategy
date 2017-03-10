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
public class Producto {
    private final String nombre;
    private final Double precioUnitario;
    private final String unidadMedida;
    private final TipoProducto tipoProducto;

    public Producto(String nombre, Double precioUnitario, String unidadMedida, TipoProducto tipoProducto) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.unidadMedida = unidadMedida;
        this.tipoProducto = tipoProducto;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public Double obtenerPrecioUnitario() {
        return precioUnitario;
    }

    public String obtenerUnidadMedida() {
        return unidadMedida;
    }

    public TipoProducto obtenerTipoProducto() {
        return tipoProducto;
    }
}
