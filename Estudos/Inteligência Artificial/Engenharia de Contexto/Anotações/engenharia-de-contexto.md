# Engenharia de Contexto

**O que é e qual o seu papel:** A disciplina de preparar, estruturar e restringir as informações entregues ao modelo para garantir que o código gerado siga a arquitetura, convenções e regras do projeto sem desvios.
**Tempo Estimado:** 3 a 5 dias

## Tópicos para Estudar
- [ ] Diferença entre Engenharia de Prompt e Engenharia de Contexto
- [ ] Arquivos de regras de projeto (`AGENTS.md`, `.cursorrules`, `.windsurfrules`, sidecars)
- [ ] Spec-Driven Development: especificações funcionais e técnicas antes da codificação
- [ ] O princípio do menor contexto necessário (evitar ruído e saturação)
- [ ] Indexação de código em IDEs modernas (AST, busca lexical e embeddings)
- [ ] Tipos e contratos como fontes primárias de verdade

## Analogia — a planta da obra vs pedido verbal
- **Engenharia de Prompt**: Chegar na obra e dizer verbalmente para a equipe: *"Faça uma cozinha bonita, moderna e com espaço para cooktop"*. Cada pedreiro vai interpretar "bonita" do seu jeito e puxar encanamento no improviso.
- **Engenharia de Contexto**: Entregar a **planta hidráulica**, o **esquema elétrico**, o manual das marcas de tomadas permitidas e a espessura exata dos canos antes do primeiro tijolo ser assentado. O operário não precisa adivinhar nada; ele apenas executa conforme o gabarito.

## Conceito — Engenharia de Prompt vs Engenharia de Contexto

| Aspecto | Engenharia de Prompt | Engenharia de Contexto |
|---|---|---|
| Foco | Como formular a frase da pergunta | Que informações colocar no ambiente de decisão |
| Escopo | Instrução pontual (uma mensagem) | O ecossistema do projeto (regras, tipos, schemas, arquivos) |
| Repetibilidade | Baixa (varia a cada chat) | Alta (definida em arquivos de configuração no repositório) |
| Impacto no código | Corrige sintaxe pontual | Garante consistência arquitetural no projeto inteiro |

## Estrutura de Arquivos de Regras

Arquivos como `AGENTS.md` ou `.cursorrules` funcionam como a "memória permanente" do assistente no repositório. Devem ser objetivos e conter:

1. **Stack e Versões**: Versão exata do Node.js, TypeScript, frameworks e bibliotecas principais.
2. **Convenções de Arquitetura**: Onde cada camada reside (ex.: DTOs em `dto/`, regras de negócio em `services/`, persistência em `repositories/`).
3. **Padrões de Nomenclatura**: Nomes de arquivos em `kebab-case`, classes em `PascalCase`, métodos em `camelCase`.
4. **Proibições Explícitas**: *"Nunca use `any` no TypeScript"*, *"Nunca use `typeorm` diretamente no controller"*, *"Nunca adicione dependências sem perguntar"*.
5. **Comandos de Teste e Build**: O comando exato para validar alterações (`npm test`, `npm run build`, `npm run lint`).

## Metodologia Spec-Driven Development (SDD)

Em vez de solicitar a implementação direta de um recurso complexo, o fluxo ideal segue três passos:

```text
PASSO 1: ESPECIFICAÇÃO
Desenvolvedor descreve a necessidade -> IA gera um documento técnico com:
  - Arquivos a criar/alterar
  - Interfaces TypeScript e contratos de entrada/saída
  - Cenários de erro esperados e validações
               │
               ▼
PASSO 2: REVISÃO HUMANA
Você audita a especificação e corrige decisões arquiteturais antes do código existir.
               │
               ▼
PASSO 3: EXECUÇÃO CONTROLADA
IA codifica com base estrita no documento aprovado, sem espaço para improvisos.
```

## O Princípio do Menor Contexto Necessário

Inserir arquivos irrelevantes na conversa gera dois problemas graves:
1. **Consumo desnecessário de tokens** (aumenta latência e custos).
2. **Dispersão de atenção** do mecanismo de atenção do modelo.

Ao solicitar uma alteração em um Controller, forneça:
- O Controller atual.
- O DTO correspondente.
- Apenas a interface ou tipos do Service chamado (não precisa enviar os 600 linhas da implementação do Service).

## Pegadinhas
- **Regras longas e prolixas**: Modelos ignoram parágrafos poéticos sobre "escrever código limpo". Prefira regras curtas, em bullet points, com exemplos de "Faça isso / Não faça aquilo".
- **Contradições no contexto**: Manter uma regra no `.cursorrules` que contradiz o `tsconfig.json` confunde o modelo e gera código instável.
- **Não incluir exemplos negativos**: A forma mais rápida de impedir um erro recorrente da IA é mostrar o exemplo exato do código que ela não deve gerar.

## Pergunta para fixar
Em um projeto NestJS com 50 módulos, por que é mais eficiente fornecer apenas os DTOs e as interfaces para a IA do que abrir todos os arquivos de services relacionados?

## Ver também
- [Fundamentos de LLMs](../../Inteligência%20Artificial/Fundamentos%20de%20LLMs/Anotações/fundamentos-de-llms.md)
- [Agentes e MCP](../../Inteligência%20Artificial/Agentes%20e%20MCP/Anotações/agentes-e-mcp.md)
- [Estrutura NestJS Ideal](../../../Arquitetura/Estrutura%20NestJS%20Ideal/Anotações/estrutura-nestjs-ideal.md)
