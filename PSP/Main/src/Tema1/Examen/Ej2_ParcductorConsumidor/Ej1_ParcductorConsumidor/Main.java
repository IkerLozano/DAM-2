package Tema1.Examen.Ej2_ParcductorConsumidor.Ej1_ParcductorConsumidor;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static ColaTrabajos cola = new ColaTrabajos();

    public static void main(String[] args) {


        Thread h1 = new Thread(new Productor(cola), "[Productor-1]");
        Thread h2 = new Thread(new Productor(cola), "[Productor-2]");
        Thread h3 = new Thread(new Consumidor(cola), "[Consumidor-1]");
        Thread h4 = new Thread(new Consumidor(cola), "[Consumidor-2]");

        h1.start();
        h2.start();
        h3.start();
        h4.start();

    }
}
