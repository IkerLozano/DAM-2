import java.util.Random;
import java.util.Scanner;

public class Ej2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //int random = (int) (Math.random()*100+1);
        int random = 10;

        int num = 0;

        int cont = 0;

        do {

            System.out.println("Dime un numero");
            num = sc.nextInt();

            if (num > random){
                System.out.println("El número es menor");
            }

            if (num < random){
                System.out.println("El número es mayor");
            }


            cont = cont + 1;



        }while (num != random);


        if (num == random){
            System.out.println("Lo has adivinado");
            System.out.println("Lo has echo en " + cont + " intentos");
        }
    }
}
