package com.indra.eventossostenibles;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal que gestiona todas las otras clases
 */
public class GestionEventos {
    private ArrayList<Organizador> organizadores;
    private ArrayList<Usuario> usuarios;


    public GestionEventos(ArrayList<Organizador> organizadores, ArrayList<Usuario> usuarios) {
        this.organizadores = organizadores;
        this.usuarios = usuarios;
    }

    public GestionEventos() {
        this.organizadores=new ArrayList<>();
        this.usuarios=new ArrayList<>();
    }

    /**
     * Lista todos los eventos
     */
    public void listarEventos(){
        for(Organizador o:organizadores){
            for (Evento e:o.getEventos()){
                System.out.println(e);
            }
        }
    }

    /**
     * Lista todos los eventos de una categoria concreta
     * @param categoria - Categoria de los eventos a listar
     */
    public void listarEventosCategoria(Categoria categoria){
        for(Organizador o:organizadores){
            for (Evento e:o.getEventos()){
                if (e.getCategoria().equals(categoria)){
                    System.out.println(e);
                }
            }
        }
    }

    /**
     * Busca un evento y lo devuelve si lo encuentra
     * @param nombre - Nombre del evento a buscar
     * @return - El evento si lo encuentra o null si no lo encuentra
     */
    private Evento buscarEventoNombre(String nombre){
        for(Organizador o:organizadores){
            for (Evento e:o.getEventos()){
                if (e.getNombre().equals(nombre)){
                    return e;
                }
            }
        }
        return null;
    }

    /**
     * Devuelve al usuario buscado
     * @param nombre - Nombre del usuario a buscar
     * @return - El usuario o null si no lo encuentra
     */
    private Usuario buscarUsuarioNombre(String nombre){
        for (Usuario u : this.usuarios){
            if(u.getNombre().equals(nombre)){
                return u;
            }
        }
        return null;
    }

    /**
     * Devuelve al Organizador buscado
     * @param nombre - Nombre del organizador a buscar
     * @return - El organizador o null si no lo encuentra
     */
    private Organizador buscarOrganizadorNombre(String nombre){
        for (Organizador o : this.organizadores){
            if(o.getNombre().equals(nombre)){
                return o;
            }
        }
        return null;
    }

    /**
     * Crea un organizador y lo añade a la lista de organizadores
     * @param nombre - nombre del organizador
     * @param claveAcceso - Contraseña de acceso a la cuenta
     * @param email - Email de contacto
     * @param razonSocial - Razon social de la empresa
     */
    public void registrarOrganizador(String nombre, String claveAcceso,String email, String razonSocial){
        this.organizadores.add(new Organizador(nombre,claveAcceso,email,razonSocial));
    }

    /**
     * Crea un usuario y lo añade a la lista de usuarios
     * @param nombre - Nombre del usuario
     * @param claveAcceso - Contraseña de la cuenta
     * @param email - Email de contacto
     */
    public void registrarUsuario(String nombre, String claveAcceso,String email){
        this.usuarios.add(new Usuario(nombre,claveAcceso,email));
    }

    /**
     * Apunta registra a un usuario en un
     * @return True si lo apunta, false si no lo hace
     */
    public boolean apuntarUsuario(String nombre, Evento evento){
        Usuario usuario=this.buscarUsuarioNombre(nombre);
        if(usuario==null) return false;
        else{
            if(usuario.registrarse(evento)){
                System.out.println(usuario.getNombre()+" se ha apuntado con exito a "+evento.getNombre());
                return true;
            }
            else{
                System.out.println("Error en el registro");
                return false;
            }
        }
    }

    /**
     * Cancela la participacion de un usuario en un evento
     * @return True si lo elimina, false si no lo hace
     */
    public boolean cancelarParticipacionEvento(String nombre, String nombreEvento){
        Usuario usuario=this.buscarUsuarioNombre(nombre);
        Evento evento;
        if (usuario!=null) evento=usuario.getEventoNombre(nombreEvento);
        else evento=null;

        if(usuario==null || evento==null) return false;
        else{
            if(usuario.anularRegistro(evento)){
                System.out.println(usuario.getNombre()+" se ha eliminado con exito de "+evento.getNombre());
                return true;
            }
            else{
                System.out.println("Error al borrar al usuario del evento");
                return false;
            }
        }
    }

    /**
     * Pide los datos del evento y hace que el organizador lo cree
     * @param nombreOrg - Nombre del organizador encargado de crear el evento
     * @return - Verdadero si lo crea, falso en caso contrario
     */
    public boolean crearEvento(String nombreOrg){
        Organizador organizador=this.buscarOrganizadorNombre(nombreOrg);
        if(organizador==null) return false;
        else{
            Scanner in = new Scanner(System.in).useDelimiter("\n");
            String nombre,fecha,categoria,direccion;
            int tipo;
            System.out.print("Nombre: ");
            nombre=in.next();
            System.out.print("Fecha: ");
            fecha=in.next();
            System.out.print("Categoria: ");
            categoria=in.next().toUpperCase();
            System.out.println("Tipo (0 - Presencial | 1 - Online): ");
            tipo=in.nextInt();
            if(tipo==0) System.out.print("Dirección: ");
            else System.out.print("Enlace: ");
            direccion=in.next();
            return organizador.crearEvento(nombre,fecha, Categoria.valueOf(categoria),direccion,tipo);
        }
    }

    //Getters

    public ArrayList<Organizador> getOrganizadores() {
        return organizadores;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
