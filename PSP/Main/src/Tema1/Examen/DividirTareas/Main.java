package Tema1.Examen.DividirTareas;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        //int hilos = Runtime.getRuntime().availableProcessors();


        //indico los hilos con los que voy a trabajar
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

        // Lista donde guardaré los objetos que representan las tareas
        List<Tareas> tareas = new ArrayList<>();



        //lista con los numeros
        ArrayList<Integer> nums = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i <100000 ; i++) {

            int num = random.nextInt(1, 1001);
            nums.add(num);

        }


        // Divido la lista principal en 4 sublistas
        List<List<Integer>> sublistas = sublistas(nums, 4);


        // Recorro las sublistas para crear una tarea para cada una
        for (List<Integer> l : sublistas){


            tareas.add(new Tareas(l)); //Creo un objeto Tareas y le paso una sublista
        }


        // Lista donde guardaré los resultados de las tareas
        // Cada Future<Integer> representa el resultado de una tarea
        List<Future<Integer>> resultList;

        // Envío todas las tareas al ExecutorService
        // invokeAll espera a que todas las tareas terminen
        resultList = executor.invokeAll(tareas);

        //Indico que no voy a enviar más tareas al ExecutorService
        executor.shutdown();


        //Recorro los resultados que ha devuelto cada tarea
        int total = 0;
        for (int i = 0; i <resultList.size() ; i++) {

            Future<Integer> resp = resultList.get(i);
            System.out.println("Result of task " + i + " is:" + resp.get());// get() obtiene el resultado que ha devuelto el metodo call()


            total+= resp.get();

        }

        System.out.println("El total es: " + total);



    }

    //funcion que divide la lista en listas de partes iguales, para darle cada lista cada tarea
    public static List<List<Integer>> sublistas(ArrayList<Integer> lista, int numPartes){


        List<List<Integer>> partes = new ArrayList<>();

        int total = lista.size();
        int base = total / numPartes;
        int resto = total % numPartes;

        int inicio = 0;
        for (int i = 0; i < numPartes; i++) {

            int size = base + ((i < resto) ? 1 : 0);
            partes.add(new ArrayList<>(lista.subList(inicio, inicio + size)));
            inicio += size;
        }


        return partes;

    }
}
