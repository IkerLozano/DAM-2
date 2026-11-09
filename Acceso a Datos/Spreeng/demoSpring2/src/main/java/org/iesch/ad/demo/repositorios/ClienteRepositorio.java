package org.iesch.ad.demo.repositorios;


import org.iesch.ad.demo.modelo.Cliente;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {


    @Query("select distinct c from Cliente c left join fetch c.pedidos")
    List<Cliente> findAllConPedidos();



    @EntityGraph(attributePaths = {"pedidos"})
    List<Cliente> findAll();
}
