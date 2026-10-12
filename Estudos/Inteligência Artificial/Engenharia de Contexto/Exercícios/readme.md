# Exercícios: Engenharia de Contexto

## Objetivo
Criar arquivos de instruções padronizados para repositórios e praticar a metodologia de desenvolvimento orientada a especificações (Spec-Driven Development).

---

### Exercício 1: Construção de um Arquivo de Regras para Repositório
1. Crie um arquivo `AGENTS.md` ou `.cursorrules` para um projeto fictício de backend em NestJS com Prisma.
2. Defina com clareza:
   - Versões do runtime e dos pacotes principais.
   - Padrão de pastas (onde colocar DTOs, interfaces, services e controllers).
   - Lista explícita de "Nunca Faça" (ex.: proibir `any`, proibir imports circulares, proibir lógicas de banco no controller).
   - O comando de validação que o modelo deve executar (`npm test`).
3. Peça a um assistente de IA para criar uma nova funcionalidade e observe se ele segue as regras sem você precisar repeti-las no chat.

---

### Exercício 2: Fluxo Spec-Driven Development
1. Escolha uma funcionalidade nova (ex.: *"Adicionar suporte a cancelamento de pedidos com devolução de estoque"*).
2. Peça à IA **apenas** o documento de especificação técnica contendo:
   - Contrato de entrada/saída (DTOs com validações `class-validator`).
   - Diagrama de sequência em texto.
   - Cenários de falha (pedido já cancelado, produto não encontrado).
3. Revise e altere a especificação manualmente.
4. Só depois de aprovar a especificação, peça a implementação em código e compare a qualidade em relação a um pedido feito sem spec.
