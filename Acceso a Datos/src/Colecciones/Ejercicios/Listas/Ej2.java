package Colecciones.Ejercicios.Listas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ej2 {

    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        System.out.println(nuevaLista(numeros));

    }


    private static List<Integer> nuevaLista (List<Integer> listaOG){

        return listaOG.stream().filter(n -> n % 2 == 0).toList();
    }
}
