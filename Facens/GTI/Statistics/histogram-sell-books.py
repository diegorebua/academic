import numpy as np

# Dados de Vendas de Livros
np.random.seed(0)  # Para reprodutibilidade
generos = ['Ficção', 'Não-ficção', 'Fantasia', 'Biografia', 'Ciência']
vendas_livros = np.random.randint(100, 500, size=50)  # Vendas entre 100 e 500
precos_livros = np.random.uniform(5, 30, size=50)  # Preços entre 5 e 30 USD

# Criando listas para os dados de vendas de livros
livros = []
for i in range(50):
    genero = np.random.choice(generos)  # Escolhe um gênero aleatório
    livros.append((genero, vendas_livros[i], precos_livros[i]))

# Exibindo os dados gerados
print("Dados de Vendas de Livros:")
for livro in livros[:5]:  # Mostrando os primeiros 5 itens
    print(f"Gênero: {livro[0]}, Vendas: {livro[1]}, Preço: {livro[2]:.2f} USD")
print()

import matplotlib.pyplot as plt

# Criando o histograma
plt.figure(figsize=(8, 5))
(n, bins, patches) = plt.hist(vendas_livros, bins=10, color='blue', alpha=0.7) #vendas, bins=10
plt.title('Distribuição de Vendas de Livros')
plt.xlabel('Vendas')
plt.ylabel('Frequência')
plt.grid(axis='y', alpha=0.75)
plt.show()

# Mostrando os intervalos
print("Mostrar intervalos: ", bins)