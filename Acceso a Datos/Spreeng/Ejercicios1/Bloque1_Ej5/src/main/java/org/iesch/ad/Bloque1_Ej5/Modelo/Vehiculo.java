package org.iesch.ad.Bloque1_Ej5.Modelo;



import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    String matricula;
    String marca;
    String duenio;


    @OneToOne(mappedBy = "vehiculo")
    @ToString.Exclude
    RegistroVehicular registroVehicular;


}
