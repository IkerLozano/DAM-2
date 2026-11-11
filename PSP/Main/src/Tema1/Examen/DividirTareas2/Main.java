package Tema1.Examen.DividirTareas2;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);


        //aqui guardare las tareas
        List<Tareas> tareas = new ArrayList<>();



        //lista con los numeros
        List<Integer> numeros = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i <100000 ; i++) {

            int num = random.nextInt(1,200);

            numeros.add(num);

        }


        //creo una lista con 4 lista
        List<List<Integer>> partes = dividirLista(numeros, 4);


        for (List<Integer> l : partes){

            tareas.add(new Tareas(l));
        }


        //lista de resultados
        List<Future<Integer>> resultList;
        resultList = executor.invokeAll(tareas);
        executor.shutdown();


        //recorro y muestro tareas
        int mayorGlobal = 0;

        for (int i = 0; i < tareas.size() ; i++) {

            Future<Integer> res = resultList.get(i);

            if (mayorGlobal < res.get()){
                mayorGlobal = res.get();
            }

            System.out.println(i + " --> " + res.get());


            /*
                SUMA DE LOS NUMS DE CADA SUBLISTA
                0 --> 2491042
                1 --> 2498791
                2 --> 2497003
                3 --> 2499143
             */
        }

        System.out.println("La suma mas mayor es " + mayorGlobal);


    }

    public static List<List<Integer>> dividirLista ( List<Integer> lista, int numpartes){

        List<List<Integer>> partes = new ArrayList<>();

        int tamaño = lista.size() / numpartes; //tamaño de cada sublista, cantidad de nuemros de cada parte
        int resto = lista.size() % numpartes; //para que no se queden numeros sueltos


        //desde qué posición de la lista original empezamos a coger números
        int inicio = 0;


        for (int i = 0; i <numpartes ; i++) {


            int fin = inicio+tamaño;


            //repartir los nuems sobrantes
            if (i < resto) {
                fin++;
            }

            partes.add(new ArrayList<>(lista.subList(inicio, fin)));
            /*
                lista.subList(inicio, fin) obtiene los números de esa parte.
                new ArrayList<>(...) crea una lista nueva con esos números.
                partes.add(...) guarda esa lista dentro de nuestra lista de listas.
             */


            //actualizar el inicio
            //Cuando se termine de crear una sublista, hay que empezar la siguiente justo donde terminó la anterior.
            inicio = fin;
        }


        return partes;

    }
}
