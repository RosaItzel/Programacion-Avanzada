package Controlador;

import modelo.Mejercicio02;
import Vista.Vejercicioclase02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Cejercicioclase02 implements ActionListener {

    private Vejercicioclase02 vista;
    private Mejercicio02 modelo;

    public Cejercicioclase02(){

        vista = new Vejercicioclase02();
        modelo = new Mejercicio02();

        vista.getComboBox().setModel(modelo.getModeloCombo());
        vista.getLista().setModel(modelo.getModeloLista());

        vista.getBagregar().addActionListener(this);
        vista.getBeliminar().addActionListener(this);
        vista.getBsalir().addActionListener(this);

        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == vista.getBagregar()){

            String dato = vista.getTdato().getText().trim();

            if(dato.isEmpty()){
                JOptionPane.showMessageDialog(null,
                        "Campo vacío",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            modelo.agregar(dato);
            vista.limpiar();
        }

        if(e.getSource() == vista.getBeliminar()){

            int index = vista.getLista().getSelectedIndex();

            if(index < 0){
                JOptionPane.showMessageDialog(null,
                        "Seleccione un elemento",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            modelo.eliminar(index);
        }

        if(e.getSource() == vista.getBsalir()){
            vista.dispose();
        }
    }
}
