package Tema1.Ejercicios.Ejs2.Ej2;

import java.io.File;
import java.io.IOException;

public class Ej2 {

    public static void main(String[] args) throws IOException, InterruptedException {


        File comandos = new File("src/Tema1/Ejercicios/Ejs2/Ej2/comandos.bat");
        File salida = new File("src/Tema1/Ejercicios/Ejs2/Ej2/salida.txt");
        File errores = new File("src/Tema1/Ejercicios/Ejs2/Ej2/Errores.txt");

        ProcessBuilder pb = new ProcessBuilder("cmd.exe");

        pb.redirectInput(comandos);
        pb.redirectOutput(salida);
        pb.redirectError(errores);

        Process p = pb.start();

        int codigo = p.waitFor();


        System.out.println("código de finalización: " + codigo);
    }

}
