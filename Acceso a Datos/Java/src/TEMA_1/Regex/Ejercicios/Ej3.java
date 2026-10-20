package TEMA_1.Regex.Ejercicios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ej3 {


    public static void main(String[] args) {

            String texto = "El curso comenzó el 09/2026 y el primer examen será el 20/10/2026.\n" +
                    "La entrega del proyecto está prevista para el 05/11/2026.\n" +
                    "El 255/12/2026 no habrá clase y las vacaciones terminarán el 07/01/2027.\n" +
                    "También hay una reunión programada para el 18/02/207.";



            Pattern patron = Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{4}");

            Matcher matcher = patron.matcher(texto);

            while (matcher.find()){
                System.out.println(matcher.group());
            }

    }

}
