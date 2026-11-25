package org.iesch.ad.Bloque1_Ej2;

import org.iesch.ad.Bloque1_Ej2.Modelo.Empleado;
import org.iesch.ad.Bloque1_Ej2.Modelo.Tarjeta;
import org.iesch.ad.Bloque1_Ej2.Repositorios.EmpleadoRepo;
import org.iesch.ad.Bloque1_Ej2.Repositorios.TarjetaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Bloque1Ej2Application implements CommandLineRunner {

	@Autowired
	TarjetaRepo tarjetaRepo;

	@Autowired
	EmpleadoRepo empleadoRepo;



	public static void main(String[] args) {
		SpringApplication.run(Bloque1Ej2Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {



		//UNIDIRECCIONAL
		System.out.println("UNIDIRECCIONAL");

		//creo sus tarjetas
		Tarjeta t1 = Tarjeta.builder().codigo("1111").fechaExp(LocalDate.of(2029, 1, 1)).build();
		Tarjeta t2 = Tarjeta.builder().codigo("2222").fechaExp(LocalDate.of(2028, 6, 15)).build();
		Tarjeta t3 = Tarjeta.builder().codigo("3333").fechaExp(LocalDate.of(2030, 3, 20)).build();
		Tarjeta t4 = Tarjeta.builder().codigo("4444").fechaExp(LocalDate.of(2027, 11, 30)).build();


		//creo empleados
		Empleado e1 = Empleado.builder().nombre("Iker").email("ilozanor@iesch.org").tarjeta(t1).build();
		Empleado e2 = Empleado.builder().nombre("Lucia").email("lucia@gmail.com").tarjeta(t2).build();
		Empleado e3 = Empleado.builder().nombre("Daniel").email("daniel@gmail.com").tarjeta(t3).build();
		Empleado e4 = Empleado.builder().nombre("Marta").email("marta@gmail.com").tarjeta(t4).build();


		//le asigno las tarjetas a lo empleados, esto no o hacia antes pq el lado propietario ya lo hacia
		// con el cascade, pero aqui el casde esta en un lado y el propietario es otro por lo cual hay que hacerlo
		//se asigna antes de guardar
		t1.setEmpleado(e1);
		t2.setEmpleado(e2);
		t3.setEmpleado(e3);
		t4.setEmpleado(e4);



		empleadoRepo.save(e1);
		empleadoRepo.save(e2);
		empleadoRepo.save(e3);
		empleadoRepo.save(e4);



		//ontengo los empleados meidnate las tarjetas
		System.out.println("UNIDIRECCIONAL");

		List<Tarjeta> tarjetas = tarjetaRepo.findAll();

		for (Tarjeta t : tarjetas){

			System.out.println("------Tarjeta del empleado " + t.getEmpleado().getNombre() + "-------");
			System.out.println(t.getCodigo());
			System.out.println(t.getFechaExp());

		}



		//BIDIRECCIONAL
		System.out.println("BIDIRECCIONAL");

		//uso los empleados que ya hay metidos
		//los recojo
		List<Empleado> empleados = empleadoRepo.findAll();

		for (Empleado e : empleados){

			System.out.println("------Empleado: " + e.getNombre() + "--------");
			System.out.println(e.getTarjeta().getCodigo());
			System.out.println(e.getTarjeta().getFechaExp());
		}



		//borro un empleado, al borarlo se tienw que borar su tarjeta ya que tenmos el  "cascade = CascadeType.ALL" en empleado
		Optional<Empleado> empleadoBorrar = empleadoRepo.findById(2L);

		if (empleadoBorrar.isPresent()){


			Empleado empleadoYaElimado = empleadoBorrar.get();

			System.out.println("El empelado " + empleadoYaElimado.getNombre() + " a sido eliminado, y su tarjeta con cod " + empleadoYaElimado.getTarjeta().getCodigo() + " tambien se a eliminado");

			empleadoRepo.delete(empleadoYaElimado);



		}


	}

}
