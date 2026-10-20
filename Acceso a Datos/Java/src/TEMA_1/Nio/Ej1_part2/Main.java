package TEMA_1.Nio.Ej1_part2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        List<Producto> productos = new ArrayList<>(Arrays.asList(
                new Producto(001, "Teclado", 25.4, true, 'I'),
                new Producto(002, "Ratón", 15.99, true, 'I'),
                new Producto(003, "Monitor", 149.99, true, 'I'),
                new Producto(004, "Auriculares", 35.50, true, 'I'),
                new Producto(005, "Impresora", 89.99, true, 'I'),
                new Producto(006, "Altavoces", 29.99, true, 'I')
        ));


        Path archivo = Path.of("src/TEMA_1.API_Stream/Ejercicios/MasEjs/Ej1/Archivo");


        //meter los prosuctos de la lista en un archivo
        try (BufferedWriter escribir = Files.newBufferedWriter(archivo)) {

            for (Producto p : productos){

                escribir.write(String.valueOf(p));
                escribir.newLine();

            }


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


        //leer el archivo con los productos y monstarlo
        try (BufferedReader leer = Files.newBufferedReader(archivo)) {

            String linea;

            while ((linea = leer.readLine()) !=null){

                System.out.println(linea);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


    }
}
