# Agentes Autônomos e Model Context Protocol (MCP)

**O que é e qual o seu papel:** Compreender a transição de modelos conversacionais passivos para agentes autônomos orientados a ferramentas, e dominar o padrão aberto MCP para conectar IAs a fontes de dados e sistemas externos.
**Tempo Estimado:** 5 a 7 dias

## Tópicos para Estudar
- [ ] O ciclo ReAct (Reason + Act): Planejar, Agir, Observar e Corrigir
- [ ] Chamada de ferramentas (Tool Calling / Function Calling)
- [ ] O que é o Model Context Protocol (MCP) da Anthropic
- [ ] A arquitetura do MCP: Host, Client e Server
- [ ] Primitivas do MCP: Resources, Prompts e Tools
- [ ] Servidores MCP comuns: PostgreSQL, Git, GitHub, Sistemas de Arquivos
- [ ] Especialização de papéis com subagentes (leitor, executor, revisor)

## Analogia — o cérebro na jarra vs o operador com ferramentas
- **LLM tradicional**: Um cérebro genial mantido dentro de uma redoma de vidro. Ele sabe tudo sobre teoria de banco de dados, mas não tem mãos nem olhos: não consegue ver o que está no seu disco, não roda testes e não pode consultar o Postgres para ver se a tabela existe.
- **Agente com MCP**: O mesmo cérebro, agora equipado com periféricos reais (braços mecânicos, teclado, acesso a terminais e monitores). O **MCP é o cabo USB universal** padronizado que conecta o cérebro a qualquer sistema externo sem necessidade de código sob medida para cada ferramenta.

## O Ciclo ReAct (Reason + Act)

Os agentes autônomos não respondem em um único disparo. Eles operam em um loop contínuo de pensamento e ação:

```text
       ┌───────────────────────────────┐
       ▼                               │
1. THINK (Raciocínio)                  │
   "Preciso saber quais tabelas        │
    existem antes de criar a migration"│
       │                               │
       ▼                               │
2. ACT (Ação / Tool Call)              │
   Chama tool: run_command("ls prisma")│
       │                               │
       ▼                               │
3. OBSERVE (Observação)                │
   Lê o resultado retornado pelo shell │
       │                               │
       └─ Se o objetivo foi atingido ──┘
          Responde ao usuário com a solução validada
```

## O que é o Model Context Protocol (MCP)

Criado como padrão aberto pela Anthropic em 2024, o MCP resolve o problema da fragmentação de integrações. Em vez de cada editor de código (Cursor, VS Code, Windsurf, Claude Desktop, Antigravity) criar um plugin proprietário para falar com o PostgreSQL ou com o GitHub, o **MCP padroniza a comunicação via JSON-RPC**.

```text
[Assistente / Host (IDE ou CLI)]
           │
     (Cliente MCP)
           │  JSON-RPC via stdio ou SSE
   ┌───────┴───────────────────┐
   ▼                           ▼
[Servidor MCP Postgres]     [Servidor MCP GitHub]
- Query no banco            - Listar PRs abertos
- Listar schemas            - Criar comentários
```

### As 3 Primitivas de um Servidor MCP
1. **Tools (Ferramentas)**: Funções executáveis que realizam ações ou efeitos colaterais (ex.: `run_sql_query`, `create_branch`).
2. **Resources (Recursos)**: Dados estáticos ou semi-estáticos de leitura expostos pelo servidor (ex.: logs de servidor, arquivo de configuração).
3. **Prompts**: Modelos pré-fabricados de instrução expostos pelo servidor para guiar tarefas comuns.

## Subagentes e Divisão de Responsabilidades

Para tarefas grandes e refatorações complexas, um único agente pode acumular contexto excessivo e perder o foco. A prática recomendada é a delegação para subagentes especializados:

- **Subagente Pesquisador (Read-Only)**: Possui apenas ferramentas de leitura (`view_file`, `search_code`). Varre o repositório, resume dependências e retorna um relatório sintetizado.
- **Subagente Executor (Write/Run)**: Recebe o plano e as instruções exatas. Realiza as alterações de código e executa testes unitários.
- **Subagente Revisor**: Analisa o diff gerado contra a especificação original para apontar regressões.

## Pegadinhas
- **Loop Infinito sem Critério de Parada**: Um agente que tenta consertar um erro de compilação sem sucesso pode gastar dezenas de iterações e milhares de tokens se não tiver limite de tentativas configurado.
- **Ferramentas com Efeitos Colaterais Destrutivos**: Dar acesso irrestrito a comandos como `rm -rf`, `DROP TABLE` ou `git reset --hard` sem confirmação humana direta pode corromper ambientes locais.
- **Falta de Tratamento de Erros nas Tools**: Se uma ferramenta falha e retorna vazio em vez do stack trace de erro, o agente fica "cego" e alucina uma justificativa.

## Pergunta para fixar
Qual a diferença fundamental entre uma IA conectada diretamente a um Servidor MCP de Banco de Dados versus o desenvolvedor copiar manualmente o resultado de um `SELECT` e colar no chat?

## Ver também
- [Fundamentos de LLMs](../../Inteligência%20Artificial/Fundamentos%20de%20LLMs/Anotações/fundamentos-de-llms.md)
- [Engenharia de Contexto](../../Inteligência%20Artificial/Engenharia%20de%20Contexto/Anotações/engenharia-de-contexto.md)
- [Segurança e Guardrails](../../Inteligência%20Artificial/Segurança%20e%20Guardrails/Anotações/segurança-e-guardrails.md)
