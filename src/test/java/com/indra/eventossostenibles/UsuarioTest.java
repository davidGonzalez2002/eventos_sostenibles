package com.indra.eventossostenibles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

class UsuarioTest {
    private static Usuario usuario;
    private static Evento evento;

    @BeforeAll
    static void init(){
        usuario=new Usuario("Carlos","1234","carlos@gmail.com");
        evento=new EventoOnline("Taller ecosostenible","25/03/2025",Categoria.TALLER,"https://www.ejemplo.com");
    }

    @org.junit.jupiter.api.Test
    void registrarse() {
        Assertions.assertTrue(usuario.registrarse(evento));
        //Si ya esta apuntado a ese evento, no debe poder apuntarse
        Assertions.assertFalse(usuario.registrarse(evento));
        Assertions.assertEquals(1,usuario.getEventos().size());
    }

    @org.junit.jupiter.api.Test
    void anularRegistro() {
        usuario.registrarse(evento);
        Assertions.assertTrue(usuario.anularRegistro(evento));
        //Si no existe el evento, no debe poder borrarse
        Assertions.assertFalse(usuario.anularRegistro(evento));
        Assertions.assertEquals(0,usuario.getEventos().size());

    }

    @org.junit.jupiter.api.Test
    void getEventoNombre() {
        usuario.registrarse(evento);
        Assertions.assertEquals(evento,usuario.getEventoNombre("Taller ecosostenible"));
        Assertions.assertNull(usuario.getEventoNombre("Ejemplo"));

    }
}