package org.iesch.ad.Bloque1_Ej1.Service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.iesch.ad.Bloque1_Ej1.Repositorio.PerfilRepositorio;
import org.iesch.ad.Bloque1_Ej1.Repositorio.UsuarioRepositorio;
import org.iesch.ad.Bloque1_Ej1.modelo.Perfil;
import org.iesch.ad.Bloque1_Ej1.modelo.Usuario;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UsuarioService {


    private final UsuarioRepositorio usuarioRepositorio;
    private final PerfilRepositorio perfilRepositorio;

    @Transactional
    public void  cambiaPerfil(Usuario usuario){


        //FORMA 1
        Perfil perfil = usuario.getPerfil();
        perfil.setFotoPerfil("img/jose.jpg");
        perfil.setFechaNacimiento(LocalDate.of(2000, 5, 12));
        perfil.setDescripcion("Nuevo perfil para DAM1");

        usuarioRepositorio.save(usuario);

    }
}
