package Aula_2;
// atividade de numeros aleatorios de estrutura de dados

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class AdvinharNumero0a100 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Random gerador = new Random();
        int palpite = 0;

        int numAleatorio = gerador.nextInt(100);

        JOptionPane.showMessageDialog(null, "Vamos adivinhar o numero de 0 a 100");
        do {
            palpite = Integer.parseInt(JOptionPane.showInputDialog("Digite o seu palpite: "));
            if (palpite >= 0 && palpite <= 100) {
                if (palpite < numAleatorio) {
                    JOptionPane.showMessageDialog(null, "Ops. Seu numero é muito baixo, coloque um numero maior");
                } else if (palpite > numAleatorio) {
                    JOptionPane.showMessageDialog(null, "Opa. Seu numero é muito alto, digite um numero menor");

                } else {
                    JOptionPane.showMessageDialog(null, "Parabens! voce acertou o numero! O numero é: " + numAleatorio);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Digite um numero entre 0 a 100!");
            }
        } while (palpite != numAleatorio);
        scn.close();
    }
}