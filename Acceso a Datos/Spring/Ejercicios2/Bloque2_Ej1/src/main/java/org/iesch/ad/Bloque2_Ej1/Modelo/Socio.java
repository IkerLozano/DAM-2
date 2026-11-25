package org.iesch.ad.Bloque2_Ej1.Modelo;


import jakarta.persistence.*;
import jakarta.persistence.metamodel.IdentifiableType;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Socio {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    String nombre;
    String dni;
    String email;

    @OneToOne(mappedBy = "socio")
    @ToString.Exclude

    Perfil perfil;
}
