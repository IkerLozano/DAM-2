package org.iesch.ad.demoSpring1.repositorio;

import ch.qos.logback.core.encoder.JsonEscapeUtil;
import org.iesch.ad.demoSpring1.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //si no anotamos va a salir todo mal
public interface PersonaRepositorio extends JpaRepository<Persona, Long> {


//aqui ponemos las consultas de nuestro programa (q no esten echas), no se pueden usar * hayque usar p qp es una entidad

    @Query("select p from Persona p") //HQL
    List<Persona> buscaTodasPersonas();


    @NativeQuery("select * from Persona") //Nativo
    List<Persona> buscaTodasPersonasNative();


    //El nombre tiene q ser findBy+"lo que buscamos"+StartingWith
    List<Persona> findByNombreStartingWith(char c);
    List<Persona> findByDniContainingAndApellidosContaining (char d, String a); //funciona tanto string como char
    List<Persona> findByDniContainingOrEmailIsNull (String s);

}
