package Tema1.Examen.Semaforos.Ej1;

public class Main {

    public static void main(String[] args) {


        for (int i = 0; i <15 ; i++) {
            new Thread(new Parking("hilo"+ (i+1))).start();

        }

    }
}
