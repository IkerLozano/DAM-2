package API_Stream.Collectors;

import Comparator_y_Comparable.Jugador;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Jugadores> jugadores = new ArrayList<>();

        jugadores.add(new Jugadores("Iker", 19, Arrays.asList("Roma")));
        jugadores.add(new Jugadores("Juan", 19, Arrays.asList("Francia")));
        jugadores.add(new Jugadores("Marta", 25, Arrays.asList("Japón")));
        jugadores.add(new Jugadores("Lucía", 20, Arrays.asList("México")));


        System.out.println(jugadores.stream().map(Jugadores::getNombre).collect(Collectors.toList()));
            /*
                collect(Collectors.toList()) → recoge los nombres en una lista

                toList() y Collectors.toList():
                Ambos permiten recoger los elementos en una lista, aunque Collectors.toList()
                forma parte de la API de Collectors y puede combinarse con otros colectores
             */

        System.out.println(jugadores.stream().collect(Collectors.counting()));
            //lo mismo que usar un count()


        System.out.println(jugadores.stream().collect(Collectors.minBy(Comparator.comparing(Jugadores::getEdad))).map(Jugadores::getNombre));
            //lo mismo que min()
            //aqui pillo el que menos edad tenga y con el map() transforno la persona en solo el nombre, para q me muestre el nombre del que tenga menos edad


        System.out.println(jugadores.stream().collect(Collectors.summingInt(Jugadores::getEdad)));
            //lo mimso que sum
            //suma la edad de todas los jugadores

        System.out.println(jugadores.stream().collect(Collectors.averagingInt(Jugadores::getEdad)));
            //calcula la meida de edad de todos los jugadores


        System.out.println(jugadores.stream().collect(Collectors.summarizingInt(Jugadores::getEdad)));
            //me dice varioas datos
            //{count=4, sum=86, min=19, average=21,500000, max=25}


        System.out.println(jugadores.stream().map(Jugadores::getNombre).collect(Collectors.joining(", ")));
            //en el join() le podemos porque lo queremos separar
            //tenemos que usar un map() para obtener el nombre
            //Iker, Juan, Marta, Lucía


        System.out.println(jugadores.stream().collect(Collectors.groupingBy(Jugadores::getEdad)));
            //agrupa por la edad

        System.out.println(jugadores.stream().collect(Collectors.groupingBy(Jugadores::getEdad, Collectors.counting())));
            //cuanta cuantos tienen cada edad
            //{19=2, 20=1, 25=1}

    }
}
