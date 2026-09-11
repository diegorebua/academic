# Nível 6: Avançado Inicial (Subconsultas - Subqueries)

Neste nível você usará consultas aninhadas (uma query dentro de outra) para buscar parâmetros dinâmicos de filtragem ou colunas derivadas.

---

### Exercício 6.1: Subquery no WHERE
**Objetivo:** Escreva uma consulta para encontrar todos os `funcionarios` cujo salário seja **maior** do que a média salarial de **toda** a empresa. (A média deve ser calculada dinamicamente via subquery).

---

### Exercício 6.2: Uso de EXISTS
**Objetivo:** Utilizando a cláusula `EXISTS`, retorne todos os `clientes` que possuam pelo menos 1 pedido registrado na tabela de `pedidos` nos últimos 30 dias.

---

### Exercício 6.3: Subquery no SELECT
**Objetivo:** Retorne uma lista com o `id` e `nome` de cada `departamento` e uma terceira coluna contendo a quantidade exata de funcionários naquele departamento, sem utilizar a cláusula `GROUP BY`.
