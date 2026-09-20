package Colecciones;

import java.util.HashMap;
import java.util.Map;

public class Ej_Map {

    public static void main(String[] args) {

        //CREAR UN MAP
        Map<Integer, String> alumnos  = new HashMap<>();

        alumnos.put(1, "Iker");
        alumnos.put(2, "Juan");
        alumnos.put(3, "Pedro");


        //OBTENER VALORES (usamos get y la clave)
        System.out.println(alumnos.get(1));

        //AÑADIR (put)
        alumnos.put(4, "Hecproll"); //si usamos una clave que ya existe

        // MOSTRAR EL MAP
        System.out.println(alumnos); //en lista

        for (Map.Entry<Integer, String> a : alumnos.entrySet()){ //salida personalizada
            System.out.println(a.getKey() + " - " + a.getValue());
        }

            //entrySet() → permite recorrer las claves y valores juntos.

    }
}
