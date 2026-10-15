package Tema1.Ejercicios.Ejs4.Ej4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main implements Runnable{


    boolean productor = true;
    static Queue<Integer> cola = new LinkedList<>();
    static ColaTrabajos ct = new ColaTrabajos(cola);

    public Main(ColaTrabajos ct, boolean productor) {
        this.ct = ct;
        this.productor = productor;
    }

    public static void main(String[] args) throws InterruptedException {


        Thread h1P = new Thread(new Main(ct, true), "Hilo 1P");
        Thread h2P = new Thread(new Main(ct, true), "Hilo 2P");
        Thread h1C = new Thread(new Main(ct, false), "Hilo 1C");
        Thread h2C = new Thread(new Main(ct, false), "Hilo 2C");

        h1P.start();
        h2P.start();
        h1C.start();
        h2C.start();

    }

    @Override
    public void run() {



        if (productor){

            try {
                ct.anadir();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }else{

            try {
                ct.sacar();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }



    }
}
