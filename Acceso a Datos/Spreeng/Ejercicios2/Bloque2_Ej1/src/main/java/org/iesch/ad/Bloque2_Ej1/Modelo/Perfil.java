package org.iesch.ad.Bloque2_Ej1.Modelo;


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
public class Perfil {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    String biografia;
    LocalDate fechaNacimiento;
    String preferencias;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "socio_id", referencedColumnName = "id")

    Socio socio;
}
