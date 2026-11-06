package Tema1.Pruebas;

public class Deadlock {

    static Object recursoA = new Object();
    static Object recursoB = new Object();

    public static void main(String[] args) {

        // HILO 1
        Thread hilo1 = new Thread(() -> {

            synchronized (recursoA) {
                System.out.println("Hilo 1: tiene el recurso A");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    return;
                }

                System.out.println("Hilo 1: espera el recurso B");

                synchronized (recursoB) {
                    System.out.println("Hilo 1: tiene A y B");
                }
            }
        });

        // HILO 2
        Thread hilo2 = new Thread(() -> {

            /*
             * CÓDIGO QUE PROVOCABA EL DEADLOCK:
             *
             * synchronized (recursoB) {
             *     System.out.println("Hilo 2: tiene el recurso B");
             *
             *     try {
             *         Thread.sleep(100);
             *     } catch (InterruptedException e) {
             *         return;
             *     }
             *
             *     System.out.println("Hilo 2: espera el recurso A");
             *
             *     synchronized (recursoA) {
             *         System.out.println("Hilo 2: tiene B y A");
             *     }
             * }
             *
             * ¿POR QUÉ PROVOCABA EL DEADLOCK?
             *
             * Hilo 1: bloquea A y espera B.
             * Hilo 2: bloquea B y espera A.
             *
             * Cada hilo espera un recurso que tiene el otro.
             * Por eso, ninguno puede continuar.
             */

            // SOLUCIÓN: adquirir los recursos en el mismo orden que el hilo 1.
            // Primero A y después B.

            synchronized (recursoA) {
                System.out.println("Hilo 2: tiene el recurso A");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    return;
                }

                System.out.println("Hilo 2: espera el recurso B");

                synchronized (recursoB) {
                    System.out.println("Hilo 2: tiene A y B");
                }
            }
        });


        //esta uno dentro dentro de otra para poder tener los dos recursos a la vez

        hilo1.start();
        hilo2.start();
    }
}