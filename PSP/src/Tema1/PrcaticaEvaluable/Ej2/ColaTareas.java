package Tema1.PrcaticaEvaluable.Ej2;

import java.util.LinkedList;
import java.util.Queue;

public class ColaTareas {

    private Queue<Integer> cola = new LinkedList<>();
    private Integer max = 3;


    public synchronized void producir(int tarea) throws InterruptedException {

        while (cola.size() >= max) {

            wait();

        }

        cola.add(tarea);

        notifyAll();

    }



}
