package API_Stream.Ejercicios.Ej4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Persona> personas = new ArrayList<>();

        personas.add(new Persona("Iker", 19));
        personas.add(new Persona("Hecproll", 67));
        personas.add(new Persona("Alons", 20));
        personas.add(new Persona("Andres", 9999));

        //mayor a menor
        System.out.println(personas.stream().sorted(Comparator.comparing(Persona::getEdad).reversed()).toList());

        //menor a mayor
        System.out.println(personas.stream().sorted(Comparator.comparing(Persona::getEdad)).toList());


    }
}
