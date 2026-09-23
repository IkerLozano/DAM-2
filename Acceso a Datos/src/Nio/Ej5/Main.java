package Nio.Ej5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {


        Path archivo = Path.of("src/Nio/Ej5/Fichero");

        List<Productos> productos = new ArrayList<>(Arrays.asList(
                new Productos(1, "Teclado", 35.99, true, 'A'),
                new Productos(2, "Raton", 19.99, false, 'B'),
                new Productos(3, "Monitor", 189.50, true, 'A'),
                new Productos(4, "Auriculares", 59.99, false, 'C'),
                new Productos(5, "Webcam", 45.75, true, 'B')
        ));

        /*

            Borro el contenido anterior del fichero, de esta manera:
            abre el fichero una sola vez,
            al abrirlo sin APPEND, borra el contenido anterior
            El for escribe los 5 productos sobre el mismo BufferedWriter abierto

            try (BufferedWriter escribir = Files.newBufferedWriter(archivo)) {

                for (Productos p : productos) {
                    escribir.write(String.valueOf(p));
                    escribir.newLine();
                }

            } catch (Exception e) {
                System.out.println("Error");
            }


         */


        //recorro las lista y ecribo cada elemento en un archivo
        for (Productos p : productos){


            try (BufferedWriter escribir = Files.newBufferedWriter(archivo, StandardOpenOption.APPEND)) {

                escribir.write(String.valueOf(p));
                escribir.newLine();

                //System.out.println("Copiado");


            }catch (Exception e) {
                System.out.println("Error");
            }

        }


        //muestro el archivo con los elemntos
        try (BufferedReader leer = Files.newBufferedReader(archivo)) {

            String linea;

            System.out.println("----Mostrado articulos:----");
            while ((linea = leer.readLine()) !=null){

                System.out.println(linea);
            }

        } catch (Exception e) {
            System.out.println("Error");
        }


        //muestro solo el 4º producto
        System.out.println("----Muestro el 4º elemento del fichero----");

            int cont = 0;

            try (BufferedReader leer = Files.newBufferedReader(archivo)) {

                String linea;

               while ((linea = leer.readLine()) !=null){

                   cont ++;

                   if (cont == 4){

                       System.out.println(linea);
                   }

                }

            } catch (Exception e) {
                System.out.println("Error");
            }


    }
}
