package Tema1;

public class PruebaContador {

    public static void main(String[] args) throws InterruptedException {

        Contador contador = new Contador();

        // Creamos el primer hilo
        Thread t1 = new Thread(() -> {

            // Este hilo va a incrementar el contador 5 veces
            for (int i = 0; i < 10000000; i++) {
                contador.incrementar();
            }

        });


        // Creamos el segundo hilo
        Thread t2 = new Thread(() -> {


            // Este hilo también va a incrementar el contador 5 veces
            for (int i = 0; i < 10000000; i++) {
                contador.incrementar();
            }

        });

        // Iniciamos los dos hilos
        t1.start();
        t2.start();

        // El main espera a que termine el Hilo A
        t1.join();
        // El main espera a que termine el Hilo B
        t2.join();


        // Cuando los dos hilos han terminado, mostramos el resultado final.
        System.out.println("Resultado: " + contador.getValor());
    }

}
