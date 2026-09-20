package API_Stream.Metodos_de_Datos_Calculo_y_Ordenacion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ejemplo {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8);
        List<Integer> numeros2 = Arrays.asList(5,1,4,89,4,2,5,7);
        List<String> letras = Arrays.asList("casa", "perro", "lluvia");



        //reduce()
        System.out.println(numeros.stream().reduce((a, b) -> a * b).orElse(0));
            //usamos el .orElse() por si la lista esta vacia que nos muestre 0


        //count()
        System.out.println(numeros.stream().filter(n -> n > 5).count());
            //nos dice la cant de numeros que cumplen la condicion


        //min() y max()
        System.out.println(numeros2.stream().min(Comparator.naturalOrder()));
            //nos devuelve el numero mas pequeño


        //sorted()
        System.out.println(letras.stream().sorted().toList());
            //los ordena en el orden natural

        System.out.println(numeros2.stream().sorted(Comparator.reverseOrder()).toList());
            //los ordena al reves


    }
}
