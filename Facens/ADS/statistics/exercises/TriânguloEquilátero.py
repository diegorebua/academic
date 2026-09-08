# g) Imprimir um triângulo equilátero

print("--- g) Triângulo equilátero ---")
n = int(input("Digite um número inteiro positivo (n > 1) para a altura: "))

if n <= 1:
    print("O número deve ser maior que 1.")
else:
    for i in range(1, n + 1):
        # Espaços para alinhar o triângulo
        print(" " * (n - i), end="")
        # Símbolos # para a base do triângulo
        print("#" * (2 * i - 1))