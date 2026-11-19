package org.iesch.ad.demo;

import org.iesch.ad.demo.Servicios.ClienteService;
import org.iesch.ad.demo.modelo.Cliente;
import org.iesch.ad.demo.modelo.Pedido;
import org.iesch.ad.demo.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	ClienteService clienteService;


	@Autowired
	ClienteRepositorio clienteRepositorio;

	@Override
	public void run(String... args) throws Exception {


		// ======================================================================
		//  RELACIÓN ONE TO MANY
		// ======================================================================

/*
		//UNIDIRECCIONAL
		System.out.println("MANY TO MANY UNIDIRECCIONAL");

		// Creo un cliente
		Cliente cliente = new Cliente();
		cliente.setNombre("Iker");

		// Creo dos pedidos
		Pedido pedido1 = new Pedido();
		pedido1.setFecha(LocalDateTime.now());
		pedido1.setResumen("Compra ordenador");

		Pedido pedido2 = new Pedido();
		pedido2.setFecha(LocalDateTime.now());
		pedido2.setResumen("Compra teclado");

		// Relaciono el cliente con los pedidos
		cliente.setPedidos(List.of(pedido1, pedido2));

		// Guardo el cliente
		clienteRepositorio.save(cliente);


		//muestro todos
		System.out.println("Muestro todos");
		clienteService.arreglarN1();


		//Acceder a los pedidos desde el cliente
		//aqui como uso findAllConPedidos soluciono elprobema de N+1
		//Si puesiera findAll entonces aparaceia el N+1
		List<Cliente> clientes = clienteRepositorio.findAllConPedidos();

		for (int i = 0; i <clientes.size() ; i++) {

			System.out.println("----------- Pedido del cliente " + clientes.get(i).getNombre() + "-----------");

			for (int j = 0; j <clientes.get(i).getPedidos().size() ; j++) {

				System.out.println("--> " + clientes.get(i).getPedidos().get(j).getResumen());
			}

		}

*/


		//BIDIRECCIONAL
		System.out.println("MANY TO MANY BIDIRECCIONAL");

	}
}
