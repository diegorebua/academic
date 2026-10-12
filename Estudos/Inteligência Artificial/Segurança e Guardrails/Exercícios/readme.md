# Exercícios: Segurança e Guardrails em Código com IA

## Objetivo
Praticar a proteção de repositórios contra vazamentos de segredos e implementar verificações de segurança em esteiras locais e de CI.

---

### Exercício 1: Instalação e Teste de Secret Scanner (Gitleaks)
1. Instale o utilitário `gitleaks` na sua máquina ou como hook de pré-commit (`pre-commit` ou Husky).
2. Simule a criação de um arquivo fictício contendo uma chave de API simulada no formato `sk_live_...`.
3. Tente realizar o commit e comprove que o scanner bloqueia a gravação antes do envio ao repositório remoto.
4. Configure o arquivo `.gitleaksignore` para entender como ignorar testes e mocks sem abrir brechas.

---

### Exercício 2: Simulação de Prompt Injection Indireto
1. Crie um script de leitura que recebe um texto simulado de um usuário externo (ex.: uma mensagem de suporte com instruções ocultas de injeção).
2. Instrua a IA a resumir o chamado do suporte.
3. Observe se o modelo desvia da tarefa de resumo ao encontrar a instrução invasora.
4. Refatore o prompt delimitando claramente os dados não confiáveis com tags XML (`<user_input>`) e estabelecendo uma regra de isolamento estrito de instruções.
