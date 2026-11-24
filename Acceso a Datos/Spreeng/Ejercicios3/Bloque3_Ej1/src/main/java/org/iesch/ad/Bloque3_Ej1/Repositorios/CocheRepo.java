package org.iesch.ad.Bloque3_Ej1.Repositorios;


import org.iesch.ad.Bloque3_Ej1.Modelo.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CocheRepo extends JpaRepository<Coche, String> {


    //Ej4
    @Query("SELECT c FROM Coche c ORDER BY SIZE(c.revisiones) ASC LIMIT 1")
    List<Coche> cochesRevisiones();

    //Ej5
    @Query("SELECT c.matricula, SIZE(c.revisiones) AS revisiones from Coche c GROUP BY c.matricula")
    List<String> cocheYmatricula();

}
