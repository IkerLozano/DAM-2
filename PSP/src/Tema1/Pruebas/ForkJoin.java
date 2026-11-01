
package Tema1.Pruebas;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class ForkJoin {

    // 1. Creamos una tarea que puede devolver un resultado Integer.
    //RecursiveTask --> indica que es una tarea que puede dividirse en otras tareas, indicamos que devolvera un numero
    static class SumaTask extends RecursiveTask<Integer> {

        private int[] numeros;
        private int inicio;
        private int fin;

        // 2. Constructor: recibe el array y la parte que debe sumar.
        public SumaTask(int[] numeros, int inicio, int fin) {
            this.numeros = numeros;
            this.inicio = inicio;
            this.fin = fin;

            //si una tarea recibe new SumaTask(numeros, 0, 4); Significa que tiene que trabajar con las posiciones 0, 1, 2 y 3.
        }

        // 3. compute() contiene el trabajo que debe realizar la tarea.
        @Override
        protected Integer compute() {

            // CASO BASE:
            // Si quedan 2 números o menos, los sumamos directamente.
            if (fin - inicio <= 2) {

                int suma = 0;

                for (int i = inicio; i < fin; i++) {
                    suma += numeros[i];
                }

                System.out.println("Sumando directamente desde " + inicio + " hasta " + (fin - 1) + ". Resultado: " + suma);

                return suma;
            }


            // 4. DIVIDIMOS EL TRABAJO EN DOS PARTES.
            //si la tarea tiene más de 2 números hacemos esto
            int mitad = (inicio + fin) / 2;

            // Creamos la tarea de la izquierda.
            SumaTask izquierda = new SumaTask(numeros, inicio, mitad);

            // Creamos la tarea de la derecha.
            SumaTask derecha = new SumaTask(numeros, mitad, fin);

            // 5. FORK:
            // Enviamos la tarea izquierda para que pueda ejecutarse.
            izquierda.fork();

            // 6. COMPUTE:
            // Resolvemos directamente la tarea derecha.
            int resultadoDerecha = derecha.compute();

            // 7. JOIN:
            // Esperamos a que termine la tarea izquierda
            // y recuperamos su resultado.
            int resultadoIzquierda = izquierda.join();

            // 8. COMBINAMOS LOS DOS RESULTADOS.
            int resultadoTotal =
                    resultadoIzquierda + resultadoDerecha;

            System.out.println("Combinando " + resultadoIzquierda + " + " + resultadoDerecha + " = " + resultadoTotal);

            return resultadoTotal;
        }
    }



    public static void main(String[] args) {

        // 9. Creamos el array de números.
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8};

        // 10. Creamos el gestor ForkJoin con 3 hilos.
        ForkJoinPool pool = new ForkJoinPool(3);

        // 11. Creamos la tarea principal.
        // Tiene que sumar todo el array: desde la posición 0 hasta la 8.
        SumaTask tarea = new SumaTask(
                numeros, 0, numeros.length
        );

        // 12. Ejecutamos la tarea y esperamos el resultado.
        int resultado = pool.invoke(tarea);

        // 13. Mostramos el resultado final.
        System.out.println("Resultado final: " + resultado);

        // 14. Cerramos el gestor.
        pool.shutdown();
    }
}
