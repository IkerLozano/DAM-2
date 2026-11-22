package org.iesch.ad.Bloque2_Ej2.modelo;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Libro {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    Long Id;
    @Column(nullable = false)
    private String titulo;
    private String autor;
    //private String categoria;


    @ManyToOne(optional = false)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categorias categoria;

}
