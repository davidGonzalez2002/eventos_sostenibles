package com.indra.eventossostenibles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class OrganizadorTest {

    @Test
    void crearEvento() {
        Organizador organizador=new Organizador("Juan","123456789","juan@organizacion.com","Ejemplo S.L");
        organizador.crearEvento("Taller Ecosostenible","26/03/2025",Categoria.TALLER,"https://ejemplo.com",1);
        Assertions.assertEquals(1,organizador.getEventos().size());
    }
}