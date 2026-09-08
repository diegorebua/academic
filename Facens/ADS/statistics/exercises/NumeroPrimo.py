# c) Determinar se um número é primo

print("--- c) Verificador de número primo ---")
num = int(input("Digite um número inteiro positivo (n > 1): "))

if num <= 1:
    print("O número deve ser maior que 1.")
else:
    is_prime = True
    for i in range(2, int(num**0.5) + 1):
        if num % i == 0:
            is_prime = False
            break
    
    if is_prime:
        print(f"O número {num} é primo.")
    else:
        print(f"O número {num} não é primo.")