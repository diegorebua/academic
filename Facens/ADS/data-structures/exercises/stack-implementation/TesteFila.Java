package Estrutura_de_dados.Aula_3;

public class TesteFila;

    //Classe para tester a fila
    public static void main(String{} args){

        Fila minhaFila = new Fila();

        if(minhaFila.tamanho()==10)
            System.out.println("Tamanho igual a 10! Ok");
        else
            System.out.println("Erro!!! Temanho diferente");

        //Se não for implementado a rotina de proteção o código vai quebrar nesse ponto
        minhaFila.remover();
        minhaFila.exibirinicio();

        minhaFila.adicionar("D");
        minhaFila.adicionar("i");
        minhaFila.adicionar("e");
        minhaFila.adicionar("g");
        minhaFila.adicionar("o");

        if(minhaFila.tamanho()==5)
        {
            System.out.println("Tamanho ok!")
        }
        else
        {
            System.out.println("Tamanho incorreto!")
        }
        while (minhaFila.tamanho()>0){
            System.out.println(minhaFila.remover());
        }

    }