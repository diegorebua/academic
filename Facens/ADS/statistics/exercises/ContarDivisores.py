# b) Contar o número de divisores de um número

print("--- b) Contagem de divisores ---")
num = int(input("Digite um número inteiro positivo (n > 1): "))
count = 0

if num <= 1:
    print("O número deve ser maior que 1.")
else:
    for i in range(1, num + 1):
        if num % i == 0:
            count += 1
    print(f"O número {num} tem {count} divisores.")