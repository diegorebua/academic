import java.util.Scanner;

public class SomaWhile {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int numero,
      soma = 0;

    System.out.println("Digite o primeiro número:");
    numero = scn.nextInt();

    while (numero >= 0) {
      soma += numero;
      System.out.println("Soma atual: " + soma);
      System.out.println(
        "Digite o próximo número (número negativo para parar):"
      );
      numero = scn.nextInt();
    }
    System.out.println("Soma final dos números digitados: " + soma);
    scn.close();
  }
}
