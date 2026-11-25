package org.iesch.ad.Bloque1_Ej3.Modelo;



import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {



    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    String nombre;
    int num;
    int cantidad;


    @OneToOne(mappedBy = "pedido")
    @ToString.Exclude
    Direccion direccion;

}
