package Colecciones.Ejercicios.Set;

import java.util.HashSet;
import java.util.Set;

public class Ej2 {

    public static void main(String[] args) {

        Set<Integer> numeros = new HashSet<>();
        numeros.add(1);
        numeros.add(5);
        numeros.add(3);
        numeros.add(6);
        numeros.add(5);
        numeros.add(6);
        numeros.add(7);

        System.out.println(unicos(numeros));

    }

    static public Set<Integer> unicos(Set<Integer> setNuevo){

        Set<Integer> nueva = new HashSet<>(setNuevo);
        return nueva;
    }
}
