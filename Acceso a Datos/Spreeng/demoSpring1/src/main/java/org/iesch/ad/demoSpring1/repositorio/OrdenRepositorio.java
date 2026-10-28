package org.iesch.ad.demoSpring1.repositorio;


import org.iesch.ad.demoSpring1.modelo.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepositorio extends JpaRepository<Orden, Long> {


}
