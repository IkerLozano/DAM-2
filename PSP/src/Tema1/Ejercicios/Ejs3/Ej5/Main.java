package Tema1.Ejercicios.Ejs3.Ej5;

import Prueba_Inicial.Ej3;


public class Main implements Runnable{

    //El constructor de Slado crea el saldo

    //recibe el saldo para q el hilo peuda trabajar con el

    private Slado saldo; //guarda la cuenta bancaria sobre la que va a trabajar el hilo
    private double cantidad; //aquí se guarda el dinero que añade cada hilo

    public Main(Slado saldo, double cantidad) {
        this.saldo = saldo;
        this.cantidad = cantidad;
    }

    public static void main(String[] args) throws InterruptedException {


        Slado saldo = new Slado(100);
        System.out.println(saldo.getSaldoDisponible());


        Thread hilo1 = new Thread(new Main(saldo, 50), "Hilo 1");
        Thread hilo2 = new Thread(new Main(saldo, 67), "Hilo 2");
        Thread hilo3 = new Thread(new Main(saldo, 10), "Hilo 3");
        Thread hilo4 = new Thread(new Main(saldo, 500), "Hilo 4");

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        //los join() garantizan que el main() no continúe después de cada espera hasta que el hilo correspondiente haya terminado
        hilo1.join();
        hilo2.join();
        hilo3.join();
        hilo4.join();


        System.out.println("Saldo final: " + saldo.getSaldoDisponible());
        /*

            Si no necesitamos hacer nada después de los start(), puede que no necesitemos los joins

            Si queremos mostrar el saldo final cuando hayan terminado todos los hilos,
            sí necesitas los join(), para q lo muestre cuando termien todos los hilos

         */


    }



    @Override
    public void run() {
        try {
            saldo.Movimientos(cantidad);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /*
        si quito el synchronized las operaciones se hacen desordenadas
        asi evito que dos hilos ejecuten a la vez el metodo que modifica el saldo.

            Hilo: Hilo 4
            Cantidad añadida: 500.0
            Saldo inicial: 227.0
            Saldo final: 727.0
            Hilo: Hilo 2
            Hilo: Hilo 1
            Cantidad añadida: 67.0
            Cantidad añadida: 50.0
            Saldo inicial: 150.0
            Saldo inicial: 100.0
            Saldo final: 727.0
            Saldo final: 727.0
            Hilo: Hilo 3
            Cantidad añadida: 10.0
            Saldo inicial: 217.0
            Saldo final: 727.0
     */


    /*

           Si o pongo el siguiente hilo no entra en los datos hasta que el otro hilo termine

            Hilo: Hilo 1
            Cantidad añadida: 50.0
            Saldo inicial: 100.0
            Saldo final: 150.0

            Hilo: Hilo 2
            Cantidad añadida: 67.0
            Saldo inicial: 150.0
            Saldo final: 217.0

            Hilo: Hilo 3
            Cantidad añadida: 10.0
            Saldo inicial: 217.0
            Saldo final: 227.0

            Hilo: Hilo 4
            Cantidad añadida: 500.0
            Saldo inicial: 227.0
            Saldo final: 727.0
     */
}
