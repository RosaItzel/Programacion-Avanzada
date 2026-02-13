package modelo;

import java.util.Objects;

public class Cpersona {

    private String nombre;
    private String apellido;
    private int id;
    private static int contador = 1;

    public Cpersona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = contador++;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getId() { return id; }

    @Override
    public String toString() {
        return id + " - " + nombre + " " + apellido;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cpersona)) return false;
        Cpersona other = (Cpersona) obj;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
