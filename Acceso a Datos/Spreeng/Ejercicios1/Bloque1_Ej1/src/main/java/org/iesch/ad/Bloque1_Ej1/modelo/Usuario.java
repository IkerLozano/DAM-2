package org.iesch.ad.Bloque1_Ej1.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
//@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class Usuario {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    String nombre;
    String password;


    @OneToOne (mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    //mappedBy = "usuario" --> poner usuario noes obligatorio, pero mirar
    private Perfil perfil; //no puede existir un perfil sin un usuario relacionado


    //setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
        if (perfil != null){
            perfil.setUsuario(this);
        }
    }
}


