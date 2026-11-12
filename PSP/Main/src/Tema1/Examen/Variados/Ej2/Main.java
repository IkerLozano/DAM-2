package Tema1.Examen.Variados.Ej2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main implements Runnable{

    public static void main(String[] args) throws InterruptedException {

            long inicio = System.currentTimeMillis();

            Scanner sc = new Scanner(System.in);
            System.out.println("Cuntos seg espero");
            int seg = sc.nextInt();

            Thread h1 = new Thread(new Main(), "[Hilo Segundario]");

            h1.start();

            int cont = 0;
            while (h1.isAlive()) {

                if (cont == seg){
                    h1.interrupt();

                }

                Thread.currentThread().sleep(1000);
                System.out.println("Main - El main está esperando");
                cont++;


            }

            h1.join();

            long fin = System.currentTimeMillis();

            long timepo = fin-inicio;
            System.out.println("El programa se a ejecutado durante " + timepo/1000 + " segundos");


    }

    @Override
    public void run() {
        List<String> palabras = new ArrayList<>(Arrays.asList("Inicio del programa", "Procesos", "Servicios", "Multihilo", "Sincronización", "Fin del programa"));

        boolean interrmpido = false;

        for (int i = 0; i <palabras.size() ; i++) {

            if (interrmpido) {

                System.out.println(Thread.currentThread().getName() + palabras.get(i));

            }else{


                System.out.println(Thread.currentThread().getName() + palabras.get(i));


                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    interrmpido = true;
                }
            }




        }



    }
}
