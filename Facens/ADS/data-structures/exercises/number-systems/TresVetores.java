package Aula_2;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class TresVetores {
    private int[] vetor1 = new int[8];
    private int[] vetor2 = new int[8];
    private int[] vetor3 = new int[8];
    private int[][] matriz = new int[3][8];

    // Getters
    public int[] getVetor1() {
        return vetor1;
    }

    public int[] getVetor2() {
        return vetor2;
    }

    public int[] getVetor3() {
        return vetor3;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setVetor1(int[] vetor1) {
        if (vetor1.length == 8) {
            this.vetor1 = vetor1;
            matriz[0] = vetor1;
        } else {
            JOptionPane.showMessageDialog(null, "O vetor precisa ter 8 elementos.");
        }
    }

    public void setVetor2(int[] vetor2) {
        if (vetor2.length == 8) {
            this.vetor2 = vetor2;
            matriz[1] = vetor2;
        } else {
            JOptionPane.showMessageDialog(null, "O vetor precisa ter 8 elementos.");;
        }
    }

    public void setVetor3(int[] vetor3) {
        if (vetor3.length == 8) {
            this.vetor3 = vetor3;
            matriz[2] = vetor3;
        } else {
            JOptionPane.showMessageDialog(null, "O vetor precisa ter 8 elementos.");
        }
    }

    public void mostrarMatriz() {
        JOptionPane.showMessageDialog(null,"A matriz fica: "+ Arrays.deepToString(matriz));
    }
}