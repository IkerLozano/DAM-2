package org.iesch.ad.Bloque1_Ej1.modelo;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.EntityGraph;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Perfil {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    private String fotoPerfil;
    private String descripcion;
    private LocalDate fechaNacimiento;


    //relacion bidireccional
    @OneToOne
    @JoinColumn(name="usuario_id", nullable = false, unique = true) //no crear dos claves ajeanas
    private Usuario usuario;


    //en vez esto se pude poner el toString exclude
    @Override
    public String toString() {
        return "Perfil{" +
                "id=" + id +
                ", fotoPerfil='" + fotoPerfil + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", usuario=" + usuario.getId() + " " + usuario.getNombre() + " " + usuario.getPassword() +
                '}';
    }
}
