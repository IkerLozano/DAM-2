package org.iesch.ad.Repaso_Ej1.Servicios;


import org.iesch.ad.Repaso_Ej1.Modelo.Libro;
import org.iesch.ad.Repaso_Ej1.Repositorios.CategoriaRepo;
import org.iesch.ad.Repaso_Ej1.Repositorios.LibroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServicio {


    @Autowired
    CategoriaRepo categoriaRepo;



    public int totalLibros(Long idCategoria){

        return categoriaRepo.numLibros(idCategoria);
    }
}
