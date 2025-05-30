package com.indra.eventossostenibles;

public class EventoOnline extends Evento{
    private String enlace;

    public EventoOnline(String nombre, String fecha, Categoria categoria, String enlace) {
        super(nombre, fecha, categoria);
        this.enlace = enlace;
    }

    /**
     * Inicia la retransmision del evento online, en esta version incial
     * solo muestra un mensaje por consola
     */
    @Override
    public void iniciarEvento(){
        System.out.println("Para acceder a la retransmisión del evento, acuda a: "+this.enlace);
    }

    /*Getter, setter y toString*/

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    @Override
    public String toString() {
        return super.toString()+"EventoOnline{" +
                "enlace='" + enlace + '\'' +
                '}';
    }
}
