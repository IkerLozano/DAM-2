package org.iesch.ad.Bloque3_Ej1.Repositorios;


import org.iesch.ad.Bloque3_Ej1.Modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Long> {
}
