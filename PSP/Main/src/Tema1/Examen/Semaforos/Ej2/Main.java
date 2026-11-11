package Tema1.Examen.Semaforos.Ej2;

public class Main {

    public static void main(String[] args) {


        for (int i = 0; i <12 ; i++) {

            new Thread(new Impresora("Empleado " + (i+1))).start();
        }

    }
}
