package org.iesch.ad.demoSpring1.modelo;

import jakarta.persistence.*;
import lombok.*;

//esto es como hacer los getter y setter y todo lo demas, esto es de loombok
@Getter
@Setter
//@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

@Entity //crea una tabla en bbdd con el nombre perosna y los atributos
public class Persona {


    @Id //inidca el id para ls bbdd
            @GeneratedValue(strategy = GenerationType.IDENTITY) //autonumerico
    Long id;
    //@Column() para indicarle la condgffiguracion del dato(unique...)
    String nombre;
    String apellidos;
    @Column(length = 9)
    String dni;
    String email;


}
