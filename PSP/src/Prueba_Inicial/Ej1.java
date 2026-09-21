import java.util.Scanner;

public class Ej1 {
    public static void main() {

        Scanner sc = new Scanner(System.in);


        int contL = 0;
        double sumaL = 0.0;

        for (int i = 0; i <2 ; i++) {

            System.out.print("Dime la nota de Lengua " + (i+1) + " : ");
            double nota = sc.nextDouble();

            contL = contL+1;
            sumaL = sumaL+nota;
        }

        double mediaL = 0.0;
        mediaL = sumaL/contL;
        System.out.println("La media es: " + mediaL);

        if (mediaL < 5) {
            System.out.println("Estas suspenso");
        } else if (mediaL == 9 || mediaL == 10) {
            System.out.println("sobresaliente ");
        } else{
            System.out.println("Estas aprobado");
        }


        //--------------------------------

        int contM = 0;
        double sumaM = 0.0;

        for (int i = 0; i <2 ; i++) {

            System.out.print("Dime la nota de Mates " + (i+1) + " : ");
            double nota = sc.nextDouble();

            contM = contM+1;
            sumaM = sumaM+nota;
        }

        double mediaM = 0.0;
        mediaL = sumaM/contM;
        System.out.println("La media es: " + mediaL);

        if (mediaM < 5) {
            System.out.println("Estas suspenso");
        } else if (mediaM == 9 || mediaM == 10) {
            System.out.println("sobresaliente ");
        } else{
            System.out.println("Estas aprobado");
        }


        //--------------------------------

        int contS = 0;
        double sumaS = 0.0;

        for (int i = 0; i <2 ; i++) {

            System.out.print("Dime la nota de Sociales " + (i+1) + " : ");
            double nota = sc.nextDouble();

            contS = contS+1;
            sumaS = sumaS+nota;
        }

        double mediaS = 0.0;
        mediaS = sumaS/contS;
        System.out.println("La media es: " + mediaS);

        if (mediaS < 5) {
            System.out.println("Estas suspenso");
        } else if (mediaS == 9 || mediaS == 10) {
            System.out.println("sobresaliente ");
        } else{
            System.out.println("Estas aprobado");
        }

    }
}
