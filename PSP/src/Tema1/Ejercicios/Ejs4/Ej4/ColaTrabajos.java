package Tema1.Ejercicios.Ejs4.Ej4;

import java.util.Queue;

public class ColaTrabajos {


    private Queue<Integer> colaNums;


    public ColaTrabajos(Queue<Integer> colaNums) {
        this.colaNums = colaNums;
    }

    synchronized private void añadir(int num ){

        colaNums.offer(num);
    }


    synchronized private void sacar ( ){

        colaNums.poll();
    }
}
