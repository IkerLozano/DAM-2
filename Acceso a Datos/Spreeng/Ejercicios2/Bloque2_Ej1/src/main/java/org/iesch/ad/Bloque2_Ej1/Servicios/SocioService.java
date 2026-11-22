package org.iesch.ad.Bloque2_Ej1.Servicios;


import jakarta.persistence.metamodel.IdentifiableType;
import org.iesch.ad.Bloque2_Ej1.Modelo.Perfil;
import org.iesch.ad.Bloque2_Ej1.Modelo.Socio;
import org.iesch.ad.Bloque2_Ej1.Repositorios.PerfilRepo;
import org.iesch.ad.Bloque2_Ej1.Repositorios.SocioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SocioService {

    @Autowired
    PerfilRepo perfilRepo;

    @Autowired
    SocioRepo socioRepo;

    public Socio altaSocio(String nombre, String email, String bio, LocalDate fecha) {

        //creo el socio
        Socio s1 = Socio.builder().nombre(nombre).email(email).build();

        //creo el perfil
        Perfil p1 = Perfil.builder().biografia(bio).fechaNacimiento(fecha).build();

        p1.setSocio(s1);
        s1.setPerfil(p1);

        perfilRepo.save(p1);

        return s1;
    }


    public List<Socio> listarSocios() {

        List<Socio> socios = socioRepo.findAll();

        for (Socio s : socios){

            System.out.println(s);
        }

        return socios;
    }


    public void borrarSocio(long idSocio) {

        Optional<Socio> socioBorrar = socioRepo.findById(idSocio);

        if (socioBorrar.isPresent()){

            Socio socioYaBorrado = socioBorrar.get();

            // Obtenemos el perfil asociado al socio
            Perfil perfil = socioYaBorrado.getPerfil();

            if (perfil != null) {
                // Desvinculamos el perfil del socio
                perfil.setSocio(null);
                socioYaBorrado.setPerfil(null);

                // Guardamos el perfil sin socio
                perfilRepo.save(perfil);
            }
            // Borramos el socio
            socioRepo.delete(socioYaBorrado);


        }

    }

    public void borrarPerfil(long idPerfil) {

        Optional<Perfil> perfilBorrar = perfilRepo.findById(idPerfil);

        if (perfilBorrar.isPresent()){

            Perfil perfilYaBorrado = perfilBorrar.get();
            perfilRepo.delete(perfilYaBorrado);

        }

    }
}
