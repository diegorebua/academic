
import java.util.Scanner;

public class MediadasNotas{

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        double notaAC1, notaAC2, notaAG, notaAF, notaMinima;
        double calculoNotaAC1, calculoNotaAC2, calculoNotaAG, calculoNotaAF, calculoFinal;

        System.out.println("Insira a nota da Avaliação Continuada 1(AC1):");
        notaAC1 = scn.nextDouble();
        System.out.println("Insira a nota da Avaliação Continuada 2(AC2):");
        notaAC2 = scn.nextDouble();
        System.out.println("Insira a nota da Avaliação Geral(AG):");
        notaAG = scn.nextDouble();
        System.out.println("Insira a nota da Avaliação Final(AF):");
        notaAF = scn.nextDouble();
        System.out.println("Insira a nota minima para ser aprovado:");
        notaMinima = scn.nextDouble();

        calculoNotaAC1 = notaAC1 * 0.15;
        calculoNotaAC2 = notaAC2 * 0.30;
        calculoNotaAG = notaAG * 0.10;
        calculoNotaAF = notaAF * 0.45;

        calculoFinal = calculoNotaAC1 + calculoNotaAC2 + calculoNotaAG + calculoNotaAF;

        if(calculoFinal >= notaMinima && calculoFinal <= 10){
            System.out.println("Aprovado! sua nota foi: "+calculoFinal);
        }else if(calculoFinal < notaMinima){
            System.out.println("Reprovado! sua nota foi: "+calculoFinal);
        }
        else{
            System.out.println("Valor invalido");
        }
        scn.close();
    }
}