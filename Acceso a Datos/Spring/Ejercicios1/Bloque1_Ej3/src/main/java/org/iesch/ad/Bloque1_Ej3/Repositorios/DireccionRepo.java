package org.iesch.ad.Bloque1_Ej3.Repositorios;

import org.iesch.ad.Bloque1_Ej3.Modelo.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DireccionRepo extends JpaRepository<Direccion, Long> {
}
