package com.indra.eventossostenibles;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola mundo");

        Organizador o = new Organizador(1,"Crlos","1234","d@gmail.om","Indra");
        o.crearEvento();

        System.out.println(o.getEventos());
    }
}
