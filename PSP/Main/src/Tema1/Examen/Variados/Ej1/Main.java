package Tema1.Examen.Variados.Ej1;

public class Main implements Runnable{


    private String mensaje;

    public Main(String mensaje) {
        this.mensaje = mensaje;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread h1 = new Thread(new Main("Hola"), "Hilo1");
        Thread h2 = new Thread(new Main("DAM"), "Hilo2");

        h1.start();

        Thread.sleep(50);

        h2.start();


        Thread.sleep(5000);
        h1.interrupt();
        h2.interrupt();


        h1.join();
        h2.join();

        System.out.println("Programa finalizado");

    }

    @Override
    public void run() {

        for (int i = 0; i <10 ; i++) {

            System.out.println(Thread.currentThread().getName() + " - " +  mensaje);


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("El hilo a sido interrumpido");
                return;
            }

        }


    }


}
