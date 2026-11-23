package org.iesch.ad.Bloque2_Ej3.Servicio;


import jakarta.transaction.Transactional;
import org.iesch.ad.Bloque2_Ej3.Modelo.Asignatura;
import org.iesch.ad.Bloque2_Ej3.Modelo.Estudiante;
import org.iesch.ad.Bloque2_Ej3.Repositorios.AsignaturaRepo;
import org.iesch.ad.Bloque2_Ej3.Repositorios.EstudianteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ColegioServicio {


    @Autowired
    AsignaturaRepo asignaturaRepo;

    @Autowired
    EstudianteRepo estudianteRepo;


    @Transactional
    public void crearEstudiante(String nombre, String email) {

        Estudiante e1 = Estudiante.builder().nombre(nombre).email(email).build();


        estudianteRepo.save(e1);


    }


    @Transactional
    public void crearAsignatura(String nombre) {

        Asignatura a1 = Asignatura.builder().nombre(nombre).build();

        asignaturaRepo.save(a1);



    }

    @Transactional
    public void matricular(Long idEstudiante, Long idAsignatura) {

        Estudiante estudiante = estudianteRepo.findById(idEstudiante).get();

        Asignatura asignatura = asignaturaRepo.findById(idAsignatura).get();

        estudiante.getAsignaturas().add(asignatura);
        asignatura.getEstudiantes().add(estudiante);

    }

    @Transactional
    public List<Estudiante> listarEstudiantes() {

        List<Estudiante> estudiantes = estudianteRepo.findAll();

        for (Estudiante e : estudiantes){

            System.out.println("--> " + e);

        }

        return estudiantes;

    }

    @Transactional
    public List<Asignatura> listarAsignaturas() {

        List<Asignatura> asignaturas = asignaturaRepo.findAll();

        for (Asignatura a : asignaturas){

            System.out.println("--> " + a);

        }

        return asignaturas;

    }

    @Transactional
    public void borrarEstudiante(long l) {

        Optional<Estudiante> estudianteBorrar = estudianteRepo.findById(l);

        if (estudianteBorrar.isPresent()){

            Estudiante estudianteYaBorrado = estudianteBorrar.get();
            estudianteRepo.delete(estudianteYaBorrado);

        }

    }

    @Transactional
    public void borrarAsignatura(long l) {

        Optional<Asignatura> asignaturaBorrar = asignaturaRepo.findById(l);

        if (asignaturaBorrar.isPresent()){

            Asignatura asignaturaYaBorrado = asignaturaBorrar.get();

            for (Estudiante e : asignaturaYaBorrado.getEstudiantes()){

                e.getAsignaturas().remove(asignaturaYaBorrado);
                estudianteRepo.save(e); //esto no haria falta, ya que se supone que con Transactional se guarda automatico

            }




            asignaturaRepo.delete(asignaturaYaBorrado);

        }

    }

    @Transactional
    public void desmatricular(Long idEstudiante, Long idAsignatura) {

        Estudiante estudiante = estudianteRepo.findById(idEstudiante).get();

        Asignatura asignatura = asignaturaRepo.findById(idAsignatura).get();

        estudiante.getAsignaturas().remove(asignatura);
        asignatura.getEstudiantes().remove(estudiante);

    }
}
