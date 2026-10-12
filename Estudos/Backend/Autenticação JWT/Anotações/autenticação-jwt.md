# Autenticação com JWT

## Conceito: 
É como uma "pulseira de balada". O usuário mostra o RG (login/senha) na entrada, ganha a pulseira (token JWT) e depois só precisa mostrar a pulseira para pedir bebidas (acessar rotas), sem precisar mostrar o RG de novo toda hora. 

## O que é: 
JWT (JSON Web Token) é um padrão para transmitir informações de forma segura entre duas partes. No NestJS, usamos junto com o Passport e Guards. 

## Fluxo
1. **Login:** Usuário envia `email` e `senha`.
2. **Validação:** Backend confere no banco. Se bater, gera um **Token** (uma string **assinada** — o conteúdo é legível por qualquer um, mas não pode ser alterado sem invalidar a assinatura).
3. **Uso:** O Frontend (Vue) guarda esse token e o envia no `Header` de cada requisição (`Authorization: Bearer <token>`).
4. **Proteção:** O Backend verifica se o token é válido antes de responder.

## HS256 vs RS256 — o carimbo e a lupa
A assinatura pode ser feita de dois jeitos:

```text
HS256 (simétrico)   UMA chave secreta, compartilhada
                    quem confere o token TAMBÉM consegue fabricar tokens

RS256 (assimétrico) chave PRIVADA  → só o serviço de login tem → ASSINA (carimba)
                    chave PÚBLICA  → qualquer serviço pode ter → CONFERE (lupa)
```

```text
                 chave PRIVADA                     chave PÚBLICA
                (só a API de login)              (qualquer serviço)
                       │                                │
                 ASSINA o token                  CONFERE a assinatura
                       │                                │
                 API de login               API de login, serviço de estoque,
                                            serviço financeiro...
```

**Por que RS256 quando há vários serviços:** se um serviço for invadido, o atacante leva só a **lupa** — consegue conferir tokens, mas **não fabricar**. Com HS256, cada serviço que confere também poderia emitir tokens falsos.

## Ver também
- [Decodificação de JWT](../../Decodificação%20de%20JWT/Anotações/decodificação-de-jwt.md)
- [Access Token vs Refresh Token](../../Tokens%20de%20Acesso%20e%20Refresh/Anotações/tokens-de-acesso-e-refresh.md)
- [AuthGuard](../../Auth%20Guard/Anotações/auth-guard.md)
