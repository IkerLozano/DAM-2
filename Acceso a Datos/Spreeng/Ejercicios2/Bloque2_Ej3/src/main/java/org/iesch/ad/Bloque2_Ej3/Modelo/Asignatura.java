package org.iesch.ad.Bloque2_Ej3.Modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Asignatura {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;


    private String nombre;
    private String profesor;
    private int horas;
}
