package Tema1.Ejercicios.Ejs2.Ej5;

import java.io.File;
import java.io.IOException;

public class Ej5 {

    public static void main(String[] args){

        try {


            File ip = new File("src/Tema1/Ejercicios/Ejs2/Ej5/ipconfig.txt");
            File nombre = new File("src/Tema1/Ejercicios/Ejs2/Ej5/hostname.txt");
            File ping = new File("src/Tema1/Ejercicios/Ejs2/Ej5/ping.txt");

            ProcessBuilder pb1 = new ProcessBuilder("cmd.exe", "/c", "ipconfig"); // /c --> ejecuta el comando y termina
            ProcessBuilder pb2 = new ProcessBuilder("cmd.exe", "/c", "hostname");
            ProcessBuilder pb3 = new ProcessBuilder("cmd.exe", "/c", "ping www.google.es");

            pb1.redirectOutput(ip);
            pb2.redirectOutput(nombre);
            pb3.redirectOutput(ping);

            Process p1 =  pb1.start();
            Process p2 =  pb2.start();
            Process p3 =  pb3.start();

            int cod1 = p1.waitFor();
            int cod2 = p2.waitFor();
            int cod3 = p3.waitFor();


            System.out.println("el código de finalización 1:" + cod1);
            System.out.println("el código de finalización 2:" + cod2);
            System.out.println("el código de finalización 3:" + cod3);


        }catch (IOException | InterruptedException e){
            System.out.println("A ocurrido un error:" + e.getMessage());
        }





    }
}
