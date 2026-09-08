import java.util.Scanner;
import java.util.Stack;

public class ValidadorDeParenteses {

    /**
     * Valida se uma string de expressão matemática tem parênteses, colchetes e chaves balanceados.
     * Utiliza uma pilha para garantir que cada símbolo de abertura tenha um símbolo de fechamento
     * correspondente na ordem correta.
     * @param expression A string de entrada a ser validada.
     * @return
     */
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '(') {
                stack.push(')');
            } else if (ch == '}' || ch == ']' || ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (ch != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] testCases = {
            "{ [ ( ) ( ) ] }",
            "{ [ ( ) ) ] }",
            "([{}])",
            "({[",
            "([)]"
        };

        System.out.println("--- Verificação de Parênteses Balanceados ---");

        for (String testCase : testCases) {
            System.out.printf("Entrada: \"%s\" -> Saída: %s%n", testCase, isBalanced(testCase) ? "Balanceado" : "Desbalanceado");
        }

        System.out.println("\n--- Digite sua própria expressão para verificar (ou 'sair' para encerrar) ---");
        String input;
        while (true) {
            System.out.print("Digite a expressão: ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("sair")) {
                break;
            }
            System.out.printf("Entrada: \"%s\" -> Saída: %s%n", input, isBalanced(input) ? "Balanceado" : "Desbalanceado");
        }

        scanner.close();
    }
}