package Tema1.Examen.Variados.Ej4;

import java.net.PortUnreachableException;
import java.util.LinkedList;
import java.util.Queue;

public class ColaTrabajos {

    static Queue<Integer> cola = new LinkedList<>();


    public synchronized void meter(int num) throws InterruptedException {

        if (cola.size() == 5){

            wait();
        }

        cola.add(num);
        System.out.println(Thread.currentThread().getName() + "Produce: " + num);
        notifyAll();

    }


    public synchronized void sacar() throws InterruptedException {

        if (cola.isEmpty()){

            wait();
        }


        System.out.println(Thread.currentThread().getName() + "Consume: " + cola.poll());
        notifyAll();

    }
}
