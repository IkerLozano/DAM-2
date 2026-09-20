package API_Stream.Metodos_de_busqueda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Ejemplo {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8);
        List<Integer> numeros2 = Arrays.asList(2, 4, 6, 8);

        //“allMatch(Predicate<T>)”:
        System.out.println(numeros.stream().allMatch(n -> n % 2 == 0));
            //devuelve false pq no todos cuplen la condicion e ser pares


        //“anyMatch(Predicate<T>)”:
        System.out.println(numeros.stream().anyMatch(n -> n % 2 == 0));
            //devuelve true pq al menos uno es par


        //“noneMatch(Predicate<T>)”:
        System.out.println(numeros.stream().noneMatch(n -> n % 2 == 67));
            //como el resto de ningun numero entre 2 va a ser 67 nos da true, pq ninguno cumple la condicion


        //“findFirst()”:
        System.out.println(numeros.stream().filter(n -> n % 2 == 0).findFirst());
            //nos devuelve el primer elemeto que cumpla la condicion


        //“findAny()”:
        System.out.println(numeros.stream().filter(n -> n % 2 == 0).findAny());
            //nos devuelve cualuqier numero que coincida, no tiene pq ser el primero

    }
}
