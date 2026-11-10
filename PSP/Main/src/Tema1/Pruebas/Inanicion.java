package Tema1.Pruebas;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Inanicion {

    static Lock recurso = new ReentrantLock(true); //crear el recurso compartido
    /*
        Lock: representa un bloqueo que permite controlar el acceso a un recurso.
        ReentrantLock: es la clase que implementa ese bloqueo.
        true: Para reducir el riesgo de que un hilo se adelante continuamente a otros que llevan esperando.
     */

    public static void main(String[] args) {

        Runnable tarea = () -> {

            for (int i = 0; i < 5; i++) {

                recurso.lock();
                /*
                Quiero conseguir el bloqueo para utilizar el recurso.
                    - Si está libre, el hilo lo consigue.
                    - Si otro hilo lo tiene, el hilo espera hasta que pueda conseguirlo.
                 */


                try {

                    System.out.println(Thread.currentThread().getName() + " está utilizando el recurso");

                } finally {
                    recurso.unlock(); //ibera el bloqueo para que otro hilo pueda conseguirlo, esto es importante
                }
            }
        };

        Thread hiloA = new Thread(tarea, "Hilo A");
        Thread hiloB = new Thread(tarea, "Hilo B");
        Thread hiloC = new Thread(tarea, "Hilo C");

        hiloA.start();
        hiloB.start();
        hiloC.start();
    }
}