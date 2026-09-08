package Aula_2;

import javax.swing.JOptionPane;

public class Decimal {
    private int[] decimal = new int[8];
    private int numero = 0;

    public int[] getDecimal() {
        return decimal;
    }

    public void setDecimal(int[] decimal) {
        this.decimal = decimal;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void convertDecimal(int numero) {
        for (int i = 7; i >= 0; i--) {
            decimal[i] = numero % 2;
            numero /= 2;
        }
    }

   public void mostrarBinario() {
    String mensagem = "";

    for (int bit : decimal) {
        mensagem = mensagem + bit + " ";
    }

    JOptionPane.showMessageDialog(null, "Binário em 8 bits: " + mensagem);
}
    }
