package org.iesch.ad.Repaso_Ej2.Modelo;


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
    private String codigo;
    private int horas;


    @PostPersist
    public void preGuardar(){

        System.out.println("Se guarda la asignatura " + this.nombre);

    }

    @ManyToMany(mappedBy = "asignaturas", fetch = FetchType.EAGER)
    @ToString.Exclude
    List<Estudiante> estudiantes;

}
