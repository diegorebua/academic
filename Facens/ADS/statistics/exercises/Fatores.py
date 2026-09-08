# e) Fatores primos únicos

print("--- e) Fatores primos únicos ---")
num = int(input("Digite um número inteiro positivo (n > 1): "))

if num <= 1:
    print("O número deve ser maior que 1.")
else:
    print(f"Os fatores primos de {num} são:", end=" ")
    i = 2
    temp = num
    unique_factors = set()
    
    while i * i <= temp:
        if temp % i == 0:
            unique_factors.add(i)
            while temp % i == 0:
                temp //= i
        i += 1
    if temp > 1:
        unique_factors.add(temp)
    
    print(", ".join(map(str, sorted(list(unique_factors)))))