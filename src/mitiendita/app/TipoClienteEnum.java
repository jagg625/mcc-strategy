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
public enum TipoClienteEnum {
    TERCER_EDAD("3ra edad"), JOVEN("Joven");
    
    private final String descripcion;

    private TipoClienteEnum(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String obtenerDescripcion(){
        return this.descripcion;
    }
}
