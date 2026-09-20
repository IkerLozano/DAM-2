package Lambda.Ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Ej2 {

    public static void main(String[] args) {


        List<String> lista = new ArrayList<>(Arrays.asList("hola", "adios", "casa", "perro"));

        Consumer<String> consumer = n -> System.out.println(n);

        lista.forEach(consumer);

    }

}


