package org.iesch.ad.demoSpring1.modelo;


import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.List;

@Entity
@Data //mete lo imnportante
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;

    @OneToMany(mappedBy = "cliente") //bidireccional
    //@JoinColumn(name = "order_id")//unidireccional, para evitar la tabla intermedia, le idicamos como se va a llamar la clave ajena de la tabla orden
    List<Orden> listaOrdenes;
}
