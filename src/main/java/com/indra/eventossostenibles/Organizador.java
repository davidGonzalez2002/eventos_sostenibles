package com.indra.eventossostenibles;

import java.util.ArrayList;
import java.util.Scanner;

public class Organizador extends Cuenta{
    private String razonSocial;

    public Organizador(int id, String nombre, String clave_acceso, String email, ArrayList<Evento> eventos, String razonSocial) {
        super(id, nombre, clave_acceso, email, eventos);
        this.razonSocial = razonSocial;
    }

    public Organizador(int id, String nombre, String clave_acceso, String email, String razonSocial) {
        super(id, nombre, clave_acceso, email);
        this.razonSocial = razonSocial;
    }

    /**
     * Pide los datos del evento y lo añade a los creados por este organizador
     */
    public void crearEvento(){
        Scanner in = new Scanner(System.in).useDelimiter("\n");
        String nombre,fecha,categoria;
        int tipo;
        System.out.print("Nombre del evento: ");
        nombre=in.next();
        System.out.print("Fecha del evento");
        fecha=in.next();
        System.out.print("Categoria(TALLER, CONFERENCIA, CHARLA o FORMACION): ");
        categoria=in.next().toUpperCase(); //Para que coincida con el enum
        System.out.println("""
                1) Presencial
                2) Online""");
        tipo=in.nextInt();
        if(tipo==1){
            System.out.print("Dirección física: ");
            this.getEventos().add(new EventoPresencial(nombre,fecha,Categoria.valueOf(categoria),in.next()));
        }
        else if(tipo==2){
            System.out.print("Enlace a la reunión: ");
            this.getEventos().add(new EventoOnline(nombre,fecha,Categoria.valueOf(categoria),in.next()));
        }
        else{
            System.out.println("Tipo no váido");
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
