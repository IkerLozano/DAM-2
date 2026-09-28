package API_Stream.Ejercicios.Ej8_part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        List<Cancion> canciones = new ArrayList<>(Arrays.asList(
                new Cancion("Livin' on Prayer", "Bon Jovi"),
                new Cancion("Long Hot Summer", "Keith Urban"),
                new Cancion("It's my Life", "Bon Jovi"),
                new Cancion("Dolor Fantasma", "Amadeus"),
                new Cancion("Run To You", "Bryan Adams"),
                new Cancion("Summer of 69", "Bryan Adams"),
                new Cancion("Paranoid", "Black Sabbath"),
                new Cancion("Cherokee", "Europe"),
                new Cancion("River Bank", "Brad Paisley"),
                new Cancion("Summer of 69", "Bryan Adams")
        ));


        //Busca las canciones de “Bon Jovi” usando programación tradicional (bucles)
        for (Cancion c: canciones){
            if (c.getCantante().equals("Bon Jovi")){

                System.out.println(c);
            }
        }


        //Busca las canciones de “Bon Jovi” usando programación funcional.
        System.out.println("-----------");
        canciones.stream().filter(c -> c.getCantante().equals("Bon Jovi")).forEach(c -> System.out.println(c));


        //Busca las canciones de "Bon Jovi" usando programación funcional y las canciones encontradas deben acabar en nueva lista.
        System.out.println("-----------");
        System.out.println(canciones.stream().filter(c -> c.getCantante().equals("Bon Jovi")).toList());


        //Cuenta el número de canciones que tiene “Bon Jovi” en la lista.
        System.out.println("-----------");
        System.out.println(canciones.stream()
                .filter(c -> c.getCantante().equals("Bon Jovi"))
                .collect(Collectors.groupingBy(Cancion::getCantante, Collectors.counting())));

            //otra manera de hacerlo
        System.out.println(canciones.stream()
                .map(Cancion::getCantante)
                .filter(c -> c.equals("Bon Jovi")).collect(Collectors.counting()));


        //Realiza una agrupación por cantante y muestra el número de canciones que tiene cada cantante
        System.out.println("------------");
        System.out.println(canciones.stream().collect(Collectors.groupingBy(Cancion::getCantante, Collectors.counting())));



        //Queremos imprimir la información de todas las canciones, pero sin dicho duplicado
        System.out.println("--------------");
        canciones.stream().distinct().forEach(c -> System.out.println(c));
        //hay que generar el equals y el hasCode en la clase Cancion
    }


}
