package Tema1;

public class hilos_sleep implements  Runnable{

    public static void main(String[] args) {


        Thread hilo = new Thread(new hilos_sleep());
        hilo.start();

        //creo el hilo y entra en el metodo

    }

    @Override
    public void run() {

        try {
            //duermo el hilo 3 seg y después de los 3 seg dira Hola
            Thread.sleep(3000);
            System.out.println("Hola");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}


