package Tema1.Ejercicios.Ejs3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ej4_part2 implements Runnable{

    //lo creo aquí fuera para el metodo pueda acceder al array
    List<String> palabras = new ArrayList(Arrays.asList("Programas", "Procesos", "Servicios", "Hilos"));


    public static void main() throws InterruptedException {

        long inicio  = System.currentTimeMillis(); //para saber cuando empieza a ejecutarse el progarama
                                                    //al ponerlo encima del Scanner mido toodo el tiempo de ejecución

        Scanner sc = new Scanner(System.in);

        System.out.println("Cuanto tiempo quieres que espere el main");
        int tiempo = sc.nextInt();


        //creo el hilo
        Thread hilo = new Thread(new Ej4_part2());
        hilo.start();


        //esto se va a ejecutar mienstras el hilo1 este vivo y cuado entre el main se quedar esperando un seg
        int cont = 0;
        while (hilo.isAlive()){ //comprueba si un hilo sigue ejecutándose (devulve true/false)


            //si llego al tiempo maximo de espera, interrumpo el hilo, espero a que termine y salgo del while
            if (cont == tiempo){
                hilo.interrupt();
                hilo.join();
                break;
            }

            //si no es igual no interrumpo y sigo esperando
            cont++;
            hilo.join(1000); //hago que el main espere 1 seg hasta q termine el hilo1, hace que el main se quede bloqueado
            System.out.println("Hilo " + Thread.currentThread().getName()  + " -->  Esperando " + cont + " segundos");
        }


        if (!hilo.isAlive()){
            System.out.println("Hilo " + Thread.currentThread().getName() + " --> Proceso terminado");
            long fin  = System.currentTimeMillis(); //para saber cuando acaba a ejecutarse el progarama
            long result = (fin-inicio)/1000; //cálculo y divio àrsa psar de miliegundos a seg
            System.out.println("Hilo " + Thread.currentThread().getName() + " --> El programa se a ejecutado durante " + result + " segundos");
        }
    }




    @Override
    public void run() {

        boolean interrumpido = false;


        for (int i = 0; i <palabras.toArray().length ; i++) {

            //si el hilo a sido interrumpido imprimo las palabras sin esperar
            if (Thread.currentThread().isInterrupted() | interrumpido){
                System.out.println("Hilo " + Thread.currentThread().getName() + " --> " + palabras.get(i));

            }else{
                //si el ilo no a sdio interrumpido espero 4 seg entre cada palabra
                System.out.println("Hilo " + Thread.currentThread().getName() + " --> " + palabras.get(i));

                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                   interrumpido = true; //si el hilo a sido interrumpido va a llegar aqui asi que con esto lo mando al if
                }
            }



        }
    }

}
