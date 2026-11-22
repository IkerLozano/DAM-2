package org.iesch.ad.Bloque2_Ej1;

import org.iesch.ad.Bloque2_Ej1.Modelo.Socio;
import org.iesch.ad.Bloque2_Ej1.Repositorios.PerfilRepo;
import org.iesch.ad.Bloque2_Ej1.Repositorios.SocioRepo;
import org.iesch.ad.Bloque2_Ej1.Servicios.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Scanner;

@SpringBootApplication
public class Bloque2Ej1Application implements CommandLineRunner {


	@Autowired
	PerfilRepo perfilRepo;


	@Autowired
	SocioRepo socioRepo;


	@Autowired
	SocioService service;


	public static void main(String[] args) {
		SpringApplication.run(Bloque2Ej1Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("\nCLUB: 1 Alta socio+perfil | 2 Listar | 3 Borrar socio | 4 Borrar perfil | 0 Salir");
			String opcion = in.nextLine().trim();
			if (opcion.equals("0")) return;
			try {
				switch (opcion) {
					case "1" -> {
						System.out.print("Nombre: "); String nombre = in.nextLine();
						System.out.print("Email: "); String email = in.nextLine();
						System.out.print("Biografía: "); String bio = in.nextLine();
						System.out.print("Nacimiento (AAAA-MM-DD): "); LocalDate fecha = LocalDate.parse(in.nextLine());
						Socio socio = service.altaSocio(nombre, email, bio, fecha);
						System.out.println("Alta completada. Socio " + socio.getId() + ", perfil " + socio.getPerfil().getId());
					}
					case "2" -> service.listarSocios().forEach(s -> System.out.printf(
							"Socio %d: %s (%s), perfil %d: %s%n", s.getId(), s.getNombre(), s.getEmail(),
							s.getPerfil().getId(), s.getPerfil().getBiografia()));
					case "3" -> { System.out.print("Id de socio: "); service.borrarSocio(Long.parseLong(in.nextLine())); }
					case "4" -> { System.out.print("Id de perfil: "); service.borrarPerfil(Long.parseLong(in.nextLine())); }
					default -> System.out.println("Opción no válida.");
				}
			} catch (IllegalArgumentException | IllegalStateException e) {
				System.out.println("No se pudo completar la operación: " + e.getMessage());
			}
		}

	}
}
