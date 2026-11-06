package Tema1.Ejercicios.Ejs1;

import java.io.IOException;

public class Ej1 {

    public static void main(String[] args) throws IOException {


        ProcessBuilder pb = new ProcessBuilder("notepad", "\"C:\\Users\\Iker\\Documents\\Hola.txt\"");
        Process p = pb.start();

        //lo segundo es la ruta del fichero, de esta manera se abre el fichero en notepad

    }

}
