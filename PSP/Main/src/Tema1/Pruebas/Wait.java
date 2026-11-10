
package Tema1.Pruebas;

public class Wait {

    // Variable que indica si se puede continuar.
    // false = todavía hay que esperar.
    // true = ya se puede continuar.
    static boolean joy = false;

    // synchronized: el metodo utiliza el bloqueo de la clase Wait.
    public static synchronized void guardedJoy() {

        // Mientras joy sea false, el hilo tendrá que esperar.
        while (!joy) {
            try {
                System.out.println("Esperando...");

                // El hilo se queda esperando un aviso.
                // Además, libera el bloqueo para que otro hilo
                // pueda entrar y cambiar joy a true.
                Wait.class.wait();

                // Cuando recibe un aviso, vuelve aquí y comprueba
                // otra vez la condición del while.

            } catch (InterruptedException e) {

                // Si se interrumpe el hilo, restaura su estado
                // de interrupción y sale del metodo.
                Thread.currentThread().interrupt();
                return;
            }
        }

        // Solo llega aquí cuando joy es true.
        System.out.println("Ya puedo continuar");
    }

    // synchronized: utiliza el mismo bloqueo que guardedJoy().
    public static synchronized void notifyJoy() {

        // Cambia la condición para permitir continuar.
        joy = true;

        // Avisa a todos los hilos que esperan con wait()
        // sobre el objeto Wait.class.
        Wait.class.notifyAll();

        // El hilo que esperaba podrá continuar cuando consiga
        // recuperar el bloqueo de la clase Wait.
    }

    public static void main(String[] args) throws InterruptedException {

        // Crea un hilo que ejecutará guardedJoy().
        Thread hilo1 = new Thread(() -> guardedJoy());

        hilo1.start();

        // El hilo principal espera 1 segundo.
        // Esto NO garantiza que hilo1 ya esté esperando.
        Thread.sleep(1000);

        // Cambia joy a true y avisa a los hilos que esperan.
        notifyJoy();
    }
}
