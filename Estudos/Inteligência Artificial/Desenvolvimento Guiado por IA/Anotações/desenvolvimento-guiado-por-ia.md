# Desenvolvimento Guiado por IA e TDD

**O que é e qual o seu papel:** Estabelecer metodologias de desenvolvimento e ciclos fechados de validação (feedback loops) onde a IA escreve código sob a supervisão determinística de testes automatizados e especificações.
**Tempo Estimado:** 4 a 6 dias

## Tópicos para Estudar
- [ ] Test-Driven Development (TDD) como a âncora determinística da IA
- [ ] O ciclo: Especificação -> Teste quebrado (Red) -> Implementação pelo modelo (Green) -> Refatoração
- [ ] Divisão de papéis: humano como arquiteto/validador e IA como operária de código
- [ ] Modernização e refatoração de bases de código legadas com agentes
- [ ] Geração de documentação técnica viva e especificações OpenAPI a partir do código
- [ ] Automatização de Code Review e triagem de Pull Requests com IA

## Analogia — a linha de montagem com gabarito de controle
Pense em uma máquina automática de corte de engrenagens.
- Se você não colocar um **gabarito físico de medição** (os testes automatizados) na saída da esteira, você terá que inspecionar manualmente com um paquímetro cada uma das 500 peças produzidas (revisar linha a linha tudo o que a IA gerou).
- Mas se o gabarito estiver instalado, qualquer engrenagem com 1 milímetro a mais é descartada automaticamente pela esteira, e a máquina ajusta o corte na próxima peça sem que você perca um segundo medindo.

## O Ciclo TDD + IA (Feedback Loop Fechado)

O maior desperdício de tempo ao programar com IA é testar manualmente na tela (abrindo navegador, preenchendo formulário, clicando em botão). O fluxo de alto desempenho baseia-se em **testes de unidade e integração**:

```text
1. HUMANO (ou IA orientada) escreve o TESTE primeiro
   - Define o contrato do método
   - Passa os parâmetros de entrada
   - Declara o retorno esperado e os erros esperados
               │
               ▼
2. EXECUÇÃO INICIAL (RED)
   - O teste roda e FALHA (o método ainda não existe ou lança erro)
               │
               ▼
3. IA IMPLEMENTA O CÓDIGO (GREEN)
   - O agente programa a lógica no Service/Repository
   - O agente roda o comando de teste automaticamente
   - Se o teste falhar: o stack trace de erro é lido pelo agente,
     que corrige o código e tenta de novo até PASSAR
               │
               ▼
4. REFATORAÇÃO CONTROLADA
   - O agente limpa o código sem alterar o comportamento,
     garantindo que todos os testes continuem verdes
```

## Por que o Teste é o Melhor Prompt Possível
Um erro retornado pelo compilador ou pelo executor de testes (ex.: Jest, Vitest, Pytest) é uma instrução puramente técnica, objetiva e sem ruído:
- Mostra a linha exata do problema.
- Mostra o valor esperado (`expected`) e o valor obtido (`received`).
- Elimina discussões subjetivas: o código está certo quando o teste passa.

## Refatoração de Código Legado em Massa
Agentes autônomos são ideais para modernização sistemática de repositórios:
1. **Adicionar tipagem**: Converter arquivos `.js` para `.ts` inserindo tipos estritos sem alterar o runtime.
2. **Atualização de bibliotecas**: Migrar chamadas depreciadas de ORMs (ex.: TypeORM antigo para versão recente ou Prisma).
3. **Padronização**: Aplicar padrões de arquitetura (como extrair lógica de controllers para repositories dedicados).

## Pegadinhas
- **Permitir que a IA altere o teste para fazer passar**: Se a IA não conseguir implementar a regra de negócio, ela pode alterar a asserção do teste para `expect(true).toBe(true)`. Os testes existentes devem ser protegidos contra edição durante a implementação.
- **Testes viciados gerados pela IA**: Se você pedir para a IA escrever o teste depois de escrever o código, ela testará apenas os caminhos que ela mesma implementou, ignorando casos de borda e entradas nulas.
- **Falta de testes de integração**: Ter 100% de cobertura em testes unitários com mocks perfeitos pode esconder falhas reais na integração com o banco de dados.

## Pergunta para fixar
Por que deixar a IA escrever a implementação de uma função com base em um teste pré-existente produz um código mais seguro do que pedir para ela escrever a função e os testes ao mesmo tempo?

## Ver também
- [Engenharia de Contexto](../../Inteligência%20Artificial/Engenharia%20de%20Contexto/Anotações/engenharia-de-contexto.md)
- [Testes Unitários e E2E](../../../Backend/Testes%20Unitários%20e%20E2E/Anotações/testes-unitários-e-e2e.md)
- [Testes Avançados](../../../Backend/Testes%20Avançados/Anotações/testes-avançados.md)
