package Modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Gestion {

    private ArrayList<Producto> lista = new ArrayList<>();

    public ArrayList<Producto> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Producto> lista) {
        this.lista = lista;
    }

    public boolean existe(int id) {

        for (Producto p : lista) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void insertar(Producto p) {
        lista.add(p);
    }

    public Producto buscar(int id) {

        Iterator<Producto> it = lista.iterator();

        while (it.hasNext()) {
            Producto p = it.next();

            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }

    public boolean actualizar(Producto prod) {

        for (Producto p : lista) {

            if (p.getId() == prod.getId()) {

                p.setNombre(prod.getNombre());
                p.setTipo(prod.getTipo());
                p.setCantidad(prod.getCantidad());
                p.setPrecio(prod.getPrecio());
                p.setEstado(prod.getEstado());

                return true;
            }
        }

        return false;
    }

    public boolean eliminar(int id) {

        Iterator<Producto> it = lista.iterator();

        while (it.hasNext()) {

            Producto p = it.next();

            if (p.getId() == id) {
                it.remove();
                return true;
            }
        }

        return false;
    }
}