package com.indra.eventossostenibles;

import java.util.HashSet;

public class Usuario extends Cuenta{


    public Usuario(String nombre, String claveAcceso, String email, HashSet<Evento> eventos) {
        super(nombre, claveAcceso, email,eventos);
    }

    public Usuario(String nombre, String clave_acceso, String email) {
        super(nombre, clave_acceso, email);
    }

    /**
     * Registra a un usuario en un evento pasado por parametro
     * @param evento - Evento en el que se registra
     * @return - true si se registra con exito, false si no lo hace
     */
    public boolean registrarse(Evento evento){
        return this.getEventos().add(evento);
    }

    /**
     * Anula el registro de un usuario en un evento pasado por parametro
     * @param evento - Evento del que lo retiraremos
     * @return True si lo elimina, false si no lo hace
     */
    public boolean anularRegistro(Evento evento){
        return this.getEventos().remove(evento);
    }

    /**
     * Devuelve el evento del usuario con el nombre pasado por parametro
     * @param nombre - Nombre del evento
     * @return - El evento o null si no existe
     */
    public Evento getEventoNombre(String nombre){
        for(Evento e:this.getEventos()){
            if(e.getNombre().equals(nombre)){
                return e;
            }
        }
        return null;
    }

    /*toString*/
    @Override
    public String toString() {
        return super.toString();
    }
}
