
// Já foi visto

import java.util.Scanner;

public class SequenciaDecrescente{

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        System.out.println("\nInsira o número:");
        int num = scn.nextInt();

        for(int i = num; i > 0; i --){
            for(int j = 1; j < i; j ++){
                System.out.print(j+" ");
            }
            System.out.println(i);
        }

    scn.close();
    }
    
}