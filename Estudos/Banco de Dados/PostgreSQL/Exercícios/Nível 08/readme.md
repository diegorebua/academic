# Nível 8: Especialista Inicial (CTEs - Expressões de Tabela Comuns)

Neste nível focaremos na cláusula `WITH` para modularizar e organizar queries gigantescas, além das famosas CTEs Recursivas.

---

### Exercício 8.1: CTE Básica
**Objetivo:** Crie uma CTE chamada `VendasMensais` que calcule a soma das vendas por mês. Em seguida, na consulta principal, selecione apenas os meses cuja venda total ultrapassou 100.000.

---

### Exercício 8.2: Múltiplas CTEs Encadeadas
**Objetivo:** Crie duas CTEs:
1. `ClientesVips`: Filtra os IDs dos clientes que gastaram mais de 5.000 no último ano.
2. `ProdutosTop`: Filtra os IDs dos 3 produtos mais vendidos no geral.
Na query principal, descubra quais "Clientes VIPs" compraram "Produtos Top".

---

### Exercício 8.3: CTE Recursiva (Hierarquias)
**Objetivo:** Em uma tabela de `funcionarios` (`id`, `nome`, `gestor_id`), escreva uma CTE Recursiva (`WITH RECURSIVE`) para listar toda a cadeia hierárquica (organograma) abaixo de um Diretor específico (ex: `gestor_id IS NULL` ou `id = 1`).
