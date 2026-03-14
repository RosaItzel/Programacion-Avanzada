package Main;import Vista.Principal;
import Vista.VentanaProductos;
import Vista.VentanaVentas;

import Modelo.Gestion;

import CSV.Archivo;

import Controlador.ContProd;
import Controlador.ContVenta;

public class Menu {

    public static void main(String[] args) {

        Principal principal = new Principal();

        VentanaProductos vp = new VentanaProductos();
        VentanaVentas vv = new VentanaVentas();

        Gestion modelo = new Gestion();

        Archivo archivo = new Archivo();

        new ContProd(vp, modelo, archivo);
        new ContVenta(vv, modelo);

        principal.menuProductos.addActionListener(e -> {
            principal.abrirVentana(vp);
        });

        principal.menuVentas.addActionListener(e -> {
            principal.abrirVentana(vv);
        });

        principal.setVisible(true);
    }
}