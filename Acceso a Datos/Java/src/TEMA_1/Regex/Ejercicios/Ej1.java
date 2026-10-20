package TEMA_1.Regex.Ejercicios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ej1 {

    public static void main(String[] args) {


        String texto = "El servidor principal tiene la dirección IP 192.168.1.10 y el servidor secundario utiliza la IP 10.0.0.25. También tenemos un ordenador con la IP 172.16.0.100 conectado a la red.  La dirección 192.168.1.300 no es válida y 999.20.10.5 tampoco. Otro equipo utiliza la dirección 8.8.8.8 para conectarse a Internet 1924.1.1.1\n";


        Pattern patron = Pattern.compile("(?<!\\d)\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}(?!\\d)");

        Matcher matcher = patron.matcher(texto);

        while (matcher.find()){
            System.out.println(matcher.group());
        }
        //matcher.find() --> Busca la siguiente coincidencia.
        //matcher.group() --> Te da el texto que ha encontrado

    }
}
