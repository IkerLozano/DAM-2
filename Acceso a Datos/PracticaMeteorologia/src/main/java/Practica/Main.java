package Practica;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {


        ExecutorService executor = Executors.newFixedThreadPool(4);




        recorrerHilos(executor);

    }







    public static void recorrerHilos(ExecutorService executor){

        List<Path> tareas = new ArrayList<>();

        //recorro los datos de la carpeta
        Path dir = Paths.get("src/main/java/Practica/datosPractica");

        try (
                DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path path: stream) { //path es la ruta de cada archivo


                //añado cada archivo a la lista
                tareas.add(path);
                for (int i = 0; i <tareas.size() ; i++) {
                    //System.out.println(tareas.get(i));
                }
            }


        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println(x);
        }




        //reparto las tareas entre los hilos, cada hilo hará 25 archivos
        int tareasPorHilo = tareas.size()/4;


        //indico donde empieza y acaba cada grupo de las tareas
        //calculo el rango de la tarea y Envía ese trabajo al ExecutorService
        //esto lo repito 4 veces ()que son los hilos que voy a tener
        for (int i = 0; i <4 ; i++) {

            int inicio = i*tareasPorHilo;
            int fin = inicio + tareasPorHilo;

            //System.out.println("inicio -->" + inicio);
            //System.out.println("fin -->" + fin);

            //envio cada grupo de tareas al ExecutorService
            executor.submit(() -> procesarTareas(tareas, inicio, fin));
        }

        //lo cierro para decirle que no voy a enviar mas tareas
        executor.shutdown();

    }


    public static void procesarTareas(List<Path> tareas, int inicio, int fin)  {

        for (int i = inicio; i < fin; i++) {
            Path rutaArchivo = tareas.get(i);

            try {
                String content = new String(Files.readAllBytes(rutaArchivo));

                Gson gson = new Gson();
                DatosJSON dato = gson.fromJson(content, DatosJSON.class);

                dato.cambiarTemperatura();

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }




    }




}
