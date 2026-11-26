package org.iesch.ad.Repaso_Ej1.Repositorios;

import org.iesch.ad.Repaso_Ej1.Modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface LibroRepo extends JpaRepository<Libro, Long>{

    @Query("SELECT l FROM Libro l WHERE l.categoria.id = :idCategoria")
    List<Libro> librosPorCategoria(@Param("idCategoria")Long idCategoria);

}
