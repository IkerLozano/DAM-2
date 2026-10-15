package Tema1.Ejercicios.Ejs4.Ej3;

public class Main implements Runnable{


    private Cuenta cuenta;
    private double dinero;
    private boolean ingresar;

    public Main(Cuenta cuenta, double dinero, boolean ingresar) {
        this.cuenta = cuenta;
        this.dinero = dinero;
        this.ingresar = ingresar;
    }

    public static void main(String[] args) throws InterruptedException {


        Cuenta c = new Cuenta(100.0);

        Thread h1 = new Thread(new Main(c, 50.0, true), "Hilo 1");
        Thread h2 = new Thread(new Main(c, 100.0, true), "Hilo 2");
        Thread h3 = new Thread(new Main(c, 9.99, false), "Hilo 3");
        Thread h4 = new Thread(new Main(c,45, true), "Hilo 4");
        Thread h5 = new Thread(new Main(c, 20, false), "Hilo 5");

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();


        h1.join();
        h2.join();
        h3.join();
        h4.join();
        h5.join();

        System.out.println("---------El saldo final es " + c.getSaldo() + "--------------");

    }



    @Override
    public void run() {

        for (int i = 0; i <5 ; i++) {

            if (ingresar){
                try {
                    cuenta.ingresar(dinero);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else{
                try {
                    cuenta.retirar(dinero);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }
}
