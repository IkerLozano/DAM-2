package org.iesch.ad.Bloque1_Ej2.Modelo;


import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {



    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long id;

    String nombre;
    String email;

    @OneToOne(mappedBy = "empleado", cascade = CascadeType.ALL)
    @ToString.Exclude

    Tarjeta tarjeta;

}
