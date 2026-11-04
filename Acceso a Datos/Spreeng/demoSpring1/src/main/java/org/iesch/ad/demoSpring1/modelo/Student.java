package org.iesch.ad.demoSpring1.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            //no usar all en el hijo

    Long Id;
    String nombre;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_curso",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "cureso_id")
    )
    private Set<Curso> cursos = new HashSet<>();

}

