
package Tema1.Pruebas;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class Locks {

    // Recurso compartido: cuenta bancaria
    static class Cuenta {

        private int saldo = 1000;

        // Creamos el bloqueo que controla el acceso al saldo
        private final Lock lock = new ReentrantLock();;

        public void ingresar(int cantidad) {

            // 1. Intentamos adquirir el bloqueo.
            // Si otro hilo lo tiene, esperamos hasta que se libere.
            lock.lock();
            /*
                Si el hilo 2 o el hilo 3 llaman a lock.lock() mientras el hilo 1
                tiene el bloqueo, tendrán que esperar.
             */


            /*
                try:
                Contiene el código que ejecutamos mientras tenemos adquirido el bloqueo.
                Aquí colocamos la sección crítica.
             */
            try {
                // 2. SECCIÓN CRÍTICA:
                // Solo el hilo que tiene el bloqueo puede entrar aquí.
                saldo += cantidad;

                System.out.println(Thread.currentThread().getName() + " ingresa " + cantidad + " €. Saldo: " + saldo + " €");

            } finally {
                // 3. Liberamos el bloqueo al terminar.
                // Así, otro hilo podrá entrar en la sección crítica.
                lock.unlock();
                /*
                    Porque ponemos finally:
                    Porque, si el hilo adquiere el bloqueo y después ocurre un error,
                    podría dejarlo bloqueado si no lo libera.
                 */
            }
        }

        // Consultamos el saldo utilizando también el bloqueo
        public int getSaldo() {

            lock.lock();

            try {
                return saldo;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // Los tres hilos compartirán la MISMA cuenta y el MISMO bloqueo
        Cuenta cuenta = new Cuenta();

        Thread h1 = new Thread(() -> cuenta.ingresar(100), "Hilo 1");
        Thread h2 = new Thread(() -> cuenta.ingresar(200), "Hilo 2");
        Thread h3 = new Thread(() -> cuenta.ingresar(300), "Hilo 3");

        // Iniciamos los tres hilos
        h1.start();
        h2.start();
        h3.start();

        // Esperamos a que terminen antes de consultar el saldo
        h1.join();
        h2.join();
        h3.join();

        System.out.println("Saldo final: " + cuenta.getSaldo() + " €");
    }
}
