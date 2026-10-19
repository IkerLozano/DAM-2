package TEMA_1.Regex.Ejercicios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ej4 {

    public static void main(String[] args) {


        String valida = "Casa123!";
        String noValida = "casa1234";


        Pattern patron = Pattern.compile("^(?=.*.{8,})(?=.*[A-Z]{1,})(?=.*[a-z]{1,})(?=.*\\d{1,})(?=.*[-+%&¿?!]).*$");

        Matcher matcher = patron.matcher(valida);

        System.out.println(matcher.matches());

    }
}
