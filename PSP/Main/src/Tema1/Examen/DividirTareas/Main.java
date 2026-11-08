package Tema1.Examen.DividirTareas;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        //int hilos = Runtime.getRuntime().availableProcessors();

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

        //tareas que queremos ejecutar
        List<Tareas> tareas = new ArrayList<>();

        //lista con los numeros
        ArrayList<Integer> nums = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i <100000 ; i++) {

            int num = random.nextInt(1, 1001);
            nums.add(num);

        }

        //divido la lista principal en listas mas pequeñas (en 4)
        List<List<Integer>> sublistas = sublistas(nums, 4);


        for (List<Integer> l : sublistas){


            tareas.add(new Tareas(l));
        }


        List<Future<Integer>> resultList;
        resultList = executor.invokeAll(tareas);


        executor.shutdown();

        //recorro da cosa que devuelve la tarea
        int total = 0;
        for (int i = 0; i <resultList.size() ; i++) {

            Future<Integer> resp = resultList.get(i);
            System.out.println("Result of task " + i + " is:" + resp.get());

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
