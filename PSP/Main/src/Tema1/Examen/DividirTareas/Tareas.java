package Tema1.Examen.DividirTareas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Tareas implements Callable<Integer> {

    private List<Integer> numeros;


    //constructor
    public Tareas(List<Integer> numeros) {
        this.numeros = numeros;

    }

    @Override
    public Integer call() throws Exception {


        int sum = 0;

        for (int i = 0; i <numeros.size() ; i++) {

            sum = sum+numeros.get(i);

        }

        return sum;


    }
}
