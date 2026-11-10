package Tema1.Ejercicios.Ejs4.Ej3;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.nio.file.StandardOpenOption;
import java.util.Random;

public class Cuenta implements Runnable{

      private double saldo;


    //constructor
    public Cuenta(double saldo) {
        this.saldo = saldo;
    }

    //getter
    public double getSaldo() {
        return saldo;
    }

    //ingresar dinero
     synchronized void ingresar(double sumar) throws InterruptedException {
        Random random = new Random();
        int num = random.nextInt(100, 500);
        Thread.sleep(num);

        System.out.println("-----------"+ Thread.currentThread().getName() + "-----------");
        System.out.println("INGRESAR");
        System.out.println("Cantidad ingresada: " + sumar);
        System.out.println("Cantidad anterior: " + saldo);

         double resultado = saldo+sumar;
         saldo = resultado;
         System.out.println("Cantidad actual: " + resultado);

    }

    //retirar dinero
    synchronized void retirar(double restar) throws InterruptedException {
        Random random = new Random();
        int num = random.nextInt(100, 500);
        Thread.sleep(num);

        System.out.println("-----------"+ Thread.currentThread().getName() + "-----------");
        System.out.println("RETIRAR");
        System.out.println("Cantidad retirada: " + restar);
        System.out.println("Cantidad anterior: " + saldo);

        double resultado = saldo-restar;
        saldo = resultado;
        System.out.println("Cantidad actual: " + resultado);
    }

    @Override
    public void run() {

    }
}
