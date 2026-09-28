package Nio.Ej2_part2;

import javax.swing.table.TableRowSorter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class Main {

    public static void main(String[] args) throws IOException {

        Path archivoO = Path.of("src/Nio/Ej2_part2/Archivo");
        Path archivoC = Path.of("src/Nio/Ej2_part2/ArchivoC");


        try (BufferedReader leer = Files.newBufferedReader(archivoO);
            BufferedWriter escribir = Files.newBufferedWriter(archivoC)){

            String linea;

            while ((linea = leer.readLine()) !=null){

                String nuevo = linea.replace("Java", "Python");
                escribir.write(nuevo);
                escribir.newLine();

            }


        } catch (Exception e) {
            System.out.println("Error");
        }


    }
}
