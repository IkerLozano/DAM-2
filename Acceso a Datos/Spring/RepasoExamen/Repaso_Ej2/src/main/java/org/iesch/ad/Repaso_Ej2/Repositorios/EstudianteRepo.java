package org.iesch.ad.Repaso_Ej2.Repositorios;


import org.iesch.ad.Repaso_Ej2.Modelo.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepo extends JpaRepository<Estudiante, Long> {
}
