
package Tema1.Pruebas;

import java.util.concurrent.Semaphore;

public class Semaforos implements Runnable{

    // Número de procesos que pueden ejecutarse en paralelo
    private static final int AVAILABLE_THREADS = 4; //maximo 4 hilos a la vez

    // Crear el semáforo con los 4 accesos
    private static final Semaphore semafore = new Semaphore(AVAILABLE_THREADS);
        //static: todos los objetos de esta clase comparten el mismo semáforo

    // Nombre del proceso
    private final String name;

    // Constructor
    public Semaforos(String name) {
        this.name = name;
    }



    //MAIN
    public static void main(String[] args) {
        // Lanzamos 20 procesos
        for (int i = 0; i < 20; i++) {
            new Thread(new Semaforos(Integer.toString(i + 1))).start();
        }
    }



    @Override
    public void run() {
        try {
            // Pedimos permiso al semáforo para continuar
            //Cada hilo pide un permiso al semáforo. Los cuatro primeros pueden entrar
            //Los otros 16 tienen que esperar mientras no haya permisos libres.
            semafore.acquire();

            System.out.println("Executing process: " + name);


            Thread.sleep(1000);//aunq este durmiendo sigue teniendo su permiso en el semaforo

            System.out.println("End: " + name);

            // Liberamos el permiso al terminar
            //Cuando un hilo termina su trabajo, libera el permiso y otro hilo que esperaba puede entrar.
            semafore.release();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


}
