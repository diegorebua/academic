
import java.util.Scanner;

public class Fibonacci{

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int a=1,b=1,aux=0,n=0;

        System.out.println("\nNúmero: ");
        n=scn.nextInt();

        for(int i = 0;i <= n;i ++){

        aux=a;
        a+=b;
        b=aux;
        System.out.println(aux);

        }
        scn.close();
    }
}