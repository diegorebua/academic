
// Já foi visto

import java.util.Scanner;

public class CalculoPar{

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int numero;

        System.out.println("\nInsira o numero desejado: ");
        numero = scn.nextInt();

        System.out.println("\nNúmeros pares de 2 até " + numero + ":");
        for(int cont = 2;cont <= numero;cont += 2){
        System.out.println(cont);
    
        }
        scn.close();
    }
}