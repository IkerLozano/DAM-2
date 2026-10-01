package Tema1;

import java.io.IOException;

public class Pruebas {

    public static void main(String[] args) throws IOException, InterruptedException {

//
//        ProcessBuilder pb = new ProcessBuilder("calc");
//        Process p = pb.start();
//
//
//        //si lo hacemos de esta anera no hce fata rear un ProcessBuilder
//        Process p2 = new ProcessBuilder("notepad").start();
//
//        /*
//        new ProcessBuilder("calc"): prepara la ejecución de la calculadora.
//        pb.start(): inicia el proceso.
//        Process p: almacena el objeto que representa el proceso iniciado,
//            si queremos hacer cosas con el proceso, usaremos p.
//         */
//
//        System.out.println(p.pid()); //muestro el pid del proceso
//        System.out.println(p2.pid());
//
//        //esto  no va, lo dice al momento, no espera a q se terminen los prcesos
//        p.waitFor();
//        p2.waitFor();
//
//        System.out.println(p + "a finalizado");
//        System.out.println(p2 + "a finlaizado");



        String clase = System.getProperty("java.class.path");

        ProcessBuilder pb4 = new ProcessBuilder(
                "java",
                "-cp",
                clase,
                "Tema1.Suma",
                "5",
                "10"
        );

        Process p4 = pb4.start();



    }
}
