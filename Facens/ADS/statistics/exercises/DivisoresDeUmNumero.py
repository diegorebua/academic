# a) Imprimir os divisores de um número

print("--- a) Divisores de um número ---")
num = int(input("Digite um número inteiro positivo (n > 1): "))

if num <= 1:
    print("O número deve ser maior que 1.")
else:
    print(f"Os divisores de {num} são:")
    for i in range(1, num + 1):
        if num % i == 0:
            print(i)