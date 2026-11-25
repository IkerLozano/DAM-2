package org.iesch.ad.demo.repositorios;


import org.iesch.ad.demo.modelo.Cliente;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

    //obtengo los clientes y sus pedidos
    @Query("select distinct c from Cliente c left join fetch c.pedidos")
    List<Cliente> findAllConPedidos();
    /*
        left join: realiza una unión entre clientes y pedidos, incluyendo también los clientes que no tienen pedidos.
        fetch: indica que queremos cargar también los pedidos en esa misma consulta.
        c.pedidos: indica la relación que queremos cargar.
     */




/*
    //Esto es otra forma de indicar a Spring Data JPA que cargue los pedidos al ejecutar findAll().
    @EntityGraph(attributePaths = {"pedidos"})
    List<Cliente> findAll();

 */
}
