package TarefaDAO.dao;

import TarefaDAO.entity.Produto;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Inserir Produto");
            System.out.println("2 - Apagar Produto");
            System.out.println("3 - Editar Produto");
            System.out.println("4 - Listar Todos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    Produto novo = new Produto();
                    System.out.print("Nome: ");
                    novo.setNome(scanner.nextLine());
                    System.out.print("Quantidade: ");
                    novo.setQuantidade(Integer.parseInt(scanner.nextLine()));
                    System.out.print("Valor Unitário: ");
                    novo.setValorUnitario(Double.parseDouble(scanner.nextLine()));
                    dao.inserir(novo);
                    break;
                case "2":
                    System.out.print("ID para apagar: ");
                    dao.apagar(Integer.parseInt(scanner.nextLine()));
                    break;
                case "3":
                    Produto editado = new Produto();
                    System.out.print("ID do produto: ");
                    editado.setId(Integer.parseInt(scanner.nextLine()));
                    System.out.print("Novo nome: ");
                    editado.setNome(scanner.nextLine());
                    System.out.print("Nova quantidade: ");
                    editado.setQuantidade(Integer.parseInt(scanner.nextLine()));
                    System.out.print("Novo valor unitário: ");
                    editado.setValorUnitario(Double.parseDouble(scanner.nextLine()));
                    dao.editar(editado);
                    break;
                case "4":
                    List<Produto> produtos = dao.listarTodos();
                    for (Produto p : produtos) {
                        System.out.println("ID: "+ p.getId()
                                + " | Nome: "+ p.getNome()
                                + " | Quantidade: " + p.getQuantidade()
                                + " | Valor: R$ "+ p.getValorUnitario());
                    }
                    break;
                case "0":
                    System.out.println("Encerrando...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scn.close();
    }
}
