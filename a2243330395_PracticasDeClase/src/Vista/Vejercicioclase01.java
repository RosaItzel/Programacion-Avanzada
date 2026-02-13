package Vista;

import javax.swing.*;

public class Vejercicioclase01 extends JFrame {

    private JTextField T1, T2;
    private JTextArea Tr;
    private JButton Bagregar, Bsalir;

    public Vejercicioclase01(){

        setTitle("Ejercicio Clase 01");
        setSize(400,400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Nombre:");
        l1.setBounds(20,20,100,25);
        add(l1);

        T1 = new JTextField();
        T1.setBounds(100,20,150,25);
        add(T1);

        JLabel l2 = new JLabel("Apellido:");
        l2.setBounds(20,60,100,25);
        add(l2);

        T2 = new JTextField();
        T2.setBounds(100,60,150,25);
        add(T2);

        Bagregar = new JButton("Agregar");
        Bagregar.setBounds(20,100,100,30);
        add(Bagregar);

        Bsalir = new JButton("Salir");
        Bsalir.setBounds(150,100,100,30);
        add(Bsalir);

        Tr = new JTextArea();
        JScrollPane scroll = new JScrollPane(Tr);
        scroll.setBounds(20,150,330,180);
        add(scroll);
    }

    public String getT1(){ return T1.getText(); }
    public String getT2(){ return T2.getText(); }

    public void setTr(String texto){ Tr.setText(texto); }

    public void limparText(){
        T1.setText("");
        T2.setText("");
    }

    public JButton bagregar(){ return Bagregar; }
    public JButton bsalir(){ return Bsalir; }
}
