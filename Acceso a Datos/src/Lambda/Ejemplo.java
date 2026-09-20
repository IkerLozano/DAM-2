package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ejemplo {

    public static void main(String[] args) {

        List<String> lista1 = new ArrayList<>(Arrays.asList("Hola", "Camion", "Perro", "Bicicleta"));
        List<Integer> lista2 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

        //1.
        funcion1(lista1);

        //2.
        funcion2(lista2);
    }

    //1. ORDENAR PALABRAS POR LONGUTUD
    public static void funcion1(List<String> listaOg){

        Collections.sort(listaOg,(p1,p2) -> p2.length() - p1.length());
        System.out.println(listaOg);

            //Convierte la lista en un Stream para poder procesar sus elementos uno a uno usando operaciones como filter, map, sorted, etc
//        listaOg.stream()
//                .sorted((p1, p2) -> p2.length() - p1.length())
//                .forEach(System.out::println);
    }


    //2. SACAR EL CUADRADO DE LOS NUMEROS PARES
    public static void funcion2(List<Integer> listaNum){

        System.out.println(listaNum.stream().filter(n -> n % 2 == 0).map(n -> n * n).toList());
        //filter() necesita stream() para funcionar
        //Map ≠ map()
            //map() es una operación de Streams que sirve para transformar cada elemento.
    }
}
