package Tema1.Examen.Variados.Ej3;

import java.util.Random;

public class Cuenta {

    private static double saldo;

    public Cuenta(double saldo) {
        this.saldo = saldo;
    }



    public static void getSaldo(){

        System.out.println("SALDO FINAL: " + saldo);

    }




    public synchronized static void meter(double cantidadIngresar) throws InterruptedException {

        Random random = new Random();

        int num = random.nextInt(100, 501);

        Thread.sleep(num);

        System.out.println("----------------------" + Thread.currentThread().getName() + "----------------------");
        System.out.println("Ingreso: " + cantidadIngresar + "€");
        System.out.println("Saldo anterior: " + saldo);

        saldo = saldo + cantidadIngresar;

        System.out.println("Saldo posteior: " + saldo);

    }



    public synchronized static void sacar(double cantidadRtirar) throws InterruptedException {
        Random random = new Random();

        int num = random.nextInt(100, 501);

        Thread.sleep(num);

        System.out.println("----------------------" + Thread.currentThread().getName() + "----------------------");
        System.out.println("Retira: " + cantidadRtirar + "€");
        System.out.println("Saldo anterior: " + saldo);

        saldo = saldo - cantidadRtirar;

        System.out.println("Saldo posteior: " + saldo);


    }
}
