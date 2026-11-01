package Tema1.Pruebas;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Executors3 {

    public static void main(String[] args) {

        // Creamos un gestor que permite programar tareas (2 hilos max)
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);


        // 1. SCHEDULE: ejecutar una sola vez después de 3 segundos
        executor.schedule(() -> {
            System.out.println("Tarea 1: Se ejecuta después de 3 segundos");
        }, 3, TimeUnit.SECONDS); //3 seg de espera


        // 2. SCHEDULE AT FIXED RATE: ejecutar cada 5 segundos
        executor.scheduleAtFixedRate(() -> {
            System.out.println("Tarea 2: Ejecución periódica");
        }, 0, 5, TimeUnit.SECONDS); //con el 0 le inidcamos que empiece inmediatamente


        // 3. SCHEDULE WITH FIXED DELAY: esperar 3 segundos después de terminar
        // desde que termina una ejecución hasta que comienza la siguiente
        executor.scheduleWithFixedDelay(() -> {
            System.out.println("Tarea 3: Ejecución con pausa entre tareas");
        }, 0, 3, TimeUnit.SECONDS);

    }
}