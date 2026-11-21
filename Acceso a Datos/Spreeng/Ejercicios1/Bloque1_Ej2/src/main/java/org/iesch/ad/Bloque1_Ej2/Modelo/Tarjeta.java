package org.iesch.ad.Bloque1_Ej2.Modelo;

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
public class Tarjeta {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long id;

    String codigo;
    LocalDate fechaExp;

    @OneToOne()
    @JoinColumn(name = "empleado_id", referencedColumnName = "id")
    Empleado empleado;
}
