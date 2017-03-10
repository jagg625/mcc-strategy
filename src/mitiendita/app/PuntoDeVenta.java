/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mitiendita.app;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import mitiendita.framework.ventas.Venta;
import mitiendita.framework.ventas.VentasEstrategias.DiaAdultoMayorEstrategia;
import mitiendita.framework.ventas.VentasEstrategias.DiaEmbutidosYLacteosEstrategia;
import mitiendita.framework.ventas.VentasEstrategias.DiaFrutasEstrategia;
import mitiendita.framework.ventas.VentasEstrategias.DiaMenonitaEstrategia;
import mitiendita.framework.ventas.VentasEstrategias.DiaSinDescuentoEstrategia;

/**
 *
 * @author jesusarmandoguerragarcia
 */
public class PuntoDeVenta {

    public void iniciar() {

        List<Pedido> ticket = Arrays.asList(
                new Pedido(10, new Producto("Leche", 15.50, "Lts", TipoProducto.LACTEO)),
                new Pedido(500, new Producto("Crema", 10.0 / 1000, "Gr", TipoProducto.LACTEO)),
                new Pedido(250, new Producto("Mantequilla", 4.50 / 1000, "Gr", TipoProducto.LACTEO)),
                new Pedido(500, new Producto("Queso", 100.0 / 1000, "Gr", TipoProducto.LACTEO)),
                new Pedido(1000, new Producto("Plátano", 14.0 / 1000, "Gr", TipoProducto.FRUTA)),
                new Pedido(2000, new Producto("Manzana", 13.0 / 1000, "Gr", TipoProducto.FRUTA)));

        Venta ventaEstrategia;
        TipoClienteEnum tipoClienteEnum = TipoClienteEnum.JOVEN;

        DiaEnum[] dias = DiaEnum.values();

        for (DiaEnum dia : dias) {
            ventaEstrategia = obtenerVentaEstrategia(dia, tipoClienteEnum);

            ResumenVenta resumenVenta = ventaEstrategia.realizarVenta(ticket);

            imprimirVenta(dia, tipoClienteEnum, ticket, resumenVenta);
        }
    }

    public Venta obtenerVentaEstrategia(DiaEnum diaEnum, TipoClienteEnum tipoClienteEnum) {
        Venta ventaEstrategia = null;

        switch (diaEnum) {
            case LUNES:
            case DOMINGO:
                if (tipoClienteEnum == TipoClienteEnum.TERCER_EDAD) {
                    ventaEstrategia = new DiaAdultoMayorEstrategia();
                } else {
                    ventaEstrategia = new DiaSinDescuentoEstrategia();
                }
                break;
            case MARTES:
                ventaEstrategia = new DiaSinDescuentoEstrategia();
                break;
            case MIERCOLES:
                ventaEstrategia = new DiaMenonitaEstrategia();
                break;
            case JUEVES:
                ventaEstrategia = new DiaFrutasEstrategia();
                break;
            case VIERNES:
                ventaEstrategia = new DiaEmbutidosYLacteosEstrategia();
                break;
            case SABADO:
                ventaEstrategia = new DiaSinDescuentoEstrategia();
                break;
        }

        return ventaEstrategia;
    }

    private void imprimirVenta(DiaEnum diaEnum, TipoClienteEnum tipoClienteEnum, List<Pedido> ticket, ResumenVenta resumenVenta) {

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        numberFormat.setMaximumFractionDigits(2);

        System.out.println("*************************************************************************");
        System.out.println("Día de la venta : " + diaEnum.obtenerNombre());
        System.out.println("Descripcion de la venta : " + resumenVenta.obtenerDescripcionVenta());
        System.out.println("Es un cliente " + (tipoClienteEnum == TipoClienteEnum.JOVEN ? tipoClienteEnum.obtenerDescripcion() : "de la " + tipoClienteEnum.obtenerDescripcion()));

        ticket.stream().forEach((pedido) -> {

            String cantidad = null;
            Producto producto = pedido.obtenerProducto();

            if (producto.obtenerUnidadMedida().toUpperCase().compareTo("GR") == 0) {
                cantidad = ((double)pedido.obtenerCantidad() / 1000) + " " + " kg";
            } else {
                cantidad = pedido.obtenerCantidad() + " " + pedido.obtenerProducto().obtenerUnidadMedida();
            }

            System.out.println(cantidad + " " + producto.obtenerNombre());
        });

        System.out.println("");

        String subTotal = numberFormat.format(resumenVenta.obtenerSubTotal());
        String IVA = numberFormat.format(resumenVenta.obtenerIva());
        String total = numberFormat.format(resumenVenta.obtenerTotal());
        String descuento = numberFormat.format(resumenVenta.obtenerDescuento());

        System.out.println("Subtotal : " + subTotal + ", IVA : " + IVA + ", descuento : " + descuento + ", total : " + total);
        System.out.println("*************************************************************************");
    }
}
