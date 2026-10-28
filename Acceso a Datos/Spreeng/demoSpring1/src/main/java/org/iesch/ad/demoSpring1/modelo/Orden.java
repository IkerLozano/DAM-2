package org.iesch.ad.demoSpring1.modelo;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data //mete lo imnportante
public class Orden {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "order_id")
    Cliente cliente;

}
