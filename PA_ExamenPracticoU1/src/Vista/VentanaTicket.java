package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaTicket extends JInternalFrame {

    public JTable tablaTicket;

    public JLabel lblSubtotal = new JLabel("Subtotal: 0");
    public JLabel lblIVA = new JLabel("IVA: 0");
    public JLabel lblTotal = new JLabel("Total: 0");

    public JButton btnGenerar = new JButton("Generar Ticket");
    public JButton btnCerrar = new JButton("Cerrar");

    public VentanaTicket(){

        setTitle("Ticket");
        setSize(500,400);
        setClosable(true);

        setLayout(new BorderLayout());

        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"ID","Nombre","Cantidad","Precio","Total"},0
        );

        tablaTicket = new JTable(modelo);

        add(new JScrollPane(tablaTicket),BorderLayout.CENTER);

        JPanel panelTotales = new JPanel(new GridLayout(3,1));
        panelTotales.add(lblSubtotal);
        panelTotales.add(lblIVA);
        panelTotales.add(lblTotal);

        add(panelTotales,BorderLayout.EAST);

        JPanel botones = new JPanel();

        botones.add(btnGenerar);
        botones.add(btnCerrar);

        add(botones,BorderLayout.SOUTH);
    }
}