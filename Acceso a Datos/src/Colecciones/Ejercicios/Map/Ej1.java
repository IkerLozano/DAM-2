package Colecciones.Ejercicios.Map;

import java.util.HashMap;
import java.util.Map;

public class Ej1 {

    public static void main(String[] args) {

        Map<String, String> paises = new HashMap<>();

        paises.put("España", "Madrid");
        paises.put("Argentina", "Buenos Aires");
        paises.put("Francia", "Paris");

        paises.entrySet().forEach(System.out::println);
        //System.out.println(paises);

    }
}
