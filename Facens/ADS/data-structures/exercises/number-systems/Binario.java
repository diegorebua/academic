package Aula_2;

import javax.swing.JOptionPane;

public class Binario {
    private int[] binario = new int[8];
    private int numeroDecimal = 0;
    private String numero;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getNumeroDecimal() {
        return numeroDecimal;
    }

    public int[] getBinario() {
        return binario;
    }

    public void converter(String numero) {
        if (numero.length() <= 8 && numero.length() > 0) {
            for (int i = 0; i < binario.length; i++) {
                binario[i] = numero.charAt(i) - '0';
            }
            numeroDecimal = 0;
            for (int i = 0; i < binario.length; i++) {
                numeroDecimal += binario[i] * Math.pow(2, 7 - i);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Numero Invalido");
        }
    }

    public void mostrarDecimal() {

        JOptionPane.showMessageDialog(null, "O numero fica:"+numeroDecimal);
    }
}