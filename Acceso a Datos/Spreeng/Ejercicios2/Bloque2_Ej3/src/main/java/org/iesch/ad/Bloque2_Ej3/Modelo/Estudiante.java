package org.iesch.ad.Bloque2_Ej3.Modelo;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;


    private String nombre;
    private String apellidos;
    private String email;

    @ManyToMany()
    @JoinTable(
            name = "estudiante_asignatura",
            joinColumns = @JoinColumn(name = "estudiante_id"),
            inverseJoinColumns = @JoinColumn(name = "asignatura_id")
    )
    List<Asignatura> asignaturas;
}
