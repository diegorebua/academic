# AuthGuard

**O que é e qual o seu papel:** A "catraca" do NestJS — decide se a requisição pode seguir até o controller.
**Tempo Estimado:** 2 a 3 dias (sugestão)

## Tópicos para Estudar
- [ ] O que é um `AuthGuard` (conceito e analogia)
- [ ] Como funciona no NestJS (guards, strategies, decorators)
- [ ] Exemplos de uso protegendo rotas
- [ ] Diferenças entre autenticação e autorização no contexto de guards
- [ ] Guard global (`APP_GUARD`) vs guard por rota (`@UseGuards`)
- [ ] 401 vs 403
- [ ] RBAC: usuário → cargo → permissões

## Analogia — portaria e porta da sala
- **Autenticação** = **portaria** do prédio: *"quem é você?"*. Mostra documento, ganha um crachá de visitante com validade.
- **Autorização** = **porta de cada sala**: *"esse crachá abre esta porta?"*.

Dois guards, duas perguntas:

```text
JwtAuthGuard      → "o crachá é verdadeiro e está na validade?"   (autenticação)
PermissionsGuard  → "o crachá abre ESTA porta?"                   (autorização)
```

## Como funciona no NestJS

- **Guard** = classe com `canActivate()` que retorna `true` (segue) ou `false`/exceção (barra). Roda **antes** de pipes e do controller.
- **Strategy** (Passport) = *como* validar o token: de onde tirar (`Bearer`), qual chave, qual algoritmo, se aceita expirado.
- **Decorator** = etiqueta na rota dizendo o que ela exige; o guard lê essa etiqueta via `Reflector`.

```ts
// o decorator só "cola uma etiqueta" (metadata) na rota
export const RequirePermissions = (...perms: string[]) => SetMetadata('permissions', perms);

// o guard lê a etiqueta e confere
canActivate(ctx) {
  const required = this.reflector.getAllAndOverride<string[]>('permissions', [
    ctx.getHandler(), ctx.getClass(),
  ]);
  if (!required?.length) return true;            // rota sem exigência
  const { permissions } = ctx.switchToHttp().getRequest().user; // veio do JWT
  const set = new Set(permissions);
  return required.every((p) => set.has(p));      // precisa de TODAS
}
```

## Estrutura em texto — o caminho de uma requisição

```text
FRONT   interceptor HTTP: Authorization: Bearer <access token>
   │
   ▼
API     guards GLOBAIS (registrados como APP_GUARD), nesta ordem:
   │
   ├─ JwtAuthGuard → JwtStrategy
   │     ├─ assinatura confere com a chave pública?
   │     ├─ não expirou?
   │     └─ usuário ainda existe e está ativo?
   │     falhou → 401
   │
   ├─ PermissionsGuard
   │     ├─ lê @RequirePermissions('stock.read') da rota
   │     └─ o JWT tem todas? (se o token for antigo, sem a lista → busca no banco)
   │     falhou → 403
   │
   └─ ValidationPipe → Controller → Service → Banco → Interceptor → resposta
```

**Global vs por rota:** registrar como `APP_GUARD` protege **tudo por padrão**; rotas abertas (login, health) precisam ser marcadas com `@Public()`. É mais seguro que o contrário — esquecer um `@UseGuards` deixaria a rota aberta.

## 401 vs 403

```text
401  "não sei quem você é"         token inválido/expirado
     └─ o front pode tentar refresh e repetir a requisição
403  "sei quem você é, mas não pode" falta a permissão
     └─ refresh não resolve
```

## RBAC — de onde vêm as permissões

```text
Permission  = o crachá       stock.read, stock.edit
Role        = o cargo        "Estoquista" = PACOTE de crachás
User        recebe cargos    por loja; vários cargos → crachás SOMADOS
```

No login, o backend soma os crachás de todos os cargos da pessoa, coloca a lista no JWT e assina. O guard só confere a lista.

## Pegadinhas
- **Guard no front é UX, não segurança.** Esconder botão não impede nada — quem autoriza é a API.
- Permissões **dentro do token** → mudou o cargo da pessoa, ela só "ganha" o crachá novo no **próximo refresh/login**.
- A strategy do JWT deve **fixar o algoritmo** (`algorithms: ['RS256']`) — nunca aceitar o que vier no header do token.

## Pergunta para fixar
O usuário está com a tela aberta há 20 minutos (access token de 15 min) e clica em "listar". Descreva, passo a passo, o que acontece entre front e API.

## Ver também
- [Autenticação JWT](../../Autenticação%20JWT/Anotações/autenticação-jwt.md)
- [Access Token vs Refresh Token](../../Tokens%20de%20Acesso%20e%20Refresh/Anotações/tokens-de-acesso-e-refresh.md)
- [Fluxo de Requisição NestJS](../../../Arquitetura/Fluxo%20Requisição%20NestJS/Anotações/fluxo-requisição-nestjs.md)
