package Tema1.Examen.Ej2_ParcductorConsumidor.Ej1_ParcductorConsumidor;

import java.util.LinkedList;
import java.util.Queue;

public class ColaTrabajos {

    static Queue<Integer> cola = new LinkedList<>();

    public ColaTrabajos() {
        this.cola = cola;
    }



    public synchronized void meter(int num) throws InterruptedException {

        if (cola.size() == 5){

            wait();
        }

        cola.add(num);
        notifyAll();
        System.out.println(Thread.currentThread().getName() + "Produce:" +  num);


    }



    public synchronized void sacar() throws InterruptedException {

        if (cola.size() == 0){

            wait();
        }

        System.out.println(Thread.currentThread().getName() + "Consume:" +  cola.poll());
        notifyAll();

    }
}
