package org.iesch.ad.Bloque1_Ej1;

import org.iesch.ad.Bloque1_Ej1.Repositorio.PerfilRepositorio;
import org.iesch.ad.Bloque1_Ej1.Repositorio.UsuarioRepositorio;
import org.iesch.ad.Bloque1_Ej1.Service.UsuarioService;
import org.iesch.ad.Bloque1_Ej1.modelo.Perfil;
import org.iesch.ad.Bloque1_Ej1.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class Bloque1Ej1Application implements CommandLineRunner {


	@Autowired
	UsuarioRepositorio usuarioRepositorio;

	@Autowired
	PerfilRepositorio perfilRepositorio;

	@Autowired
	UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(Bloque1Ej1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("-".repeat(30));

/*
		Perfil perfil = new Perfil();
		perfil.setFotoPerfil("/img/juan.jpa");
		perfil.setDescripcion("Estudiante de SMR");
		perfil.setFechaNacimiento(LocalDate.of(2006, 5, 14));


		Usuario usuario = new Usuario();
		usuario.setNombre("Juan");
		usuario.setPassword("123456");

		//le asigno el perfil al user y biciversa
		usuario.setPerfil(perfil);
		//perfil.setUsuario(usuario); se puede hacer esto o los setter de usuario
		usuarioRepositorio.save(usuario);
*/


/*

		Optional<Usuario> user = usuarioRepositorio.findById(1L);
		if (user.isPresent()){
			Usuario usuario = user.get();
			System.out.println(usuario);

			usuarioService.cambiaPerfil(usuario);

		}
*/

		//BORRAR UN USUARIO

		//Optional<Usuario> usuarioTMP = usuarioRepositorio.findById(2L);
		//
		//if (usuarioTMP.isPresent()){
		//	Usuario usuario = usuarioTMP.get();
		//
		//	usuarioRepositorio.delete(usuario);
		//}

		//otra forma de borrar (mjeor digo yo)
		usuarioRepositorio.deleteById(2L);

	}
}
