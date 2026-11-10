package Tema1.Ejercicios.Ejs4.Ej5;

import java.util.ArrayList;

public class Clasificacion {

    private ArrayList<String> clasi = new ArrayList<>();


    // Registrar la llegada de un corredor
    public synchronized void registrarLlegada(String nombre) {
        clasi.add(nombre);
    }


    // Mostrar la clasificación final
    public void mostrarClasificacion() {

        System.out.println("---- CLASIFICACION ----");

        for (int i = 0; i < clasi.size(); i++) {
            System.out.println("[" + clasi.get(i) + "] ¡Ha terminado! Posición: " + (i + 1));
        }
    }
}