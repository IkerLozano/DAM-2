package org.iesch.ad.Bloque1_Ej1.Repositorio;


import org.iesch.ad.Bloque1_Ej1.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
}
