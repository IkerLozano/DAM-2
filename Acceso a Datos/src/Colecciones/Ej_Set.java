package Colecciones;

import java.util.HashSet;
import java.util.Set;

public class Ej_Set {

    public static void main(String[] args) {

        //CREAR UN SET
        Set<String> nombres = new HashSet<String>(Set.of("Iker", "Juan", "Pedro"));


        //RECORRERLA
        System.out.println(nombres.stream().toList()); //en formato lista

        nombres.forEach(System.out::println); //uno debajo de otro

        for (String n : nombres){
            System.out.println(n);
        }   //uno debajo de otro


        //METODOS
        nombres.add("Iker");          // Añadir
        nombres.remove("Iker");    // Eliminar
        nombres.contains("Iker");     // Comprobar si existe
        nombres.size();               // Tamaño




    }
}
