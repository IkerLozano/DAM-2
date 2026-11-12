package Tema1.Examen.Variados.Ej5;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Cuenta {

    private static double saldo;
    static ReentrantLock reentrantLock = new ReentrantLock();

    public Cuenta(double saldo) {
        this.saldo = saldo;
    }



    public static void getSaldo(){

        System.out.println("SALDO FINAL: " + saldo);

    }




    public static void meter(double cantidadIngresar) throws InterruptedException {

        try {

            reentrantLock.lock();

            Random random = new Random();

            int num = random.nextInt(100, 501);

            Thread.sleep(num);

            System.out.println("----------------------" + Thread.currentThread().getName() + "----------------------");
            System.out.println("Ingreso: " + cantidadIngresar + "€");
            System.out.println("Saldo anterior: " + saldo);

            saldo = saldo + cantidadIngresar;

            System.out.println("Saldo posteior: " + saldo);

        }finally {

            reentrantLock.unlock();
        }



    }



    public static void sacar(double cantidadRtirar) throws InterruptedException {

        try {


            reentrantLock.lock();

            Random random = new Random();

            int num = random.nextInt(100, 501);

            Thread.sleep(num);

            System.out.println("----------------------" + Thread.currentThread().getName() + "----------------------");
            System.out.println("Retira: " + cantidadRtirar + "€");
            System.out.println("Saldo anterior: " + saldo);

            saldo = saldo - cantidadRtirar;

            System.out.println("Saldo posteior: " + saldo);

        }finally {

            reentrantLock.unlock();
        }




    }
}
