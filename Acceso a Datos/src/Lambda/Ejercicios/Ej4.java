package Lambda.Ejercicios;

import java.util.Random;
import java.util.function.Supplier;

public class Ej4 {

    public static void main(String[] args) {

        Supplier<Integer> supplier = () -> new Random().nextInt(10);

        for (int i = 0; i <10 ; i++) {
            System.out.print(supplier.get() + " ");
        }


    }
}
