# Access Token vs Refresh Token

**O que é e qual o seu papel:** Dois tokens com funções diferentes para equilibrar segurança e conforto do usuário.
**Tempo Estimado:** 1 a 2 dias (sugestão)

## Tópicos para Estudar
- [ ] Definição de Access Token (curta duração)
- [ ] Definição de Refresh Token (longa duração)
- [ ] Por que separar os dois
- [ ] Fluxo típico de renovação de token
- [ ] Boas práticas de segurança e armazenamento
- [ ] Cookie `httpOnly` e por que ele protege contra XSS
- [ ] Evitar vários refresh simultâneos (uma promise compartilhada)

## Analogia — o crachá do dia e o cadastro
- **Access token** = **crachá do dia**: abre as salas, mas vence rápido.
- **Refresh token** = **seu cadastro na portaria**: não abre sala nenhuma, só serve para pegar um crachá do dia novo sem mostrar o RG (login/senha) de novo.

## Conceito

| | Access token (JWT) | Refresh token |
|---|---|---|
| Para que serve | acessar as rotas | obter um access token novo |
| Validade | **curta** (ex.: 15 min) | **longa** (dias) |
| Onde fica no browser | memória / `localStorage` | **cookie `httpOnly`** |
| JavaScript consegue ler? | sim | **não** |
| Vai em toda requisição? | sim (`Authorization: Bearer`) | só na rota de refresh |

**Por que separar:** o token que o JavaScript consegue ler **vale pouco tempo**; o que vale muito tempo o JavaScript **não consegue ler**. Se um script malicioso rodar na página (XSS), ele rouba no máximo um crachá que vence em minutos.

## Estrutura em texto — fluxo de renovação

```text
requisição normal  ──►  API responde 401 (access expirou)
                              │
      interceptor de resposta do front:
      ├─ já tentei refresh nesta requisição?  → sim: desiste
      ├─ POST /auth/refresh   (o cookie httpOnly vai sozinho — withCredentials)
      │     ├─ OK  → salva o access novo → REPETE a requisição original
      │     │        (o usuário nem percebe)
      │     └─ erro → apaga o access → redireciona para /login
      └─ várias requisições deram 401 ao mesmo tempo?
            → todas esperam a MESMA promise de refresh (evita 5 refresh em paralelo)
```

## Boas práticas
- Refresh token **nunca** em `localStorage` — é cookie `httpOnly` (+ `Secure`, `SameSite`).
- Guardar no banco só o **hash** do refresh token (se o banco vazar, o token não é reutilizável).
- **Rotação**: a cada refresh, emitir um refresh novo e invalidar o anterior.
- Access curto **e** revalidar o usuário no guard (usuário bloqueado perde acesso logo, não só quando o token vencer).
- Nunca logar token no console.

## Pegadinhas
- **Permissões dentro do access token** só mudam quando ele é reemitido (refresh/login). Mudou o cargo? Pode levar até a validade do access para refletir.
- Um `401` na **própria** rota de refresh não pode disparar outro refresh — senão vira loop.
- `401` ≠ `403`: refresh só resolve `401`.

## Pergunta para fixar
Por que o refresh token **não** é enviado em toda requisição, como o access token?

## Ver também
- [Autenticação JWT](../../Autenticação%20JWT/Anotações/autenticação-jwt.md)
- [AuthGuard](../../Auth%20Guard/Anotações/auth-guard.md)
- [Decodificação de JWT](../../Decodificação%20de%20JWT/Anotações/decodificação-de-jwt.md)
