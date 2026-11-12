package Tema1.Examen.Variados.Ej4;

import Tema1.Examen.Ej1_ParcductorConsumidor.Consumidor;

public class Main {

    static ColaTrabajos colaTrabajos = new ColaTrabajos();

    public Main(ColaTrabajos colaTrabajos) {
        this.colaTrabajos = colaTrabajos;
    }

    public static void main(String[] args) {

        Thread h1 = new Thread(new Productor(colaTrabajos), "[Productor - 1]");
        Thread h2 = new Thread(new Productor(colaTrabajos), "[Productor - 2]");
        Thread h3 = new Thread(new Consumirdor(colaTrabajos), "[Consumidor - 1]");
        Thread h4 = new Thread(new Consumirdor(colaTrabajos), "[Consumidor - 2]");

        h1.start();
        h2.start();
        h3.start();
        h4.start();



    }
}
