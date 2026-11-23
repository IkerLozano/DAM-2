package org.iesch.ad.Bloque2_Ej2;

import org.iesch.ad.Bloque2_Ej2.Repositorios.CategoriaRepo;
import org.iesch.ad.Bloque2_Ej2.Repositorios.LibroRepo;
import org.iesch.ad.Bloque2_Ej2.Servicios.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Bloque2Ej2Application implements CommandLineRunner {


	@Autowired
	CategoriaRepo categoriaRepo;


	@Autowired
	LibroRepo libroRepo;


	@Autowired
	LibroService service;


	public static void main(String[] args) {
		SpringApplication.run(Bloque2Ej2Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("\nBIBLIOTECA: 1 Crear categoría | 2 Crear libro | 3 Listar libros | 4 Listar categorías | 5 Cambiar categoría | 6 Borrar libro | 7 Borrar categoría | 8 Trasladar libros | 0 Salir");

			String opcion = in.nextLine().trim();

			if (opcion.equals("0")) return;

			try {
				switch (opcion) {
					case "1" -> {
						System.out.print("Nombre: ");
						service.crearCategoria(in.nextLine());
					}
					case "2" -> {
						System.out.print("Título: ");
						String titulo = in.nextLine();

						System.out.print("Autor: ");
						String autor = in.nextLine();

						System.out.print("Id de categoría: ");
						service.crearLibro(titulo, autor, Long.parseLong(in.nextLine()));
					}
					case "3" -> {
						System.out.print("Id de categoría (vacío = todos): ");
						String id = in.nextLine().trim();

						service.listarLibros(id.isEmpty() ? null : Long.parseLong(id)).forEach(l -> System.out.printf(
								"Libro %d: %s — %s [categoría %d: %s]%n", l.getId(), l.getTitulo(), l.getAutor(),
								l.getCategoria().getId(), l.getCategoria().getNombre()));
					}
					case "4" -> {
						service.listarCategorias().forEach(c -> System.out.printf(
								"Categoría %d: %s%n", c.getId(), c.getNombre()));
					}
					case "5" -> {
						System.out.print("Id libro: ");
						Long libro = Long.parseLong(in.nextLine());

						System.out.print("Id nueva categoría: ");
						service.cambiarCategoria(libro, Long.parseLong(in.nextLine()));
					}
					case "6" -> {
						System.out.print("Id libro: ");
						service.borrarLibro(Long.parseLong(in.nextLine()));
					}
					case "7" -> {
						System.out.print("Id categoría: ");
						service.borrarCategoria(Long.parseLong(in.nextLine()));
					}
					case "8" -> {
						System.out.print("Id de la categoría de origen: ");
						Long origen = Long.parseLong(in.nextLine());

						System.out.print("Id de la categoría de destino: ");
						Long destino = Long.parseLong(in.nextLine());

						service.trasladarLibros(origen, destino);
					}
					default -> System.out.println("Opción no válida.");
				}
			} catch (IllegalArgumentException | IllegalStateException e) {
				System.out.println("No se pudo completar la operación: " + e.getMessage());
			}
		}
	}
}
