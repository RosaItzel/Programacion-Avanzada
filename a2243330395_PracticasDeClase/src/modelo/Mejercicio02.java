package modelo;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class Mejercicio02 {

    private DefaultComboBoxModel<String> modeloCombo;
    private DefaultListModel<String> modeloLista;

    private String[] equipos = {
            "Real Madrid",
            "Barcelona",
            "Manchester City",
            "PSG"
    };

    public Mejercicio02(){

        modeloCombo = new DefaultComboBoxModel<>();
        modeloLista = new DefaultListModel<>();

        inicializar();
    }

    private void inicializar(){
        for(String e : equipos){
            modeloCombo.addElement(e);
            modeloLista.addElement(e);
        }
    }

    public void agregar(String dato){
        modeloCombo.addElement(dato);
        modeloLista.addElement(dato);
    }

    public void eliminar(int index){
        if(index >= 0){
            modeloCombo.removeElementAt(index);
            modeloLista.remove(index);
        }
    }

    public DefaultComboBoxModel<String> getModeloCombo(){
        return modeloCombo;
    }

    public DefaultListModel<String> getModeloLista(){
        return modeloLista;
    }
}
