package Tema1.Examen.Semaforos.Ej2;

import java.util.concurrent.Semaphore;

public class Impresora implements Runnable{

    private String nombreEmp;

    public Impresora(String nombreEmp) {
        this.nombreEmp = nombreEmp;
    }

    static private int AVAILABLE_THREADS = 2;

    static private Semaphore semaphore = new Semaphore(AVAILABLE_THREADS);


    @Override
    public void run() {


        try {
            semaphore.acquire();

            System.out.println("El empleado " + nombreEmp + " esta imprimiendo");

            Thread.sleep(3000);

            System.out.println("El empleado " + nombreEmp + " ha terminado de imprimir");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }finally {
            semaphore.release();
        }

    }
}
