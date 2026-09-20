package Colecciones.Ejercicios.Listas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ej1 {

    public static void main(String[] args) {

        List<String> lista = new ArrayList<>(Arrays.asList("Casa", "Perro", "Gato"));

        lista.stream().forEach(System.out::println);

    }
}
