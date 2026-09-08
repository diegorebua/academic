
// Já foi visto

import java.util.Scanner;

public class NumerosDivisiveis7{

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int inicio, fim;

        System.out.println("\nDigite número do início:");
        inicio = scn.nextInt();

        System.out.println("Digite o número do fim:");
        fim = scn.nextInt();

        System.out.println("Números divisíveis por 7 no intervalo:");
        for(int cont = inicio; cont <= fim; cont++){
            if (cont % 7 == 0){
                System.out.println(cont);
            }
        }
        scn.close();
    }
}