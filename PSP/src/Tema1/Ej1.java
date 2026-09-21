package Tema1;

import java.io.IOException;

public class Ej1 {

    public static void main() throws IOException {

        ProcessBuilder pb = new ProcessBuilder("C:\\Program Files\\Notepad++\\notepad++.exe", "C:\\Users\\dam2\\Documents\\texto.txt\"");
        Process p = pb.start();


        //el segudno parametro es lo que queremos abrir



    }

}
