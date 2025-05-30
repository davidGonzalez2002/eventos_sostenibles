package com.indra.eventossostenibles;

import java.util.HashSet;

public abstract class Cuenta implements Comparable<Cuenta>{
    private String nombre;
    private String claveAcceso;
    private String email;
    private HashSet<Evento> eventos;

    public Cuenta(String nombre, String clave_acceso, String email, HashSet<Evento> eventos) {
        this.nombre = nombre;
        this.claveAcceso = clave_acceso;
        this.email = email;
        this.eventos = eventos;
    }

    public Cuenta(String nombre, String clave_acceso, String email) {
        this.nombre = nombre;
        this.claveAcceso = clave_acceso;
        this.email = email;
        this.eventos=new HashSet<>();
    }

    @Override
    public int compareTo(Cuenta c){
        return this.nombre.compareTo(c.getNombre());
    }

    /*Getters, setters y toString*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HashSet<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(HashSet<Evento> eventos) {
        this.eventos = eventos;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                ", nombre='" + nombre + '\'' +
                ", clave_acceso='" + claveAcceso + '\'' +
                ", email='" + email + '\'' +
                ", eventos=" + eventos +
                '}';
    }
}
