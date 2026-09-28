package API_Stream.Ejercicios;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ej5_part2 {

    public static void main(String[] args) {


         String texto = "este es un ejemplo de texto para contar palabras este texto puede ser todo lo largo que quieras";

         String[] palabras = texto.split(" ");

         List<String> textoD = new ArrayList<>(Arrays.asList(palabras));

        System.out.println(textoD.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting())));
        /*
            Usamos un lambda (palabra -> palabra) porque queremos utilizar la propia
            palabra como clave para agrupar las palabras iguales.

            //{que=1, ser=1, puede=1, de=1, lo=1, es=1, todo=1, texto=2, este=2, para=1, palabras=1, un=1, quieras=1, largo=1, contar=1, ejemplo=1}
         */
    }
}
