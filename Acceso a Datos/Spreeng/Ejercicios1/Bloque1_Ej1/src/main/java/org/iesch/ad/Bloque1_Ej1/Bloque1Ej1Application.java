package org.iesch.ad.Bloque1_Ej1;

import org.iesch.ad.Bloque1_Ej1.Modelo.Perfil;
import org.iesch.ad.Bloque1_Ej1.Modelo.Usuario;
import org.iesch.ad.Bloque1_Ej1.Repositorios.PerfilRepo;
import org.iesch.ad.Bloque1_Ej1.Repositorios.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Bloque1Ej1Application implements CommandLineRunner {

	//inyeccion de dependencias

	@Autowired
	UsuarioRepo usuarioRepo;

	@Autowired
	PerfilRepo perfilRepo;


	public static void main(String[] args){
		SpringApplication.run(Bloque1Ej1Application.class, args);
	}


	//aqui el codigo
	@Override
	public void run(String... args) throws Exception {


/*


		//----UNIDIRECCIONAL-----
		System.out.println("UNIDIRECIAL");


		//creo usuarios
		Usuario u1 = Usuario.builder().nombre("Iker").edad(19).email("ilozanor@iesch.org").build();
		Usuario u2 = Usuario.builder().nombre("Andres").edad(20).email("andres@iesch.org").build();
		Usuario u3 = Usuario.builder().nombre("Hecproll").edad(19).email("hecproll@iesch.org").build();



		//Esto no hace falta porque tenmos el Cascade en usuario, asi se
		//guardan los usuarios y sus perfiles se guardan automáticamente

		//suarioRepo.save(u1);
		//suarioRepo.save(u2);
		//suarioRepo.save(u3);



		//creo perfiles
		Perfil p1 = Perfil.builder().descripcion("Perfil del user Iker").fechaNacimiento(LocalDate.of(2007, 1, 3)).foto("img/iker").usuario(u1).build();
		Perfil p2 = Perfil.builder().descripcion("Perfil del user Andres").fechaNacimiento(LocalDate.of(2008, 4, 8)).foto("img/andres").usuario(u2).build();
		Perfil p3 = Perfil.builder().descripcion("Perfil del user Hecproll").fechaNacimiento(LocalDate.of(2009, 10, 25)).foto("img/hecproll").usuario(u3).build();


		perfilRepo.save(p1);
		perfilRepo.save(p2);
		perfilRepo.save(p3);


		//muestro los usuarios
		System.out.println(u1);
		System.out.println(u2);
		System.out.println(u3);


		//accedo a los usuarios desde perfil

		List<Perfil> perfiles = perfilRepo.findAll();
		for (Perfil p : perfiles) {

			System.out.println("----Perfil de " + p.getUsuario().getNombre() + "-------");
			System.out.println(p.getId());
			System.out.println(p.getDescripcion());
			System.out.println(p.getFechaNacimiento());
		}

*/


		//----BIDIRECCIONAL-----
		System.out.println("BIDIRECCIONAL");

		//creo usuarios
		Usuario u1 = Usuario.builder().nombre("Carlos").edad(22).email("carlos@gmail.com").build();
		Usuario u2 = Usuario.builder().nombre("Lucia").edad(21).email("lucia@gmail.com").build();
		Usuario u3 = Usuario.builder().nombre("Daniel").edad(24).email("daniel@gmail.com").build();


		//Esto no hace falta porque tenemos el Cascade en usuario, asi se
		//guardan los usuarios y sus perfiles se guardan automáticamente

		//usuarioRepo.save(u1);
		//usuarioRepo.save(u2);
		//usuarioRepo.save(u3);


		//creo perfiles
		Perfil p1 = Perfil.builder().descripcion("Perfil personal de Carlos").fechaNacimiento(LocalDate.of(2004, 5, 12)).foto("img/carlos").usuario(u1).build();
		Perfil p2 = Perfil.builder().descripcion("Perfil personal de Lucia").fechaNacimiento(LocalDate.of(2005, 8, 23)).foto("img/lucia").usuario(u2).build();
		Perfil p3 = Perfil.builder().descripcion("Perfil personal de Daniel").fechaNacimiento(LocalDate.of(2002, 11, 7)).foto("img/daniel").usuario(u3).build();


		perfilRepo.save(p1);
		perfilRepo.save(p2);
		perfilRepo.save(p3);


		//accedo a los perfiles desde usuario
		List<Usuario> usuarios = usuarioRepo.findAll();

		for (Usuario u : usuarios){

			System.out.println("------ Usuario " + u.getNombre() + "---------");
			System.out.println(u.getPerfil().getDescripcion());
			System.out.println(u.getPerfil().getFoto());

		}




	}
}
