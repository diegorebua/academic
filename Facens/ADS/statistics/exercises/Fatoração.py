# d) Fatoração em números primos

print("--- d) Fatoração em primos ---")
num = int(input("Digite um número inteiro positivo (n > 1): "))

if num <= 1:
    print("O número deve ser maior que 1.")
else:
    print(f"A fatoração prima de {num} é:", end=" ")
    i = 2
    temp = num
    factors = []
    
    while i * i <= temp:
        while temp % i == 0:
            factors.append(i)
            temp //= i
        i += 1
    if temp > 1:
        factors.append(temp)
    
    print(" x ".join(map(str, factors)))