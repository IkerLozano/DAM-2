package Lambda.Ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Ej1 {

    public static void main(String[] args) {

        List<Integer> nuemros = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

        Predicate<Integer> predicate = n -> n % 2 != 0;

        nuemros.removeIf(predicate);

        System.out.println(nuemros);
    }
}
