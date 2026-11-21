package org.iesch.ad.Bloque1_Ej5.modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Ig;

    private String marca;
    private String modelo;
    private String matricula;


    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name="registro_vehicular_id", nullable = false, unique = true)
    private RegistroVehicular registroVehicular;
}
