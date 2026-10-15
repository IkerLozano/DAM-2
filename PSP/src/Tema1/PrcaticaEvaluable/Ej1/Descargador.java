package Tema1.PrcaticaEvaluable.Ej1;

import Tema1.Ejercicios.Ejs4.Ej3.Cuenta;

import java.util.Random;

public class Descargador implements Runnable{

     private GestorDescargas ref;
     private String nombre;


    public Descargador(GestorDescargas ref, String nombre) {
        this.ref = ref;
        this.nombre = nombre;
    }




    @Override
    public void run() {

        Random random = new Random();
        int num = random.nextInt(500, 1500);

        try {
            Thread.sleep(num);
        } catch (InterruptedException e) {
            System.out.println("El hilo " + "'" + Thread.currentThread().getName() + "'" + " a sido interrumpido");
            return;
        }

        ref.registrarDescarga(nombre);



    }
}





