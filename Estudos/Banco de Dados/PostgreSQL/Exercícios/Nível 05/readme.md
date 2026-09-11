# Nível 5: Intermediário+ (Joins Avançados)

Neste nível exploraremos os Joins externos (`LEFT`, `RIGHT`, `FULL`) essenciais quando existem registros orfãos ou incompletos.

---

### Exercício 5.1: LEFT JOIN
**Objetivo:** Liste o `nome` de TODOS os clientes cadastrados e, caso possuam, o `id` e `data` de seus pedidos. Se um cliente não fez nenhum pedido, ele deve continuar aparecendo no resultado.

---

### Exercício 5.2: Identificando Registros Órfãos
**Objetivo:** Utilizando `LEFT JOIN` ou `RIGHT JOIN`, escreva uma consulta para encontrar os nomes de todos os clientes que **NUNCA** realizaram um pedido na tabela `pedidos`.

---

### Exercício 5.3: FULL OUTER JOIN
**Objetivo:** Combine a tabela de `funcionarios` (do projeto A) e `terceirizados` (do projeto B). Escreva uma consulta que retorne todos os profissionais envolvidos nos projetos, exibindo colunas de ambas as tabelas (utilizando `FULL OUTER JOIN`), mesmo que a pessoa exista apenas de um lado.
