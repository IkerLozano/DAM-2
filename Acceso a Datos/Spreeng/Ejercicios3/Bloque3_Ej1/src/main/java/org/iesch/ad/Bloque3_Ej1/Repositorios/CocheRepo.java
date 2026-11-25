package org.iesch.ad.Bloque3_Ej1.Repositorios;


import org.iesch.ad.Bloque3_Ej1.Modelo.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CocheRepo extends JpaRepository<Coche, String> {


    //Ej4
    @Query("SELECT c FROM Coche c ORDER BY SIZE(c.revisiones) ASC LIMIT 1")
    List<Coche> cochesRevisiones();

    //Ej5
    @Query("SELECT c.matricula, SIZE(c.revisiones) AS revisiones from Coche c GROUP BY c.matricula")
    List<String> cocheYmatricula();


    //Ej8
    @Query("SELECT p.nombre, p.nif, p.direccion, p.ciudad, p.telefono, SIZE(p.coches) as numCoches, SUM(c.precio) as precioTotal FROM Coche c JOIN c.cliente p JOIN c.revisiones r WHERE r.codigo = :codigo");
    //@Query("SELECT c.nombre, c.ciudad, c.direccion, c.nif, c.telefono, SIZE(c.coches), SUM(co2.precio) FROM Coche co JOIN co.revisiones rev JOIN co.cliente c JOIN c.coches co2 WHERE rev.codigo = :codigo")
    Optional<String> clientePorCodigoFinal2(@Param("codigo") String codigo);

}
