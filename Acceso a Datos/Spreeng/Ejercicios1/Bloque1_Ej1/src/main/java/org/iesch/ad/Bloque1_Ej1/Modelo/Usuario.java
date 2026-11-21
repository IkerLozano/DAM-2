package org.iesch.ad.Bloque1_Ej1.Modelo;


import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    String nombre;
    String email;
    int edad;

    @OneToOne(mappedBy = "usuario")
    @ToString.Exclude

    Perfil perfil;


}
