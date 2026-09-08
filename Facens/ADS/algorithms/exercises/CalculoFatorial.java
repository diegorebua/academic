
// Já foi visto

import java.util.Scanner;

public class CalculoFatorial{

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int numero;

        System.out.println("\nInsira o numero desejado: ");
        numero = scn.nextInt();

        System.out.println("\nFatoriais do número 1 até " + numero + ":");
        
        for(int i = 1; i <= numero; i++){
          int fatorial = 1;
          for(int j = 1; j <=i; j++){
          fatorial *= j;
        }
        System.out.println(i + "! = " + fatorial);
        }
        scn.close();
    }
}