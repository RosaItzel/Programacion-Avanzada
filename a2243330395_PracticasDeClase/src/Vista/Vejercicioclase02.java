package Vista;

import javax.swing.*;

public class Vejercicioclase02 extends JFrame {

    private JTextField Tdato;
    private JComboBox<String> comboBox;
    private JList<String> lista;
    private JButton Bagregar, Beliminar, Bsalir;

    public Vejercicioclase02(){

        setTitle("Ejercicio Clase 02");
        setSize(400,400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Tdato = new JTextField();
        Tdato.setBounds(20,20,200,25);
        add(Tdato);

        comboBox = new JComboBox<>();
        comboBox.setBounds(20,60,200,25);
        add(comboBox);

        lista = new JList<>();
        JScrollPane scroll = new JScrollPane(lista);
        scroll.setBounds(20,100,200,150);
        add(scroll);

        Bagregar = new JButton("Agregar");
        Bagregar.setBounds(240,20,100,30);
        add(Bagregar);

        Beliminar = new JButton("Eliminar");
        Beliminar.setBounds(240,60,100,30);
        add(Beliminar);

        Bsalir = new JButton("Salir");
        Bsalir.setBounds(240,100,100,30);
        add(Bsalir);
    }

    public JTextField getTdato(){ return Tdato; }
    public JComboBox<String> getComboBox(){ return comboBox; }
    public JList<String> getLista(){ return lista; }
    public JButton getBagregar(){ return Bagregar; }
    public JButton getBeliminar(){ return Beliminar; }
    public JButton getBsalir(){ return Bsalir; }

    public void limpiar(){
        Tdato.setText("");
    }
}
