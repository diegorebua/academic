import java.util.Scanner;

public class AreaTriangulo{
    public static void main(String[] args) {

        int base = 0, altura = 0, area = 0;
        Scanner scn = new Scanner(System.in);

        System.out.println("\nEsse programa calcula a área de um triangulo!");
        System.out.println("\nDigite o valor da base do triangulo: ");
        base = scn.nextInt();

        System.out.println("Digite o valor da altura do triangulo: ");
        altura = scn.nextInt();

        area = base * altura / 2;

        System.out.println("\nA área do triangulo com base " + base + " e altura " + altura + " é = " + area);  
    
        scn.close();
    }
}