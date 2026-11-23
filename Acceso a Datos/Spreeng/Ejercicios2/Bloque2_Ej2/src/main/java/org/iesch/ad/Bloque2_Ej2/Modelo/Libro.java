package org.iesch.ad.Bloque2_Ej2.Modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Libro {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    String titulo;
    String autor;
    String isbn;

    @ManyToOne()
    @JoinColumn(name = "categoria", referencedColumnName = "id")
    Categoria categoria;
}
