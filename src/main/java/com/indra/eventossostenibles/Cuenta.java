package com.indra.eventossostenibles;

import java.util.ArrayList;

public class Cuenta {
    private int id;
    private String nombre;
    private String claveAcceso;
    private String email;
    private ArrayList<Evento> eventos;

    public Cuenta(int id, String nombre, String clave_acceso, String email, ArrayList<Evento> eventos) {
        this.id = id;
        this.nombre = nombre;
        this.claveAcceso = clave_acceso;
        this.email = email;
        this.eventos = eventos;
    }

    public Cuenta(int id, String nombre, String clave_acceso, String email) {
        this.id = id;
        this.nombre = nombre;
        this.claveAcceso = clave_acceso;
        this.email = email;
        this.eventos=new ArrayList<>();
    }

    /*Getters, setters y toString*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", clave_acceso='" + claveAcceso + '\'' +
                ", email='" + email + '\'' +
                ", eventos=" + eventos +
                '}';
    }
}
