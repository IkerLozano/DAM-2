package Tema1.Ejercicios.Ejs4.Ej5;

import java.util.ArrayList;
import java.util.Random;

public class Corredor implements Runnable{

    private int distanciaRecorrida;
    private int distanciaARecorrer;
    private Clasificacion clasi;


    //constructor
    public Corredor(int distanciaRecorrida, int distanciaARecorrer, Clasificacion clasi) {
        this.distanciaRecorrida = distanciaRecorrida;
        this.distanciaARecorrer = distanciaARecorrer;
        this.clasi = clasi;
    }

    //getter y setter
    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(int distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public int getDistanciaARecorrer() {
        return distanciaARecorrer;
    }

    public void setDistanciaARecorrer(int distanciaARecorrer) {
        this.distanciaARecorrer = distanciaARecorrer;
    }

    public Clasificacion getClasi() {
        return clasi;
    }

    public void setClasi(Clasificacion clasi) {
        this.clasi = clasi;
    }




    //metodo run
    @Override
    public void run() {



        while (distanciaRecorrida<20){

            Random random = new Random();
            int distancia = random.nextInt(1, 4);//4 pq el ultimo num no se incluye
            int dormir = random.nextInt(200, 700);

            if (distanciaRecorrida == 19){
                distanciaRecorrida = distanciaRecorrida+1;
            } else if (distanciaRecorrida == 18) {
                distanciaRecorrida = distanciaRecorrida+2;
            }else{
                distanciaRecorrida = distanciaRecorrida+distancia;
            }



            System.out.println("[" + Thread.currentThread().getName() + "] Ha avanzado " + distancia + " metros. Distancia:" + distanciaRecorrida + "/20");


            try {
                Thread.sleep(dormir);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


        clasi.registrarLlegada(Thread.currentThread().getName());

        /*
        clasi.add(Thread.currentThread().getName());


        int cont = 1;
        if (clasi.size() == 4){
            System.out.println("----CLASIFICACION----");
            for (int i = 0; i < clasi.size() ; i++) {


                System.out.println("[" + clasi.get(i) + "] ¡Ha terminado! Posicion: " + cont);

                cont++;
            }
        }
        */

    }





}
