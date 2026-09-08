package Aula_2;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class Invertido {
    private int[] vetor = new int[8];
    private int[] vetorInvertido = new int[8];

    public int[] getVetor() {
        return vetor;
    }

    public int[] getVetorInvertido() {
        return vetorInvertido;
    }

    public void criarVetor(String numero) {
        if (numero.length() <= 8 && numero.length() > 0) {
            for (int i = 0; i < vetor.length; i++) {
                vetor[i] = numero.charAt(i) - '0';
            }
        } else {
            JOptionPane.showMessageDialog(null, "Numero Invalido");
        }
    }

    public void inverter() {
        for (int i = 0; i < vetor.length; i++) {
            vetorInvertido[i] = vetor[vetor.length - 1 - i];
        }
    }

    public void mostrarInvertido() {
        JOptionPane.showMessageDialog(null, "Os valores invertidos são: "+Arrays.toString(vetorInvertido));
    }
}