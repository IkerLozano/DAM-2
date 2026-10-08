package Tema1.Ejercicios.Ejs3;

public class Ej3 implements Runnable {

    String mensaje;

    public Ej3(String mensaje) {
        this.mensaje = mensaje;
    }

    public static void main(String[] args) throws InterruptedException {

            //creo los hilos
            Thread hilo1 = new Thread(new Ej3("Hola"), "Hilo 1");
            Thread hilo2 = new Thread(new Ej3("Mundo"), "Hilo 2");

            //los inicio
            hilo1.start();
            hilo2.start();

            //esto es lo que hace el hilo pricipial (main) sobre los otros hilos
            Thread.sleep(5000); //el hilo principal espera 5 segundos.
            hilo1.interrupt(); //el hilo principal le dice a hilo1: "interrúmpete"


    }

    //aqui pongo lo que van a ahcer los hilos
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
