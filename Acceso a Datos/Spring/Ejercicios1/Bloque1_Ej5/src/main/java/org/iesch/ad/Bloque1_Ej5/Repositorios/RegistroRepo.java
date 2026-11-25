package org.iesch.ad.Bloque1_Ej5.Repositorios;


import org.iesch.ad.Bloque1_Ej5.Modelo.RegistroVehicular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepo extends JpaRepository<RegistroVehicular, Long> {
}
