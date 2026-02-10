
import java.util.Scanner;

public class Maior{

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        double primeiroNumero, segundoNumero;

        System.out.println("Insira o primeiro numero: ");
        primeiroNumero = scn.nextDouble();
        System.out.println("Insira o segundo numero: ");
        segundoNumero = scn.nextDouble();

        if(primeiroNumero > segundoNumero){
            System.out.println("O numero:"+primeiroNumero+" é o maior numero");
        }
        else{
            System.out.println("O numero:"+segundoNumero+" é o maior numero");
        }
        scn.close();
    }
}