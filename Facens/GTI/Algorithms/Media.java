
import java.util.Scanner;

public class Media {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        double numero, media;

        System.out.println("Insira o primeiro numero: ");
        numero = scn.nextDouble();

        System.out.println("insira segundo numero: ");
        media = scn.nextDouble();

        media = numero + media;

        System.out.println("Insira o terceiro numero: ");
        numero = scn.nextDouble();

        media = (numero + media)/3;

        System.out.println("O resultado é: "+media);
    
        scn.close();
    }
}