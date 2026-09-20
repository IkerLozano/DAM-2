package Colecciones.Ejercicios.Set;

import java.util.HashSet;
import java.util.Set;

public class Ej1 {

    public static void main(String[] args) {

        //Set<String> nombres = new HashSet<>(Set.of("Iker", "Alonso", "Hecproll", "Andres", "Pablo", "Alonso"));

        Set<String> nombres2 = new HashSet<>();
        nombres2.add("Iker");
        nombres2.add("Andres");
        nombres2.add("Iker");
        nombres2.add("Pablo");


        /*
        si usamos Set.of y metemos un repetido dara fallo, pero si lo hacemos con add no, pq
        el HashSet permite duplicados, lo unico que no lo mostrara
         */

        System.out.println(nombres2.stream().toList());
        //el primero de la lista sera el qie primero a entrado
        // salida: [Pablo, Andres, Alonso, Iker, Hecproll]

    }
}
