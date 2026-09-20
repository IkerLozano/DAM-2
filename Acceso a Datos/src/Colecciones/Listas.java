package Colecciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Listas {

    public static void main() {


        //CREAR UNA LISTA
        List<String> lista1 = new ArrayList<>(Arrays.asList("Andres", "Pablo", "Alonso"));
        ArrayList<String> lista2 = new ArrayList<>(Arrays.asList("uno", "dos", "tres"));


        //RECORRERLA
        for (String l : lista1){
            System.out.println(l);
        } //uno debajo de otro

        lista1.forEach(System.out::println); //uno debajo de otro

        System.out.println(lista1.stream().toList()); //fomato lita


        //ACCESDER A UN ELEMENTO
        System.out.println(lista1.get(0));

        //METODOS IMPORTANTES
        lista1.add("Luis");          // Añadir
        lista1.get(0);               // Obtener
        lista1.set(0, "Carlos");     // Cambiar
        lista1.remove(0);      // Eliminar por índice
        lista1.size();               // Tamaño
        lista1.contains("Iker");     // Comprobar si existe

    }
}
