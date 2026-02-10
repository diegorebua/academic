
import java.util.Scanner;

public class ConverterMedidas{

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int opcao;
        double medida;

        System.out.println("Escolha a unidade para conversão: (1)Metros;(2)KM;(3)cm");
        opcao = scn.nextInt();

        switch(opcao){

            case 1: System.out.println("Para Metros. Insira o valor para converter:");
                    medida = scn.nextDouble();

                    medida = medida/100;

                    System.out.println("A medida em Metros é igual a:"+medida+"m");
                    break;

            case 2: System.out.println("Para KM. Insira o valor para converter:");
                    medida = scn.nextDouble();

                    medida = medida/100;

                    System.out.println("A medida em KM é igual a:"+medida+"km");
                    break;

            case 3: System.out.println("Para cm. Insira o valor para converter:");
                    medida = scn.nextDouble();

                    medida = medida/100;

                    System.out.println("A medida em cm é igual a:"+medida+"cm");
                    break;

            default: System.out.println("Opcao invalida");
        }

        scn.close();
    }
}