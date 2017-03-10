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
public enum DiaEnum {
    LUNES("Lunes"), MARTES("Martes"), MIERCOLES("Miercoles"), JUEVES("Jueves"), VIERNES("Viernes"), SABADO("Sabado"), DOMINGO("Domingo");
    
    private final String nombre;

    private DiaEnum(String nombre) {
        this.nombre = nombre;
    }
    
    public String obtenerNombre(){
        return this.nombre;
    }
}
