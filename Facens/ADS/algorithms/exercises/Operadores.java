
import java.util.Scanner;

public class Operadores {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int primeiroValor, segundoValor, total = 0;

        System.out.println("Insira o primeiro valor: ");
        primeiroValor = scn.nextInt();
        System.out.println("Insira a operação desejada (+, -, / ou *): ");
        String op = scn.next();
        System.out.println("Insira o segundo valor: ");
        segundoValor = scn.nextInt();

        if (op.equals ("+")){
            total = primeiroValor+segundoValor;
            System.out.println("O calculo de "+ primeiroValor + " " + op + " "+ segundoValor + " É igual a: "+total);
        }else if (op.equals ("-")){
            total = primeiroValor-segundoValor;
            System.out.println("O calculo de "+ primeiroValor + " " + op + " "+ segundoValor + " É igual a: "+total);
        }else if (op.equals ("/")){
            total = primeiroValor/segundoValor;
            System.out.println("O calculo de "+ primeiroValor + " " + op + " "+ segundoValor + " É igual a: "+total);
        }else if (op.equals("*")){
            total = primeiroValor*segundoValor;
            System.out.println("O calculo de "+ primeiroValor + " " + op + " "+ segundoValor + " É igual a: "+total);
        }
        else{
            System.out.println("Operador invalido");
        }
        scn.close();
    }    
}