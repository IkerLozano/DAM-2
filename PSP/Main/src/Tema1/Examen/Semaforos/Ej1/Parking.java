package Tema1.Examen.Semaforos.Ej1;

import java.util.concurrent.Semaphore;

public class Parking implements Runnable{

    //id
    private String nombre;

    //constructor
    public Parking(String nombre) {
        this.nombre = nombre;
    }

    //numeros de procesos
    private static final int AVAILABLE_THREADS = 3;

    //semaforo
    private static final  Semaphore semaforo = new Semaphore(AVAILABLE_THREADS);


    @Override
    public void run() {

        try {
            semaforo.acquire();

            System.out.println("El coche " + nombre + " ha entrado al parking");

            Thread.sleep(200);

            System.out.println("El coche " + nombre + " ha salido del parking");


        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }finally {

            semaforo.release();
        }


    }
}
