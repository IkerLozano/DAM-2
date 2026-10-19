package org.iesch.ad.demoSpring1.modelo;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class Persona {

    Long id;
    String nombre;
    String apellidos;
    String dni;
    String email;


}
