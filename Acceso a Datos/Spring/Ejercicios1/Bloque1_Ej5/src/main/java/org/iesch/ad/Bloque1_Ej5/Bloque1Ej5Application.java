package org.iesch.ad.Bloque1_Ej5;

import org.iesch.ad.Bloque1_Ej5.Modelo.RegistroVehicular;
import org.iesch.ad.Bloque1_Ej5.Modelo.Vehiculo;
import org.iesch.ad.Bloque1_Ej5.Repositorios.RegistroRepo;
import org.iesch.ad.Bloque1_Ej5.Repositorios.VehiculoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Bloque1Ej5Application implements CommandLineRunner {


	@Autowired
	RegistroRepo registroRepo;

	@Autowired
	VehiculoRepo vehiculoRepo;


	public static void main(String[] args) {
		SpringApplication.run(Bloque1Ej5Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {


		//UNIDIRECCIONAL
		System.out.println("UNIDIRECCIONAL");

		//creo los vehiculos
		Vehiculo v1 = Vehiculo.builder().marca("Toyota").matricula("1236454AD").duenio("Iker").build();
		Vehiculo v2 = Vehiculo.builder().marca("BMW").matricula("4567BCD").duenio("Lucia").build();
		Vehiculo v3 = Vehiculo.builder().marca("Audi").matricula("7890FGH").duenio("Daniel").build();
		Vehiculo v4 = Vehiculo.builder().marca("Seat").matricula("2345JKL").duenio("Marta").build();


		//creo los registros
		RegistroVehicular rv1 = RegistroVehicular.builder().numRegistro(15).fechaExpedicion(LocalDate.of(2026, 1, 1)).fechaVencimiento(LocalDate.of(2029, 1, 1)).vehiculo(v1).build();
		RegistroVehicular rv2 = RegistroVehicular.builder().numRegistro(16).fechaExpedicion(LocalDate.of(2026, 2, 1)).fechaVencimiento(LocalDate.of(2029, 2, 1)).vehiculo(v2).build();
		RegistroVehicular rv3 = RegistroVehicular.builder().numRegistro(17).fechaExpedicion(LocalDate.of(2026, 3, 1)).fechaVencimiento(LocalDate.of(2029, 3, 1)).vehiculo(v3).build();
		RegistroVehicular rv4 = RegistroVehicular.builder().numRegistro(18).fechaExpedicion(LocalDate.of(2026, 4, 1)).fechaVencimiento(LocalDate.of(2029, 4, 1)).vehiculo(v4).build();


		v1.setRegistroVehicular(rv1);
		v2.setRegistroVehicular(rv2);
		v3.setRegistroVehicular(rv3);
		v4.setRegistroVehicular(rv4);


		registroRepo.save(rv1);
		registroRepo.save(rv2);
		registroRepo.save(rv3);
		registroRepo.save(rv4);


		//accedo al vehiculo medinate el registro
		List<RegistroVehicular> registroVehiculars = registroRepo.findAll();

		for (RegistroVehicular rv : registroVehiculars){

			System.out.println("------Resgistro del vehiculo: " + rv.getVehiculo().getMatricula() + "--------");
			System.out.println(rv.getNumRegistro());
			System.out.println(rv.getFechaExpedicion());
			System.out.println(rv.getFechaVencimiento());
		}


		//BIDIRECCIONAL
		System.out.println("BIDIRECCIONAL");


		List<Vehiculo> vehiculos = vehiculoRepo.findAll();

		for (Vehiculo v : vehiculos){

			System.out.println("-------Vehiculo de " + v.getDuenio() + "--------");
			System.out.println("Num registro:" + v.getRegistroVehicular().getNumRegistro());
			System.out.println("Vencimineto" + v.getRegistroVehicular().getFechaExpedicion());
		}


	}
}
