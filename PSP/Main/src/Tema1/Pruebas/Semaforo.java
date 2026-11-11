
package Tema1.Pruebas;

import java.util.concurrent.Semaphore;

public class Semaforo implements Runnable {

    // Número de procesos disponibles
    private static final int AVAILABLE_THREADS = 4;

    // Semáforo
    private static final Semaphore semafore = new Semaphore(AVAILABLE_THREADS);

    // Nombre del proceso
    private final String name;

    // Constructor
    public Semaforo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            // Pedimos permiso
            semafore.acquire();
            /*
                Si hay permisos disponibles, el hilo consigue uno y continúa.
                Si no quedan permisos, el hilo se queda esperando hasta que otro lo libere.
             */


            System.out.println("Executing process: " + name);

            Thread.sleep(1000);

            System.out.println("End: " + name);

            // Liberamos el permiso
            semafore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {

        // Lanzamos 20 procesos
        for (int i = 0; i < 20; i++) {
            new Thread(new Semaforo(Integer.toString(i + 1))).start();
        }
    }
}
