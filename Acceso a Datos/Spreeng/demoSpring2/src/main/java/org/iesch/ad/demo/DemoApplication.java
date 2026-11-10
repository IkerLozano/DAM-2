package org.iesch.ad.demo;

import org.iesch.ad.demo.Servicios.ClienteService;
import org.iesch.ad.demo.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	ClienteService clienteService;

	@Override
	public void run(String... args) throws Exception {



		//lanzar la app
		//System.out.println("DATOS DEL CLIENTE 1");

		//clienteService.mostrarDatos(1L);

		//muestro todos
		System.out.println("Muestro todos");
		clienteService.mostrarTodos();


		//arreglo N+1 consultas
		System.out.println("\n".repeat(5));
		clienteService.arreglarN1();


		//arreglo N+1 consultas left join fetch

	}
}
