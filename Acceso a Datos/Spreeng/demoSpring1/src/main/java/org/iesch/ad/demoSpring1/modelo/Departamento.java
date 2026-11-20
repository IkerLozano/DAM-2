package org.iesch.ad.demoSpring1.modelo;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data //como si ponemos @gette, @setter, toString(), equals() y hashCode()
@Entity
public class Departamento {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;


    @OneToMany(mappedBy = "departamento") //Un departamento → muchos empleados
     /*

        Este mappedBy le dice a JPA que la relación con los empleados ya está definida en
        el atributo departamento de la clase Empleado. Utiliza esa relación».

        "departamento" no es el nombre de la tabla ni de la columna SQL.
        Es el nombre exacto del atributo Java de la clase Empleado.
     */
    private List<Empleado> empleados;

}

