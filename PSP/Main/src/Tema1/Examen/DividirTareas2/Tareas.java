package Tema1.Examen.DividirTareas2;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;


//ESTO ES LO QUE VA A HACER CADA HILO
public class Tareas implements Callable<Integer> {


    List<Integer> numeros;

    //constructor
    public Tareas(List<Integer> numeros) {
        this.numeros = numeros;
    }


    @Override
    public Integer call() throws Exception {
        int suma = 0;

        for (int i = 0; i <numeros.size() ; i++) {

          suma = suma + numeros.get(i);

        }

        return suma;

    }
}
