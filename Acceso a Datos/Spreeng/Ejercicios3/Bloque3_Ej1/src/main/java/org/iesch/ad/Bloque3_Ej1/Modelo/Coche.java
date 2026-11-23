package org.iesch.ad.Bloque3_Ej1.Modelo;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coche {


    //@GeneratedValue(strategy = GenerationType.IDENTITY)  //no se pude esto pq es un String
    @Id
    String matricula;

    String marca;
    String modelo;
    String color;
    double precio;


    //muchos oches tienen un dueño
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    Cliente cliente_id;


    //un coche puede tener varias revisiones
    @OneToMany(mappedBy = "coche_id")
    List<Revision> revisiones;

}
