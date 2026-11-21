package org.iesch.ad.Bloque1_Ej5.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RegistroVehicularRepositorio extends JpaRepository<RegistroVehicularRepositorio, Long> {
}
