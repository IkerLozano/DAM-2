package Nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ej1 {

    public static void main() throws IOException {

        int cont = 0;

        Path ruta = Path.of("src/Nio/Archivo"); //creamos la ruta, puede existir o no

        try (BufferedReader leer = Files.newBufferedReader(ruta)) { //abre el archivo  que le indicamos en la ruta y cra un BufferedReader, ese BufferedReader se guarda en "leer"

            String linea; //aqui guardaremos cada linea que vaya leyendo del archivo, va linea por linea

            while ((linea = leer.readLine()) != null){ //leer.readLine lee la siguiente línea del archivo, eso que lemaos se guarda en linea
                cont++;
            }

        } catch (IOException e) {
            System.out.println("Error");
        }

        System.out.println(cont);

        //lo hacemos dentro de un try y catch para que cuando termine de leer cierre el archivo

    }
}
