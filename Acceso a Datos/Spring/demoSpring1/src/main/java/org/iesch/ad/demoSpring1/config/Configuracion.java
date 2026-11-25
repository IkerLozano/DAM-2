package org.iesch.ad.demoSpring1.config;

import org.iesch.ad.demoSpring1.modelo.Persona;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Configuracion {

    /*
    @Bean

    public List<Persona> dameLista(){

        List<Persona> listaPersona = new ArrayList<>();

        Persona p1 = Persona.builder().id(1L).build();
        Persona p2 = Persona.builder().id(2L).build();
        Persona p3 = Persona.builder().id(3L).nombre("Iker").build();
        Persona p4 = Persona.builder().id(4L).build();
        Persona p5 = Persona.builder().id(5L).build();
        Persona p6 = Persona.builder().id(6L).apellidos("lozano").build();
        Persona p7 = Persona.builder().id(7L).build();

        listaPersona.add(p1);
        listaPersona.add(p2);
        listaPersona.add(p3);
        listaPersona.add(p4);
        listaPersona.add(p5);
        listaPersona.add(p6);
        listaPersona.add(p7);

        return listaPersona;



    }

    */

}
