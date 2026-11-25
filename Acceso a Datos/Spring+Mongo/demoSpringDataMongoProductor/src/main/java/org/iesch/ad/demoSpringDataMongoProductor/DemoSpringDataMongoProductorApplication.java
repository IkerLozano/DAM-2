package org.iesch.ad.demoSpringDataMongoProductor;

import org.iesch.ad.demoSpringDataMongoProductor.Repositorio.ProductoRepository;
import org.iesch.ad.demoSpringDataMongoProductor.modelos.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DemoSpringDataMongoProductorApplication implements CommandLineRunner {


	@Autowired
	ProductoRepository productoRepository;


	public static void main(String[] args) {
		SpringApplication.run(DemoSpringDataMongoProductorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		INSERT
		Producto producto = Producto.builder().sku("BY1258XC").nombre("Coche").categoria("Juguetes").precio(15.59).stock(12).build();
		productoRepository.save(producto);

		 */


		/*
		SELECT
		List<Producto> productoList = productoRepository.findAll();

		System.out.println(productoList);

		 */


		/*
		ELIMINAR
		Optional<Producto> producto = productoRepository.findById("6b07272b2a6c06c00295ff4a");
		System.out.println(producto);

		productoRepository.deleteById("6b07272b2a6c06c00295ff4a");

		 */

	}
}
