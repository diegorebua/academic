# Exercícios: Fundamentos de LLMs para Desenvolvedores

## Objetivo
Praticar a análise de tokens, entender os efeitos de temperatura e identificar padrões de alucinação na prática.

---

### Exercício 1: Auditoria de Tokenização e Custo de Sintaxe
1. Utilize uma ferramenta de inspeção de tokens (como o Tokenizer da OpenAI ou biblioteca `tiktoken` em Python/Node.js).
2. Compare o custo em tokens de:
   - Um trecho de código em Python formatado com 4 espaços.
   - O mesmo trecho em TypeScript com tipos estritos e tipagem genérica complexa.
   - Um arquivo JSON minificado versus o mesmo JSON identado.
3. Anote as diferenças e identifique como a formatação impacta a janela de contexto.

---

### Exercício 2: Efeito da Temperatura no Código
1. Formule uma solicitação complexa (ex.: *"Escreva uma função em TypeScript que faça debounce com cancelamento e tipagem genérica estrita"*).
2. Execute a mesma solicitação 5 vezes com `temperature: 0.0` e 5 vezes com `temperature: 0.8`.
3. Compare o código gerado em ambas as séries:
   - Na temperatura 0.0, as saídas são idênticas ou quase idênticas?
   - Na temperatura 0.8, surgiram variações desnecessárias ou APIs inexistentes?

---

### Exercício 3: Teste de Resistência ao Lost in the Middle
1. Crie um arquivo de texto com 3.000 linhas de logs fictícios.
2. No meio do arquivo (por volta da linha 1.500), insira uma linha isolada:
   `"PARAMETRO_SECRETO_CONFIG=VALOR_X99"`
3. Cole o arquivo inteiro no prompt e faça perguntas pontuais no fim do prompt sobre o valor do parâmetro.
4. Repita colocando a linha nas primeiras 10 linhas e nas últimas 10 linhas. Analise a variação da taxa de acerto.
