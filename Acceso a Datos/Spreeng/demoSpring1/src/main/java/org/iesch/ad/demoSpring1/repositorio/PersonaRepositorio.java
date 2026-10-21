package org.iesch.ad.demoSpring1.repositorio;

import org.iesch.ad.demoSpring1.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //si no anotamos va a salir todo mal
public interface PersonaRepositorio extends JpaRepository<Persona, Long> {




}
