package Comparator_y_Comparable;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main() {

        ArrayList<Jugador> lista = new ArrayList<>();

        lista.add(new Jugador("Pedri", 23));
        lista.add(new Jugador("Gavi", 21));
        lista.add(new Jugador("Lamine", 18));


        //------------------
        //COMPARATOR
        //-----------------
        Collections.sort(lista, new ComparadorJugador());
        System.out.println("ORDENAR POR NOMBRE");
        System.out.println(lista);

        //Ordenar por nombre
        //Jugador{nombre='Gavi', edad=21}, Jugador{nombre='Lamine', edad=18}, Jugador{nombre='Pedri', edad=23}]




        //------------------
        //COMPARABLE
        //-----------------

        Collections.sort(lista);
        System.out.println("ORDENAR POR EDAD");
        System.out.println(lista);

        //Ordenar por edad
        //[Comparator_y_Comparable.Jugador{nombre='Lamine', edad=18}, Comparator_y_Comparable.Jugador{nombre='Gavi', edad=21}, Comparator_y_Comparable.Jugador{nombre='Pedri', edad=23}]
    }





}
