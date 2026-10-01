package Tema1;

public class Hilos_Runnable implements Runnable{


    public static void main(String[] args) {


        //creamos el hilo y le decimos que ejecute la tareas Hilos, que es nuestra clase
        Thread t = new Thread(new Hilos_Runnable());
        t.start(); //iniciamos el hilo y hace que se ejecute el metodo run()

    }

    //aqui decimos lo que queremos que haga el hilo
    @Override
    public void run() {
        System.out.println("hola desde el hilo");
    }
}




