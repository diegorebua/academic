# f) Contar triplas de Pitágoras (a^2 + b^2 = c^2)

print("--- f) Contagem de triplas de Pitágoras ---")
n = int(input("Digite um número inteiro positivo (n > 1): "))
count = 0

if n <= 1:
    print("O número deve ser maior que 1.")
else:
    for a in range(1, n + 1):
        for b in range(a, n + 1):
            c_squared = a**2 + b**2
            c = int(c_squared**0.5)
            if c <= n and c * c == c_squared and b <= c:
                count += 1
    
    print(f"Existem {count} triplas de inteiros positivos (a, b, c) tais que a <= b <= c <= {n} e a^2 + b^2 = c^2.")