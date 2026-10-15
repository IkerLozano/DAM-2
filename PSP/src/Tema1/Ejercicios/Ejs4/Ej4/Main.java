package Tema1.Ejercicios.Ejs4.Ej4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main implements Runnable{


    boolean productor = true;
    static Queue<Integer> cola = new LinkedList<>();

    public Main(Queue<Integer> cola, boolean productor) {
        this.productor = productor;
        this.cola = cola;
    }



    public static void main(String[] args) throws InterruptedException {


        Thread h1P = new Thread(new Main(cola, true));
        Thread h2P = new Thread(new Main(cola, true));
        Thread h1C = new Thread(new Main(cola, false));
        Thread h2C = new Thread(new Main(cola, false));

        h1P.start();
        h2P.start();
        h1C.start();
        h2C.start();


        if (cola.size() >= 5){
            h1P.wait();
            h2P.wait();
        }

        if (cola.isEmpty()){
            h1C.wait();
            h2C.wait();
        }



    }

    @Override
    public void run() {



        if (productor){

            for (int i = 0; i <10 ; i++) {
                Random random = new Random();
                int num = random.nextInt();

                cola.offer(num);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }else{
            System.out.println(cola.poll());

            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
