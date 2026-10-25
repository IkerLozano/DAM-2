
package Tema1.Pruebas;

import java.util.concurrent.CountDownLatch;

public class Semaforos2 {

    public static void main(String[] args) {

        // Cada CountDownLatch empieza con una cuenta de 1.
        // Cuando la cuenta llega a 0, los hilos que esperan pueden continuar.
        CountDownLatch countDownPhase1 = new CountDownLatch(1);
        CountDownLatch countDownPhase2 = new CountDownLatch(1);

        // Hilo P1: escribe "Hello"
        Thread p1 = new Thread(() -> {System.out.print("Hello ");

            // Indicamos que la fase 1 ha terminado.
            // La cuenta pasa de 1 a 0.
            countDownPhase1.countDown();
        });

        // Hilo P2: escribe "world!"
        Thread p2 = new Thread(() -> {
            try {
                // P2 espera hasta que P1 termine su fase.
                countDownPhase1.await();

                System.out.print("world!");

                // Indicamos que la fase 2 ha terminado.
                countDownPhase2.countDown();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Iniciamos los dos hilos.
        p1.start();
        p2.start();

        try {
            // El hilo principal espera a que termine la fase 2.
            countDownPhase2.await();

            System.out.println("\nFin del programa.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    /*
        await()	Espera hasta que la cuenta llegue a cero.
        countDown()	Resta uno a la cuenta. Si llega a cero, permite continuar a los hilos que esperan.
     */
}
