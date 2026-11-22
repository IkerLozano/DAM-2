package org.iesch.ad.Bloque2_Ej2.modelo;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Categorias {



    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    Long Id;
    private String titulo;
    @Column(nullable = false, unique = true)
    private String nombre;

    @OneToMany(mappedBy = "categoria")
    private List<Libro> libros =  new ArrayList<>();


    //helper/ayudadores, esto no es obligatorio pero ayuda, esto lo hace el cascade solo creo
    public void AgregarLibro(Libro libro) {

        libros.add(libro);
        libro.setCategoria(this);
    }

    public void quitarLibro(Libro libro) {

        libros.remove(libro);
        libro.setCategoria(null);
    }
}
