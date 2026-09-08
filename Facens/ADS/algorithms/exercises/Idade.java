
import java.util.Scanner;

public class Idade{

    public static void main (String [] args){
        Scanner scn = new Scanner(System.in);

        int idade;

        System.out.println("Insira a sua idade: ");
        idade = scn.nextInt();

        if(idade <= 12){
            System.out.println("Criança");
        }else if(idade > 12 && idade <= 18){
            System.out.println("Adolescente");
        }else if(idade > 18 && idade <= 60){
            System.out.println("Adulto");
        }else if (idade > 60){
            System.out.println("Idoso");
        }
        else{
            System.out.println("Valor invalido");
        }
        scn.close();
    }
}