package Tema1.Examen.Ej1_ParcductorConsumidor;

import java.util.Random;

public class Productor implements Runnable{


    private ColaTrabajos cola;


    //constructor
    public Productor(ColaTrabajos cola) {
        this.cola = cola;
    }




    @Override
    public void run() {

        Random random = new Random();


        for (int i = 0; i <10 ; i++) {

            int num = random.nextInt(1, 11);//11 pq el último num no se incluye


            try {
                cola.meterNums(num);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
