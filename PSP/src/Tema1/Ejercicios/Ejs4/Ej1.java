package Tema1.Ejercicios.Ejs4;

public class Ej1 implements Runnable{

    String mensaje;

    public Ej1(String mensaje) {
        this.mensaje = mensaje;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread h1 = new Thread(new Ej1("Hola"),"Hilo1");
        Thread h2 = new Thread(new Ej1("DAM"), "Hilo2");

        h1.start();

        h2.sleep(50); //0.05seg

        h2.start();


        //esero 5 seg e interrumpo los hilos
       Thread.sleep(5000);
       h1.interrupt();
       h2.interrupt();

        //el main espera q termien los hilos para mostar el mensaje
        h1.join();
        h2.join();

        System.out.println("Programa finalizado");




    }

    @Override
    public void run() {


        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName() + " --> " + mensaje);


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("El hilo " + "'" + Thread.currentThread().getName()  +"'" +  " ha sido interrumpido");
                return;
            }
        }

    }
}
