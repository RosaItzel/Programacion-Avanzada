package modelo;

import java.util.ArrayList;

public class Lista {

    private ArrayList<Cpersona> lista = new ArrayList<>();

    public void insertar(Cpersona p){
        lista.add(p);
    }

    public String info(){
        StringBuilder sb = new StringBuilder();
        for(Cpersona p : lista){
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }
}

