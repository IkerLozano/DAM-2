package Nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Ej2 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Que archivo quieres copiar");
        String NombreOrigen = sc.nextLine();

        System.out.println("Como quieres que se llame el archivo copia");
        String NombreCopia = sc.nextLine();

        Path origen = Path.of("src/Nio/" + NombreOrigen);
        Path destino = Path.of("src/Nio/" + NombreCopia);

        if (Files.exists(origen)){ //compruebo que el nombre del archivo que quiere copiar exista
            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING); //en caso de que el archvo exista la borra y lo crea otra vez
            System.out.println("Archivo copiado correctamente");
        }else{
            System.out.println("El archivo que quieres copiar no existe");
        }



    }
}
