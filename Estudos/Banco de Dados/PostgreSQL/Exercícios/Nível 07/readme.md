# Nível 7: Avançado (Window Functions)

Neste nível abordaremos Funções de Janela (`OVER`, `PARTITION BY`), poderosas para análises estatísticas em relatórios e dashboards.

---

### Exercício 7.1: Ranking Básico (RANK / ROW_NUMBER)
**Objetivo:** Escreva uma consulta que liste os nomes dos funcionários e seus salários. Adicione uma coluna calculada `posicao_ranking` indicando a classificação do funcionário do maior para o menor salário em toda a empresa.

---

### Exercício 7.2: Ranking Particionado (PARTITION BY)
**Objetivo:** Modifique a consulta anterior para que o ranking de salário seja calculado **por departamento**. (ex: O maior salário da área de 'TI' é o 1º colocado de 'TI', o maior do 'RH' é o 1º de 'RH').

---

### Exercício 7.3: Média Móvel / Acumulada
**Objetivo:** Dada uma tabela de `vendas` diárias (com colunas `data` e `valor_total`), escreva uma consulta utilizando `SUM() OVER(ORDER BY ...)` para retornar o total acumulado das vendas dia a dia.
