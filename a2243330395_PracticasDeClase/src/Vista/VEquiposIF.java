package Vista;

import javax.swing.*;

public class VEquiposIF extends JInternalFrame {

    public VEquiposIF(){

        super("Ventana Equipos", true, true, true, true);

        setSize(300,200);
        setLayout(null);

        JLabel label = new JLabel("Ventana de Equipos");
        label.setBounds(50,50,200,30);
        add(label);
    }
}

