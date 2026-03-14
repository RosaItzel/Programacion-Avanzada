package Controlador;

import Modelo.Producto;
import Modelo.Gestion;
import CSV.Archivo;
import Vista.VentanaProductos;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ContProd implements ActionListener {

    private VentanaProductos Vista;
    private Gestion modelo;
    private Archivo archivo;

    public ContProd(VentanaProductos vista, Gestion modelo, Archivo archivo) {
        this.Vista = vista;
        this.modelo = modelo;
        this.archivo = archivo;

        
        vista.btnGuardar.addActionListener(this);
        ((AbstractButton) vista.btnBuscar).addActionListener(this);
        vista.btnModificar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnMostrar.addActionListener(this);

        modelo.setLista(archivo.importarCSV());
        listarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Vista.btnGuardar) {
            insertar();
        }

        if (e.getSource() == Vista.btnBuscar) {
            consultar();
        }

        if (e.getSource() == Vista.btnModificar) {
            modificar();
        }

        if (e.getSource() == Vista.btnEliminar) {
            eliminar();
        }

        if (e.getSource() == Vista.btnMostrar) {
            listarTabla();
        }
    }

    private void insertar() {

        try {

            int id = Integer.parseInt(Vista.txtId.getText());
            String nombre = Vista.txtNombre.getText();
            String tipo = Vista.comboTipo.getSelectedItem().toString();
            int cantidad = Integer.parseInt(Vista.txtCantidad.getText());
            double precio = Double.parseDouble(Vista.txtPrecio.getText());
            String estado = Vista.rbDisponible.isSelected() ? "Disponible" : "Agotado";

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No puede haber campos vacíos");
                return;
            }

            if (modelo.existe(id)) {
                JOptionPane.showMessageDialog(null, "El ID ya existe");
                return;
            }

            Producto p = new Producto(id, nombre, tipo, cantidad, precio, estado);

            modelo.insertar(p);

            archivo.exportarCSV(modelo.getLista());

            listarTabla();

            limpiarCampos();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error: datos numéricos inválidos");
        }
    }
    
    private void consultar() {

        try {

            int id = Integer.parseInt(Vista.txtId.getText());

            Producto p = modelo.buscar(id);

            if (p != null) {

                Vista.txtNombre.setText(p.getNombre());
                Vista.comboTipo.setSelectedItem(p.getTipo());
                Vista.txtCantidad.setText(String.valueOf(p.getCantidad()));
                Vista.txtPrecio.setText(String.valueOf(p.getPrecio()));

                if (p.getEstado().equals("Disponible")) {
                    Vista.rbDisponible.setSelected(true);
                } else {
                    Vista.rbAgotado.setSelected(true);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID inválido");
        }
    }

    private void modificar() {

        try {

            int id = Integer.parseInt(Vista.txtId.getText());

            String nombre = Vista.txtNombre.getText();
            String tipo = Vista.comboTipo.getSelectedItem().toString();
            int cantidad = Integer.parseInt(Vista.txtCantidad.getText());
            double precio = Double.parseDouble(Vista.txtPrecio.getText());
            String estado = Vista.rbDisponible.isSelected() ? "Disponible" : "Agotado";

            Producto p = new Producto(id, nombre, tipo, cantidad, precio, estado);

            if (modelo.actualizar(p)) {

                archivo.exportarCSV(modelo.getLista());

                listarTabla();

                limpiarCampos();

                JOptionPane.showMessageDialog(null, "Producto actualizado");

            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el producto");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Datos inválidos");
        }
    }

    
    private void eliminar() {

        try {

            int id = Integer.parseInt(Vista.txtId.getText());

            int opcion = JOptionPane.showConfirmDialog(
                    null,
                    "¿Seguro que desea eliminar?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION
            );

            if (opcion == JOptionPane.YES_OPTION) {

                if (modelo.eliminar(id)) {

                    archivo.exportarCSV(modelo.getLista());

                    listarTabla();

                    limpiarCampos();

                } else {
                    JOptionPane.showMessageDialog(null, "No existe el producto");
                }
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID inválido");
        }
    }

    private void listarTabla() {

        ArrayList<Producto> lista = modelo.getLista();

        javax.swing.table.DefaultTableModel modeloTabla =
                (javax.swing.table.DefaultTableModel) Vista.tabla.getModel();

        modeloTabla.setRowCount(0);

        for (Producto p : lista) {

            Object[] fila = {
                    p.getId(),
                    p.getNombre(),
                    p.getTipo(),
                    p.getCantidad(),
                    p.getPrecio(),
                    p.getEstado()
            };

            modeloTabla.addRow(fila);
        }
    }

    private void limpiarCampos() {

        Vista.txtId.setText("");
        Vista.txtNombre.setText("");
        Vista.txtCantidad.setText("");
        Vista.txtPrecio.setText("");

        Vista.comboTipo.setSelectedIndex(0);

        Vista.rbDisponible.setSelected(true);
    }
}