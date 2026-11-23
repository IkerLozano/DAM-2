package org.iesch.ad.Bloque2_Ej2.Servicios;


import jakarta.transaction.Transactional;
import org.iesch.ad.Bloque2_Ej2.Modelo.Categoria;
import org.iesch.ad.Bloque2_Ej2.Modelo.Libro;
import org.iesch.ad.Bloque2_Ej2.Repositorios.CategoriaRepo;
import org.iesch.ad.Bloque2_Ej2.Repositorios.LibroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Optional;

@Service
public class LibroService {


    @Autowired
    CategoriaRepo categoriaRepo;


    @Autowired
    LibroRepo libroRepo;


    public void crearCategoria(String nombre) {


        Categoria c1 = Categoria.builder().nombre(nombre).build();

        categoriaRepo.save(c1);

    }

    @Transactional
    public void crearLibro(String titulo, String autor, long idCategoria) {

        Categoria categoria = categoriaRepo.findById(idCategoria).get();

        Libro l1 = Libro.builder().titulo(titulo).autor(autor).categoria(categoria).build();

        l1.setCategoria(categoria);
        categoria.getLibros().add(l1);

        libroRepo.save(l1);

    }

    public List<Categoria> listarCategorias() {

        List<Categoria> categorias = categoriaRepo.findAll();

        for (Categoria c : categorias){

            System.out.println(c);
        }

        return categorias;

    }

    public List<Libro> listarLibros(Long id) {

        List<Libro> libros = libroRepo.findByCategoriaId(id);

        for (Libro l : libros){

            System.out.println(l);
        }

        return libros;
    }

    @Transactional
    public void borrarLibro(long l) {

        Optional<Libro> libroBorrar = libroRepo.findById(l);

        if (libroBorrar.isPresent()){

            Libro libroYaBorrado = libroBorrar.get();
            libroRepo.delete(libroYaBorrado);

        }

    }


    @Transactional
    public void borrarCategoria(long l) {

        //List<Categoria> categorias = categoriaRepo.findAll();
        Optional<Categoria> categoriaBorrar = categoriaRepo.findById(l);

        if (categoriaBorrar.get().getLibros().isEmpty()){

            Categoria categoriaYaBorrada = categoriaBorrar.get();
            categoriaRepo.delete(categoriaYaBorrada);

        }else{

            System.out.println("No se puede borrar la categoria porque aun tiene libros");
        }

    }

    public void cambiarCategoria(Long libroId, long categoriaId) {

        Optional<Libro> libro1 = libroRepo.findById(libroId); //busco el libro por el id que me diga

        Categoria categoria = categoriaRepo.findById(categoriaId).get(); //busco la ategoria por el id que me diga


        libro1.get().setCategoria(categoria);

        libroRepo.save(libro1.get());
    }

    public void trasladarLibros(Long origen, Long destino) {

        List<Libro> libros = libroRepo.findByCategoriaId(origen); //obtengo los libros de la categoria de origen

        Optional<Categoria> categoria = categoriaRepo.findById(destino); //obtengo la categria de destino

        for (Libro l : libros){

            l.setCategoria(categoria.get());

            libroRepo.save(l);

        }

    }
}
