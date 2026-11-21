package org.iesch.ad.Bloque1_Ej3;

import org.iesch.ad.Bloque1_Ej3.Modelo.Direccion;
import org.iesch.ad.Bloque1_Ej3.Modelo.Pedido;
import org.iesch.ad.Bloque1_Ej3.Repositorios.DireccionRepo;
import org.iesch.ad.Bloque1_Ej3.Repositorios.PedidoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Bloque1Ej3Application implements CommandLineRunner {

	@Autowired
	PedidoRepo pedidoRepo;


	@Autowired
	DireccionRepo direccionRepo;



	public static void main(String[] args) {
		SpringApplication.run(Bloque1Ej3Application.class, args);
	}



	@Override
	public void run(String... args) throws Exception {


		//UNIDIRECCIONAL
		System.out.println("UNIDIRECCIONAL");


		//creo los pedidos
		Pedido p1 = Pedido.builder().nombre("Iker").cantidad(12).num(125).build();
		Pedido p2 = Pedido.builder().nombre("Lucia").cantidad(5).num(126).build();
		Pedido p3 = Pedido.builder().nombre("Daniel").cantidad(8).num(127).build();
		Pedido p4 = Pedido.builder().nombre("Marta").cantidad(3).num(128).build();



		//creo las direcciones
		Direccion d1 = Direccion.builder().calle("Avenida Aragón 25").ciudad("Teruel").CP(44003).pais("España").pedido(p1).build();
		Direccion d2 = Direccion.builder().calle("Calle Mayor 12").ciudad("Madrid").CP(28013).pais("España").pedido(p2).build();
		Direccion d3 = Direccion.builder().calle("Calle San Juan 8").ciudad("Valencia").CP(46001).pais("España").pedido(p3).build();
		Direccion d4 = Direccion.builder().calle("Avenida del Mar 40").ciudad("Barcelona").CP(55603).pais("España").pedido(p4).build();

		direccionRepo.save(d1);
		direccionRepo.save(d2);
		direccionRepo.save(d3);
		direccionRepo.save(d4);


		//desde la direccion objeto los pedidos
		List<Direccion> direccions = direccionRepo.findAll();

		for (Direccion d : direccions){

			System.out.println("------Pedido de " + d.getPedido().getNombre() + "--------");
			System.out.println(d.getCalle());
			System.out.println(d.getCiudad());
			System.out.println(d.getCP());
			System.out.println("Contidad pedida: " + d.getPedido().getCantidad());

		}


		//BIDIRECCIONAL
		System.out.println("BIDIRECCIONAL");

		//voy a usar los mismo datos que con la unidireccionalidad

		//recupero todos los pedidos
		List<Pedido> pedidos = pedidoRepo.findAll();

		for (Pedido p : pedidos){

			System.out.println("-----Pedido de " + p.getNombre() + "-------");
			System.out.println(p.getDireccion().getCalle());
			System.out.println(p.getDireccion().getCiudad());
			System.out.println(p.getDireccion().getCP());


		}

	}
}
