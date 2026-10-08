package Tema1;

public class Contador {

    // Este es el recurso COMPARTIDO.
    // Los dos hilos van a modificar este contador.
    private int c = 0;

    // synchronized hace que solo UN hilo pueda ejecutarlo
    public  void incrementar() {
        c++;

        // Mostramos qué hilo está modificando el contador
//        System.out.println(
//                Thread.currentThread().getName()
//                        + " → contador = " + c
//        );
    }

    public int getValor() {
        return c;
    }


}
