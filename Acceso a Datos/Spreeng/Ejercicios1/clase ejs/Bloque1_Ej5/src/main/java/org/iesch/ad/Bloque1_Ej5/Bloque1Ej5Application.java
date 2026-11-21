package org.iesch.ad.Bloque1_Ej5;

import lombok.RequiredArgsConstructor;
import org.iesch.ad.Bloque1_Ej5.Repositorios.RegistroVehicularRepositorio;
import org.iesch.ad.Bloque1_Ej5.Repositorios.VehiculoRepositorio;
import org.iesch.ad.Bloque1_Ej5.modelo.RegistroVehicular;
import org.iesch.ad.Bloque1_Ej5.modelo.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Bloque1Ej5Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Bloque1Ej5Application.class, args);
	}

	@Autowired
	VehiculoRepositorio vehiculoRepositorio;

	@Autowired
	RegistroVehicularRepositorio registroVehicularRepositorio;


	 @Override
	public void run(String... args) throws Exception {

		 RegistroVehicular registroVehicular = new RegistroVehicular();
		 registroVehicular.setNumeroRegistro("REG-A000001");
		 registroVehicular.setFechaExpedicion(LocalDate.of(2027, 12, 12));
		 registroVehicular.setFechaVencimiento(LocalDate.of(2067, 5, 3));

		 Vehiculo v1 = new Vehiculo();
		 v1.setMarca("Toyota");
		 v1.setModelo("Coche");
		 v1.setMatricula("123456A");
		 v1.setRegistroVehicular(registroVehicular);


		vehiculoRepositorio.save(v1);


	}
}
