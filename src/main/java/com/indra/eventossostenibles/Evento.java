package com.indra.eventossostenibles;

public abstract class Evento {
    private String nombre;
    private String fecha;
    private boolean activo;
    private Categoria categoria;

    public Evento(String nombre, String fecha, Categoria categoria) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.activo = true;
        this.categoria = categoria;
    }

    /**
     * Se encarga de iniciar el evento, mostrando un mensaje por consola
     */
    public abstract void iniciarEvento();

    /*Getters, setters y toString */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                ", activo=" + activo +
                ", categoria=" + categoria +
                '}';
    }
}
