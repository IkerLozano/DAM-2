package org.iesch.ad.Repaso_Ej2.Servicios;


import jakarta.transaction.Transactional;
import org.iesch.ad.Repaso_Ej2.Modelo.Asignatura;
import org.iesch.ad.Repaso_Ej2.Modelo.Estudiante;
import org.iesch.ad.Repaso_Ej2.Repositorios.AsignaturaRepo;
import org.iesch.ad.Repaso_Ej2.Repositorios.EstudianteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaService {

    @Autowired
    EstudianteRepo estudianteRepo;

    @Autowired
    AsignaturaRepo asignaturaRepo;



    @Transactional
    public void borrar(Long idAsignaturaDesmatricular,  Long idAlumnoDesmatricular){


        Asignatura asignaturaDesmatricular = asignaturaRepo.findById(idAsignaturaDesmatricular).get();
        Estudiante estudianteDesmatricular = estudianteRepo.findById(idAlumnoDesmatricular).get();

        estudianteDesmatricular.getAsignaturas().remove(asignaturaDesmatricular);
        asignaturaDesmatricular.getEstudiantes().remove(estudianteDesmatricular);

        estudianteRepo.save(estudianteDesmatricular);
        asignaturaRepo.save(asignaturaDesmatricular);

        System.out.println("El estudiante " + estudianteDesmatricular.getNombre() + " se a desmatriculado de " + asignaturaDesmatricular.getNombre());
        System.out.println(estudianteDesmatricular.getAsignaturas());


    }
}
