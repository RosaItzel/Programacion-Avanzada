package Modelo;

import java.util.ArrayList;

public class Ticket {

    private ArrayList<Producto> productos;
    private double subtotal;
    private double iva;
    private double total;

    public Ticket() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
        subtotal += p.getPrecio() * p.getCantidad();
        calcularTotal();
    }

    private void calcularTotal() {
        iva = subtotal * 0.16;
        total = subtotal + iva;
    }

    public String generarTicket() {

        String ticket = "";
        ticket += "----- TICKET DE COMPRA -----\n";

        for (Producto p : productos) {
            ticket += p.getNombre() + "  *" + p.getCantidad() +
                      "  $ " + (p.getPrecio() * p.getCantidad()) + "\n";
        }

        ticket += "\nSubtotal: $" + subtotal;
        ticket += "\nIVA (16%): $" + iva;
        ticket += "\nTotal: $" + total;

        return ticket;
    }

}