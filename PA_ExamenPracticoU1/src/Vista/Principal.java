package Vista;

import javax.swing.*;
import java.awt.event.*;

public class Principal extends JFrame {

    public JDesktopPane escritorio = new JDesktopPane();

    public JMenuItem menuProductos = new JMenuItem("Productos");
    public JMenuItem menuVentas = new JMenuItem("Punto de Venta");
    public JMenuItem menuSalir = new JMenuItem("Salir");

    public Principal(){

        setTitle("Sistema de Tienda");
        setSize(1000,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setContentPane(escritorio);

        JMenuBar barra = new JMenuBar();

        JMenu menu = new JMenu("Sistema");

        menu.add(menuProductos);
        menu.add(menuVentas);
        menu.addSeparator();
        menu.add(menuSalir);

        barra.add(menu);

        setJMenuBar(barra);

        menuSalir.addActionListener(e -> System.exit(0));
    }

    public void abrirVentana(JInternalFrame ventana){

        escritorio.add(ventana);
        ventana.setVisible(true);

        try{
            ventana.setSelected(true);
        }catch(Exception e){}
    }
}