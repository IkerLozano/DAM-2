package Tema1.PrcaticaEvaluable.Ej1;

public class Main extends Descargador{

    public Main(GestorDescargas ref, String nombre) {
        super(ref, nombre);
    }

    public static void main(String[] args) throws InterruptedException {


        GestorDescargas gd = new GestorDescargas();

        Thread h1 = new Thread(new Main(gd, "Arcivo1"), "Hilo 1");
        Thread h2 = new Thread(new Main(gd, "Arcivo2"), "Hilo 2");
        Thread h3 = new Thread(new Main(gd, "Arcivo3"), "Hilo 3");
        Thread h4 = new Thread(new Main(gd, "Arcivo4"), "Hilo 4");
        Thread h5 = new Thread(new Main(gd, "Arcivo5"), "Hilo 5");
        Thread h6 = new Thread(new Main(gd, "Arcivo6"), "Hilo 6");

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
        h6.start();

        h3.interrupt();

        h1.join();
        h2.join();
        h3.join();
        h4.join();
        h5.join();
        h6.join();

        gd.descargasCompletada();




    }
}
