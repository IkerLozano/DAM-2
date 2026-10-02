package Tema1;

public class Interrupt implements Runnable{

    public static void main(String[] args) throws InterruptedException {

        //esto se ejecuta primero
        Thread t = new Thread(new Interrupt());

        t.start();

        Thread.sleep(2000);

        t.interrupt();


        t.join();
        System.out.println("el hilo a terminado");

    }

    @Override
    public void run() {

        System.out.println("El hilo a comenzado");

        try {

            System.out.println("El hilo se duerme");
            Thread.sleep(5000);
            System.out.println("Han pasado 5 seg");

        }catch (InterruptedException e){
            System.out.println("Me han interrumpido");

            Thread.currentThread().interrupt(); //lo marco como interrumpido para q muestre true

            System.out.println(Thread.currentThread().isInterrupted());
            /*
                   false pq al estar en el catch solo entar si estaba dormido y lo han interrumpido,
                   ya q catch desactive la interrupción. Es que al producirse InterruptedException,
                   Java limpia la condición de interrupción
             */
            // Thread.currentThread() --> Dame el hilo que está ejecutando este código ahora mismo
        }

        System.out.println("El hilo sigue ejecutandose");
    }
}

