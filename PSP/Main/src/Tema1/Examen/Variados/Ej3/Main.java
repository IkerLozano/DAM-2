package Tema1.Examen.Variados.Ej3;

public class Main implements Runnable{

    private static Cuenta cuenta = new Cuenta(1000);
    private boolean ingresar;
    private double dinero;

    public Main(Cuenta cuenta, boolean ingresar, double dinero) {
        this.cuenta = cuenta;
        this.ingresar = ingresar;
        this.dinero = dinero;
    }

    public static void main(String[] args) throws InterruptedException {


        Thread h1 = new Thread(new Main(cuenta, true, 200), "Hilo 1");
        Thread h2 = new Thread(new Main(cuenta, true, 150), "Hilo 2");
        Thread h3 = new Thread(new Main(cuenta, false, 50), "Hilo 3");
        Thread h4 = new Thread(new Main(cuenta, false, 200), "Hilo 4");
        Thread h5 = new Thread(new Main(cuenta, true, 9.99), "Hilo 5");


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

        cuenta.getSaldo();

    }



    @Override
    public void run() {

        for (int i = 0; i <5 ; i++) {

            if (ingresar){

                try {
                    cuenta.meter(dinero);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else{
                try {
                    cuenta.sacar(dinero);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}
