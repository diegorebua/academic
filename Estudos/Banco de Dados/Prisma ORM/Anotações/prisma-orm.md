# Prisma ORM

**O que é e qual o seu papel:** ORM que traduz código TypeScript em SQL, com tipos gerados a partir do schema.
**Tempo Estimado:** 4 a 6 dias (sugestão)

## Tópicos para Estudar
- [ ] O `schema.prisma`: `model`, campos, `@id`, `@unique`, `@@unique`, `@relation`
- [ ] `@map` / `@@map` — nome no código vs nome no banco
- [ ] `prisma migrate` vs `prisma generate` (o que cada um muda)
- [ ] `prisma migrate dev` vs `prisma migrate deploy`
- [ ] Operações do client: `findUnique`, `findFirst`, `findMany`, `create`, `update`, `updateMany`, `upsert`, `delete`
- [ ] Moldar o resultado: `include` (traz relação) vs `select` (só alguns campos)
- [ ] Usar o client no NestJS (service global) vs em script solto (seed)

## Analogia
Um **intérprete**: você fala TypeScript, o banco só entende SQL. Você pede `prisma.user.findUnique(...)` e ele traduz para `SELECT ... FROM users WHERE ...`.
A vantagem sobre um intérprete comum: ele **conhece o dicionário antes** — sabe quais tabelas e campos existem, então o TypeScript acusa um campo errado **antes** de rodar.

## Estrutura em texto — as peças

```text
prisma/schema.prisma          A PLANTA — o que existe (models, campos, relações)
        │
        ├── prisma migrate  →  prisma/migrations/*.sql     A OBRA — cria as tabelas
        │                                                    no banco de verdade
        │
        └── prisma generate →  @prisma/client               O MAPA — tipos + métodos
                               (em node_modules)             que o código usa
                                      │
                                      ▼
                          new PrismaClient({ adapter })     O INTÉRPRETE rodando
                                      │
                                      ▼
                          prisma.user.findMany(...)
```

## `migrate` vs `generate` — dois leitores da mesma planta

```text
                    schema.prisma
                     /          \
          prisma migrate      prisma generate
                 │                    │
          ensina o BANCO       ensina o TYPESCRIPT
     (cria/altera tabelas)   (cria tipos e métodos)
```

Exemplo — adicionar `phone String?` no `User`:

| Você rodou… | Banco | Código TS | Resultado |
|---|---|---|---|
| nada | sem coluna | não conhece `phone` | nada funciona com `phone` |
| só **migrate** | Sim (coluna existe) | Erro de tipo | banco pronto, código "não enxerga" |
| só **generate** | Não (sem coluna) | Válido (TS aceita) | compila e **quebra em runtime** ("column does not exist") |
| **os dois** | Sim | Válido | funciona |

O caso "só generate" é o traiçoeiro: o TS confia no mapa, mas a parede não foi erguida.

**Por que o `generate` aparece em vários scripts** (`postinstall`, `build`, antes do seed): o client gerado vive em `node_modules` — toda reinstalação apaga. Ele é barato e **não toca no banco** (nem precisa da URL de conexão).

## `migrate dev` vs `migrate deploy`

```text
migrate dev      ← VOCÊ, na máquina local
   1. compara schema com o banco
   2. GERA uma pasta nova com migration.sql
   3. aplica no banco local + roda o generate

migrate deploy   ← o SERVIDOR / pipeline
   1. lê a tabela _prisma_migrations ("quais já rodaram?")
   2. aplica SÓ as que faltam, em ordem
   3. nunca gera nada
```

`dev` cria, `deploy` só aplica — por isso a pasta da migration vai no commit.

## Lendo uma query

```ts
const rows = await prisma.userStoreRole.findMany({
  where:   { userId, storeId },                                            // ① filtro
  include: { role: { include: { permissions: { include: { permission: true } } } } }, // ② segue as FKs
});
const codes = new Set<string>();                                           // ③ soma sem repetir
for (const r of rows) for (const rp of r.role.permissions) codes.add(rp.permission.code);
```

- `where` → filtra as linhas
- cada `include` ≈ um `JOIN` (o Prisma pode dividir em mais de uma consulta, mas a ideia é essa)
- o `Set` existe porque a pessoa pode ter **vários cargos** — os crachás se somam sem duplicar

Equivalente conceitual em SQL:

```sql
SELECT p.code
FROM user_store_roles usr
JOIN roles            r  ON r.id = usr.role_id
JOIN role_permissions rp ON rp.role_id = r.id
JOIN permissions      p  ON p.id = rp.permission_id
WHERE usr.user_id = 'U1' AND usr.store_id = 'S1';
```

## Cola das operações

```text
LER
findUnique({ where: { email } })        por PK ou chave única → 1 ou null
findFirst ({ where })                   o primeiro que bater → 1 ou null
findMany  ({ where, include, select })  lista

ESCREVER
create    ({ data })                    cria (erro se violar @unique)
update    ({ where, data })             altera 1 (erro se não existir)
updateMany({ where, data })             altera vários → { count }
upsert    ({ where, create, update })   "existe? update : create"
delete    ({ where })                   apaga 1

MOLDAR
include: { role: true }                 traz a relação junto
select:  { id: true, email: true }      só esses campos (use para nunca devolver hash de senha)
```

## Pegadinhas
- `upsert` com `update: {}` = **create-only**: se existe, não mexe em nada. Base de seeds idempotentes.
- O `where` do `upsert` precisa ser **PK ou chave única** — é assim que ele sabe se "já existe".
- Na API (NestJS) o client é **um só**, injetado como service global. Em script solto (seed) você cria o client na mão e chama `$disconnect()` no final.

## Pergunta para fixar
Na query acima, o que muda no resultado se o `storeId` **não** for passado no `where`?

## Ver também
- [Modelagem Relacional](../../Modelagem%20Relacional/Anotações/modelagem-relacional.md)
- [Seed e Dados Iniciais](../../Seed%20e%20Dados%20Iniciais/Anotações/seed-e-dados-iniciais.md)
- [TypeORM e Migrations](../../TypeORM%20e%20Migrations/Anotações/typeorm-e-migrations.md)
