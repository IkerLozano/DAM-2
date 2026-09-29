package API_Stream.Ejercicios.Ej10_part2;

import API_Stream.Ejercicios.Ej10_part2.Productos;



import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {


        Path archivo = Path.of("src/API_Stream/Ejercicios/Ej10_part2/products (1).csv");

        List<Productos> productos = new ArrayList<>();


        try (BufferedReader leer = Files.newBufferedReader(archivo)) {

            leer.readLine();

            String linea;

            while ((linea = leer.readLine()) != null){

                String[] datos = linea.split(",");

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


                productos.add(new Productos(productID, productName, supplierID, categoryID, quantityPerUnit, unitPrice, unitsInStock, unitsOnOrder, reorderLevel, discontinued));

            }



            //Imprime la lista de productos.
            System.out.println("--- 1 ---");
            productos.forEach(n -> System.out.println(n));

            //Realiza el equivalente a un select name from productos.
            System.out.println("--- 2 ---");
            productos.stream().map(Productos::getProductName).forEach(n -> System.out.println(n));

            //Imprime el nombre de los productos cuyo stock sea menos a 10
            System.out.println("--- 3 ---");
//            productos.stream().filter(n -> n.getUnitsInStock() <10).map(Productos::getProductName)
//                    .forEach(n -> System.out.println(n));
                        //este no deja poner dos valores en el for pq el map solo nos deja el nomnre

            productos.stream().filter(n -> n.getUnitsInStock() <10)
                    .forEach((n -> System.out.println(n.getProductName() + ": " + n.getUnitsInStock() + " en stock")));




            //Imprime el nombre de los productos cuyo stock sea menor a 10, pero ordenado por número de el número de stock de menor a mayor
            System.out.println("--- 4 ---");





        } catch (Exception e) {
            System.out.println("Error: " +  e.getMessage());
        }



    }
}
