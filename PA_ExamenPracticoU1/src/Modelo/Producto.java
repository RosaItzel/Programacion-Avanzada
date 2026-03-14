package Modelo;

public class Producto {

    private int id;
    private String nombre;
    private String tipo;
    private int cantidad;
    private double precio;
    private String estado;

    public Producto(int id, String nombre, String tipo, int cantidad, double precio, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.estado = estado;
    }

    public int getId() { return id; }

    public String getNombre() { 
    	return nombre; 
    	}

    public String getTipo() { 
    	return tipo;
    	}

    public int getCantidad() {
    	return cantidad; 
    	}

    public double getPrecio() {
    	return precio;
    	}

    public String getEstado() {
    	return estado; 
    	}

    public void setNombre(String nombre) { 
    	this.nombre = nombre;
    	}

    public void setTipo(String tipo) { 
    	this.tipo = tipo; 
    	}

    public void setCantidad(int cantidad) {
    	this.cantidad = cantidad;
    	}

    public void setPrecio(double precio) {
    	this.precio = precio; 
    	}

    public void setEstado(String estado) { 
    	this.estado = estado; 
    	}

    @Override
    public String toString() {
        return id + "," + nombre + "," + tipo + "," + cantidad + "," + precio + "," + estado;
    }
}