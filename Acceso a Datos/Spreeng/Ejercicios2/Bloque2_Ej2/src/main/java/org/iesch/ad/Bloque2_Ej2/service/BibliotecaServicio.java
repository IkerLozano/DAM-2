package org.iesch.ad.Bloque2_Ej2.service;


import org.iesch.ad.Bloque2_Ej2.Repositorios.CategoriaRepo;
import org.iesch.ad.Bloque2_Ej2.Repositorios.LibroRepo;
import org.iesch.ad.Bloque2_Ej2.modelo.Categorias;
import org.iesch.ad.Bloque2_Ej2.modelo.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaServicio {


    @Autowired
    CategoriaRepo categoriaRepo;


    @Autowired
    LibroRepo libroRepo;

    public List<Libro> listarLibros(Long categoriaId) {

        return categoriaId == null ? libroRepo.findAll() : libroRepo.findByCategoriaId()

    }


    public Categorias crearCategoria(String nombre) {

        Categorias categoria = new Categorias();
        categoria.setNombre(nombre);

        return categoriaRepo.save(categoria);

    }


    public void crearLibro(String titulo, String autor, long categoriaId) {

        Categorias categoria =  buscarCategoria(categoriaId);
        Libro libro = new Libro();
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        categoria.agregarLibro(libro);

        return libroRepo.save(libro);


    }

    private Categorias buscarCategoria(long categoriaId) {

        return categoriaRepo.findById(categoriaId).orElseThrow(
                ()->new IllegalArgumentException("No existe la catrgoría " + categoriaId));
        );


    }

    public List<Categorias> listarCategorias() {

        return categoriaRepo.findAll();

    }

    public void cambiarCategoria(Long libro, long l) {


    }

    public void borrarLibro(long l) {


    }

    public void borrarCategoria(long idLibro) {

        Libro libro = libroRepo.findBy(idLibro)

    }
}
