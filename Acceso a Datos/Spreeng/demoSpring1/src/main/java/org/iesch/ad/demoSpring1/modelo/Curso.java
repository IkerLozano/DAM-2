package org.iesch.ad.demoSpring1.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
public class Curso {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    String nombre;



    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "cursos") //mismo nombre que el set de student
    //ascade = CascadeType.ALL --> peligroso ya que si borramos un curso se puede dar el caso q borres al padre(student) y tamb al resto de cursos del estudinate
    //se recomiendo usar cascade = CascadeType.PERSIST, CascadeType.MERGE
    //con PERSIST al gurdar se guarda el padre
    //con Merge al actualizar se actualiza el padre
    @ToString.Exclude //para que el hijo no tenga el toString y que no tenga referencia infinita
    Set<Student> student = new HashSet<>();

}
