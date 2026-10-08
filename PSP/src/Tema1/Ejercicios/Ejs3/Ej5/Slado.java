package Tema1.Ejercicios.Ejs3.Ej5;

import java.util.Random;

public class Slado {

    private double saldoDisponible;

    //constructor
    public Slado(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    //getter y setter
    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    private void setSaldoDisponible(double saldoDisponible) throws InterruptedException {
        this.saldoDisponible = saldoDisponible;
        Random random = new Random();
        int num = random.nextInt(1,10);
        Thread.sleep(num* 1000L); //para q sea en milisegundos

    }


    public synchronized void Movimientos(double cantidad) throws InterruptedException {

        double saldoInicial;
        double saldoFinal;


        //saldo inicial
        saldoInicial = saldoDisponible;

        //recibo una cantidad y la añado al saldo
        setSaldoDisponible(saldoInicial+cantidad);

        //saldo final
        saldoFinal = saldoDisponible;

        //muestro la informacioN
        System.out.println("Hilo: " + Thread.currentThread().getName());
        System.out.println("Cantidad añadida: " + cantidad);
        System.out.println("Saldo inicial: " + saldoInicial);
        System.out.println("Saldo final: " + saldoFinal);

    }
}
