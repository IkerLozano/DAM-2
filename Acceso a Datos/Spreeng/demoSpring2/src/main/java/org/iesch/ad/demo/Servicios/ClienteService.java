package org.iesch.ad.demo.Servicios;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.iesch.ad.demo.modelo.Cliente;
import org.iesch.ad.demo.repositorios.ClienteRepositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {



    private final ClienteRepositorio clienteRepositorio;

    //el loger tiene que se el sf4j
    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    // Es necesario que tenga transactional si la relacion es lazy para que la conexión no se abra y se cierre en esta línea solo:
    // Optional<Cliente> clienteOptional = clienteRepositorio.findById(id);
    // permitiendo sacar los datos necesarios
    //MIRAR ESTO *****
    @Transactional
    public void mostrarDatos(long id){
        logger.trace("entra en el mostrarDatos");
        logger.debug("id" + id);

        Optional<Cliente> clienteOPtional = clienteRepositorio.findById(id);

        if (clienteOPtional.isPresent()){

            Cliente cliente = clienteOPtional.get();
            System.out.println(cliente.getNombre());
            System.out.println(cliente.getId());
            //System.out.println(cliente);

            System.out.println("--".repeat(10));

            System.out.println(cliente.getPedidos().size());


        }
        else System.out.println("No existe el id " + id );

        logger.trace("Se sale de mostrarDatos");
    }



    //@Transactional
    public void mostrarTodos() {


        List<Cliente> clienteList = clienteRepositorio.findAll();
        System.out.println(clienteList);

/*
        System.out.println(clienteList.size());
        System.out.println("#".repeat(20));

        for (Cliente cliente : clienteList){
            System.out.println("Pedidos cliente: " + cliente.getId() + " - " + cliente.getPedidos().size() + " pedidos");
        }

 */

    }

    public void arreglarN1() {

        List<Cliente> clienteList = clienteRepositorio.findAllConPedidos();
        System.out.println(clienteList);



    }


}
