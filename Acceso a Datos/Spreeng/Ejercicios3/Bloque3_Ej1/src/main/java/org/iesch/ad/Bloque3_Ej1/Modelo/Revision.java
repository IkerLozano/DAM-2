package org.iesch.ad.Bloque3_Ej1.Modelo;


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
public class Revision {


    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    String codigo;

    boolean cambio_filtro;
    boolean cambio_aceite;
    double coste;



    //muchas reviciones pertenecen a un coche
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coche_id", referencedColumnName = "matricula")
    Coche coche;

}
