package Lambda.Ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Ej5 {

    public static void main(String[] args) {

        List<String> lista = new ArrayList<>(Arrays.asList("hola", "Adios", "casa", "perro", "avion"));

        Predicate<String> predicate =  n -> n.charAt(0) == 'A' || n.charAt(0) == 'a';

        System.out.println(lista.stream().filter(predicate).toList());

    }
}
