package org.iesch.ad.Repaso_Ej1.Servicios;


import org.iesch.ad.Repaso_Ej1.Modelo.Libro;
import org.iesch.ad.Repaso_Ej1.Repositorios.CategoriaRepo;
import org.iesch.ad.Repaso_Ej1.Repositorios.LibroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServicio {



    @Autowired
    LibroRepo libroRepo;



    public List<Libro> mostrarLibros(Long idCategoria){

        return libroRepo.librosPorCategoria(idCategoria);
    }
}
