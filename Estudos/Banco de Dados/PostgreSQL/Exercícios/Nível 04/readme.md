# Nível 4: Intermediário (Joins Básicos)

Neste nível você começará a cruzar dados de diferentes tabelas relacionais usando o `INNER JOIN`.

---

### Exercício 4.1: INNER JOIN Básico
**Objetivo:** Escreva uma consulta que retorne o `nome` do funcionário e o `nome` do departamento em que ele trabalha, cruzando a tabela `funcionarios` com a tabela `departamentos` através da chave `departamento_id`.

---

### Exercício 4.2: INNER JOIN com Filtro WHERE
**Objetivo:** Modifique a consulta anterior para retornar apenas os funcionários que trabalham no departamento de nome 'TI' ou 'Engenharia'.

---

### Exercício 4.3: Múltiplos Joins
**Objetivo:** Escreva uma consulta para retornar o número do `pedido`, o `nome` do cliente e o `nome` do produto, unindo as tabelas `pedidos`, `clientes` e `produtos` (assuma a existência de uma tabela associativa `itens_pedido`).
