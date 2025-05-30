package com.indra.eventossostenibles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class GestionEventosTest {
    private GestionEventos gestionEventos;

    @BeforeEach
    void init(){
        gestionEventos=new GestionEventos();
        gestionEventos.registrarUsuario("Carlos","1234","carlos@gamil.com");
        gestionEventos.registrarOrganizador("Juan","123456789","juan@Organizacion.com","Ejemplo S.L");
    }

    @Test
    void registrarOrganizador() {
        gestionEventos.registrarOrganizador("Marta","1235678920","marta@Organizacion.com","Empresa S.l");
        Assertions.assertEquals(2,gestionEventos.getOrganizadores().size());
    }

    @Test
    void registrarUsuario() {
        gestionEventos.registrarUsuario("Maria","1235","maria@gamil.com");
        Assertions.assertEquals(2,gestionEventos.getUsuarios().size());
    }

    @Test
    void apuntarUsuario() {
        EventoOnline evento =new EventoOnline("Taller ecosostenibilidad","25/05/2025",Categoria.TALLER,"https://Ejemplo.com");
        Assertions.assertTrue(gestionEventos.apuntarUsuario("Carlos",evento));
        Assertions.assertFalse(gestionEventos.apuntarUsuario("Pedro",evento));
    }

    @Test
    void cancelarParticipacionEvento() {
        EventoOnline evento = new EventoOnline("Taller ecosostenibilidad","25/05/2025",Categoria.TALLER,"https://Ejemplo.com");
        gestionEventos.apuntarUsuario("Carlos",evento);
        gestionEventos.cancelarParticipacionEvento("Carlos",evento.getNombre());
        Assertions.assertEquals(0,gestionEventos.getUsuarios().get(0).getEventos().size()); //Solo exixte carlos asique accedo por su indice
    }
}