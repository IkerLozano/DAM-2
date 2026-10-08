package Tema1.Ejercicios.Ejs3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ej4 implements Runnable{


    //lo creo aqui fuera para el metodo pueda acceder al array
    List<String> palabras = new ArrayList(Arrays.asList("Programas", "Procesos", "Servicios", "Hilos"));


    public static void main() throws InterruptedException {


        Thread hilo = new Thread(new Ej4());
        hilo.start();


        //esto se va a ejecutar mienstras el hilo1 este vivo y cuado entre el main se quedar esperando un seg
        int cont = 0;
        while (hilo.isAlive()){ //comprueba si un hilo sigue ejecutándose (devulve true/false)
            cont++;
            hilo.join(1000); //hago que el main espere 1 seg hasta q termine el hilo1, hace que el main se quede bloqueado
            System.out.println("Esperando " + cont + " segundos");
        }
    }

    @Override
    public void run() {

        for (int i = 0; i <palabras.toArray().length ; i++) {
            System.out.println(palabras.get(i));

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
