package org.iesch.ad.Bloque2_Ej2.Repositorios;

import org.iesch.ad.Bloque2_Ej2.modelo.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepo extends JpaRepository<Categorias, Long> {




}
