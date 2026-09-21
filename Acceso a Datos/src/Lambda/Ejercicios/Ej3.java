package Lambda.Ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Ej3 {

    public static void main(String[] args) {

        List<Integer> nuemros = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

        Function<Integer, Integer> function = n -> n * n *n;

        System.out.println(nuemros.stream().map(function).toList());

    }
}
