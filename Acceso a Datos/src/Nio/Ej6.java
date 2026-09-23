package Nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Ej6 {


    public static void main(String[] args) throws IOException {


        //Hacerlo con File
        File ruta = new File("C://Users//Iker//Desktop"); //creo la ruta


        File[] contenido = ruta.listFiles(); //meto cada contenido del escritorio en una posciion de un array


        //recorro el array y muestro solo los .txt
        for (File c: contenido){

            if (c.getName().endsWith(".txt")){
                System.out.println(c.getName());
            }
        }



        //Hacerlo con Files
        Path rutaFile = Path.of("C://Users//Iker//Desktop");

        Stream<Path> contenido2 = Files.list(rutaFile);

        contenido2.filter(c -> c.endsWith(".txt")).forEach(System.out::println);


        //El ejercicio 7
        //hay que usar el metodo walk(), para que nos muestre tamb subcarpetas, pq file solo muestra el contenido de una carpeta

        Files.walk(rutaFile, 3).filter(n -> n.toString().endsWith(".txt")).forEach(System.out::println);


    }
}
