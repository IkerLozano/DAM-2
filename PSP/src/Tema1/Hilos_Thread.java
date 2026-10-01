package Tema1;

public class Hilos_Thread extends Thread{

    public static void main(String[] args) {

        Thread t = new Thread(new Hilos_Thread());
        t.start();


    }

    @Override
    public void run() {
        System.out.println("hola desde el hilo");
    }
}


