
// Já foi visto

import java.util.Scanner;

public class CaractereseVogais {

    public static void main(String[] args){
    Scanner scn = new Scanner(System.in);

        System.out.println("\nDigite a frase:");
        String frase = scn.nextLine().toLowerCase();
        int qtd = frase.length();
        int vogal = 0;

        for(int i = 0; i < qtd; i++){
            char carac = frase.charAt(i);
            if(carac == 'a' || carac == 'e' || carac == 'i' || carac == 'o' || carac == 'u'){
                vogal ++;
                }
            }
        
            System.out.println("\nQuantidade de caracteres: " + qtd);
            System.out.println("Quantidade de vogais: " + vogal);
        
        scn.close();
        }
    }