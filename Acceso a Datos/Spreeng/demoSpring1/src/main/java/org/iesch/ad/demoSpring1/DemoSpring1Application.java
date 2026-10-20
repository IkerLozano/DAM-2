package org.iesch.ad.demoSpring1;

import org.iesch.ad.demoSpring1.modelo.Persona;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.util.List;


@SpringBootApplication
@PropertySource(value = "classpath:mi.properties", encoding = "UTF-8")
public class DemoSpring1Application implements CommandLineRunner {


	@Value("${mi.app.nombre}")
	String nombre;

	@Value("${mi.app.version}")
	String version;

	@Value("${firma}")
	String firma;

	@Autowired
	List<Persona> listaPersona;


	public static void main(String[] args) {
		SpringApplication.run(DemoSpring1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola mundo");

		/*
		System.out.println(version);
		System.out.println(nombre);
		System.out.println(firma);

		Persona p = Persona.builder().id(1L).dni("18444555A").build();
		System.out.println(p);

		Persona p2 = Persona.builder().id(2L).nombre("Iker").build();
		System.out.println(p2);
		*/

		listaPersona.forEach(System.out::println);


	}
}
