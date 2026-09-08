
import java.util.Scanner;

public class Vetores2 {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        char[] vetorChar;
        String texto = "texto qualquer";

        vetorChar = new char[texto.length()];

        for(int i = 0; i < texto.length(); i++){
            vetorChar[i] = texto.charAt(i);
        }

        System.out.println(vetorChar);
        

        int[] vetor = {1, 2, 3};
        System.out.println(vetor);

        scn.close();
    }
}