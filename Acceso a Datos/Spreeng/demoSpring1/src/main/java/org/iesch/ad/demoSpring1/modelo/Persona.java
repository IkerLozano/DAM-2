package org.iesch.ad.demoSpring1.modelo;

import jakarta.persistence.*;
import lombok.*;


@Getter //genera los setters
@Setter //genera los getters
@ToString //genera el toString
@EqualsAndHashCode
@Builder //Permite crear objetos de forma rapida, encadenando campos
@AllArgsConstructor //Genera un constructor con todos los campos, en el orden en que están declarados
@NoArgsConstructor //Genera un constructor vacío
@Entity //crea una tabla en bbdd con el nombre perosna y los atributos

public class Persona {


    @Id //inidca el id para ls bbdd
            @GeneratedValue(strategy = GenerationType.IDENTITY) //autonumerico
    Long id;
    //@Column() para indicarle la configuracion del dato(unique...)
    String nombre;
    String apellidos;
    @Column(length = 9)
    String dni;
    String email;


}
