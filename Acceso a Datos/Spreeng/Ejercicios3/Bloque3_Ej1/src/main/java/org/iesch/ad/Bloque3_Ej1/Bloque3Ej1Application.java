package org.iesch.ad.Bloque3_Ej1;

import org.iesch.ad.Bloque3_Ej1.Modelo.Cliente;
import org.iesch.ad.Bloque3_Ej1.Modelo.Coche;
import org.iesch.ad.Bloque3_Ej1.Repositorios.ClienteRepo;
import org.iesch.ad.Bloque3_Ej1.Repositorios.CocheRepo;
import org.iesch.ad.Bloque3_Ej1.Servicios.CocheServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

@SpringBootApplication
public class Bloque3Ej1Application implements CommandLineRunner {


	@Autowired
	CocheRepo cocheRepo;


	@Autowired
	ClienteRepo clienteRepo;


	@Autowired
	CocheServicio servicio;



	public static void main(String[] args) {
		SpringApplication.run(Bloque3Ej1Application.class, args);
	}



	@Override
	public void run(String... args) throws Exception {


		Scanner teclado = new Scanner(System.in);
		while (true) {
			System.out.println("""

                        1. Clientes con un coche de un color
                        2. Clientes con un coche por encima de un precio
                        3. Datos de los clientes con más coches
                        4. Coches con menos revisiones
                        5. Número de revisiones de cada coche
                        6. Cliente a partir de una matrícula
                        7. Cliente a partir de un código de revisión
                        8. Cliente y gastos a partir de un código de revisión
                        0. Salir
                        """);
			String opcion = leer(teclado, "Opción: ");
			if (opcion == null || opcion.equals("0")) {
				break;
			}
			switch (opcion) {
				case "1" -> {
					String color = leer(teclado, "Color: ");
					if (color != null) imprimirLista(servicio.clientesPorColor(color), Bloque3Ej1Application::imprimirCliente);
				}
				case "2" -> {
					String texto = leer(teclado, "Precio: ");
					if (texto != null) {
						try {
							BigDecimal precio = new BigDecimal(texto.replace(',', '.'));
							imprimirLista(servicio.clientesPorPrecioMayorQue(precio), Bloque3Ej1Application::imprimirCliente);
						} catch (NumberFormatException e) {
							System.out.println("Precio no válido.");
						}
					}
				}
				case "3" -> imprimirLista(servicio.clientesConMasCoches(), System.out::println);
				case "4" -> imprimirLista(servicio.cochesConMenosRevisiones(), Bloque3Ej1Application::imprimirCoche);
				case "5" -> imprimirLista(servicio.revisionesPorCoche(), System.out::println);
				case "6" -> {
					String matricula = leer(teclado, "Matrícula: ");
					if (matricula != null) servicio.clientePorMatricula(matricula)
							.ifPresentOrElse(Bloque3Ej1Application::imprimirCliente, () -> System.out.println("Matrícula no encontrada."));
				}
				case "7" -> {
					String codigo = leer(teclado, "Código de revisión: ");
					if (codigo != null) servicio.clientePorCodigoRevision(codigo)
							.ifPresentOrElse(Bloque3Ej1Application::imprimirCliente, () -> System.out.println("Revisión no encontrada."));
				}
				case "8" -> {
					String codigo = leer(teclado, "Código de revisión: ");
					if (codigo != null) servicio.resumenPorCodigoRevision(codigo)
							.ifPresentOrElse(System.out::println, () -> System.out.println("Revisión no encontrada."));
				}
				default -> System.out.println("Opción no válida.");
			}
		}

	}


	private static String leer(Scanner teclado, String mensaje) {
		System.out.print(mensaje);
		return teclado.hasNextLine() ? teclado.nextLine().trim() : null;
	}

	private static <T> void imprimirLista(List<T> resultados, Consumer<T> imprimir) {
		if (resultados.isEmpty()) {
			System.out.println("Sin resultados.");
		} else {
			resultados.forEach(imprimir);
		}
	}

	private static void imprimirCliente(Cliente c) {
		System.out.printf("%s | %s | %s | %s | %s | %s%n",
				c.getId(), c.getNif(), c.getNombre(), c.getDireccion(), c.getCiudad(), c.getTelefono());
	}

	private static void imprimirCoche(Coche c) {
		System.out.printf("%s | %s | %s | %s | %s%n",
				c.getMatricula(), c.getMarca(), c.getModelo(), c.getColor(), c.getPrecio());
	}
}
