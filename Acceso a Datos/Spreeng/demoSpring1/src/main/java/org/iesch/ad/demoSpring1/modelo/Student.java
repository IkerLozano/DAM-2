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
    @GeneratedValue(strategy = GenerationType.IDENTITY) //no usar all en el hijo

    Long Id;
    String nombre;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    /*
       PERSIST: al guardar un Student, también se guardan sus cursos.
       MERGE: al actualizar un Student, también se actualizan sus cursos.
    */

    @JoinTable( //esto solo se pone aqui ya que es el propietario de la relacion
            name = "student_curso", //nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "student_id"), //columna que hace referencia a la entidad donde estamos declarando la relación (Student)
            inverseJoinColumns = @JoinColumn(name = "curso_id") //columna que hace referencia a la otra entidad (Curso)
    )
    /*
        Esto crea la tercera tabla de la realcion, ya que en MANY TO MANY necesitamos una tabla intermedia
        para relacionar las dos tablas
     */


    //esto se usa si la relacion es con muchos (MANY2MANY / ONE2MANY)
    private Set<Curso> cursos = new HashSet<>();
    /*
        Significa que vamos a tener una colección de objetos de tipo Curso (q un estudiante puede tener muchos cursos)
        Usamos Set pq no permite elementos duplicados.
        Este estudiante ya tiene un conjunto de cursos vacío, preparado para añadir cursos
            --> student.setCursos(Set.of(curso1, curso2, curso3)); metemos varios cursos al estudinate
     */
}

