package Comparator_y_Comparable.Ejercicios;

import java.time.LocalDateTime;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {


        PriorityQueue<Paciente> pacientes = new PriorityQueue<>(new ComparadorGravedad());

        pacientes.offer(new Paciente("Ana", 5, LocalDateTime.parse("2026-09-16T10:01")));
        pacientes.offer(new Paciente("Luis", 9, LocalDateTime.parse("2026-09-16T10:02")));
        pacientes.offer(new Paciente("Marta", 9, LocalDateTime.parse("2026-09-16T10:03")));
        pacientes.offer(new Paciente("Pepe", 3, LocalDateTime.parse("2026-09-16T10:04")));
        pacientes.offer(new Paciente("Sonia", 7, LocalDateTime.parse("2026-09-16T10:05")));
        pacientes.offer(new Paciente("Raúl", 4, LocalDateTime.parse("2026-09-16T10:06")));
        pacientes.offer(new Paciente("Julia", 10, LocalDateTime.parse("2026-09-16T10:07")));
        pacientes.offer(new Paciente("Iván", 6, LocalDateTime.parse("2026-09-16T10:08")));
        pacientes.offer(new Paciente("Clara", 8, LocalDateTime.parse("2026-09-16T10:09")));
        pacientes.offer(new Paciente("Diego", 2, LocalDateTime.parse("2026-09-16T10:10")));
        pacientes.offer(new Paciente("Nora", 10, LocalDateTime.parse("2026-09-16T10:11")));
        pacientes.offer(new Paciente("Óscar", 1, LocalDateTime.parse("2026-09-16T10:12")));
        pacientes.offer(new Paciente("Belén", 7, LocalDateTime.parse("2026-09-16T10:13")));
        pacientes.offer(new Paciente("Víctor", 5, LocalDateTime.parse("2026-09-16T10:14")));
        pacientes.offer(new Paciente("Paula", 9, LocalDateTime.parse("2026-09-16T10:15")));
        pacientes.offer(new Paciente("Sergio", 4, LocalDateTime.parse("2026-09-16T10:16")));
        pacientes.offer(new Paciente("Irene", 6, LocalDateTime.parse("2026-09-16T10:17")));
        pacientes.offer(new Paciente("Tomás", 8, LocalDateTime.parse("2026-09-16T10:18")));
        pacientes.offer(new Paciente("Laura", 3, LocalDateTime.parse("2026-09-16T10:19")));
        pacientes.offer(new Paciente("Rubén", 7, LocalDateTime.parse("2026-09-16T10:20")));
        pacientes.offer(new Paciente("Pilar", 10, LocalDateTime.parse("2026-09-16T10:21")));
        pacientes.offer(new Paciente("Andrés", 2, LocalDateTime.parse("2026-09-16T10:22")));
        pacientes.offer(new Paciente("Carla", 9, LocalDateTime.parse("2026-09-16T10:23")));
        pacientes.offer(new Paciente("Mario", 6, LocalDateTime.parse("2026-09-16T10:24")));
        pacientes.offer(new Paciente("Elena", 8, LocalDateTime.parse("2026-09-16T10:25")));
        pacientes.offer(new Paciente("Fabián", 4, LocalDateTime.parse("2026-09-16T10:26")));
        pacientes.offer(new Paciente("Rosa", 5, LocalDateTime.parse("2026-09-16T10:27")));
        pacientes.offer(new Paciente("David", 7, LocalDateTime.parse("2026-09-16T10:28")));
        pacientes.offer(new Paciente("Silvia", 3, LocalDateTime.parse("2026-09-16T10:29")));
        pacientes.offer(new Paciente("Héctor", 9, LocalDateTime.parse("2026-09-16T10:30")));


        do {
            System.out.println(pacientes.poll());
        }while (!pacientes.isEmpty());


        /*
            PriorityQueue es una cola de elementos en la que cada elemento tiene una prioridad
            La diferencia con una cola normal es que no necesariamente sale primero el que entró primero.

            En caso de no tener ningun comparador saldra primero de la cola segun la compracion del tipo,
            es decir si es Integer internamnete se compara de una menera, String de otra...


            poll() Devuelve y elimina el elemento con mayor prioridad
            En este caso nos mostrara los datos en el orden que hayamos definido en el Compartor,
            ese comparator se lo indicamos al crear la  PriorityQueue<>
         */


        /*
            Una vez usemos poll() sobre la lsita elimina los elementos, por es si hacemos un sout de la lista estara vacia

            System.out.println("----");
            System.out.println(pacientes);
            Salida --> [] (lista vacia)
         */

    }
}
