
import java.util.Scanner;

public class Vetores{

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int qtdNotas = 5;
        double[] notas = new double[qtdNotas];
        double media = 0.0;

        double notaTmp = 0.0;

        System.out.println("Digite as notas: ");
        for(int i = 0; i < notas.length; i++){
            do{
            System.out.println("Digite a nota " + (i + 1) + " : ");
            notaTmp = scn.nextDouble();
            } while (!(notaTmp >= 0 && notaTmp <= 10));
            notas[i] = notaTmp;
        }

        double soma = 0.0;

        for(int i = 0; i < notas.length; i++){
            soma += notas[i];
        }

        media = soma / notas.length;
        System.out.println("A media e: " + media);
        System.out.println("As notas sao: ");
        for(int i = notas.length; i > 0; i--){
            System.out.println(notas[i]);
        }
        

        scn.close();
    }
}