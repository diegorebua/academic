# Exercícios: Desenvolvimento Guiado por IA e TDD

## Objetivo
Implementar funcionalidades complexas usando feedback loops determinísticos, onde o agente de IA é guiado estritamente pela execução de testes automatizados.

---

### Exercício 1: TDD Fechado com Jest
1. Crie um arquivo de teste `calc-pricing.spec.ts` contendo 5 casos de teste para uma função de cálculo de desconto e impostos por estado (incluindo casos de cupom expirado, frete grátis e cliente VIP).
2. Não implemente a função `calcPricing()`. Deixe apenas a assinatura vazia para que o teste falhe (`RED`).
3. Forneça o arquivo de teste ao agente e instrua:
   *"Implemente a função para fazer todos os testes passarem. Não altere nenhuma linha do arquivo de teste."*
4. Deixe o agente rodar o `npm test`, analisar os erros de asserção e corrigir o código até todos ficarem verdes (`GREEN`).

---

### Exercício 2: Modernização de Código Legado
1. Pegue um módulo ou função antiga escrita em JavaScript sem tipos (com callbacks aninhados ou `var`).
2. Peça ao agente para:
   - Adicionar uma suíte de testes de regressão garantindo que o comportamento atual não mude.
   - Refatorar a função para TypeScript estrito com `async/await`.
   - Garantir que a suíte de testes passe em 100% das asserções.
