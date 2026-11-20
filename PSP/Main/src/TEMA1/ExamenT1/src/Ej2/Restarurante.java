package TEMA1.ExamenT1.src.Ej2;

import java.util.Queue;

public class Restarurante{



    static Queue<Trabajo> cola;


    public Restarurante(Queue<Trabajo> cola) {
        this.cola = cola;
    }

    public static void main(String[] args) {


        Thread h1 = new Thread(new Cocinero(cola));
        Thread h2 = new Thread(new Cocinero(cola));
        Thread h3 = new Thread(new Cocinero(cola));
        Thread h4 = new Thread(new Camarero(cola));
        Thread h5 = new Thread(new Camarero(cola));


        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
    }




}
