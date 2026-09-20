package Comparator_y_Comparable;

import java.util.Comparator;

public class ComparadorJugador implements Comparator<Jugador> {


    //------------------
    //COMPARATOR
    //-----------------

    //ordeno por nombre
    @Override
    public int compare(Jugador j1, Jugador j2) {
        return j1.getNombre().compareTo(j2.getNombre());
    }
}

