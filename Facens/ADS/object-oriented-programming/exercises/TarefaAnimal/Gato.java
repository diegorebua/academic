package TarefaAnimal;

public class Gato extends Animal {
    private int AlturaSalto;

    public Gato() {
    }

    public Gato(String nome, int idade, int AlturaSalto) {
        super(nome, idade);
        this.AlturaSalto = AlturaSalto;
    }

    public int getAlturaSalto() {
        return AlturaSalto;
    }

    public void setAlturaSalto(int alturaSalto) {
        AlturaSalto = alturaSalto;
    }

    @Override
    public String imprimir() {
        return super.imprimir() + ", Altura do Salto: " + AlturaSalto;
    }

    @Override
    public String falar() {
        return "Miauuuu";
    }

}
