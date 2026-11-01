package Tema1.Pruebas;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Executors2 {

    public static void main(String[] args) {

        // 1. Creo un gestor de tareas que puede utilizar hasta 2 hilos.
        ExecutorService executor = Executors.newFixedThreadPool(2);

        //2. Creamos una tarea Callable que devuelve un Integer
        //esta tarea tarda 2 seg y devuelve un numero
        //Callable --> indica que es una tarea que puede devolver algo.
        Callable<Integer> tarea = () -> {

            System.out.println("Calculando multiplicación...");

            Thread.sleep(2000);

            return 5 * 3;
        };


        // 3. Enviamos la tarea al gestor para que la ejecute
        //submit() nos devuelve un objeto Future que representa el resultado de esa tarea
        Future<Integer> resultado = executor.submit(tarea);

        System.out.println("La tarea se ha enviado.");


        try {

            // 4. Obtenemos el resultado
            // Si todavía no ha terminado, get() espera hasta que termine
            Integer numero = resultado.get();

            System.out.println("Resultado: " + numero);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

        } catch (Exception e) {

            e.printStackTrace();

        } finally { //se ejecuta siempre

            // 5. Cerramos el gestor
            executor.shutdown();
        }
    }
}