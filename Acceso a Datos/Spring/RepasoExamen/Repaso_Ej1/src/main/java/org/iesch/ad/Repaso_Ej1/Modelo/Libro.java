package org.iesch.ad.Repaso_Ej1.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Libro {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    private String titulo;
    private String autor;
    @Column(nullable = false, length = 13)
    private String isbn;
    private LocalDateTime saveAt;

    @PrePersist
    public void preGuardar(){
        this.saveAt = LocalDateTime.now();
    }

    @PostPersist
    public void postGuardado(){
        System.out.println("Se guarda libro con el isbn " + this.isbn);
    }

    @ManyToOne()
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    Categoria categoria;


}
