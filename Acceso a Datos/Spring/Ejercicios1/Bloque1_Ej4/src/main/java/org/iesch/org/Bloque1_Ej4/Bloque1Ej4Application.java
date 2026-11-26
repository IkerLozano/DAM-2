package org.iesch.org.Bloque1_Ej4;

import jakarta.transaction.Transactional;
import org.iesch.org.Bloque1_Ej4.Modelo.Habitacion;
import org.iesch.org.Bloque1_Ej4.Modelo.Reserva;
import org.iesch.org.Bloque1_Ej4.Repositorios.HabitacionRepo;
import org.iesch.org.Bloque1_Ej4.Repositorios.ReservaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Bloque1Ej4Application implements CommandLineRunner {


	@Autowired
	HabitacionRepo habitacionRepo;

	@Autowired
	ReservaRepo reservaRepo;



	public static void main(String[] args) {
		SpringApplication.run(Bloque1Ej4Application.class, args);
	}


	@Transactional
	@Override
	public void run(String... args) throws Exception {



		/*
			Una Reserva → una Habitacion.
			Una Habitacion → muchas Reservas
		 */


		//UNIDIRECCIONAL
		System.out.println("UNIDIRECCIONAL");

/*
		//Creo las habitaciones
		Habitacion h1 = Habitacion.builder().numHabitacion(101).camas(2).precio(80).build();
		Habitacion h2 = Habitacion.builder().numHabitacion(102).camas(1).precio(55).build();
		Habitacion h3 = Habitacion.builder().numHabitacion(103).camas(3).precio(100).build();
		Habitacion h4 = Habitacion.builder().numHabitacion(104).camas(2).precio(75).build();

		habitacionRepo.save(h1);
		habitacionRepo.save(h2);
		habitacionRepo.save(h3);
		habitacionRepo.save(h4);


		//creo las reservas
		Reserva r1 = Reserva.builder().nombreCliente("Iker").fechaEntrada(LocalDate.of(2026, 11, 11)).fechaSalida(LocalDate.of(2026, 11, 15)).numPersonas(2).habitacion(h1).build();
		Reserva r2 = Reserva.builder().nombreCliente("Lucia").fechaEntrada(LocalDate.of(2026, 11, 12)).fechaSalida(LocalDate.of(2026, 11, 16)).numPersonas(1).habitacion(h2).build();
		Reserva r3 = Reserva.builder().nombreCliente("Daniel").fechaEntrada(LocalDate.of(2026, 11, 18)).fechaSalida(LocalDate.of(2026, 11, 22)).numPersonas(3).habitacion(h3).build();
		Reserva r4 = Reserva.builder().nombreCliente("Marta").fechaEntrada(LocalDate.of(2026, 11, 25)).fechaSalida(LocalDate.of(2026, 11, 28)).numPersonas(2).habitacion(h4).build();

		List<Reserva> reservas = new ArrayList<>(Arrays.asList(r1, r2, r3, r4));
		reservaRepo.saveAll(reservas);

*/

		//obtengo las habitaciones mediante las reservas
		List<Reserva> reservas2 = reservaRepo.findAll();

		for (Reserva r : reservas2){

			System.out.println("------Reserva de " + r.getNombreCliente() + "--------");
			System.out.println("Habitacion: " + r.getHabitacion().getNumHabitacion());
			System.out.println("Camas: " + r.getHabitacion().getCamas());
			System.out.println("Precio: " + r.getHabitacion().getPrecio());


		}


		//BIDIRECCIONAL
		System.out.println("BIDIRECCIONAL");


		//creo reservas
		Reserva r1 = Reserva.builder().nombreCliente("Iker").fechaEntrada(LocalDate.of(2026, 11, 11)).fechaSalida(LocalDate.of(2026, 11, 15)).numPersonas(2).build();
		Reserva r2 = Reserva.builder().nombreCliente("Lucia").fechaEntrada(LocalDate.of(2026, 11, 12)).fechaSalida(LocalDate.of(2026, 11, 16)).numPersonas(1).build();
		Reserva r3 = Reserva.builder().nombreCliente("Daniel").fechaEntrada(LocalDate.of(2026, 11, 18)).fechaSalida(LocalDate.of(2026, 11, 22)).numPersonas(3).build();
		Reserva r4 = Reserva.builder().nombreCliente("Marta").fechaEntrada(LocalDate.of(2026, 11, 25)).fechaSalida(LocalDate.of(2026, 11, 28)).numPersonas(2).build();


		//Creo las habitaciones con sus listas de reservas
		Habitacion h1 = Habitacion.builder().numHabitacion(101).camas(2).precio(80).reservas(List.of(r1, r2)).build();
		Habitacion h2 = Habitacion.builder().numHabitacion(102).camas(1).precio(55).reservas(List.of(r3)).build();
		Habitacion h3 = Habitacion.builder().numHabitacion(103).camas(3).precio(100).reservas(List.of(r4)).build();
		Habitacion h4 = Habitacion.builder().numHabitacion(104).camas(2).precio(75).reservas(List.of()).build();


		//conecto las reservas con la habitación
		r1.setHabitacion(h1);
		r2.setHabitacion(h1);
		r3.setHabitacion(h2);
		r4.setHabitacion(h3);


		//Guardo las habitaciones
		//hay que guardar primero las habitaciones pq sino habria reservas que tiene asignada una Habitación que todavía no se ha guardado en la base de datos.
		habitacionRepo.saveAll(List.of(h1, h2, h3, h4));

		//Guardo las reservas
		List<Reserva> reservas = new ArrayList<>(Arrays.asList(r1, r2, r3, r4));
		reservaRepo.saveAll(reservas);


		//desde la habitacion accedo a las reservas
		List<Habitacion> habitacions = habitacionRepo.findAll();

		for (Habitacion h : habitacions){ //Recorre todas las habitaciones, en cada vuelta h es una habitacion diferente

			for (Reserva r: h.getReservas()){ //seria de la 101.getReservas

				//h.getReservas() significa «dame todas las reservas que tiene asociadas esta habitación».

				System.out.println("------Reserva de " + r.getNombreCliente() + "-------");
				System.out.println(r.getHabitacion().getNumHabitacion());
				System.out.println(r.getFechaEntrada());



			}

		}








	}
}
