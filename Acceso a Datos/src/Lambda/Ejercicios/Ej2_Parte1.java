package Lambda.Ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ej2_Parte1 {

    public static void main(String[] args) {

        List<String> nombres = new ArrayList<>(Arrays.asList("Iker", "Alonso", "Hecproll", "Andres", "Pablo", "alberto"));
        List<String> nombresA = new ArrayList<>(nombres);

        nombresA.removeIf(n -> n.charAt(0) !='A' && n.charAt(0) !='a');
        System.out.println(nombresA);

        /*
           removeIf devuelve un booleano
           IMPORTANTE: removeIf modifica la lista original, por eso creamos otra

         */

    }


}
