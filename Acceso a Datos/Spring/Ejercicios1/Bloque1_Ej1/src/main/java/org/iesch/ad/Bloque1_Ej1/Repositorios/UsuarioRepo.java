package org.iesch.ad.Bloque1_Ej1.Repositorios;


import org.iesch.ad.Bloque1_Ej1.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {





}
