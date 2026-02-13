package Vista;
import javax.swing.*;

public class VPractica01_Tarea01 extends JFrame {

    private JDesktopPane desktop;
    private JMenuItem menuPersona, menuEquipos, menuSalir;

    public VPractica01_Tarea01(){

        setTitle("Practica 01 - Tarea 01");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        desktop = new JDesktopPane();
        add(desktop);

        JMenuBar barra = new JMenuBar();

        JMenu menuArchivo = new JMenu("Archivo");
        JMenu menuVentanas = new JMenu("Ventanas");

        menuPersona = new JMenuItem("Persona");
        menuEquipos = new JMenuItem("Equipos");
        menuSalir = new JMenuItem("Salir");

        menuArchivo.add(menuSalir);
        menuVentanas.add(menuPersona);
        menuVentanas.add(menuEquipos);

        barra.add(menuArchivo);
        barra.add(menuVentanas);

        setJMenuBar(barra);

        // Eventos
        menuPersona.addActionListener(e -> abrirPersona());
        menuEquipos.addActionListener(e -> abrirEquipos());
        menuSalir.addActionListener(e -> System.exit(0));
    }

    private void abrirPersona(){
        VPersonaIF v = new VPersonaIF();
        desktop.add(v);
        v.setVisible(true);
    }

    private void abrirEquipos(){
        VEquiposIF v = new VEquiposIF();
        desktop.add(v);
        v.setVisible(true);
    }
}
