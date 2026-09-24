package Tema1;

public class pruebaHilos implements Runnable {

    static int cont = 0;

    public void run() {
        cont++;
        System.out.println(cont);
        try {
            Thread.sleep(30000000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String args[]) {

        for (int i = 0; i <100000000 ; i++) {
            new Thread(new pruebaHilos()).start();
        }

    }
}
