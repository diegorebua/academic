
import java.util.Scanner;

public class Tabauda {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int num, resultado;

        System.out.println("Digite um número: ");
        num = scn.nextInt();

        for (int i = 1; i <=10; i++){
            resultado = num * i;
            System.out.println(num + " x " + i + " = " + resultado);
            }
        scn.close();
        }
    }