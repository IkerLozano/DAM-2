package org.iesch.ad.Repaso_Ej2;

import jakarta.transaction.Transactional;
import org.iesch.ad.Repaso_Ej2.Modelo.Asignatura;
import org.iesch.ad.Repaso_Ej2.Modelo.Estudiante;
import org.iesch.ad.Repaso_Ej2.Repositorios.AsignaturaRepo;
import org.iesch.ad.Repaso_Ej2.Repositorios.EstudianteRepo;
import org.iesch.ad.Repaso_Ej2.Servicios.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class RepasoEj2Application implements CommandLineRunner {

	@Autowired
	EstudianteRepo estudianteRepo;

	@Autowired
	AsignaturaRepo asignaturaRepo;

	@Autowired
	AsignaturaService asignaturaService;




	public static void main(String[] args) {
		SpringApplication.run(RepasoEj2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner sc = new Scanner(System.in);

		//INSERTAR

		System.out.println("------CREAR ESTUDIANTES-------");

		Estudiante e1 = Estudiante.builder().nombre("Iker").apellidos("Lozano").dni("14785236").email("ilozanor@iesch.org").build();
		Estudiante e2 = Estudiante.builder().nombre("Ana").apellidos("Garcia").dni("58963147").email("agarcia@iesch.org").build();
		Estudiante e3 = Estudiante.builder().nombre("Luis").apellidos("Martinez").dni("69147258").email("lmartinez@iesch.org").build();
		Estudiante e4 = Estudiante.builder().nombre("Maria").apellidos("Perez").dni("41852963").email("mperez@iesch.org").build();
		Estudiante e5 = Estudiante.builder().nombre("Carlos").apellidos("Sanchez").dni("85296374").email("csanchez@iesch.org").build();
		Estudiante e6 = Estudiante.builder().nombre("Juanlu").apellidos("Garcia").dni("85296378").email("juanlu@iesch.org").build();




		System.out.println("------CREAR ASIGNATURAS-------");

		Asignatura a1 = Asignatura.builder().nombre("Acceso a datos").codigo("123").horas(15).estudiantes(List.of(e1,e2,e5)).build();
		Asignatura a2 = Asignatura.builder().nombre("Programacion").codigo("124").horas(10).estudiantes(List.of(e5)).build();
		Asignatura a3 = Asignatura.builder().nombre("Bases de datos").codigo("125").estudiantes(List.of(e5,e2)).horas(8).build();
		Asignatura a4 = Asignatura.builder().nombre("Lenguaje de marcas").codigo("126").estudiantes(List.of(e1,e5,e3)).horas(6).build();
		Asignatura a5 = Asignatura.builder().nombre("Sistemas informaticos").codigo("127").estudiantes(List.of(e3,e2)).horas(7).build();
		Asignatura a6 = Asignatura.builder().nombre("Entornos de desarrollo").codigo("128").estudiantes(List.of(e1,e2,e3,e4,e5)).horas(5).build();
		Asignatura a7 = Asignatura.builder().nombre("Python").codigo("129").horas(5).build();


		List<Asignatura> guardarAsignaturas = new ArrayList<>(Arrays.asList(a1,a2,a3,a4,a5,a6,a7));
		asignaturaRepo.saveAll(guardarAsignaturas);

		e1.setAsignaturas(List.of(a1, a4, a6));
		e2.setAsignaturas(List.of(a1, a3, a5, a6));
		e3.setAsignaturas(List.of(a4, a5, a6));
		e4.setAsignaturas(List.of(a6));
		e5.setAsignaturas(List.of(a1, a2, a3, a4, a6));


		List<Estudiante> guardarEstudiantes = new ArrayList<>(Arrays.asList(e1,e2,e3,e4,e5,e6));
		estudianteRepo.saveAll(guardarEstudiantes);


		System.out.println("-------MATRICULAR--------");
		System.out.println("Id de la asignatura");
		Long idAsignaturaMatricular = sc.nextLong();

		System.out.println("Id del alumno");
		Long idAlumnoMatricular = sc.nextLong();

		Asignatura asignaturaMatricular = asignaturaRepo.findById(idAsignaturaMatricular).get();
		Estudiante estudianteMatricular = estudianteRepo.findById(idAlumnoMatricular).get();

		estudianteMatricular.getAsignaturas().add(asignaturaMatricular);

		estudianteRepo.save(estudianteMatricular);

		System.out.println("El estudiante " + estudianteMatricular.getNombre() + " se a matriculado en " + asignaturaMatricular.getNombre());




		System.out.println("-------DESMATRICULAR--------");

		asignaturaService.borrar(7L, 6L);

	}
}
