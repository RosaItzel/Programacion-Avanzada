package Controlador;

import Modelo.Producto;
import Modelo.Gestion;
import Vista.VentanaVentas;
import Modelo.Ticket;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ContVenta implements ActionListener {

    private VentanaVentas vista;
    private Gestion modelo;

    double total = 0;

    
    public ContVenta(VentanaVentas vista, Gestion modelo){

        this.vista = vista;
        this.modelo = modelo;

        vista.btnBuscar.addActionListener(this);
        vista.btnAgregar.addActionListener(this);
        vista.btnCobrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==vista.btnBuscar){
            buscarProducto();
        }

        if(e.getSource()==vista.btnAgregar){
            agregarVenta();
        }

        if(e.getSource()==vista.btnCobrar){
            cobrar();
        }
    }

    private Producto productoActual;

    private void buscarProducto(){

        try{

            int id = Integer.parseInt(vista.txtIdProducto.getText());

            productoActual = modelo.buscar(id);

            if(productoActual != null){

                JOptionPane.showMessageDialog(null,
                        "Producto: " + productoActual.getNombre() +
                        "\nPrecio: $" + productoActual.getPrecio());

            }else{
                JOptionPane.showMessageDialog(null,"Producto no encontrado");
            }

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ID inválido");
        }
    }

    private void agregarVenta(){

        try{

            int cantidad = Integer.parseInt(vista.txtCantidad.getText());

            if(productoActual == null){
                JOptionPane.showMessageDialog(null,"Primero busca un producto");
                return;
            }

            double subtotal = cantidad * productoActual.getPrecio();

            DefaultTableModel modeloTabla =
                    (DefaultTableModel) vista.tablaVenta.getModel();

            Object[] fila = {
                    productoActual.getId(),
                    productoActual.getNombre(),
                    cantidad,
                    productoActual.getPrecio(),
                    subtotal
            };

            modeloTabla.addRow(fila);

            total += subtotal;

            vista.lblTotal.setText("Total: $" + total);

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Cantidad inválida");
        }
    }

    private void cobrar(){

        Ticket ticket = new Ticket();

        DefaultTableModel modeloTabla =
                (DefaultTableModel) vista.tablaVenta.getModel();

        for(int i = 0; i < modeloTabla.getRowCount(); i++){

            String nombre = modeloTabla.getValueAt(i,1).toString();
            int cantidad = Integer.parseInt(modeloTabla.getValueAt(i,2).toString());
            double precio = Double.parseDouble(modeloTabla.getValueAt(i,3).toString());

            Producto p = new Producto(cantidad, nombre, nombre, cantidad, precio, nombre);

            ticket.agregarProducto(p);
        }

        String textoTicket = ticket.generarTicket();

        JOptionPane.showMessageDialog(null, textoTicket);

        try{

            FileWriter archivo = new FileWriter("ventas.txt", true);
            PrintWriter escribir = new PrintWriter(archivo);

            escribir.println(textoTicket);
            escribir.println("----------------------------");

            escribir.close();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al guardar ticket");
        }

        modeloTabla.setRowCount(0);

        total = 0;

        vista.lblTotal.setText("Total: $0");
    }
}