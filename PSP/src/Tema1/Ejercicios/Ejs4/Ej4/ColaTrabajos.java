package Tema1.Ejercicios.Ejs4.Ej4;

import java.util.Queue;
import java.util.Random;
import java.util.TreeMap;

public class ColaTrabajos {


    private Queue<Integer> colaNums;
    private int productoresTerminados = 0; //cuenta cuántos productores han acabado de generar sus 10 números.

    //constructor
    public ColaTrabajos(Queue<Integer> colaNums) {
        this.colaNums = colaNums;
    }


    //metodo para añadir numeros
    synchronized public void anadir() throws InterruptedException {


        for (int i = 0; i <10 ; i++) {

            //miestras la cola este llena:
            while (colaNums.size() == 5){
                wait(); //hace que el hilo productor espere
            }

            Random random = new Random();
            int num = random.nextInt(0, 50);
            colaNums.offer(num);
            System.out.println(Thread.currentThread().getName() + " --> Produce: " + num);
            notifyAll(); //aviso a los consumidores por si tienen que intervenir
            Thread.sleep(500);


        }

        //Para saber cuando han terinado los productores
        productoresTerminados++;
        notifyAll();

    }

    //metodo para sacar numeros
    synchronized public void sacar () throws InterruptedException {


        for (int i = 0; i <10 ; i++) {

            //mientras la cola este vacia
            while (colaNums.isEmpty() && productoresTerminados < 2){
                wait();
            }

            if (colaNums.isEmpty() && productoresTerminados == 2) {
                return;
            }

            System.out.println(Thread.currentThread().getName() + " --> Consume: " + colaNums.poll());
            Thread.sleep(800);
            this.notifyAll(); //despierta a todos los hilos que están esperando con wait()

            /*
                Los llamo para ver si pueden continuar ellos
            */
        }






    }
}
