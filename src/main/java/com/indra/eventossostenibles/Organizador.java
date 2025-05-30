package com.indra.eventossostenibles;

import java.util.HashSet;

public class Organizador extends Cuenta{
    private String razonSocial;

    public Organizador(String nombre, String claveAcceso, String email, HashSet<Evento> eventos, String razonSocial) {
        super(nombre, claveAcceso, email, eventos);
        this.razonSocial = razonSocial;
    }

    public Organizador(String nombre, String clave_acceso, String email, String razonSocial) {
        super(nombre, clave_acceso, email);
        this.razonSocial = razonSocial;
    }

    /**
     * Crea un evento y lo añade a la lista de eventos creados
     * @param nombre - Nombre del evento
     * @param fecha - Fecha del evento
     * @param categoria - Categoria del evento
     * @param tipo - Si es presencial, vale 0, si es online vale 1, es un entero de cara a futuras actualizaciones(por ejemplo si queremos un tercer tipo, semipresencial por ejemplo)
     * @retrun - Verdadero si lo crea, falso si no lo crea
     */
    public boolean crearEvento(String nombre, String fecha, Categoria categoria,String direccion, int tipo){
        if(tipo==0){
            return this.getEventos().add(new EventoPresencial(nombre,fecha,categoria,direccion));
        }
        else {
            return this.getEventos().add(new EventoOnline(nombre,fecha,categoria,direccion));
        }
    }

    /*Getter, setter y toString*/

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    @Override
    public String toString() {
        return super.toString()+"Organizador{" +
                "razonSocial='" + razonSocial + '\'' +
                '}';
    }
}
