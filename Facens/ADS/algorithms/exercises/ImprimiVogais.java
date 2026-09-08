
import java.util.Scanner;

public class ImprimiVogais{

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        char inicio, fim;

        System.out.println("\nDigite a primeira palavra: ");
        inicio = scn.next().toLowerCase().charAt(0);
        System.out.println("\nDigite a segunda palavra: ");
        fim = scn.next().toLowerCase().charAt(0);

        System.out.println("\nVogais: ");
        for(char cont = inicio; cont <= fim; cont++){
            if(cont == 'a' || cont == 'e' || cont == 'i' || cont == 'o' || cont == 'u'){
                System.out.println(cont);
            }
        }

    scn.close();
    }
    
}