package Tema1.Examen.Ej1_ParcductorConsumidor;

import java.util.LinkedList;
import java.util.Queue;

public class ColaTrabajos {

    static Queue<Integer> numeros = new LinkedList<>();


    public synchronized void meterNums(int num) throws InterruptedException {

        while (numeros.size() == 5){

            wait();
        }


        numeros.add(num);
        notifyAll();
        System.out.println("[" + Thread.currentThread().getName() + "] Produce: " + num);


    }



    public synchronized void sacarNums() throws InterruptedException {


        while (numeros.size() == 0) {

            wait();

        }


        System.out.println("[" + Thread.currentThread().getName() + "] Consume: " + numeros.poll());
        notifyAll();

    }

}
