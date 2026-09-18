import java.util.Scanner;

public class Ej3 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int[] array = new int[10];

        for (int i = 0; i <10 ; i++) {
            System.out.println("Dime el numero " + (i+1));
            array[i] = sc.nextInt();
        }

        int mayor = array[0];
        int menor = array[0];
        int suma = 0;
        double media = 0.0;

        for (int j = 0; j <array.length ; j++) {

          if (mayor < array[j]){
              mayor = array[j];
          }

            if (menor > array[j]){
                menor = array[j];
            }

          suma = suma+array[j];

        }

        System.out.println("El numero mas grande es el " + mayor);
        System.out.println("La suma de todos es " + suma);

        media = suma/10;
        System.out.println("La media es " + media);

        System.out.println("El numero mas pequeño es el " + menor);

    }
}
