package TEMA1.ExamenT1.src.Ej2;

import java.util.Queue;
import java.util.Random;

public class Camarero implements Runnable{



    Queue<Trabajo> cola;

    public Camarero(Queue<Trabajo> cola) {
        this.cola = cola;
    }

    @Override
    public void run() {


        for (int i = 0; i <cola.size() ; i++) {


            cola.repartir(i);

            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


    }



}
