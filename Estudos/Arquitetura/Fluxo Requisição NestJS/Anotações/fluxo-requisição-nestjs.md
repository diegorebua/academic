# Fluxo de uma Requisicao HTTP no NestJS

**O que e:** O caminho completo que uma requisicao percorre desde a chegada ate a resposta.
**Tempo Estimado:** 3 a 5 dias

## Topicos para Estudar

### Guard
- [ ] O que e um Guard e quando ele roda (antes de tudo)
- [ ] Diferenca entre `JwtAuthGuard` (autenticacao) e `PermissionsGuard` (autorizacao)
- [ ] Como usar `@Public()` pra pular os guards
- [ ] Como usar `@RequirePermissions()` pra exigir permissao

### DTO (Data Transfer Object)
- [ ] O que e um DTO e por que ele existe (validacao automatica)
- [ ] Por que DTO e classe e nao interface (interface some na compilacao, classe nao)
- [ ] A flag `emitDecoratorMetadata` e como o NestJS sabe o tipo em runtime
- [ ] O ValidationPipe valida ANTES do controller — se falhar, controller nem executa

### Controller
- [ ] As 3 funcoes do controller: mapear rota, extrair dados, delegar pro service
- [ ] Decorators de extracao: `@Body()`, `@Param()`, `@Query()`, `@CurrentUser()`
- [ ] Por que NUNCA colocar logica de negocio no controller

### Service
- [ ] Onde ficam as regras de negocio (email unico, hash de senha, etc.)
- [ ] Como o service orquestra dependencias via constructor (injecao de dependencia)
- [ ] Excecoes HTTP: `ConflictException` (409), `NotFoundException` (404), `BadRequestException` (400)
- [ ] Usar `Logger` do NestJS — nunca `console.log`
- [ ] Controlar campos retornados via `select` — nunca retornar `passwordHash`

### Module
- [ ] O que cada propriedade faz: `imports`, `providers`, `controllers`, `exports`
- [ ] Encapsulamento: se nao exportar, ninguem de fora usa
- [ ] Como o NestJS resolve dependencias entre modulos

### Interceptor
- [ ] O que e o `TransformInterceptor` e quando roda (depois do controller)
- [ ] O envelope padrao `{ data, timestamp, path }`
- [ ] Por que no frontend e `response.data.data`

### Ordem do fluxo (memorizar)
- [ ] Guard -> ValidationPipe/DTO -> Controller -> Service -> Prisma/DB -> Interceptor -> Resposta
