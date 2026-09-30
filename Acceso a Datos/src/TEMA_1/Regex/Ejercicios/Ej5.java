package TEMA_1.Regex.Ejercicios;

import java.lang.foreign.MemoryLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ej5 {

    public static void main(String[] args) {


        String texto = "Ayer A fui con Marcos y Laura al instituto. Allí nos encontramos con Pedro, que venía de Valencia. Después fuimos a comer a un Restaurante cerca de la Plaza Mayor. Por la tarde, Marta y Sergio jugaron al Fútbol en el Parque.";


        Pattern patron = Pattern.compile("\\b[A-Z]{1}[a-záéíóú]{0,}\\b");

        Matcher matcher = patron.matcher(texto);

        while (matcher.find()){
            System.out.println(matcher.group());
        }

    }
}
