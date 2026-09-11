# Nível 10: Mestre (Otimização, Performance e Modelagem)

Neste nível abordaremos o lado DBA (Database Administrator): otimizar o tempo de resposta das consultas, entender planos de execução e criar índices.

---

### Exercício 10.1: Plano de Execução (EXPLAIN)
**Objetivo:** Adicione a cláusula `EXPLAIN ANALYZE` (PostgreSQL) ou correspondente no MySQL/SQL Server antes de uma consulta complexa com JOINs e Subqueries, e documente o que significa o termo "Seq Scan" e "Index Scan" que aparecerá no resultado.

---

### Exercício 10.2: Criação de Índices Otimizados
**Objetivo:** Dada uma tabela `logs` de 10 milhões de linhas onde a busca `WHERE data_evento > '2025-01-01' AND severidade = 'ERROR'` está muito lenta, escreva a sintaxe para criar um Índice Composto (`CREATE INDEX`) otimizado para acelerar especificamente essa filtragem.

---

### Exercício 10.3: Views Materializadas
**Objetivo:** Crie uma `MATERIALIZED VIEW` chamada `vendas_resumo_mensal` contendo agregações complexas de milhares de vendas. Explique a diferença de performance e atualização de dados entre essa View Materializada e uma View tradicional (Virtual).
