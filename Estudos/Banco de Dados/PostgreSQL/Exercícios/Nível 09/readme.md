# Nível 9: Especialista (Modificações e Transações)

Neste nível vamos focar nas cláusulas de inserção com condicionais (`UPSERT`), manipulação segura em massa e controle de Transações (`BEGIN`, `COMMIT`, `ROLLBACK`).

---

### Exercício 9.1: UPSERT (INSERT ON CONFLICT)
**Objetivo:** Escreva um script para inserir um registro na tabela `configuracoes` (`chave`, `valor`). Caso a `chave` já exista no banco de dados (conflito de Primary Key/Unique), atualize o `valor` existente.

---

### Exercício 9.2: Deleção Segura com OUTPUT/RETURNING
**Objetivo:** Escreva um comando `DELETE` para apagar todas as vendas com `status = 'CANCELADO'`. Modifique-o adicionando a cláusula `RETURNING *` (no PostgreSQL) ou equivalentes para retornar na tela exatamente quais registros foram deletados.

---

### Exercício 9.3: Bloco de Transação (ACID)
**Objetivo:** Escreva um bloco de transação (`BEGIN; ... COMMIT;`) simulando uma transferência bancária entre duas contas (Tabela `contas` com colunas `id` e `saldo`). 
- Debite 500 da conta A.
- Credite 500 na conta B.
*(Desafio extra: adicione um `CHECK` na tabela para garantir que o saldo não fique negativo, forçando um ROLLBACK natural).*
