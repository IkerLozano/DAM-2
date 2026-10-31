package org.iesch.ad.demoSpring1;

import org.iesch.ad.demoSpring1.modelo.Coche;
import org.iesch.ad.demoSpring1.modelo.Persona;
import org.iesch.ad.demoSpring1.repositorio.CocheRepositorio;
import org.iesch.ad.demoSpring1.repositorio.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.util.*;


@SpringBootApplication
//@RequiredArgsConstructor
@PropertySource(value = "classpath:mi.properties", encoding = "UTF-8") //UTF-8 --> para que pille bien acentos y ñ
public class DemoSpring1Application implements CommandLineRunner {


	// ==========================================================================
	//  VALORES LEIDOS DEL ARCHIVO "mi.properties"
	// ==========================================================================

	//para sacar la informacion del archivo "mi.properties"
	@Value("${mi.app.nombre}")
	String nombre;

	@Value("${mi.app.version}")
	String version;

	@Value("${firma}")
	String firma;


	// ==========================================================================
	//  INYECCION DE DEPENDENCIAS - usar los Repos aqui
	// ==========================================================================

	//FORMA 1 (constructor manual)

	/*
	PersonaRepositorio personaRepositorio;
	public DemoSpring2Application(PersonaRepositorio personaRepositorio) {

		this.personaRepositorio = personaRepositorio;
	}
 	*/

	//FORMA 2 (Autowired)
	//	@Autowired
	//	List<Persona> listaPersona;


	//FORMA 3 (RequiredArgsConstructor)
	//@RequiredArgsConstructor (poner encima de clase)
	//private final PersonaRepositorio personaRepositorio;   //el campo tiene que ser final


	//Meto los repos con la forma2

		//repo de personas
	@Autowired
	PersonaRepositorio personaRepositorio;


		//repo de coches
	@Autowired
	CocheRepositorio cocheRepositorio;



	// ==========================================================================
	//  METODO MAIN  (arranca la aplicacion)
	// ==========================================================================

	public static void main(String[] args) {
		SpringApplication.run(DemoSpring1Application.class, args);
	}


	// ==========================================================================
	//  METODO RUN  (aqui probamos tódo)
	// ==========================================================================

	@Override
	public void run(String... args) throws Exception {


		// ======================================================================
		//  MOSTRAR INFO DEL ARCHIVO mi.properties
		// ======================================================================

		System.out.println("====== INFO ======");
		System.out.println(nombre);
		System.out.println(version);
		System.out.println(firma);
		System.out.println("==================");





		// ======================================================================
		//  INSERTAR DATOS
		// ======================================================================


/*
		//Crear personas con BUILDER
		Persona p1 = Persona.builder().nombre("Iker").apellidos("Lozano").email("ilozanor@iesch.org").dni("11811114G").build();
		Persona p2 = Persona.builder().nombre("Juan").apellidos("Magan").email("juan@iesch.org").dni("11811114A").build();
		Persona p3 = Persona.builder().nombre("Hecproll").apellidos("criado").email("hectorcriado@iesch.org").dni("11811114B").build();
		Persona p4 = Persona.builder().nombre("Paula").apellidos("Micas").email("paulam@iesch.org").dni("11811114C").build();



		//Crear personas con SETTERS
		Persona p5 = new Persona();
		p5.setNombre("Pascualico");
		p5.setApellidos("java");
		p5.setDni("123123A");
		p5.setEmail("PAC");



		//INSERTAR:

		//meto las personas a la lista
		List<Persona> personaList = new ArrayList<>(Arrays.asList(p1, p2, p3, p4));

		//añado las personas a la bbdd
		personaRepositorio.saveAll(personaList); //todas
		personaRepositorio.save(p5); //solo una

*/




		// ======================================================================
		//  LEER DATOS
		// ======================================================================

/*
		//nos traemos tódo los dato de la bbdd y lo mete en personasBBDD y lo mostramos
		List<Persona> personasBBDD = personaRepositorio.findAll();  //findAll() --> busca y devuelve todas las personas almacenadas en la base de datos.

		System.out.println("---TRAIGO TODA LA INFO DE LA BBDD---");
		personasBBDD.forEach(System.out::println);
		System.out.println("-----------------------------------");

*/




		// ======================================================================
		//  ACTUALIZAR DATOS
		// ======================================================================

/*


		//me creo una persona nueva y la meto a la bbdd
		Persona p6 = Persona.builder().nombre("Andres").apellidos("Stan").email("aestan@iesch").dni("18444555A").build();
		personaRepositorio.save(p6);


		//busco la persona por su ID

			//si no ponemos el Optional y nos encuentra esa persona nos dara fallo
		Optional<Persona> PersonaEncontradaPorId = personaRepositorio.findById(6L);

			//compruebo si esa persona existe
		if (PersonaEncontradaPorId.isPresent()){

			System.out.println(PersonaEncontradaPorId.get()); //el .get() es para q no muetsre el Optional

			PersonaEncontradaPorId.get().setNombre("Joaquin");
			PersonaEncontradaPorId.get().setApellidos("juanlu");
			PersonaEncontradaPorId.get().setDni("99999999R");
			PersonaEncontradaPorId.get().setEmail("juanlu@aa.es");

			//guardo los cambios
			personaRepositorio.save(PersonaEncontradaPorId.get());

			//consulto los datos
			List<Persona> personasUpdate = personaRepositorio.findAll();
			personasUpdate.forEach(System.out::println);


		}else{
			System.out.println("Persona no encontrada");
		}

*/



		// ======================================================================
		//  ELIMINAR DATOS
		// ======================================================================


/*
		//FORMA 1 (buscar y borrar)
		Optional<Persona> personaBorrar = personaRepositorio.findById(6L); //busco la perosna con ese id

		//si existe la boroo
		if (personaBorrar.isPresent()){

			Persona personaEliminada = personaBorrar.get();
			personaRepositorio.delete(personaEliminada);

		}


		//forma 2 (objeto temporal con el id)
		Persona personaTMP = new Persona(); //crea un objeto perona vacio, no se crea una persona nueva
		personaTMP.setId(5L); //le asigno el id 5
		personaRepositorio.delete(personaTMP); //borro la perona con id5


*/




		// ======================================================================
		//  4.5  CONSULTAS PERSONALIZADAS (HQL, NATIVO Y PSEUDO-LENGUAJE)
		// ======================================================================


/*
		//1- HQL
		System.out.println("POR HQL");

		List<Persona> consulta1 = personaRepositorio.buscaTodasPersonas();
		consulta1.forEach(System.out::println);



		//2- NATIVO
		System.out.println("POR NATIVO");

		List<Persona> consulta2 = personaRepositorio.buscaTodasPersonasNative();
		consulta2.forEach(System.out::println);



		//3- PSEUDO-LENGUAJE
		System.out.println("PSEUDO-LENGUAJE");

		//buscamos personas q su nomnre empieze por J
		List<Persona> empeizaJ = personaRepositorio.findByNombreStartingWith('j');
		System.out.println(empeizaJ);

		//buscamos personas con DNI que acabe en A y el apellido contenga una A
		List<Persona> dniYapellido = personaRepositorio.findByDniContainingAndApellidosContaining('A', "A");
		System.out.println(dniYapellido);

		//persona con dni que contenga un 1 o su email sea nulo
		List<Persona> dniYemial = personaRepositorio.findByDniContainingOrEmailIsNull("1");
		System.out.println(dniYemial);

*/



		// ======================================================================
		//  RELACION ONE TO ONE
		// ======================================================================


/*

		//UNIDIRECCIONAL
		System.out.println("ONE TO ONE UNIDIRECCIONAL");

		//creo una persona
		Persona persona1 = new Persona();
		persona1.setNombre("Pepelu");
		persona1.setApellidos("Valencia");
		persona1.setDni("1231123A");
		persona1.setEmail("pepelu@aa.es");


		//Creo un coche
		Coche coche1 = new Coche();
		coche1.setMarca("Tesla");
		coche1.setModelo("3");
		coche1.setMatricula("9999 JNY");



		//relacionarlos y guardarlo

		//Relaciono el coche con la persona
		persona1.setCoche(coche1);
		//lo guardo en la BBDD
		personaRepositorio.save(persona1);




		//muestro la persona y el coche
		Optional<Persona> personaConCoche = personaRepositorio.findById(7L);
		if (personaConCoche.isPresent()){
			Persona p = personaConCoche.get();
			System.out.println(p);
		}


		Optional<Coche> coche2 = cocheRepositorio.findById(1L);
		if (coche2.isPresent()){
			Coche p = coche2.get();
			System.out.println(p);
		}

*/



/*
		//BIDIRECCIONAL
		System.out.println("ONE TO ONE BIDIRECCIONAL");

		//creo una persona
		Persona persona2 = new Persona();
		persona2.setNombre("Junalu");
		persona2.setApellidos("dbz");
		persona2.setDni("147258A");
		persona2.setEmail("Jjuanlu@.es");
		personaRepositorio.save(persona2);

		//creo un coche
		Coche coche2 = new Coche();
		coche2.setMarca("Tesla");
		coche2.setModelo("3");
		coche2.setMatricula("9988 NAN");
		cocheRepositorio.save(coche2);

		//Relaciono el coche con la persona
		persona2.setCoche(coche2);
		//Le asigno la persona 2 al coche 2. Así quedan relacionadas en ambos sentidos
		coche2.setPersona(persona2);
		//lo guardo en la bbdd
		personaRepositorio.save(persona2);


*/
		//Buscar una persona y acceder a su coche
		Optional<Persona> personaCoche = personaRepositorio.findById(8L);

		if (personaCoche.isPresent()){
			Persona personaConCoche = personaCoche.get();
			System.out.println(personaConCoche);

			//accedo al coche desde la persona, mostrando al matricula del coche de la perona con id 8
				//esto ya lo podiamos hacer desde la unidireccional
			System.out.println(personaConCoche.getCoche().getMatricula());
		}


		System.out.println("----------------------------------------");


		//Buscar un coche y acceder a su persona
		Optional<Coche> cochePersona = cocheRepositorio.findById(2L);

		if (cochePersona.isPresent()){
			Coche coche1 = cochePersona.get();
			System.out.println(coche1);

			Persona cocheDePersona = coche1.getPersona(); //Acceder desde el coche hasta la persona

			System.out.println(coche1.getPersona().getCoche().getMatricula());
			/*
				coche1.getPersona() → accedo a la persona
				.getCoche() → desde la persona vuelvo a acceder a su coche.
				.getMatricula() → obtienes la matrícula de ese coche.
			 */

			System.out.println(cocheDePersona);//muestro la persona
		}




	}
}