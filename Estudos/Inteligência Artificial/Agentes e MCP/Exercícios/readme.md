# Exercícios: Agentes Autônomos e Model Context Protocol (MCP)

## Objetivo
Configurar servidores MCP locais, conectar assistentes a ferramentas reais e construir uma tool customizada.

---

### Exercício 1: Configuração de um Servidor MCP Local
1. Instale e configure um servidor MCP de sistema de arquivos ou SQLite local utilizando o `npx` ou instalador do protocolo.
2. Conecte seu cliente de IA (como Claude Desktop, Cursor ou Antigravity CLI) a esse servidor.
3. Peça ao agente para consultar uma tabela no SQLite ou listar a hierarquia de pastas do projeto sem você digitar os dados manualmente.
4. Analise os logs da comunicação JSON-RPC para entender a troca de mensagens entre Host e Server.

---

### Exercício 2: Criação de um Servidor MCP Personalizado
1. Usando TypeScript e o SDK oficial `@modelcontextprotocol/sdk`:
2. Crie um servidor simples com transporte `stdio`.
3. Registre uma ferramenta personalizada chamada `get_git_branch_status` que executa comandos do Git local e retorna a branch atual e arquivos pendentes formatados.
4. Teste a chamada da ferramenta pelo assistente e observe como o agente toma decisões com base no retorno da tool.
