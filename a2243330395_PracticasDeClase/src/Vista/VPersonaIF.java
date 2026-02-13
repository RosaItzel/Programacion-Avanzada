package Vista;


import javax.swing.*;

public class VPersonaIF extends JInternalFrame {

    public VPersonaIF(){

        super("Ventana Persona", true, true, true, true);

        setSize(300,200);
        setLayout(null);

        JLabel label = new JLabel("Ventana de Persona");
        label.setBounds(50,50,200,30);
        add(label);
    }
}

