package Colecciones.Ejercicios.Map;

import java.security.Key;
import java.util.*;

public class Ej2 {

    public static void main(String[] args) {

        List<String> lista = new ArrayList<>(Arrays.asList("Iker", "Alonso", "Hecproll", "Hecproll", "Pablo", "Iker"));

        System.out.println(mapa(lista));
    }

    public static Map<String, Integer> mapa(List<String> listOg){

        Map<String, Integer> nuevo = new HashMap<>();

        //recorro la lista y obtengo cada String
        for (String l : listOg){
            nuevo.put(l, nuevo.getOrDefault(l, 0) +1); //meto al mapa la clave que va a ser el String que e obtenido y como valor hago el getOrDefault
            /*
            getOrDefault(clave, valor) busca la clave; si existe devuelve su valor y si no existe devuelve el valor indicado como segundo parámetro.
            */
        }
        return nuevo;
    }
}
