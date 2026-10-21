package org.iesch.ad.demoSpring1;

import lombok.RequiredArgsConstructor;
import org.iesch.ad.demoSpring1.modelo.Persona;
import org.iesch.ad.demoSpring1.repositorio.PersonaRepositorio;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
@RequiredArgsConstructor //FORMA2
@PropertySource(value = "classpath:mi.properties", encoding = "UTF-8") // para que pille bien acentos y demas
public class DemoSpring1Application implements CommandLineRunner {

	//sacar informacion, esta info esta en mi.propierties
	@Value("${mi.app.nombre}")
	String nombre;

	@Value("${mi.app.version}")
	String version;

	@Value("${firma}")
	String firma;

//	@Autowired
//	List<Persona> listaPersona;

	//FORMA 3:
	@Autowired
	PersonaRepositorio personaRepositorio;

	//FORMA 1:
	/*
	//para meter nuestras perosnas en la bbdd
	PersonaRepositorio personaRepositorio;
	public DemoSpring1Application(PersonaRepositorio personaRepositorio) {

		this.personaRepositorio = personaRepositorio;
	}
	*/


	public static void main(String[] args) {
		SpringApplication.run(DemoSpring1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola mundo");


		/*
		Persona p = Persona.builder().nombre("Iker").apellidos("Lozano").email("ilozanor@iesch.org").dni("11811114G").build();
		Persona p2 = Persona.builder().nombre("Juan").apellidos("Magan").email("juan@iesch.org").dni("11811114A").build();
		Persona p3 = Persona.builder().nombre("Hecproll").apellidos("criado").email("hectorcriado@iesch.org").dni("11811114B").build();
		Persona p4 = Persona.builder().nombre("Paula").apellidos("Micas").email("paulam@iesch.org").dni("11811114C").build();



		System.out.println(p);

		//personaRepositorio.save(p); //lo añade a la bbdd
		List<Persona> personaList = new ArrayList<>(Arrays.asList(p, p2, p3, p4));
		personaRepositorio.saveAll(personaList);
		*/

		//CRUD
		List<Persona> personaList1 = personaRepositorio.findAll();
		System.out.println(personaList1);


		/*
		System.out.println(version);
		System.out.println(nombre);
		System.out.println(firma);

		Persona p = Persona.builder().id(1L).dni("18444555A").build();
		System.out.println(p);

		Persona p2 = Persona.builder().id(2L).nombre("Iker").build();
		System.out.println(p2);
		*/

		//listaPersona.forEach(System.out::println);


	}
}
