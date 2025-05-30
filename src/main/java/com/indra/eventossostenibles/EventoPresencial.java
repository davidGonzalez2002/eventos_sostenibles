package com.indra.eventossostenibles;

public class EventoPresencial extends Evento{
    private String direccion;

    public EventoPresencial(String nombre, String fecha, Categoria categoria, String direccion) {
        super(nombre, fecha, categoria);
        this.direccion = direccion;
    }

    @Override
    public void iniciarEvento(){
        System.out.println("Iniciando el evento de forma presencial, acuda a la direccion: "+this.direccion);
    }

    /*Getter, setter y toString*/

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return super.toString()+"EventoPresencial{" +
                "direccion='" + direccion + '\'' +
                '}';
    }
}
