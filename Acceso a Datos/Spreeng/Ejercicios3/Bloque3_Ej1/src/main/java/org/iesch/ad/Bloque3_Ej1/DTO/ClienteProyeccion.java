package org.iesch.ad.Bloque3_Ej1.DTO;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteProyeccion {

    private String nombre;
    private String nif;
    private String ciudad;
    private Integer totalcoches;
    //size devuelve un entero.


}

