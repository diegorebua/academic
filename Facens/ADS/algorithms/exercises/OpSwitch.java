
import java.util.Scanner;

public class OpSwitch{

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int opcao;
        double num1, num2, resultado;

        System.out.println("Escolha a operação desejada:");
        System.out.println("(1) para soma");
        System.out.println("(2) para subtração");
        System.out.println("(3) para divisão");
        System.out.println("(4) para multiplicação");
        opcao = scn.nextInt();

        switch(opcao){

            case 1: System.out.println("Insira o primeiro numero:");
                    num1 = scn.nextDouble();
                    System.out.println("Insira o segundo numero:");
                    num2 = scn.nextDouble();

                    resultado = num1 + num2;

                    System.out.println("O resultado de:"+num1+" + "+num2+"é igual a: "+resultado);
                    break;

            case 2: System.out.println("Insira o primeiro numero:");
                    num1 = scn.nextDouble();
                    System.out.println("Insira o segundo numero:");
                    num2 = scn.nextDouble();

                    resultado = num1 - num2;

                    System.out.println("O resultado de:"+num1+" - "+num2+"é igual a: "+resultado);
            
                    break;

            case 3: System.out.println("Insira o primeiro numero:");
                    num1 = scn.nextDouble();
                    System.out.println("Insira o segundo numero:");
                    num2 = scn.nextDouble();

                    resultado = num1 / num2;

                    System.out.println("O resultado de:"+num1+" / "+num2+"é igual a: "+resultado);
            
                    break;

            case 4: System.out.println("Insira o primeiro numero:");
                    num1 = scn.nextDouble();
                    System.out.println("Insira o segundo numero:");
                    num2 = scn.nextDouble();

                    resultado = num1 * num2;

                    System.out.println("O resultado de:"+num1+" * "+num2+"é igual a: "+resultado);
            
                    break;

            default: System.out.println("Opcao invalida");
        }

        scn.close();
    }
}