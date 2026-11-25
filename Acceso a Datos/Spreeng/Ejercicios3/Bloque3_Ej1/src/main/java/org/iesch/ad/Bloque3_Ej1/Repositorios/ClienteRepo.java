package org.iesch.ad.Bloque3_Ej1.Repositorios;


import org.iesch.ad.Bloque3_Ej1.DTO.ClienteProyeccion;
import org.iesch.ad.Bloque3_Ej1.Modelo.Cliente;
import org.iesch.ad.Bloque3_Ej1.Modelo.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Long> {


    //Ej1
    List<Cliente> findByCochesColor(String c);


    //Ej2
    List<Cliente> findByCochesPrecioGreaterThan(BigDecimal p);


    //Ej3
    @Query("select c.nombre, c.nif, c.ciudad, SIZE(c.coches) AS Totalcoches from Cliente c GROUP BY c ORDER BY Totalcoches DESC LIMIT 1")
    List<String> clienteConMasCoches();


    /*

    //Aqui la hago usando proyeccion
    @Query("SELECT NEW org.iesch.ad.Bloque3_Ej1.DTO.ClienteProyeccion(" +
            "c.nombre, c.nif, c.ciudad, SIZE(c.coches)) " +
            "FROM Cliente c " +
            "GROUP BY c " +
            "ORDER BY SIZE(c.coches) DESC")
    List<ClienteProyeccion> clienteConMasCoches();
    */


    //Ej6 -- por hacer
    @Query("SELECT p from Cliente p JOIN p.coches c where c.matricula = :matricula")
    Optional<Cliente> clienteDeCoche(@Param("matricula")String matricula);


    //Ej7
    @Query("SELECT p FROM Cliente p JOIN p.coches c JOIN c.revisiones r WHERE r.codigo = :codigo")
    Optional<Cliente> clientePorCodigo(@Param("codigo") String codigo);


    //Ej8
    @Query("SELECT p.nombre, p.nif, p.direccion, p.ciudad, p.telefono, SIZE(p.coches) AS NumCoches, SUM(c.precio) AS TotalGastado FROM Cliente p JOIN p.coches c JOIN c.revisiones r WHERE r.codigo = :codigo")
    Optional<String> clientePorCodigoFinal(@Param("codigo") String codigo);
    /*
    hay que hacer desde coche
    @Query("SELECT c.nombre, c.ciudad, c.direccion, c.nif, c.telefono, SIZE(c.coches), SUM(co2.precio) FROM Coche co JOIN co.revisiones rev JOIN co.cliente c JOIN c.coches co2 WHERE rev.codigo = :codigo")
     */


}
