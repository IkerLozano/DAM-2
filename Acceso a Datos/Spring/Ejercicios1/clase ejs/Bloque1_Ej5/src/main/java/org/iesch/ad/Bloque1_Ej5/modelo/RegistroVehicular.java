package org.iesch.ad.Bloque1_Ej5.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data
public class RegistroVehicular {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String numeroRegistro;
    private LocalDate fechaExpedicion;
    private LocalDate fechaVencimiento;

    //@OneToOne(mappedBy = "registroVehicular")


}
