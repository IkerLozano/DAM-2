package TEMA1.ExamenT1.src.Ej2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import TEMA1.ExamenT1.src.Ej2.*;

public class Cocinero implements Runnable{


    Queue<Trabajo> cola;

    public Cocinero(Queue<Trabajo> cola) {
        this.cola = cola;
    }

    @Override
    public void run() {

        Random random = new Random();


        int num = random.nextInt(20, 40);
        int dormir = random.nextInt(200, 500);

        for (int i = 0; i <num ; i++) {



            cola.preparar(num);


            try {
                Thread.currentThread().sleep(dormir);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


    }
}
