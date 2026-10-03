package Tema1.Ejercicios.Ejs2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ej1 {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);


        try {

            System.out.println("Dime la ruta"); //C:\Windows\System32\notepad.exe
            String ruta = sc.nextLine();


            ProcessBuilder pb = new ProcessBuilder(ruta);
            //ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "ping", "www.google.es");


            Process p = pb.start();


            int codigo =  p.waitFor();


            System.out.println("Codigo de finalizacion: " + codigo);


        }catch (InterruptedException | IOException e){
            System.out.println("A ocurrido un error: " + e.getMessage());
        }



    }
}
