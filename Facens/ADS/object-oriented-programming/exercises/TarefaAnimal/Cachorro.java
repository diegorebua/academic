package TarefaAnimal;

public class Cachorro extends Animal {
    private int velocidade;

    public Cachorro() {
    }

    public Cachorro(String nome, int idade, int velocidade) {
        super(nome, idade);
        this.velocidade = velocidade;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    public String imprimir() {
        return super.imprimir() + ", Velocidade: " + velocidade;
    }

    @Override
    public String falar() {
        return "Au Auuuu";
    }
}
