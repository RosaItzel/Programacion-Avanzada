package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaVentas extends javax.swing.JInternalFrame {

    public VentanaVentas() {
        initComponents();
    }
    private void initComponents() {

        txtIdProducto = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();

        btnBuscar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnCobrar = new javax.swing.JButton();

        lblIdProducto = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        tablaVenta = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();

        setClosable(true);
        setTitle("Punto de Venta");

        lblIdProducto.setText("ID Producto");

        lblCantidad.setText("Cantidad");

        btnBuscar.setText("Buscar");

        btnAgregar.setText("Agregar");

        btnCobrar.setText("Cobrar");

        lblTotal.setText("Total: $0");

        modeloTabla = new DefaultTableModel(
                new Object [][] {},
                new String [] {"ID", "Nombre", "Cantidad", "Precio", "Subtotal"}
        );
        tablaVenta.setModel(modeloTabla);

        jScrollPane1.setViewportView(tablaVenta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20)
                .addComponent(lblIdProducto)
                .addGap(10)
                .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20)
                .addComponent(btnBuscar)
                .addGap(20)
                .addComponent(lblCantidad)
                .addGap(10)
                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20)
                .addComponent(btnAgregar)
                .addContainerGap()
            )
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(20)
                .addComponent(lblTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 350, Short.MAX_VALUE)
                .addComponent(btnCobrar)
                .addGap(20)
            )
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
            .addGap(20)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblIdProducto)
                .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnBuscar)
                .addComponent(lblCantidad)
                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnAgregar)
            )
            .addGap(20)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addGap(10)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblTotal)
                .addComponent(btnCobrar)
            )
            .addGap(20)
        );

        pack();
    }

    public JTextField txtIdProducto;
    public JTextField txtCantidad;

    public JButton btnBuscar;
    public JButton btnAgregar;
    public JButton btnCobrar;

    public JTable tablaVenta;
    public DefaultTableModel modeloTabla;

    public JLabel lblIdProducto;
    public JLabel lblCantidad;
    public JLabel lblTotal;

    private JScrollPane jScrollPane1;
}