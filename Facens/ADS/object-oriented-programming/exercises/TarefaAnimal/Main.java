package TarefaAnimal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        Cachorro cachorro = new Cachorro("Pitoco", 7, 0);
        Gato gato = new Gato("Gamora", 4, 0);
        Capivara capivara = new Capivara("Capivarito", 15, 0);

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar velocidade, salto e peso.");
            System.out.println("2 - Mostrar todos os animais.");
            System.out.println("3 - Mostrar som do animal.");
            System.out.println("4 - Sair.");
            System.out.println("\nEscolha uma opção:");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\nQual animal deseja cadastrar os dados?");
                    System.out.println("1 - Velocidade do cachorro.");
                    System.out.println("2 - Altura do Salto do gato.");
                    System.out.println("3 - Peso da capivara");
                    System.out.println("\nEscolha uma opção:");
                    int escolha = sc.nextInt();

                    switch (escolha) {
                        case 1:
                            System.out.print("Digite a velocidade do cachorro (km/h): ");
                            int velocidade = sc.nextInt();
                            cachorro.setVelocidade(velocidade);
                            break;
                        case 2:
                            System.out.print("Digite a altura do salto do gato (cm): ");
                            int altura = sc.nextInt();
                            gato.setAlturaSalto(altura);
                            break;
                        case 3:
                            System.out.print("Digite o peso da capivara (kg): ");
                            int peso = sc.nextInt();
                            capivara.setPeso(peso);
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                    break;

                case 2:
                    System.out.println("\nDados dos Animais");
                    System.out.println(cachorro.imprimir());
                    System.out.println(gato.imprimir());
                    System.out.println(capivara.imprimir());
                    break;

                case 3:
                    System.out.println("\nAnimais Falando");
                    System.out.println(cachorro.getNome() + ": " + cachorro.falar());
                    System.out.println(gato.getNome() + ": " + gato.falar());
                    System.out.println(capivara.getNome() + ": " + capivara.falar());
                    break;

                case 4:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 4);

        sc.close();
    }
}
