package org.iesch.ad.Bloque2_Ej2.Repositorios;


import org.iesch.ad.Bloque2_Ej2.Modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepo extends JpaRepository<Libro, Long> {


    List<Libro> findByCategoriaId(Long id);
    /*
        buscar en la base de datos todos los libros que pertenecen a una categoría concreta.

        Al poner "ByCategoriaId" buscar por el id de la categoría asociada al libro.
     */
}
