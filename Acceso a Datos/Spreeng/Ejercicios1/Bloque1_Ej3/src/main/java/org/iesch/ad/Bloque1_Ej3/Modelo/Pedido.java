package org.iesch.ad.Bloque1_Ej3.Modelo;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
