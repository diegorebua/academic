
import java.util.Scanner;

public class VerificarNumero{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double numero;

        System.out.println("\nInsira o número: ");
        numero = scn.nextDouble();

        if(numero < 0){
            System.out.println("O número:" + numero + " é negativo");
        }else if(numero == 0){
            System.out.println("O número:" + numero + " é zero");
        }else{
            System.out.println("O número:" + numero + " é positivo");
        }
        scn.close();
    }
}