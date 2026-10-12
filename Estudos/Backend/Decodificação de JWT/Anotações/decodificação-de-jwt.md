# Decodificação de JWT (jwt.io)

**O que é e qual o seu papel:** Saber ler o conteúdo de um token — e entender por que ler não é o mesmo que confiar.
**Tempo Estimado:** 1 dia (sugestão)

## Tópicos para Estudar
- [ ] O que é o site `jwt.io` e para que serve
- [ ] Diferença entre **decodificar** e **validar** um token
- [ ] Partes do token (header, payload, signature)
- [ ] Riscos de confiar apenas na decodificação sem verificação de assinatura
- [ ] Base64URL ≠ criptografia
- [ ] Claims padrão: `sub`, `iat`, `exp`

## Analogia — o envelope transparente com lacre
O JWT é um **envelope transparente com lacre de cera**:
- qualquer um **lê** o que está dentro (é transparente) → **decodificar**
- só o lacre prova que **ninguém mexeu** e que veio de quem diz → **validar a assinatura**

## Conceito — as 3 partes

```text
eyJhbGciOiJSUzI1NiJ9 . eyJzdWIiOiJVMSIsImV4cCI6MTc... . k3F9x...
      HEADER                     PAYLOAD                   ASSINATURA
  {"alg":"RS256",          {"sub":"U1",                "lacre": calculado
   "typ":"JWT"}             "exp":1790000000,           sobre header+payload
                            "permissions":[...]}        com a chave
```

- **Header**: algoritmo usado na assinatura.
- **Payload**: os dados (*claims*). `sub` = de quem é o token, `iat` = quando foi emitido, `exp` = quando vence (timestamp em segundos).
- **Assinatura**: muda completamente se uma única letra do header ou do payload mudar.

## Decodificar vs validar

```text
DECODIFICAR  = base64url → JSON          qualquer um faz, sem chave   (jwt.io, atob)
VALIDAR      = conferir a assinatura     precisa da chave (pública, no RS256)
               + conferir exp / alg        é o que o backend faz em TODA requisição
```

Decodificar no front é aceitável para **UX** (ex.: mostrar o nome, esconder um menu). Decidir acesso com base nisso, **nunca** — quem decide é o backend, validando.

## Estrutura em texto — usando o jwt.io
1. Cole o token na caixa da esquerda.
2. À direita aparecem header e payload **legíveis** — prova de que o conteúdo não é secreto.
3. "Signature verified" só aparece se você fornecer a chave certa — isso é **validar**.

Atenção: Não cole token de **ambiente real** em site externo: um access token válido é uma credencial enquanto não vence.

## Riscos de só decodificar
- **Payload adulterado**: alguém troca `"permissions":["read"]` por `["admin"]` e recodifica. Sem checar assinatura, você aceita.
- **`alg: none`**: token "sem assinatura". Biblioteca mal configurada pode aceitar. Solução: **fixar** o algoritmo esperado no servidor.
- **Token vencido**: decodificar não checa `exp`.

## Pegadinhas
- Base64 **não** é criptografia — **nunca** coloque senha, CPF ou dado sensível no payload.
- "JWT criptografado" existe (JWE), mas é outro padrão; o JWT comum (JWS) é **assinado**, não criptografado.

## Pergunta para fixar
Se o payload é legível por qualquer um, o que impede um usuário de editar o próprio token e se dar a permissão de admin?

## Ver também
- [Autenticação JWT](../../Autenticação%20JWT/Anotações/autenticação-jwt.md)
- [Access Token vs Refresh Token](../../Tokens%20de%20Acesso%20e%20Refresh/Anotações/tokens-de-acesso-e-refresh.md)
