package org.iesch.ad.demo;

import org.iesch.ad.demo.Servicios.ClienteService;
import org.iesch.ad.demo.modelo.Cliente;
import org.iesch.ad.demo.modelo.Pedido;
import org.iesch.ad.demo.repositorios.ClienteRepositorio;
import org.iesch.ad.demo.repositorios.PedidoRepositorio;
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

	@Autowired
	PedidoRepositorio pedidoRepositorio;



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

		//creo 2 clientes
		Cliente c1 = new Cliente();
		c1.setNombre("Andres");

		Cliente c2 = new Cliente();
		c2.setNombre("Carlos");

		clienteRepositorio.save(c1);
		clienteRepositorio.save(c2);


		//creo 3 pedidos
		Pedido p1 = new Pedido();
		p1.setFecha(LocalDateTime.now());
		p1.setResumen("Pedido de matematicas");
		p1.setCliente(c1);

		Pedido p2 = new Pedido();
		p2.setFecha(LocalDateTime.now());
		p2.setResumen("Pedido de lengua");
		p2.setCliente(c1);

		Pedido p3 = new Pedido();
		p3.setFecha(LocalDateTime.now());
		p3.setResumen("Pedido de historia");
		p3.setCliente(c2);

		pedidoRepositorio.save(p1);
		pedidoRepositorio.save(p2);
		pedidoRepositorio.save(p3);


		// CONSULTAR CLIENTES Y SUS PEDIDOS (esto ya lo poniahacer en la unidireccionalidad)
		System.out.println("CLIENTES Y SUS PEDIDOS");

		List<Cliente> clientes = clienteRepositorio.findAll();

		for (Cliente c : clientes) {
			System.out.println("----------------Cliente: " + c.getNombre() + "----------------");

			for (Pedido p : c.getPedidos()) {
				System.out.println("Pedido: " + p.getResumen());
			}
		}


		// CONSULTAR PEDIDOS Y SUS CLIENTES
		System.out.println("PEDIDOS Y SUS CLIENTES");

		List<Pedido> pedidos = pedidoRepositorio.findAll();

		for (Pedido p : pedidos) {
			System.out.println("Pedido: " + p.getResumen());
			System.out.println(" --> Cliente: " + p.getCliente().getNombre());
		}






	}
}
