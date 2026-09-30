package TEMA_1.API_Stream.Ejercicios.PackEjerciciosExamenStreams.Ej10;


import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {


        Path archivo = Path.of("src/TEMA_1.API_Stream/Ejercicios/Ej10_part2/products (1).csv");

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
//           productos.stream().filter(n -> n.getUnitsInStock() <10).map(Productos::getProductName)
//                    .forEach(n -> System.out.println(n));
                        //este no deja poner dos valores en el for pq el map solo nos deja el nomnre



            productos.stream().filter(n -> n.getUnitsInStock() <10)
                    .forEach((n -> System.out.println(n.getProductName() + ": " + n.getUnitsInStock() + " en stock")));



            //Imprime el nombre de los productos cuyo stock sea menor a 10, pero ordenado por número de el número de stock de menor a mayor
            System.out.println("--- 4 ---");
            productos.stream()
                    .filter(n -> n.getUnitsInStock()<10)
                    .sorted(Comparator.comparing(Productos::getUnitsInStock))
                    .forEach(n -> System.out.println(n));



            //Realiza la misma consulta anterior pero ahora ordenando de mayor a menor.
            System.out.println("--- 5 ---");
            productos.stream()
                    .filter(n -> n.getUnitsInStock()<10)
                    .sorted(Comparator.comparing(Productos::getUnitsInStock).reversed())
                    .forEach(n -> System.out.println(n));


            /*
            Muestra el nombre de los productos con unidades en stock mayor de 10 ordenados
            ordenar por unidad de stock de forma descendente y por nombre de producto de
            forma ascendente.
             */
            System.out.println("--- 6 ---");
            productos.stream()
                    .filter(n -> n.getUnitsInStock() > 10)
                    .sorted(Comparator.comparing(Productos::getUnitsInStock).reversed()
                            .thenComparing(Productos::getProductName))
                    .forEach(n -> System.out.println(n));



            /*
            Muestra el nombre de los productos con unidades en stock mayor de 10 ordenados
            ordenar por unidad de stock de forma ascendente y por nombre de producto de forma
            descendente.

             */
            System.out.println("--- 7 ---");
            productos.stream()
                    .filter(n -> n.getUnitsInStock() > 10)
                    .sorted(Comparator.comparing(Productos::getUnitsInStock)
                            .thenComparing(Comparator.comparing(Productos::getProductName).reversed()))
                    .forEach(n -> System.out.println(n));



            //Obtener el número de productos agrupados por proveedor.
            System.out.println("--- 8 ---");
            productos.stream().collect(Collectors.groupingBy(Productos::getSupplierID, Collectors.counting()))
                    .forEach((n, a) -> System.out.println("El proverdor " + n  + " tiene " + a + " productos"));



            /*
            Obtener la suma del precio unitario de todos los productos agrupados por el número
            de existencias en el almacén, pero solo obtener aquellos registros cuya suma sea
            mayor a 100
            */
            System.out.println("--- 9 ---");
            productos.stream()
                    .collect(Collectors.groupingBy(Productos::getUnitsInStock, Collectors.summingDouble(Productos::getUnitPrice)))
                    .entrySet().stream()
                    .filter(n -> n.getValue() > 100)
                    .forEach((n) -> System.out.println("Existencias: " + n.getKey() + " --> " + "Precio: " + n.getValue()));



            //Calcula el promedio de existencias en almacén.
            System.out.println("--- 10 ---");
            System.out.println(productos.stream().collect(Collectors.averagingInt(Productos::getUnitsInStock)));



            //Producto con el precio unitario más alto.
            System.out.println("--- 11 ---");
            productos.stream().sorted(Comparator.comparing(Productos::getUnitPrice).reversed())
                    .limit(1)
                    .forEach(n -> System.out.println(n));



            //Imprime la lista de productos, pero limitando el número de productos devueltos a 50
            System.out.println("--- 12 ---");
            productos.stream().limit(50)
                    .forEach(n -> System.out.println(n));



        } catch (Exception e) {
            System.out.println("Error: " +  e.getMessage());
        }



    }
}
