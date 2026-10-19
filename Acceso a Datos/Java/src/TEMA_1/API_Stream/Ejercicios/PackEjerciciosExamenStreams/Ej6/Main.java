package TEMA_1.API_Stream.Ejercicios.PackEjerciciosExamenStreams.Ej6;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Persona> personas = new ArrayList<>(Arrays.asList(
                new Persona("Iker", "11111111A", Collections.singletonList(new Coche("Opel", "rojo", "11111111"))),
                new Persona("Juan", "22222222B", Collections.singletonList(new Coche("Seat", "azul", "22222222"))),
                new Persona("Carlos", "33333333C", Collections.singletonList(new Coche("BMW", "negro", "33333333"))),
                new Persona("Laura", "44444444D", Collections.singletonList(new Coche("Audi", "blanco", "44444444"))),
                new Persona("Iker", "55555555E", Collections.singletonList(new Coche("Toyota", "rojo", "55555555"))),
                new Persona("Pedro", "66666666F", Collections.singletonList(new Coche("Ford", "verde", "66666666")))
        ));


        //Muestra la información de las personas que tiene un coche rojo
        personas.stream().filter(n -> n.getCoches().stream().anyMatch(c -> c.getColor().equals("rojo"))).forEach(a -> System.out.println(a));

        //Personas con un coche Opel.
        System.out.println("-------");
        personas.stream().filter(c -> c.getCoches().stream().anyMatch(v-> v.getMarca().equals("Opel"))).forEach(e -> System.out.println(e));


        //Encontrar a la persona con más coches.
        System.out.println(personas.stream().collect(Collectors.groupingBy(Persona::getNombre, Collectors.counting())));


    }



}
