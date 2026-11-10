package org.iesch.ad.demo.repositorios;


import org.iesch.ad.demo.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepositorio extends JpaRepository<Cliente, Long> {
}
