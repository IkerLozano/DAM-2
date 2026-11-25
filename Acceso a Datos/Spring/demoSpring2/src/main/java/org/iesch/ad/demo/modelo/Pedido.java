package org.iesch.ad.demo.modelo;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Pedido {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDateTime fecha;
    String resumen;


    @ManyToOne()
    @JoinColumn(name = "cliente_id")
    /*
        Sirve para indicar que la relación se va a establecer mediante una columna
        llamada cliente_id en la tabla pedido, de esta manera no nos creara una tabla intermedia

        Como el JoinColumn esta en eta clase, inidcamos que es la clase padre, y por eso
        la columna "cliente_id" esta en la clase pedido
     */
    Cliente cliente;
}
