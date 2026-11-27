package org.iesch.ad.Repaso_Ej2.Modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(length = 8, unique = true)
    private String dni;
    private String email;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "estudiante_asignatura",
            joinColumns = @JoinColumn(name = "estudiante_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "asignatura_id", referencedColumnName = "id")
    )
    List<Asignatura> asignaturas;

}
