package org.iesch.ad.demoSpring1.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Data //como si ponemos @gette, @setter, toString(), equals() y hashCode()
@Entity
public class Empleado {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nombre;
    Double salario;

    @ManyToOne() //muchos empleados pueden pertenecer a un departamento, Muchos empleados → un departamento
    @JoinColumn(name = "departamento_id") //crea la columna departamento_id en la tabla empleado, ya que empelado es el lado Many
    /*
        La relación con los empleados ya está definida en el atributo departamento
        de la clase Empleado. Utiliza esa relación».

        "departamento" no es el nombre de la tabla ni de la columna SQL.
        Es el nombre exacto del atributo Java de la clase Empleado.
     */

    private Departamento departamento;

}
