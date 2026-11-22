package org.iesch.ad.Bloque2_Ej1.Repositorios;


import org.iesch.ad.Bloque2_Ej1.Modelo.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocioRepo extends JpaRepository<Socio, Long> {
}
