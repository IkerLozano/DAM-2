
package Tema1.Pruebas;

import java.util.concurrent.Executor;

public class Executors1 {

    public static void main(String[] args) {

        // Creamos un Executor que ejecuta cada tarea en un hilo nuevo.
        Executor e = r -> new Thread(r).start();
        /*
            e: es el nombre de nuestro objeto.
            r: representa la tarea que queremos ejecutar. En este caso, será un Runnable.
            new Thread(r).start(): crea un hilo nuevo para ejecutar esa tarea
         */


        // Creamos la primera tarea
        Runnable tarea1 = () -> {System.out.println("Ejecutando tarea 1");};

        // Creamos la segunda tarea
        Runnable tarea2 = () -> {System.out.println("Ejecutando tarea 2");};

        // Enviamos las tareas al Executor para que las ejecute
        e.execute(tarea1);
        e.execute(tarea2);

        System.out.println("Fin del main");
    }
}
