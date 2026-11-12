package Tema1.Examen.Variados.Ej4;

import java.util.Random;

public class Productor implements  Runnable{

    ColaTrabajos cola;

    public Productor(ColaTrabajos cola) {
        this.cola = cola;
    }

    @Override
    public void run() {

        Random random = new Random();

        for (int i = 0; i <10 ; i++) {

            int num = random.nextInt(1, 100);

            try {
                cola.meter(num);
                Thread.sleep(500);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }

    }
}
