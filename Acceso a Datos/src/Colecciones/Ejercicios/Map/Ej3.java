package Colecciones.Ejercicios.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ej3 {

    public static void main(String[] args) {

        List<Estudiantes> e = new ArrayList<>();
        e.add(new Estudiantes("Iker", 19, "DAM"));
        e.add(new Estudiantes("Hecproll", 25, "YuoTube"));
        e.add(new Estudiantes("Andres", 67, "Peluquero"));

        System.out.println(mapa(e));

    }

    public static Map<String, Estudiantes> mapa(List<Estudiantes> listaOG){

        Map<String, Estudiantes> nuevo = new HashMap<>();

        for (Estudiantes e: listaOG){

            nuevo.put(e.getNombre(), e);
        }

        return nuevo;
    }
}
