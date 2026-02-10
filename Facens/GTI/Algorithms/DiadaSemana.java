
import java.util.Scanner;

public class DiadaSemana{

public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int opcao;

        System.out.println("Insira o numero do dia (1 a 7)");
        opcao = scn.nextInt();

        switch(opcao){

        case 1: System.out.println("Segunda-Feira");
                break;

        case 2: System.out.println("Terça-Feira");
                break;

        case 3: System.out.println("Quarta-feira");
                break;

        case 4: System.out.println("Quinta-Feira");
                break;

        case 5: System.out.println("Sexta-Feira");
                break;

        case 6: System.out.println("Sabado");
                break;

        case 7: System.out.println("Domingo");
                break;

        default: System.out.println("Opcao invalida");
        }

        scn.close();
}
}