package Controlador;

import modelo.*;
import Vista.*;

import java.awt.event.*;

import javax.swing.JOptionPane;

public class Cejercicioclase01 implements ActionListener {

    private Vejercicioclase01 vista;
    private Lista lista;

    public Cejercicioclase01(){

        vista = new Vejercicioclase01();
        lista = new Lista();

        vista.bagregar().addActionListener(this);
        vista.bsalir().addActionListener(this);

        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == vista.bagregar()){

            String nombre = vista.getT1().trim();
            String apellido = vista.getT2().trim();

            if(nombre.isEmpty() || apellido.isEmpty()){
                JOptionPane.showMessageDialog(null,
                        "Campos vacíos",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            Cpersona p = new Cpersona(nombre, apellido);
            lista.insertar(p);

            vista.setTr(lista.info());
            vista.limparText();
        }

        if(e.getSource() == vista.bsalir()){
            vista.dispose();
        }
    }
}

