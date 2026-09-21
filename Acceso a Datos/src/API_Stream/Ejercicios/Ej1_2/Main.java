package API_Stream.Ejercicios.Ej1_2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Fruta> frutas = new ArrayList<>();

        frutas.add(new Fruta("Manzana", "Rojo"));
        frutas.add(new Fruta("Pera", "Verde"));
        frutas.add(new Fruta("Uva", "Morada"));
        frutas.add(new Fruta("Mandarina", "Naranja"));
        frutas.add(new Fruta("Melocoton", "Rojo"));

        System.out.println(frutas.stream().map(Fruta::getNombre).toList());

        System.out.println(frutas.stream().map(Fruta::getColor).distinct().toList());

    }
}
