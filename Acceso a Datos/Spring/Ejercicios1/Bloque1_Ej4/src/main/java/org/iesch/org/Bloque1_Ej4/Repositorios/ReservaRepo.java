package org.iesch.org.Bloque1_Ej4.Repositorios;


import org.iesch.org.Bloque1_Ej4.Modelo.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepo extends JpaRepository<Reserva, Long> {
}
