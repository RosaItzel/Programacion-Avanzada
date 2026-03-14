package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaProductos extends JInternalFrame {

    public JTextField txtId = new JTextField(10);
    public JTextField txtNombre = new JTextField(10);
    public JTextField txtCantidad = new JTextField(10);
    public JTextField txtPrecio = new JTextField(10);

    public JComboBox<String> comboTipo =
            new JComboBox<>(new String[]{"Alimento","Bebida","Limpieza"});

    public JRadioButton rbDisponible = new JRadioButton("Disponible",true);
    public JRadioButton rbAgotado = new JRadioButton("Agotado");

    public JButton btnGuardar = new JButton("Guardar");
    public JButton btnBuscar = new JButton("Buscar");
    public JButton btnModificar = new JButton("Modificar");
    public JButton btnEliminar = new JButton("Eliminar");
    public JButton btnMostrar = new JButton("Mostrar");

    public JTable tabla;

    public VentanaProductos(){

        setTitle("Productos");
        setSize(600,400);
        setClosable(true);

        setLayout(new BorderLayout());

        JPanel formulario = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,5,5,5);

        c.gridx=0; c.gridy=0; formulario.add(new JLabel("ID"),c);
        c.gridx=1; formulario.add(txtId,c);

        c.gridx=0; c.gridy=1; formulario.add(new JLabel("Nombre"),c);
        c.gridx=1; formulario.add(txtNombre,c);

        c.gridx=0; c.gridy=2; formulario.add(new JLabel("Tipo"),c);
        c.gridx=1; formulario.add(comboTipo,c);

        c.gridx=0; c.gridy=3; formulario.add(new JLabel("Cantidad"),c);
        c.gridx=1; formulario.add(txtCantidad,c);

        c.gridx=0; c.gridy=4; formulario.add(new JLabel("Precio"),c);
        c.gridx=1; formulario.add(txtPrecio,c);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rbDisponible);
        grupo.add(rbAgotado);

        c.gridx=0; c.gridy=5; formulario.add(rbDisponible,c);
        c.gridx=1; formulario.add(rbAgotado,c);

        add(formulario,BorderLayout.WEST);

        DefaultTableModel modeloTabla = new DefaultTableModel(
                new Object[]{"ID","Nombre","Tipo","Cantidad","Precio","Estado"},0
        );

        tabla = new JTable(modeloTabla);

        add(new JScrollPane(tabla),BorderLayout.CENTER);

        JPanel botones = new JPanel();

        botones.add(btnGuardar);
        botones.add(btnBuscar);
        botones.add(btnModificar);
        botones.add(btnEliminar);
        botones.add(btnMostrar);

        add(botones,BorderLayout.SOUTH);
    }
}