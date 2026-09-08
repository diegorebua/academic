package Aula_2;

import javax.swing.JOptionPane;

public class aula1Main {
    public static void main(String[] args) {
        int escolha = 0;
        Invertido vetores = new Invertido();
        TresVetores matriz = new TresVetores();
        Binario binario = new Binario();
        Decimal decimal = new Decimal();
        Object[] interacoes = { "Inverter valores", "Matriz 8x3", "Binario para decimal", "Decimal para binario",
                "Terminar exercicio" };

        JOptionPane.showMessageDialog(null, "Exercicio da Primeira aula");

        do {

            escolha = JOptionPane.showOptionDialog(null, "Qual exercicio voce gostaria de fazer?", "Painel de escolha",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, interacoes, interacoes[0]);

            switch (escolha) {
                case 0:
                    String numer = "";
                    JOptionPane.showMessageDialog(null, "Exercicio de inverter o vetor");
                    numer = JOptionPane.showInputDialog("Digite o numero (limite de 8)");
                    vetores.criarVetor(numer);
                    vetores.inverter();
                    vetores.mostrarInvertido();
                    break;

                case 1:
                    int vetor1[] = new int[8];
                    int vetor2[] = new int[8];
                    int vetor3[] = new int[8];
                    String valor = "";

                    JOptionPane.showMessageDialog(null, "Exercicio de criar 3 vetores e colocar numa matriz 3x8");
                    JOptionPane.showMessageDialog(null, "vamos inserir o valor do vetor 1:");
                    valor = JOptionPane.showInputDialog("Insira o valor:");
                    for (int i = 0; i < 8; i++) {
                        vetor1[i] = valor.charAt(i) - '0';
                        matriz.setVetor1(vetor1);
                    }
                    valor = "";
                    JOptionPane.showMessageDialog(null, "vamos inserir o valor do vetor 2:");
                    valor = JOptionPane.showInputDialog("Insira o valor:");
                    for (int i = 0; i < 8; i++) {
                        vetor2[i] = valor.charAt(i) - '0';
                        matriz.setVetor2(vetor2);
                    }
                    valor = "";
                    JOptionPane.showMessageDialog(null, "vamos inserir o valor do vetor 3:");
                    valor = JOptionPane.showInputDialog("Insira o valor:");
                    for (int i = 0; i < 8; i++) {
                        vetor3[i] = valor.charAt(i) - '0';
                        matriz.setVetor3(vetor3);
                    }

                    matriz.mostrarMatriz();
                    break;

                case 2:
                    String numero = "";
                    JOptionPane.showMessageDialog(null, "Exercicio de converter um valor binario para decimal");
                    numero = JOptionPane.showInputDialog("Vamos digitar o numero:");
                    binario.setNumero(numero);

                    binario.converter(numero);
                    binario.mostrarDecimal();

                    break;

                case 3:
                    int num;

                    JOptionPane.showMessageDialog(null, "Exercicio de converter um valor decimal para binario");
                    num = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor:"));
                    decimal.convertDecimal(num);
                    decimal.mostrarBinario();

                    break;
                default:
                    break;
            }

        } while (escolha != 4);
    }
}