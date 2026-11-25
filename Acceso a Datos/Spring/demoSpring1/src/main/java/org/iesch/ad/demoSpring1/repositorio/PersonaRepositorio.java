package org.iesch.ad.demoSpring1.repositorio;

import ch.qos.logback.core.encoder.JsonEscapeUtil;
import org.iesch.ad.demoSpring1.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


//Los repositorios (Repository) sirven para comunicarnos con la base de datos

@Repository //indico que es un repo
public interface PersonaRepositorio extends JpaRepository<Persona, Long> {


//aqui ponemos las consultas de nuestro programa (q no esten echas)

    //HQL
    @Query("select p from Persona p where p.nombre = 'Iker'")
    List<Persona> buscaTodasPersonas(); //devuelve una lista con todas las personas encontradas


    //Nativo
    @NativeQuery("select * from Persona where dni = '11811114C'")
    List<Persona> buscaTodasPersonasNative();


    //pseudo-lenguaje
    List<Persona> findByNombreStartingWith(char c);
    List<Persona> findByDniContainingAndApellidosContaining (char d, String a); //funciona tanto string como char
    List<Persona> findByDniContainingOrEmailIsNull (String s);

}
