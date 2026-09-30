package TEMA_1.API_Stream.Ejercicios.PackEjerciciosExamenStreams.Ej9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Estudiante> estudiantes = new ArrayList<>();

        estudiantes.add(new Estudiante(1, "1717213183", "Javier", "Molina Cano", "Java 8", 7, 28));
        estudiantes.add(new Estudiante(2, "1717456218", "Ana", "Gómez Álvarez", "Java 8", 10, 33));
        estudiantes.add(new Estudiante(3, "1717328901", "Pedro", "Marín López", "Java 8", 8.6, 15));
        estudiantes.add(new Estudiante(4, "1717567128", "Emilio", "Duque Gutiérrez", "Java 8", 10, 13));
        estudiantes.add(new Estudiante(5, "1717902145", "Alberto", "Sáenz Hurtado", "Java 8", 9.5, 15));
        estudiantes.add(new Estudiante(6, "1717678456", "Germán", "López Fernández", "Java 8", 8, 34));
        estudiantes.add(new Estudiante(7, "1102156732", "Oscar", "Murillo González", "Java 8", 10, 32));
        estudiantes.add(new Estudiante(8, "1103421907", "Antonio Jesús", "Palacio Martínez", "PHP", 9.5, 17));
        estudiantes.add(new Estudiante(9, "1717297015", "César", "González Martínez", "Java 8", 8, 26));
        estudiantes.add(new Estudiante(10, "1717912056", "Gloria", "González Castaño", "PHP", 10, 28));
        estudiantes.add(new Estudiante(11, "1717912058", "Jorge", "Ruiz Ruiz", "Python", 8, 22));
        estudiantes.add(new Estudiante(12, "1717912985", "Ignacio", "Duque García", "Java Script", 9.4, 32));
        estudiantes.add(new Estudiante(13, "1717913851", "Julio", "González Castaño", "C Sharp", 10, 22));
        estudiantes.add(new Estudiante(14, "1717986531", "Gloria", "Rodas Carretero", "Ruby", 7, 18));
        estudiantes.add(new Estudiante(15, "1717975232", "Jaime", "Jiménez Gómez", "Java Script", 10, 18));



        //1. Muestra todos los alumnos: Lista de Alumnos debes usar una referencia a metodo.
        System.out.println("--- 1 ---");
        estudiantes.forEach(System.out::println);


        //2. Alumnos cuyo apellido empiezan con el caracter L u G
        System.out.println("--- 2 ---");
        estudiantes.stream().filter(n -> n.getApellidos().startsWith("L") || n.getApellidos().startsWith("G"))
                .forEach(n -> System.out.println(n));


        //3. Número de Alumnos
        System.out.println("--- 3 ---");
        System.out.println(estudiantes.stream().count() + " estudiantes");


        //4. Alumnos con nota mayor a 9 y que sean del curso PHP
        System.out.println("--- 4 ---");

        estudiantes.stream()
                .filter(n -> n.getNota() > 9 && n.getNombreCurso().equals("PHP"))
                .forEach(n -> System.out.println(n));


        //5. Imprimir los 2 primeros Alumnos de la lista
        System.out.println("--- 5 ---");
        estudiantes.stream().sorted(Comparator.comparing(Estudiante::getNombre))
                .limit(2)
                .forEach(n -> System.out.println(n));


        //6. Imprimir el alumno con menor edad
        System.out.println("--- 6 ---");

        estudiantes.stream().sorted(Comparator.comparing(Estudiante::getEdad))
                .limit(1)
                .forEach(n -> System.out.println(n));


        //7. Imprimir el alumno con mayor edad
        System.out.println("--- 7 ---");

        estudiantes.stream().sorted(Comparator.comparing(Estudiante::getEdad).reversed())
                .limit(1)
                .forEach(n -> System.out.println(n));


        //8. Encontrar el primer Alumno
        System.out.println("--- 8 ---");
        estudiantes.stream().limit(1).forEach(n -> System.out.println(n));


        //9. Alumnos que tienen un curso en el que el nombre contienen la A
        System.out.println("--- 9 ---");
        estudiantes.stream().filter(n -> n.getNombreCurso().contains("A") || n.getNombreCurso().contains("a"))
                .forEach(n -> System.out.println(n));


        //10. Alumnos en que la longitud de su nombre es mayor a 10 caracteres
        System.out.println("--- 10 ---");
        estudiantes.stream().filter(n -> n.getNombre().length() > 10)
                .forEach(n -> System.out.println(n));


        //11. Obtiene los alumnos en los cuales el nombre del curso empieza con el caracter 'P' y la longitud sea <= a 6
        System.out.println("--- 11 ---");
        estudiantes.stream().filter(n -> n.getNombreCurso().startsWith("P") && n.getNombreCurso().length() <=6)
                .forEach(n -> System.out.println(n));


        //12. Crea una nueva lista llamada “listaNueva” con el contenido de la consulta anterior.
        System.out.println("--- 12 ---");
        List<Estudiante> listaNueva =  estudiantes.stream().filter(n -> n.getNombreCurso().startsWith("P") && n.getNombreCurso().length() <= 6)
                .toList();


        listaNueva.forEach(n -> System.out.println(n));


    }



}
