# 🎯 SQL — Intermediário

**Total de exercícios neste nível:** 30

## 📝 Lista de Exercícios

- [01 CTE Common Table Expressions](./01%20CTE%20Common%20Table%20Expressions): Use CTEs (WITH) para organizar queries complexas em partes legíveis.
- [02 Window Functions Row Number](./02%20Window%20Functions%20Row%20Number): Use ROW_NUMBER(), RANK() e DENSE_RANK() para ranking de registros.
- [03 Window Lag Lead](./03%20Window%20Lag%20Lead): Use LAG() e LEAD() para comparar um registro com o anterior e o próximo.
- [04 Window Running Total](./04%20Window%20Running%20Total): Calcule totais acumulados com SUM() OVER (ORDER BY ...).
- [05 Recursive CTE](./05%20Recursive%20CTE): Crie CTEs recursivas para navegar em hierarquias (organograma, categorias).
- [06 Índices Criação](./06%20Índices%20Criação): Crie índices simples e compostos. Entenda como eles aceleram buscas.
- [07 Explain Analyze](./07%20Explain%20Analyze): Use EXPLAIN ANALYZE para analisar o plano de execução e identificar queries lentas.
- [08 Subquery Correlacionada](./08%20Subquery%20Correlacionada): Escreva subqueries correlacionadas que referenciam a query externa.
- [09 Exists Not Exists](./09%20Exists%20Not%20Exists): Use EXISTS e NOT EXISTS como alternativa performática a IN com grandes datasets.
- [10 Lateral Join](./10%20Lateral%20Join): Use LATERAL JOIN para referenciar colunas de tabelas anteriores no FROM.
- [11 JSON PostgreSQL](./11%20JSON%20PostgreSQL): Armazene e consulte dados JSON/JSONB no PostgreSQL com operadores específicos.
- [12 Array PostgreSQL](./12%20Array%20PostgreSQL): Use colunas do tipo ARRAY no PostgreSQL com operadores de array.
- [13 Funções SQL](./13%20Funções%20SQL): Crie funções SQL reutilizáveis (CREATE FUNCTION) para lógica de negócio.
- [14 Stored Procedures](./14%20Stored%20Procedures): Crie stored procedures com lógica condicional e loops em PL/pgSQL.
- [15 Triggers](./15%20Triggers): Crie triggers para auditoria automática: registre quem e quando modificou cada linha.
- [16 Views](./16%20Views): Crie views para simplificar queries complexas e controlar acesso a dados.
- [17 Materialized Views](./17%20Materialized%20Views): Crie Materialized Views para consultas pesadas e configure refresh periódico.
- [18 Partições Tabela](./18%20Partições%20Tabela): Implemente particionamento de tabelas por range (data) e por lista (região).
- [19 Upsert On Conflict](./19%20Upsert%20On%20Conflict): Use INSERT ... ON CONFLICT (DO UPDATE / DO NOTHING) para upsert idiomático.
- [20 Sequences Serials](./20%20Sequences%20Serials): Use SEQUENCES e GENERATED ALWAYS AS IDENTITY para chaves primárias.
- [21 Schemas Namespaces](./21%20Schemas%20Namespaces): Organize tabelas em schemas separados e controle acesso por schema.
- [22 Full Text Search](./22%20Full%20Text%20Search): Configure Full Text Search: tsvector, tsquery, GIN index e relevância.
- [23 Regex SQL](./23%20Regex%20SQL): Use expressões regulares no SQL com SIMILAR TO e ~ (regexp).
- [24 Pivot Crosstab](./24%20Pivot%20Crosstab): Crie queries pivot (tabelas cruzadas) com o tablefunc e crosstab.
- [25 Temporal Data](./25%20Temporal%20Data): Gerencie dados históricos com bitemporalidade (valid_time e transaction_time).
- [26 Soft Delete](./26%20Soft%20Delete): Implemente soft delete com uma coluna deleted_at e filtre com views.
- [27 Row Level Security](./27%20Row%20Level%20Security): Configure Row Level Security no PostgreSQL para multi-tenancy no nível de linha.
- [28 Performance Tuning SQL](./28%20Performance%20Tuning%20SQL): Otimize 5 queries lentas: reescreva, adicione índices e analise o plano.
- [29 Modelo Ecommerce](./29%20Modelo%20Ecommerce): Projete o schema de um e-commerce: Produtos, Estoque, Pedidos, Pagamentos, Entregas.
- [30 Relatório Vendas](./30%20Relatório%20Vendas): Escreva um relatório complexo de vendas usando CTEs, window functions e aggregations.
