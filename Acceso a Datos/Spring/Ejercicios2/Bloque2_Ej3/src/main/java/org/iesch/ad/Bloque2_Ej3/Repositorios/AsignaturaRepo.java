package org.iesch.ad.Bloque2_Ej3.Repositorios;


import org.iesch.ad.Bloque2_Ej3.Modelo.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepo extends JpaRepository<Asignatura, Long> {
}
