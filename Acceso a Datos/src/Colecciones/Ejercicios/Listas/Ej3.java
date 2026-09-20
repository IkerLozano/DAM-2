package Colecciones.Ejercicios.Listas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ej3 {

    public static void main(String[] args) {

        List<String> nombres = new ArrayList<>(Arrays.asList("Casa", "Perro", "Avioneta"));

        //System.out.println(lonuitud(nombres));

        System.out.println(compareTo(nombres));

    }

    /*
    private static String lonuitud (List<String> listsOG){

        int largo = 0;
        String palabra = "";

      for (String l : listsOG){
          if (l.length() > largo){
              largo = l.length();
              palabra = l;
          }
      }

      String frase = palabra + " , " + largo + " letras";

      return frase;

    }

     */


    public static int compareTo(List<String> listaOG){

        return listaOG.stream().max(Comparator.comparing(String::length)).get().length();

            //.get() sirve para sacar/obtener el resultado que nos da String::length, y el .length final pasa la palabra a su num de letras
            //Comparator.comparing se usa cuando quieres crear un Comparator a partir de una característica del objeto
    }
}

