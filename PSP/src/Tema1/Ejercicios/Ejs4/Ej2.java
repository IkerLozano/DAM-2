package Tema1.Ejercicios.Ejs4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ej2 implements Runnable{

    List<String> mensajes = new ArrayList<>(Arrays.asList("Inicio del programa", "Procesos", "Servicios", "Multihilo", "Sincronización", "Fin del programa"));


    public static void main(String[] args) throws InterruptedException {

        long incio = System.currentTimeMillis();

        Scanner sc = new Scanner(System.in);

        System.out.println("Cuanto tiempo esperar el main");
        int tiempo = sc.nextInt();

        Thread h1 = new Thread(new Ej2(), "Hilo secundario");

        h1.start();

        int cont = 0;
        while (h1.isAlive()){

            //cuando llegue a los seg indicados lo interrumpo
            if (cont == tiempo){
                h1.interrupt();
            }

            System.out.println(Thread.currentThread().getName() + " --> Hilo principal esperando...");

            Thread.sleep(1000);

            //cont para los segundos
            cont = cont +1;


        }



        //el main espera q termine el h1
        h1.join();

        long fin = System.currentTimeMillis();

        long tiempo2 = fin-incio;
        System.out.println(Thread.currentThread().getName() + "--> El programa se a ejecutado durante " + tiempo2/1000 + " segundos");



    }

    @Override
    public void run() {

        boolean interumpido = false;

        for (int i = 0; i <mensajes.size(); i++) {

            //si el hilo es interrumoido muestro los ensajes sin esperar
            if (interumpido){
                System.out.println(Thread.currentThread().getName()+ "--> " + mensajes.get(i));

                //el no es interrumido muestro los mensajes esperando 3s
            }else{

                System.out.println(Thread.currentThread().getName()+ "--> " + mensajes.get(i));

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    interumpido = true;
                }
            }



        }

    }
}
