package Nio;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Random;
import java.util.Scanner;

public class Ej4 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Como quieres que se llame el archivo nuevo");
        String archivoDestino = sc.nextLine();

        System.out.println("Cuantos archivos quieres juntar");
        int num = sc.nextInt();
        sc.nextLine();


        Path destino = Path.of("src/Nio/" + archivoDestino);

        for (int i = 0; i <num ; i++) {

            System.out.println("Dime el nombre del archivo " + (i+1));
            String archivoOriginal = sc.nextLine();

            Path origen = Path.of("src/Nio/" + archivoOriginal);

            if (Files.exists(origen)){

               try (BufferedReader leer = Files.newBufferedReader(origen);
                    BufferedWriter escribir = Files.newBufferedWriter(destino, StandardOpenOption.CREATE,StandardOpenOption.APPEND)) {

                   String linea;

                   while ((linea = leer.readLine()) !=null){
                       escribir.write(linea); //escribe esa linea en destino
                       escribir.newLine(); //salto de linea
                   }

               } catch (IOException e) {
                   System.out.println("Error");
               }

                System.out.println("El archivo " + (i+1) + " se a copiado correctamente");
            }else{
                System.out.println("El archivo introducido no exixte");
            }


        }

    }
}


/*
    StandardOpenOption.APPEND --> añadir al final del archivo sin borrar lo que ya hay.
    StandardOpenOption.CREATE --> Si el archivo no existe, lo crea.

    ya que BufferReader no funciona como File.copy por jemplo, el cual
    te crea el archivo si no existe
 */