package API_Stream.map_y_FlatMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Personas> personas = new ArrayList<>();

        personas.add(new Personas("Iker", 19, Arrays.asList("roma", "España", "Argentina")));
        personas.add(new Personas("Juan", 22, Arrays.asList("Francia", "Italia", "Portugal")));
        personas.add(new Personas("Marta", 25, Arrays.asList("Japón", "China", "Corea del Sur")));
        personas.add(new Personas("Lucía", 20, Arrays.asList("México", "Brasil", "Perú")));


        System.out.println(personas.stream().map(Personas::getNombre).map(String::toUpperCase).toList());
            /*
                transforma cada objeto Personas en un String que contiene su nombre
                y luego coje el String creado y lo pone en mayusculas
             */


        System.out.println(personas.stream()
                .map(Personas::getViajes)
                .flatMap(v -> v.stream())
                .toList());

    }
}
