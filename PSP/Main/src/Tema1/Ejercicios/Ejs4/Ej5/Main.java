package Tema1.Ejercicios.Ejs4.Ej5;

import java.util.ArrayList;

public class Main {

    static Clasificacion clasi = new Clasificacion();

    public static void main(String[] args) throws InterruptedException {


        Thread h1 = new Thread(new Corredor(0,20, clasi), "hilo 1");
        Thread h2 = new Thread(new Corredor(0,20, clasi), "hilo 2");
        Thread h3 = new Thread(new Corredor(0,20, clasi), "hilo 3");
        Thread h4 = new Thread(new Corredor(0,20, clasi), "hilo 4");


        h1.start();
        h2.start();
        h3.start();
        h4.start();

        h1.join();
        h2.join();
        h3.join();
        h4.join();


        clasi.mostrarClasificacion();


    }

}
