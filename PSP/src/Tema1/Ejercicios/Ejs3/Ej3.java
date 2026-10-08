package Tema1.Ejercicios.Ejs3;

public class Ej3 implements Runnable {

    String mensaje;

    public Ej3(String mensaje) {
        this.mensaje = mensaje;
    }

    public static void main(String[] args) throws InterruptedException {


            Thread hilo1 = new Thread(new Ej3("Hola"), "Hilo 1");
            Thread hilo2 = new Thread(new Ej3("Mundo"), "Hilo 2");

            hilo1.start();
            hilo2.start();

            Thread.sleep(5000);
            hilo1.interrupt();


    }



    @Override
    public void run() {

        for (int i = 0; i < 15; i++) {
            System.out.println(mensaje);


            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Hilo 1 interrumpido");
                return; //termino el hilo1
            }


        }
    }


}
