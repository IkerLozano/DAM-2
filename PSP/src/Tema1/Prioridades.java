package Tema1;

public class Prioridades implements Runnable {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Prioridades(), "Hilo 1");
        Thread t2 = new Thread(new Prioridades(), "Hilo 2");
        Thread t3 = new Thread(new Prioridades(), "Hilo 3");

        // Cambiamos las prioridades
        t1.setPriority(Thread.MIN_PRIORITY);  // 1
        t2.setPriority(8);                    // 8
        t3.setPriority(Thread.MAX_PRIORITY); // 10

        // Mostramos las prioridades
        System.out.println("Prioridad t1: " + t1.getPriority());
        System.out.println("Prioridad t2: " + t2.getPriority());
        System.out.println("Prioridad t3: " + t3.getPriority());

        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {
        Thread hiloActual = Thread.currentThread();

        System.out.println("Nombre: " + hiloActual.getName());
        System.out.println("Prioridad: " + hiloActual.getPriority());
    }
}