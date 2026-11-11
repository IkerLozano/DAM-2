package Tema1.Examen.Ej2_ParcductorConsumidor.Ej1_ParcductorConsumidor;

import java.util.PriorityQueue;

public class Consumidor implements Runnable{

    private ColaTrabajos cola;


    public Consumidor(ColaTrabajos cola) {
        this.cola = cola;
    }


    @Override
    public void run() {

        for (int i = 0; i <10 ; i++) {

            try {
                cola.sacar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


    }
}
