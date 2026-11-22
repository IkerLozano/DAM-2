package org.iesch.ad.Bloque1_Ej5.Modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistroVehicular {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    int numRegistro;
    LocalDate fechaExpedicion;
    LocalDate fechaVencimiento;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "matricula_vehiculo", referencedColumnName = "matricula")
    Vehiculo vehiculo;


}
