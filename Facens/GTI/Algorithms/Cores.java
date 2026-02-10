
import java.util.Scanner;

public class Cores{

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        String cor;

        System.out.println("Insira o nome da cor; as opcoes sao: azul, vermelho ou verde.");
        cor = scn.next();

        switch(cor){

            case "azul":System.out.println("Azul é a cor do céu e do mar");
                        break;
            
            case "vermelho":System.out.println("Vermelho é a cor do sangue e das rosas");
                            break;
            
            case "verde":System.out.println("Verde é a cor da grama");
                         break;

            default:System.out.println("Valor invalido; use letras minusculas e use umas as cores disponiveis.");
        }                   

        scn.close();
    }
}