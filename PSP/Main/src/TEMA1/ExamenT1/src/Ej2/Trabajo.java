package TEMA1.ExamenT1.src.Ej2;


import java.util.LinkedList;
import java.util.Queue;

public class Trabajo{


    static Queue<Integer> cola = new LinkedList<>();

    public Trabajo() {
    }

    public void preparar(int num) throws InterruptedException {


        if (cola.isEmpty()){

            wait();
        }

        System.out.printf("El cocinero" + Thread.currentThread().getName() + " empieza a preparar el pedido" + num);
        cola.add(num);
        System.out.printf("El cocinero" + Thread.currentThread().getName() + " ya a preparar el pedido" + num);

        notifyAll();



    }


    public synchronized void repartir(int num) throws InterruptedException {


        if (cola.size() == 5){

            wait();
        }


        System.out.printf("El camarero" + Thread.currentThread().getName() + " entrega el pedido" + cola.poll());

        notifyAll();



    }
}
