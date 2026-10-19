package TEMA_1.API_Stream.Ejercicios.PackEjerciciosExamenStreams.Ej4;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Path archivo = Path.of("src/TEMA_1.API_Stream/Ejercicios/Ej4_part2/products.csv");

        List<Productos> productos = new ArrayList<>();


        try (BufferedReader leer = Files.newBufferedReader(archivo)) {

            leer.readLine();//para no leer la primera linea

            String linea; //linea contiene una línea completa del CSV

            while ((linea = leer.readLine()) !=null){

                String[] datos = linea.split(","); //separamos la línea cada vez que encuentra una coma y guardamos cada parte en el array datos

                int productID = Integer.parseInt(datos[0]);
                String productName = datos[1];
                int supplierID = Integer.parseInt(datos[2]);
                int categoryID = Integer.parseInt(datos[3]);
                String quantityPerUnit = datos[4];
                double unitPrice = Double.parseDouble(datos[5]);
                int unitsInStock = Integer.parseInt(datos[6]);
                int unitsOnOrder = Integer.parseInt(datos[7]);
                int reorderLevel = Integer.parseInt(datos[8]);
                boolean discontinued = Boolean.parseBoolean(datos[9]);

                //creo un objeto Productos con todos los datos y lo añadimos al ArrayList
                productos.add(new Productos(productID, productName, supplierID, categoryID, quantityPerUnit, unitPrice, unitsInStock, unitsOnOrder, reorderLevel, discontinued));

            }

            //Calcula el producto más caro de cada categoría.
            System.out.println("--- producto más caro de cada categoría ---");
            productos.stream()
                    .collect(Collectors.groupingBy(Productos::getCategoryID, Collectors.maxBy(Comparator.comparing(Productos::getUnitPrice))))
                    .forEach((c, p) -> System.out.println("Categoria " + c + ": " + p)); //la segunda linea es opcinal, es solo para que se vea mjr


            //Imprime una lista con los productos cuyo precio está entre 10 y 20 euros.
            System.out.println("--- productos cuyo precio está entre 10 y 20 euros ---");
            productos.stream()
                    .filter(n -> n.getUnitPrice() >= 10 && n.getUnitPrice() <= 20)
                    .forEach(n -> System.out.println(n)); //no es neceario, solo para que se vea mjr


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
