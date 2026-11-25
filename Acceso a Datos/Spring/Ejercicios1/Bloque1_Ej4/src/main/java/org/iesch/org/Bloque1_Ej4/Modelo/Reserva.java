package org.iesch.org.Bloque1_Ej4.Modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {


        //ONETOMANY
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    String nombreCliente;
    LocalDate fechaEntrada;
    LocalDate fechaSalida;
    int numPersonas;


    @ManyToOne() //muchas reservas pueden estar asociadas a una misma habitación.
    @JoinColumn(name = "habitacion_id", referencedColumnName = "numHabitacion")
    Habitacion habitacion;

    //para cada reseva una sola habitacion y para una habotacion una lista de reservas



}
