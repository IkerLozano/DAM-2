package Tema1.Examen.Variados.Ej3;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Cuenta {

    private static double saldo;
    private static Semaphore semaphore = new Semaphore(1);

    public Cuenta(double saldo) {
        this.saldo = saldo;
    }



    public static void getSaldo(){

        System.out.println("SALDO FINAL: " + saldo);

    }




    public static void meter(double cantidadIngresar) throws InterruptedException {

        try {

            semaphore.acquire();

            Random random = new Random();

            int num = random.nextInt(100, 501);

            Thread.sleep(num);

            System.out.println("----------------------" + Thread.currentThread().getName() + "----------------------");
            System.out.println("Ingreso: " + cantidadIngresar + "€");
            System.out.println("Saldo anterior: " + saldo);

            saldo = saldo + cantidadIngresar;

            System.out.println("Saldo posteior: " + saldo);

        }finally {

            semaphore.release();
        }



    }



    public static void sacar(double cantidadRtirar) throws InterruptedException {

        try {


            semaphore.acquire();

            Random random = new Random();

            int num = random.nextInt(100, 501);

            Thread.sleep(num);

            System.out.println("----------------------" + Thread.currentThread().getName() + "----------------------");
            System.out.println("Retira: " + cantidadRtirar + "€");
            System.out.println("Saldo anterior: " + saldo);

            saldo = saldo - cantidadRtirar;

            System.out.println("Saldo posteior: " + saldo);

        }finally {

            semaphore.release();
        }




    }
}
