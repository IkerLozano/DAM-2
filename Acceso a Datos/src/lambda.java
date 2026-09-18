import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class lambda {


    public static void main() {

        //1.
        //ordenar(); //llamo a la funcion

        //2.
        calcularXuadrado();

    }

    //1. ORDENAR PALABRAS POR LONGUTUD
    public static void ordenar (){

        List<String> lista = Arrays.asList("Peero", "Gato", "Pascual");

        //ordenar por longuitud
        Collections.sort(lista,(s1, s2) -> s1.length() - s2.length());
        System.out.println(lista);
    }


    //2. SACAR EL CUADRADO DE LOS NUMEROS PARES
    public static void calcularXuadrado(){
        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8);
        //primero filtar paea ver cuales son pares
        //Predicate<Integer> esPar = n -> n % 2 == 0; quita lo de dentro del filter y pone esPar y hace lo mismo
        List<Integer> cuadradosPares = numeros.stream().filter(n -> n % 2 == 0).map(n -> n*n).toList();    //predicado = funcion que devuelva un booleano  //filter no es una funcion terminal //map necesita una funcion
        System.out.println(cuadradosPares);


    // Un predicado tiene que devolver un booleano
    // Un consumer no devuelve nada, se usa para realizar acciónes que no necesitan una respuesta (sout)
    // Un function toma un argumento y devuelve un resultado
    // Un supplier no toma ningún argumento y devuelve un resultado

        List<Integer> numeros2 = Arrays.asList(1,2,3,4,5,6,7,8);
        System.out.println(numeros2.stream().anyMatch(n -> n % 2 == 0)); //devuelve false pq no todos sos cumplen

        List<Integer> numeros3 = Arrays.asList(1,2,3,34,4,5); //inmutable
        List<Integer> numerosMutables = new ArrayList<>(Arrays.asList(2,3,4,5,6,7,8)); //mutable
        numerosMutables.add(28);
        System.out.println(numerosMutables);

    }

}
