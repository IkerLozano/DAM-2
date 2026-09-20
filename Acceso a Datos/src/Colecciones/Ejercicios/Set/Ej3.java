package Colecciones.Ejercicios.Set;

import java.util.*;

public class Ej3 {

    public static void main(String[] args) {

        List<String> lista = new ArrayList<>(Arrays.asList("Iker", "Alonso", "Hecproll", "Andres", "Pablo", "Alonso"));

        System.out.println(unicos(lista));
    }


    public static Set<String> unicos(List<String> listaOg){

        Set<String> nueva = new HashSet<>(listaOg);
        return nueva;
    }
}
