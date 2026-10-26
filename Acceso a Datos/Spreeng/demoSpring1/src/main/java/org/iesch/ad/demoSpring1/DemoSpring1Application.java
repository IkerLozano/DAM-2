package org.iesch.ad.demoSpring1;

import lombok.RequiredArgsConstructor;
import org.iesch.ad.demoSpring1.modelo.Coche;
import org.iesch.ad.demoSpring1.modelo.Persona;
import org.iesch.ad.demoSpring1.repositorio.CocheRepositorio;
import org.iesch.ad.demoSpring1.repositorio.PersonaRepositorio;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.util.*;


@SpringBootApplication
@RequiredArgsConstructor //FORMA2 - 1)
@PropertySource(value = "classpath:mi.properties", encoding = "UTF-8") // para que pille bien acentos y demas
public class DemoSpring1Application implements CommandLineRunner {


	//private final PersonaRepositorio personaRepositorio;   // //FORMA2 - 2) el campo tiene que ser final


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
	PersonaRepositorio personaRepositorio;
	public DemoSpring1Application(PersonaRepositorio personaRepositorio) {

		this.personaRepositorio = personaRepositorio;
	}

 */

	//para podr usar el repo de coche
	@Autowired
	CocheRepositorio cocheRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(DemoSpring1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		System.out.println("Hola mundo");


		//CREO PEROSONAS CON SU INFO
		//INSERTAR
 /*
		Persona p = Persona.builder().nombre("Iker").apellidos("Lozano").email("ilozanor@iesch.org").dni("11811114G").build();
		Persona p2 = Persona.builder().nombre("Juan").apellidos("Magan").email("juan@iesch.org").dni("11811114A").build();
		Persona p3 = Persona.builder().nombre("Hecproll").apellidos("criado").email("hectorcriado@iesch.org").dni("11811114B").build();
		Persona p4 = Persona.builder().nombre("Paula").apellidos("Micas").email("paulam@iesch.org").dni("11811114C").build();
*/

		//System.out.println(p);
/*
		Persona p = new Persona();
		p.setNombre("Pascualico");
		p.setApellidos("java");
		p.setDni("123123A");
		p.setEmail("PAC");
		personaRepositorio.save(p); //solo una
*/

/*
		//------->meto esas peronas a la lista
		List<Persona> personaList = new ArrayList<>(Arrays.asList(p, p2, p3, p4));

		// -----> añado personas a la bbdd
//		personaRepositorio.save(p); //solo una
		personaRepositorio.saveAll(personaList); //todas


		//CRUD
		//------> nos traemos todo los dato de ls bbdd y lo mete en personaList1 y lo mostramos
		List<Persona> personaList1 = personaRepositorio.findAll();
		System.out.println("--TRAIGO TODA LA INFO DE LA BBDD---");
		personaList.forEach(System.out::println);
		System.out.println("-----------------------------------");


		//INFO
		System.out.println(version);
		System.out.println(nombre);
		System.out.println(firma);



		Persona p5 = Persona.builder().id(1L).dni("18444555A").build();
		System.out.println(p);

		Persona p6 = Persona.builder().id(2L).nombre("Iker").build();
		System.out.println(p2);

		//listaPersona.forEach(System.out::println);


		//UPDATE

		//si no ponemos el Optional y no encuientra esa persona nos dara fallo
		Optional<Persona> PersonaEncontradaPorId = personaRepositorio.findById(4L);


		if (PersonaEncontradaPorId.isPresent()){
			System.out.println("---------------Persona encontrada por ID----------------");

			System.out.println(PersonaEncontradaPorId.get()); //el .get() es para q no muetsre el Optional

		}else{
			System.out.println("Persona no encontrada");
		}


		//cambiamnos los datos
		if (PersonaEncontradaPorId.isPresent()){

			PersonaEncontradaPorId.get().setNombre("Joaquin");
			PersonaEncontradaPorId.get().setApellidos("juanlu");
			PersonaEncontradaPorId.get().setDni("99999999R");
			PersonaEncontradaPorId.get().setEmail("juanlu@aa.es");
			//guardo los cambios
			personaRepositorio.save(PersonaEncontradaPorId.get());

		}

		personaList1 = personaRepositorio.findAll();
		System.out.println(personaList1);



		//DELETE
		//----> forma 1 de borrar
		Optional<Persona> personaBorrar = personaRepositorio.findById(5L);
		if (personaBorrar.isPresent()){

			Persona personaBorra = personaBorrar.get();
			personaRepositorio.delete(personaBorra);

			//pone esto pero no hace nada --> Hibernate: delete from persona where id=?
		}

		//----> forma 2 de borrar
		Persona personaTMP = new Persona();
		personaTMP.setId(3L);
		personaRepositorio.delete(personaTMP);


*/

/*
		//CONSULTAS
		System.out.println("POR HQL");
		List<Persona> listaPersonas = personaRepositorio.buscaTodasPersonas();
		listaPersonas.forEach(System.out::println);

		System.out.println("POR NATIVO");
		List<Persona> listaPersonas2 = personaRepositorio.buscaTodasPersonasNative();
		listaPersonas.forEach(System.out::println);

		System.out.println("PSEUDO-LENGUAJE");
		//buscamos personas q su nomnre empieze por J
		List<Persona> empeizaJ = personaRepositorio.findByNombreStartingWith('j');
		System.out.println(empeizaJ);

		//buscamos personas con DNI que acabe en A y el apellido contenga una z
		List<Persona> dniYapellido = personaRepositorio.findByDniContainingAndApellidosContaining('A', "A");
		System.out.println(dniYapellido);

		//persona con dni que contenga un 9 o su email sea nulo
		List<Persona> dniYemial = personaRepositorio.findByDniContainingOrEmailIsNull("1");
		System.out.println(dniYemial);

*/


		System.out.println("ONE TO ONE");

		//nueva persona
		Persona persona = new Persona();
		persona.setNombre("Pepelu");
		persona.setNombre("Valencia");
		persona.setDni("1231123A");
		persona.setEmail("pepelu@aa.es");


		//Nuevo coche
		Coche coche	= new Coche();
		coche.setMarca("Tesla");
		coche.setModelo("3");
		coche.setMatricula("9999 JNY");


		//le asigno el coche a la persona
		persona.setCoche(coche);
		//lo guardo en la BBDD
		personaRepositorio.save(persona);


		//cargar de la bbdd la persona con id 16
		Optional<Persona> personaConCoche = personaRepositorio.findById(16L);
		if (personaConCoche.isPresent()){
			Persona p = personaConCoche.get();
			System.out.println(p);
		}




		Optional<Coche> coche = cocheRepositorio





	}
}
