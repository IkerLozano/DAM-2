package org.iesch.ad.Bloque3_Ej1.Modelo;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    String nif;
    String nombre;
    String direccion;
    String ciudad;
    String telefono;

    //un cliente pude tener varios oches
    @OneToMany(mappedBy = "cliente_id")
    @ToString.Exclude
    List<Coche> coches;


}
