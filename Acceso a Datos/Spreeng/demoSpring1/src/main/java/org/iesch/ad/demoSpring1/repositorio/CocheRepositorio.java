package org.iesch.ad.demoSpring1.repositorio;


import org.iesch.ad.demoSpring1.modelo.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheRepositorio extends JpaRepository<Coche, Long> {


}
