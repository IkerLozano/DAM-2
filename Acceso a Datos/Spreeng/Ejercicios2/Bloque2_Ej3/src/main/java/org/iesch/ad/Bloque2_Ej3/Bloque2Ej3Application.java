package org.iesch.ad.Bloque2_Ej3;

import org.iesch.ad.Bloque2_Ej3.Repositorios.AsignaturaRepo;
import org.iesch.ad.Bloque2_Ej3.Repositorios.EstudianteRepo;
import org.iesch.ad.Bloque2_Ej3.Servicio.ColegioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Bloque2Ej3Application implements CommandLineRunner {


	@Autowired
	AsignaturaRepo asignaturaRepo;

	@Autowired
	EstudianteRepo estudianteRepo;


	@Autowired
	ColegioServicio service;


	public static void main(String[] args) {
		SpringApplication.run(Bloque2Ej3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("\nCURSOS: 1 Crear estudiante | 2 Crear asignatura | 3 Matricular | 4 Desmatricular | 5 Listar | 6 Borrar estudiante | 7 Borrar asignatura | 0 Salir");
			String opcion = in.nextLine().trim();
			if (opcion.equals("0")) return;
			try {
				switch (opcion) {
					case "1" -> { System.out.print("Nombre: "); String nombre = in.nextLine(); System.out.print("Email: "); service.crearEstudiante(nombre, in.nextLine()); }
					case "2" -> { System.out.print("Nombre de asignatura: "); service.crearAsignatura(in.nextLine()); }
					case "3", "4" -> {
						System.out.print("Id estudiante: "); Long estudiante = Long.parseLong(in.nextLine());
						System.out.print("Id asignatura: "); Long asignatura = Long.parseLong(in.nextLine());
						if (opcion.equals("3")) service.matricular(estudiante, asignatura); else service.desmatricular(estudiante, asignatura);
					}
					case "5" -> {
						service.listarEstudiantes().forEach(e -> {
							System.out.printf("Estudiante %d: %s (%s)%n", e.getId(), e.getNombre(), e.getEmail());
							e.getAsignaturas().forEach(a -> System.out.printf("  Asignatura %d: %s%n", a.getId(), a.getNombre()));
						});
						service.listarAsignaturas().forEach(a -> System.out.printf("Asignatura %d: %s (%d estudiantes)%n", a.getId(), a.getNombre(), a.getEstudiantes().size()));
					}
					case "6" -> { System.out.print("Id estudiante: "); service.borrarEstudiante(Long.parseLong(in.nextLine())); }
					case "7" -> { System.out.print("Id asignatura: "); service.borrarAsignatura(Long.parseLong(in.nextLine())); }
					default -> System.out.println("Opción no válida.");
				}
			} catch (IllegalArgumentException | IllegalStateException e) {
				System.out.println("No se pudo completar la operación: " + e.getMessage());
			}
		}

	}
}
