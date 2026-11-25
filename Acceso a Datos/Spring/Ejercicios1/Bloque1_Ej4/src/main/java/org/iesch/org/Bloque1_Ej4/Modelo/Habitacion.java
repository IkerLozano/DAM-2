package org.iesch.org.Bloque1_Ej4.Modelo;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Habitacion {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    int numHabitacion;
    int camas;
    double precio;


    @OneToMany(mappedBy = "habitacion")  //una habitación hacia muchas reservas.
    List<Reserva> reservas;


}
