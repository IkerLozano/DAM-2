package org.iesch.ad.Repaso_Ej1.Modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "categoria")
    @ToString.Exclude
    List<Libro> libros;

}
