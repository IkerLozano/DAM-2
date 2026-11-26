package org.iesch.ad.Repaso_Ej1;

import org.iesch.ad.Repaso_Ej1.Modelo.Categoria;
import org.iesch.ad.Repaso_Ej1.Modelo.Libro;
import org.iesch.ad.Repaso_Ej1.Repositorios.CategoriaRepo;
import org.iesch.ad.Repaso_Ej1.Repositorios.LibroRepo;
import org.iesch.ad.Repaso_Ej1.Servicios.CategoriaServicio;
import org.iesch.ad.Repaso_Ej1.Servicios.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.util.*;

@SpringBootApplication
@PropertySource(value = "classpath:mi.properties", encoding = "UTF8")
public class RepasoEj1Application implements CommandLineRunner {

	//VALORES PERSONALIZADOS
	@Value("${nombre}")
	String nombre;

	@Value("${version}")
	String version;

	@Value("${firma}")
	String firma;


	@Autowired
	CategoriaRepo categoriaRepo;

	@Autowired
	LibroRepo libroRepo;

	@Autowired
	LibroServicio libroServicio;

	@Autowired
	CategoriaServicio categoriaServicio;


	public static void main(String[] args) {
		SpringApplication.run(RepasoEj1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner sc = new Scanner(System.in);

		System.out.println("===========\n" + nombre + "\n" + version + "\n" + firma + "\n===========");


/*
		//INSERTAR

		//categorias
		Categoria c1 = Categoria.builder().nombre("Ficcion").descripcion("Libros de Ficcion").build();
		Categoria c2 = Categoria.builder().nombre("Terror").descripcion("Libros de terror").build();
		Categoria c3 = Categoria.builder().nombre("Magia").descripcion("Libros de magia").build();
		Categoria c4 = Categoria.builder().nombre("Infantiles").descripcion("Libros para niños").build();

		List<Categoria> categoriaList = new ArrayList<>(Arrays.asList(c1, c2, c3, c4));
		categoriaRepo.saveAll(categoriaList);


		//libros
		Libro l1 = Libro.builder().titulo("El Quijote").autor("Miguel de Cervantes").isbn("9788420412146").categoria(c1).build();
		Libro l2 = Libro.builder().titulo("Cien años de soledad").autor("Gabriel García Márquez").categoria(c2).isbn("9780307474728").build();
		Libro l3 = Libro.builder().titulo("1984").autor("George Orwell").isbn("9780451524935").categoria(c3).build();
		Libro l4 = Libro.builder().titulo("La sombra del viento").autor("Carlos Ruiz Zafón").categoria(c4).isbn("9788408172178").build();
		Libro l5 = Libro.builder().titulo("El principito").autor("Antoine de Saint-Exupéry").categoria(c1).isbn("9780156012195").build();
		Libro l6 = Libro.builder().titulo("Harry Potter y la piedra filosofal").autor("J. K. Rowling").categoria(c2).isbn("9788478884452").build();


		c1.setLibros(List.of(l1, l5));
		c2.setLibros(List.of(l2, l6));
		c3.setLibros(List.of(l3));
		c4.setLibros(List.of(l4));


		libroRepo.save(l1);
		libroRepo.save(l2);
		libroRepo.save(l3);
		libroRepo.save(l4);
		libroRepo.save(l5);
		libroRepo.save(l6);

*/

/*
		//LISTAR
		System.out.println("------LIBROS DE UNA CATEGORIA-------");
		System.out.println("Id de categoria");
		Long categoriaId = sc.nextLong();

		libroServicio.mostrarLibros(categoriaId).forEach(System.out::println);



		System.out.println("------NUMERO DE LIBROS DE UNA CATEGORIA-------");
		System.out.println("Id de categoria");
		Long categoriaId2 = sc.nextLong();

		System.out.println(categoriaServicio.totalLibros(categoriaId2));



		//ACTUALIZAR

		System.out.println("------CAMBIAR LIBROS DE CATEGORIA-------");
		System.out.println("Id del libro");
		Long libro = sc.nextLong();
		System.out.println("Id de categoria");
		Long categoriaId3 = sc.nextLong();

		Libro libroEncontrado = libroRepo.findById(libro).get();
		Categoria categoriaEncontrada = categoriaRepo.findById(categoriaId3).get();

		libroEncontrado.setCategoria(categoriaEncontrada);
		libroRepo.save(libroEncontrado);
		System.out.println("La categoria del libro '" + libroEncontrado.getTitulo() + "' a sido cambiada");



		//ELIMINAR
		System.out.println("------ELIMINAR UNA CATEGORIA-------");

		System.out.println("Id de categoria");
		Long categoriaId4 = sc.nextLong();
		//Categoria categoriaEncontrada2 = categoriaRepo.findById(categoriaId4).get();

		if (categoriaServicio.totalLibros(categoriaId4) != 0){  //si esa categoria tiene libros

			System.out.println("Esta categoria tiene libros, ¿Quires pasar los libros a otra categoria y  borrarla? (S/N)");
			sc.nextLine(); // Consumir el salto de linea pendiente
			String resp = sc.nextLine();

			if(resp.equals("S")){


				System.out.println("Id de la nueva categoria");
				Long categoriaId6 = sc.nextLong();

				List<Libro>librosCambiar = libroRepo.librosPorCategoria(categoriaId4); //obtengo una lista con los oibros de la categoria vieja
				Categoria categoriaNueva = categoriaRepo.findById(categoriaId6).get(); //obtengo la categoria a la que quiere transladar los libros
				Categoria categoriaVieja = categoriaRepo.findById(categoriaId4).get(); //categria vieja

				for (Libro l : librosCambiar){ //cambio la categoria de los libros

					l.setCategoria(categoriaNueva);
					libroRepo.save(l);
				}

				System.out.println("Los libros de la categoria " + categoriaVieja.getNombre() + " se han cambiado a la categoria " + categoriaNueva.getNombre());
				System.out.println("Ya se pude borrar la categoria");

				categoriaRepo.delete(categoriaVieja);

			}else{

				System.out.println("Entonces no se pude borrar la categoria pq tiene libros");
			}


		}else{

			Categoria categoriaBorrar = categoriaRepo.findById(categoriaId4).get();

			//Categoria categoriaYaBorrada = categoriaBorrar.get();

			System.out.println("Se a borrado la categoria '" + categoriaBorrar.getNombre() + "'");
			categoriaRepo.delete(categoriaBorrar);
		}





		System.out.println("------ELIMINAR UN LIBRO-------");
		System.out.println("Id del libro");
		Long idLibro = sc.nextLong();


		Optional<Libro> libroBorrar = libroRepo.findById(idLibro);

		if (libroBorrar.isPresent()) {

			Libro libroYaBorrado = libroBorrar.get();

			System.out.println("El libro con titulo '" + libroYaBorrado.getTitulo()  + "' a sido borrado");

			libroRepo.delete(libroYaBorrado);

		}

*/

	}
}
