package org.iesch.ad.Bloque3_Ej1.Repositorios;


import org.iesch.ad.Bloque3_Ej1.DTO.ClienteProyeccion;
import org.iesch.ad.Bloque3_Ej1.Modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.List;

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


}
