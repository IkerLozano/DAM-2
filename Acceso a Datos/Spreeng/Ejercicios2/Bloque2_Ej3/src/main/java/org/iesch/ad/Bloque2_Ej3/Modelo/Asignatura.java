package org.iesch.ad.Bloque2_Ej3.Modelo;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Asignatura {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;


    private String nombre;
    private String profesor;
    private int horas;

    @ManyToMany(mappedBy = "asignaturas", fetch = FetchType.EAGER)
    @ToString.Exclude
    List<Estudiante> estudiantes;
}
