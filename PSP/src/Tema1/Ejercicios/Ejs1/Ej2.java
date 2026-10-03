package Tema1.Ejercicios.Ejs1;

import java.io.File;
import java.io.IOException;

public class Ej2 {

    public static void main(String[] args) throws IOException {

        File entrada = new File("src/Tema1/Ejercicios/Ejs1/comandos.bat");
        File salida = new File("src/Tema1/Ejercicios/Ejs1/Salida");
        File errores = new File("src/Tema1/Ejercicios/Ejs1/Errores.txt");

        ProcessBuilder pb = new ProcessBuilder("cmd.exe");

        pb.redirectInput(entrada); //el proceso lee los comandos desde el fichero
        pb.redirectOutput(salida); //si el coamndo se ejcuta la respuesta se va aqui (stdout)
        pb.redirectError(errores); //si el comando produce un fallo la respuesta se va aqui (stderr)

        Process p = pb.start();


    }

}
