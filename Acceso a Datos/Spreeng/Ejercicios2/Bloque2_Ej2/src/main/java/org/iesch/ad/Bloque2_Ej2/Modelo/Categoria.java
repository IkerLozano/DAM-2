package org.iesch.ad.Bloque2_Ej2.Modelo;



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

    //@Column(unique = true) // po ri squiero que la CA sea el nombre de la categoria
    String nombre;
    String descripcion;

    @OneToMany(mappedBy = "categoria")
    @ToString.Exclude
    List<Libro> libros;
}
