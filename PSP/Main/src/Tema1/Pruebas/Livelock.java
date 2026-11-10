package Tema1.Pruebas;

public class Livelock {

    static boolean recursoDisponible = true;

    public static void main(String[] args) {

        Thread hilo1 = new Thread(() -> {
            while (!recursoDisponible) {
                System.out.println("Hilo 1: vuelvo a intentarlo");
            }

            System.out.println("Hilo 1: tarea realizada");
        });

        Thread hilo2 = new Thread(() -> {
            while (!recursoDisponible) {
                System.out.println("Hilo 2: vuelvo a intentarlo");
            }

            System.out.println("Hilo 2: tarea realizada");
        });

        hilo1.start();
        hilo2.start();
    }

}
