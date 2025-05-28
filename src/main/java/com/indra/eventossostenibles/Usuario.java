package com.indra.eventossostenibles;

import java.util.ArrayList;

public class Usuario extends Cuenta{


    public Usuario(int id, String nombre, String clave_acceso, String email, ArrayList<Evento> eventos) {
        super(id, nombre, clave_acceso, email,eventos);
    }

    public Usuario(int id, String nombre, String clave_acceso, String email) {
        super(id, nombre, clave_acceso, email);
    }

    /**
     * Permite al usuario registrarse en un evento
     * @param evento - Objeto con el evento en el que se registra
     */
    public void registrarse(Evento evento){
        super.getEventos().add(evento);
    }

    /*toString*/
    @Override
    public String toString() {
        return super.toString();
    }
}
