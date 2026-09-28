package API_Stream.Ejercicios.Ej3_part2;

import API_Stream.map_y_FlatMap.Persona;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Personas> personas = new ArrayList<>(Arrays.asList(
                new Personas("Iker", 19),
                new Personas("Carlos", 35),
                new Personas("Laura", 20),
                new Personas("Marta", 31),
                new Personas("David", 18)
        ));


        System.out.println("--- EDAD PROMEDIO ---");
        System.out.println(personas.stream().collect(Collectors.averagingInt(Personas::getEdad)));

        System.out.println("-- PERSONA MAS JOVEN ---");
        System.out.println(personas.stream().collect(Collectors.minBy(Comparator.comparing(Personas::getEdad))).get());
        /*
            el .get() Obtiene y devuelve el objeto que está dentro de un Optional
            solo usarlo si sabemos que existe un resultado
        */


        System.out.println("-- PERSONAS > 30 ---");
        System.out.println(personas.stream().filter(n -> n.getEdad() > 30).map(Personas::getNombre).toList());


    }
}
