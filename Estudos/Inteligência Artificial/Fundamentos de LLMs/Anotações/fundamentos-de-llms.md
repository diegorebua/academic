# Fundamentos de LLMs para Desenvolvedores

**O que é e qual o seu papel:** Compreender a mecânica estatística, limites de contexto, atenção e causas de alucinação para saber direcionar e auditar modelos de código com precisão.
**Tempo Estimado:** 2 a 3 dias

## Tópicos para Estudar
- [ ] O que são tokens e como código é tokenizado
- [ ] Janela de contexto (context window) e limites de atenção
- [ ] O efeito "Lost in the Middle" (degradação no meio do contexto)
- [ ] Temperatura, top_p e determinismo na geração de código
- [ ] Previsão estatística de próximo token vs raciocínio simbólico
- [ ] Por que LLMs alucinam métodos, parâmetros e pacotes inexistentes
- [ ] A mudança de papel: de digitador de sintaxe para arquiteto de contexto e avaliador

## Analogia — o autocompletador hiperavançado de biblioteca
Imagine um bibliotecário com memória fotográfica de milhões de livros técnicos, mas que **não possui compilador na cabeça**.
- Se você pede: *"Complete a função de login usando JWT"*, ele busca na memória a sequência estatisticamente mais comum encontrada em projetos públicos.
- Se a maioria dos projetos públicos da internet de 2021 usava uma biblioteca defasada ou código sem validação de expiração, ele tenderá a reproduzir esse padrão antigo, a menos que você estabeleça restrições explícitas.
- Ele não "pensa" em termos de execução real de máquina; ele calcula a probabilidade da próxima palavra baseada no que leu até o momento.

## Conceito — as peças que governam o modelo

### 1. Tokens e Custo de Atenção
Modelos não leem caracteres nem palavras inteiras; leem **tokens** (pedaços de palavras, símbolos e pontuações).
- Em texto comum em inglês, 1 token equivale a aproximadamente 4 caracteres.
- Em código-fonte, indentação, chaves, operadores e nomes longos em camelCase aumentam consideravelmente o consumo de tokens.
- O custo computacional do mecanismo de atenção cresce quadraticamente ou exige aproximações em contextos muito extensos, tornando prompts gigantescos lentos e propensos a distrações.

### 2. Efeito Lost in the Middle
Pesquisas comprovam que LLMs prestam **alta atenção** ao início do prompt (instruções do sistema) e ao final do prompt (sua mensagem mais recente). O conteúdo posicionado no meio de um contexto muito longo (ex.: arquivos intermediários de 5.000 linhas) sofre degradação severa de atenção.

```text
[Início do Prompt]   Atenção MÁXIMA  (regras gerais, sistema)
[Meio do Prompt]     Atenção BAIXA   (arquivos despejados sem filtro sofrem perda)
[Fim do Prompt]      Atenção MÁXIMA  (sua pergunta recente, restrições finais)
```

### 3. Temperatura e Amostragem
A temperatura controla a aleatoriedade da distribuição de probabilidade do próximo token:
- **Temperatura 0.0 a 0.2**: Quase determinística. Ideal para tarefas de código, refatoração, migração e testes, onde a consistência e o cumprimento de regras são prioridade.
- **Temperatura 0.7 ou superior**: Mais criativa e dispersa. Útil para brainstorming de nomes ou arquiteturas conceituais, mas perigosa para sintaxe precisa.

## Por que Modelos Alucinam Código
1. **Viés de Frequência**: O modelo sugere o método mais popular da internet, não necessariamente o da versão que você instalou no `package.json`.
2. **Plausibilidade Linguística**: Nomes de métodos intuitivos (como `prisma.user.findOrCreate` ou `jwt.verifyAsync`) parecem tão lógicos que o modelo os inventa como se existissem.
3. **Falta de Feedback Interno**: Sem executar o código ou checar o sistema de arquivos, o modelo não sabe se um arquivo importado realmente está na pasta.

## Estrutura em texto — O ciclo de decisão do engenheiro

```text
DESENVOLVEDOR INICIANTE                  DESENVOLVEDOR GUIADO POR IA
"Crie uma API de pagamentos"             1. Define contratos e tipos primeiro
               │                         2. Entrega só o contexto indispensável
               ▼                         3. Exige temperatura baixa e regras estritas
Código genérico, desatualizado,          4. Executa testes automatizados para validar
vulnerável e sem tipagem sólida                         │
                                                        ▼
                                         Código determinístico, aderente ao projeto
```

## Pegadinhas
- **Assumir que mais contexto é sempre melhor**: Enviar o projeto inteiro satura a janela de contexto e faz o modelo ignorar instruções pontuais críticas.
- **Acreditar na certeza do modelo**: Uma resposta escrita com convicção e tom profissional pode conter um método fictício. A autoridade da linguagem não reflete a precisão técnica.
- **Ignorar a versão das dependências**: Se você usa NestJS 10 ou Prisma 5 mas não informa, o modelo gerará código para versões antigas que viu em abundância nos dados de treino.

## Pergunta para fixar
Por que passar a interface TypeScript de um serviço gera menos alucinações para o modelo do que passar a implementação inteira desse mesmo serviço com 800 linhas?

## Ver também
- [Engenharia de Contexto](../../Inteligência%20Artificial/Engenharia%20de%20Contexto/Anotações/engenharia-de-contexto.md)
- [Segurança e Guardrails](../../Inteligência%20Artificial/Segurança%20e%20Guardrails/Anotações/segurança-e-guardrails.md)
