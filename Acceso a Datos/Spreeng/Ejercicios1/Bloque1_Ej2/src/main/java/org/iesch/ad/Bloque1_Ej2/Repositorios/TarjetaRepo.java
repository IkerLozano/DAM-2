package org.iesch.ad.Bloque1_Ej2.Repositorios;


import org.iesch.ad.Bloque1_Ej2.Modelo.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepo extends JpaRepository<Tarjeta, Long> {
}
