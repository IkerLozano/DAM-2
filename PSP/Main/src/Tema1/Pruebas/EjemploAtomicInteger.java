
package Tema1.Pruebas;

import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAtomicInteger {


    // 1. Creamos un contador atómico que empieza en 0.
    static AtomicInteger contador = new AtomicInteger(0);

    public static void main(String[] args) {

        // 2. Creamos el primer hilo.
        Thread hilo1 = new Thread(() -> {

            // Incrementamos el contador 5 veces.
            for (int i = 0; i < 5; i++) {
                int nuevoValor = contador.incrementAndGet();

                System.out.println("Hilo 1 incrementa: " + nuevoValor);

            }
        });


        // 3. Creamos el segundo hilo.
        Thread hilo2 = new Thread(() -> {

            // Incrementamos el contador 5 veces.
            for (int i = 0; i < 5; i++) {
                int nuevoValor = contador.incrementAndGet();

                System.out.println("Hilo 2 incrementa: " + nuevoValor);
            }
        });


        // 4. Creamos el tercer hilo.
        Thread hilo3 = new Thread(() -> {

            // Decrementamos el contador 3 veces.
            for (int i = 0; i < 3; i++) {
                int nuevoValor = contador.decrementAndGet();

                System.out.println("Hilo 3 decrementa: " + nuevoValor);
            }
        });


        // 5. Iniciamos los tres hilos.
        hilo1.start();
        hilo2.start();
        hilo3.start();

        try {
            // 6. Esperamos a que terminen los tres hilos.
            hilo1.join();
            hilo2.join();
            hilo3.join();

        } catch (InterruptedException e) {
            System.out.println("Se ha interrumpido un hilo.");
            Thread.currentThread().interrupt();
        }

        // 7. Consultamos el valor final del contador.
        System.out.println("Valor final: " + contador.get());
    }
}
