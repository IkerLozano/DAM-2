package org.iesch.ad.Bloque1_Ej3.Modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    String calle;
    String ciudad;
    int CP;
    String pais;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")

    Pedido pedido;

}
