package TEMA_1.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejemplos {


    public static void main(String[] args) {


        String cosa = "hola buenas 1234, Pascual";
        String cosa2 = "1234";


        //PATTERN - es el patron que vamos a seguir

        Pattern patron = Pattern.compile("\\d+"); //uno o mas numeros


        //MATCHER - es el texto que vamos a comprobar

        Matcher matcher1 = patron.matcher(cosa); //crea un matcher que comprueba la frase usando mi patron
        Matcher matcher2 =  patron.matcher(cosa2);

        //MATCHES - comprueba si TODO el texto cumple el patron

        System.out.println(matcher1.matches()); //nos dira false pq no toda la farse cumple con nuestro patron


        //FIND - busca si hay alguna parte del texto que coincida con el patrón

        System.out.println(matcher2.find()); // nos dice true pq en la farse si que hay algo que coincide con el patron


        /*

        //Ejemplo entero
        Pattern patron = Pattern.compile("\\d+");

        Matcher matcher = patron.matcher("Tengo 25 años");

        System.out.println(matcher.matches()); //false
        System.out.println(matcher.find()); //true

         */

    }
}
