package API_Stream.Ejercicios.Ej5;

import API_Stream.Collectors.Jugadores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Empleado> empleados = new ArrayList<>();

        empleados.add(new Empleado("Iker", "Moviles"));
        empleados.add(new Empleado("Pablo", "Java"));
        empleados.add(new Empleado("Andres", "Desarollo de juegos"));
        empleados.add(new Empleado("Alonso", "AI"));
        empleados.add(new Empleado("Hecproll", "AI"));
        empleados.add(new Empleado("Iker", "Desarollo de juegos"));

        System.out.println(empleados.stream().collect(Collectors.groupingBy(Empleado::getDepartamento)));

        System.out.println(empleados.stream().collect(Collectors.groupingBy(Empleado::getDepartamento, Collectors.counting()))); //dice que se pone mucho en los examenes

        System.out.println(empleados.stream().filter(n -> n.getDepartamento().equals("AI")).toList());

        System.out.println(empleados.stream().filter(n -> n.getNombre().equals("Iker")).map(Empleado::getDepartamento).toList()); //aqui map() seria como un select

    }
}
