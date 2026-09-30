package TEMA_1.Regex.Ejercicios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ej2 {


    public static void main(String[] args) {


        String numeros = "(123) 456-7890\n" +
                "(987) 654-3210\n" +
                "(000) 000-0000\n" +
                "(555) 123-4567\n" +
                "123 456-7890\n" +
                "(123)456-7890\n" +
                "(123) 4567890\n" +
                "(123) 456-789\n" +
                "(12) 456-7890\n" +
                "(123) 45-7890\n" +
                "(123) 456-78901\n" +
                "(123) 456-789a\n" +
                "(abc) 456-7890\n" +
                "(123)456-7890";

        Pattern patron = Pattern.compile("\\([69]\\d{2}\\) \\d{3}-\\d{3}");

        Matcher matcher = patron.matcher(numeros);

        while (matcher.find()){
            System.out.println(matcher.group());
        }


    }
}
