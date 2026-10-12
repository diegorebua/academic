# Seed e Dados Iniciais

**O que é e qual o seu papel:** Script que garante os dados mínimos para o sistema funcionar (permissões, admin, cadastros base).
**Tempo Estimado:** 2 a 3 dias (sugestão)

## Tópicos para Estudar
- [ ] O que é seed e por que o banco "nasce vazio" depois da migration
- [ ] Idempotência — rodar 1 ou 100 vezes dá o mesmo resultado
- [ ] Seed não destrutivo — cria o que falta, nunca apaga
- [ ] `upsert` com `update: {}` (create-only)
- [ ] "Definição é código, ativação é dado"
- [ ] Modos de seed: local (dev) vs ambiente real (bootstrap)
- [ ] Migration vs Seed — o que vai em cada um

## Analogia — o gerente de implantação
Uma rede de lojas tem um **gerente de implantação** com uma prancheta: tudo o que *toda loja precisa ter* para abrir as portas.
Para cada item ele pergunta:

> "Isso já existe? **Se não existe, eu instalo. Se já existe, eu não mexo.**"

| Item da prancheta | No banco |
|---|---|
| Imprimir os **crachás** (um por porta) | `Permission` |
| Abrir cada **loja** | `Store` / `Tenant` |
| Criar o cargo **"Gerente"** com todos os crachás… | `Role` + `RolePermission` |
| …**menos** o crachá do cofre (dados sensíveis) | permissões sensíveis ficam de fora |
| Contratar o **gerente geral** e dar a chave | usuário admin |
| Instalar **balcões terceirizados desligados** | módulos cadastrados com `enabled: false` |

O seed **monta a loja e imprime os crachás**. Quem **abre a loja** e **entrega crachás às pessoas** é o admin, pela interface. Quem **confere o crachá na porta** é a API.

## Conceito — o padrão que se repete

```ts
prisma.permission.upsert({
  where:  { code },                     // "já existe?"  (precisa ser chave única)
  create: { code, description: code },  // não → cria
  update: {},                           // sim → NÃO MEXE
});
```

`update: {}` = **create-only**. É isso que torna o seed seguro de rodar a cada deploy sem sobrescrever o que alguém configurou pela interface (senha do admin, módulo ligado, URL configurada…).

## Estrutura em texto — ordem típica de execução

```text
$ npm run db:seed
   │
   ├─ gera o client do ORM
   └─ main()
        ├─ [1] decide o modo (dev | bootstrap) e quem é o admin
        ├─ [2] permissões  → upsert de cada código
        ├─ [3] cadastros base (grupo, lojas)
        ├─ [4] admin       → senha com hash; só é CRIADO (nunca redefinido)
        ├─ [5] por loja: cargo "Gerente" + crachás + admin vinculado
        ├─ [6] módulos     → catálogo + vínculo por loja, DESLIGADO
        └─ fim
   .then(etapas que dependem de TUDO acima)   ← ex.: ligar cada permissão ao módulo dono
   .catch → exit code ≠ 0                      ← o pipeline percebe a falha
   .finally → desconecta do banco
```

## Modos

| Modo | Onde | Admin | Dados já existentes |
|---|---|---|---|
| `dev` | máquina local | credencial fixa de desenvolvimento | pode sincronizar com o código |
| `bootstrap` | ambiente real | vem de **Secret** (obrigatório, senha forte) | só cria, nunca altera |

Faltou o Secret no modo real → o seed **falha** em vez de inventar um padrão (*fail-closed*).

## Migration vs Seed

**Regra real:**
> Coisas que devem acontecer **uma vez** → **migration**.
> Coisas que devem ser **garantidas sempre** → **seed**.

| | Migration | Seed |
|---|---|---|
| Quantas vezes roda | **uma vez** por banco | **toda vez** (a cada deploy) |
| Como sabe o que já fez | tabela `_prisma_migrations` | chaves únicas + `upsert` |
| Costuma mexer em | estrutura (tabelas, colunas) | dados base |
| Pode apagar? | pode (roda 1x, controlado) | **nunca** |
| No deploy | **antes** da API subir | **depois** |

Analogia: migration é a **reforma registrada no diário de obras** (numerada, feita uma vez, anotada). Seed é o **checklist** que roda sempre.

### Por que apagar é papel da migration

```text
seed com DELETE                              migration com DELETE
───────────────────                          ────────────────────
deploy 1: apaga módulo X  ✓                  roda 1x: apaga módulo X  ✓
alguém cadastra X de novo                    alguém cadastra X de novo
deploy 2: apaga X DE NOVO ✗                  deploy 2: já está no diário → pula ✓
          (+ config, cargos, vínculos)
```

Uma migration **pode** mexer só em dados (`DELETE`, `UPDATE`) — o critério não é "estrutura vs dados", é "uma vez vs sempre".

### Linha do tempo de um banco

```text
BANCO NOVO                              BANCO EXISTENTE (novo deploy)
migrate → aplica todas                  migrate → só as novas (ou nenhuma)
seed    → cria tudo                     seed    → só o que falta (ex.: crachá novo)
```

## Pegadinhas
- **Nunca edite uma migration já aplicada**: ela já está marcada como feita e não roda de novo. Corrigir = migration **nova**.
- **Create-only tem efeito colateral**: mudar uma variável de ambiente e rodar o seed de novo **não atualiza** um registro que já existe. Depois de criado, só muda pela interface.
- Permissões de um cargo costumam ser **aditivas**: crachá novo no código entra no cargo no próximo seed; crachá removido do código **não** sai sozinho.
- Etapa que depende de todos os passos anteriores vai **no fim da cadeia** (`.then`), não no meio.

## Pergunta para fixar
Você precisa (a) adicionar a coluna `phone` em `users` e (b) garantir que todo cargo "Gerente" tenha o crachá novo `users.export-phone`. O que vai na migration e o que vai no seed?

## Ver também
- [Prisma ORM](../../Prisma%20ORM/Anotações/prisma-orm.md)
- [TypeORM e Migrations](../../TypeORM%20e%20Migrations/Anotações/typeorm-e-migrations.md)
- [Deploy e DevOps](../../../Infra/Deploy%20e%20DevOps/Anotações/deploy-e-devops.md)
