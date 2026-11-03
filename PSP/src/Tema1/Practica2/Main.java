package Tema1.Practica2;

import javax.management.MBeanAttributeInfo;
import java.io.IOException;
import java.nio.file.*;

public class Main {

    static void main(String[] args) {

        //recorro los datos de la carpeta
        Path dir = Paths.get("src/Tema1/Practica2/datosPractica");

        try (
                DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path path: stream) {

                //leo el contenido de cada fichero
                String content = new String(Files.readAllBytes(path));

                System.out.println(content);
            }

        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println(x);
        }


    }




}
