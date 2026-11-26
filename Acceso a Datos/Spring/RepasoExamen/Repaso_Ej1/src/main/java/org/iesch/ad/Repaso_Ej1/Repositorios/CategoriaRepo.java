package org.iesch.ad.Repaso_Ej1.Repositorios;

import org.iesch.ad.Repaso_Ej1.Modelo.Categoria;
import org.iesch.ad.Repaso_Ej1.Modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoriaRepo extends JpaRepository<Categoria, Long>{

    @Query("SELECT SIZE(c.libros) AS totalLibros FROM Categoria c WHERE c.id = :idCategoria")
    int numLibros(@Param("idCategoria") Long idCategoria);
}
