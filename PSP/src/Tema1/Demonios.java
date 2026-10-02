package Tema1;

public class Demonios implements Runnable {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new Demonios());

        // Convertimos el hilo en demonio
        t.setDaemon(true);

        // Comprobamos si es demonio
        System.out.println("¿Es demonio? " + t.isDaemon());

        // Iniciamos el hilo
        t.start();

        // El main trabaja durante 3 segundos
        Thread.sleep(3000);

        System.out.println("El main ha terminado");
    }

    @Override
    public void run() {

        while (true) {
            System.out.println("El hilo demonio está trabajando...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}