
package Tema1.Pruebas;

public class Monitores {

    // Recurso compartido: cuenta bancaria
    static class Cuenta {

        private int saldo = 1000;

        // Metodo sincronizado: solo un hilo puede ejecutarlo a la vez sobre este mismo objeto.
        public synchronized void ingresar(int cantidad) {
            saldo += cantidad;

            System.out.println(Thread.currentThread().getName() + " ingresa " + cantidad + " €. Saldo: " + saldo + " €");

        }

        // Metodo sincronizado para consultar el saldo
        public synchronized int getSaldo() {
            return saldo;
        }
    }

    public static void main(String[] args)
            throws InterruptedException {

        // Creamos el monitor que controla la cuenta, contiene el recurso compartido
        Cuenta cuenta = new Cuenta();

        // Creamos tres hilos que comparten la misma cuenta
        Thread h1 = new Thread(() -> cuenta.ingresar(100), "Hilo 1");
        Thread h2 = new Thread(() -> cuenta.ingresar(200), "Hilo 2");
        Thread h3 = new Thread(() -> cuenta.ingresar(300), "Hilo 3");

        // Iniciamos los hilos
        h1.start();
        h2.start();
        h3.start();

        // Esperamos a que terminen los tres hilos
        h1.join();
        h2.join();
        h3.join();

        // Mostramos el saldo final
        System.out.println("Saldo final: " + cuenta.getSaldo() + " €");
    }
}
