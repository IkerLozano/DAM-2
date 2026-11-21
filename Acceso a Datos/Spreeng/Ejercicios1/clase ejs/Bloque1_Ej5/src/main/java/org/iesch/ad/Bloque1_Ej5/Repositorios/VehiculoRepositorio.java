package org.iesch.ad.Bloque1_Ej5.Repositorios;

import org.iesch.ad.Bloque1_Ej5.modelo.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VehiculoRepositorio extends JpaRepository<Vehiculo, Long> {
}
