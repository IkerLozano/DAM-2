package Tema1.Examen.Variados.Ej4;

import java.util.Random;

public class Consumirdor implements Runnable{


    ColaTrabajos cola;

    public Consumirdor(ColaTrabajos cola) {
        this.cola = cola;
    }

    @Override
    public void run() {

        for (int i = 0; i <10 ; i++) {

            try {
                cola.sacar();
                Thread.sleep(800);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

}
