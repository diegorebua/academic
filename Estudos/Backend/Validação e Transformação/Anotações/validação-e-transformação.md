# Validação (class-validator / class-transformer)

**O que é e qual o seu papel:** Valida payloads e omite dados sensíveis.
**Tempo Estimado:** 2 a 3 dias

## Topicos para Estudar

### ValidationPipe
- [ ] Onde e configurado (uma vez no `main.ts`, global)
- [ ] As 3 opcoes: `whitelist`, `forbidNonWhitelisted`, `transform` — saber o que cada uma faz
- [ ] O mecanismo: Pipe le a assinatura do metodo -> cria instancia do DTO -> roda decorators -> passa ou retorna 400

### class-validator (decorators)
- [ ] Decorators basicos: `@IsString`, `@IsEmail`, `@IsUUID`, `@IsInt`, `@IsArray`, `@IsOptional`
- [ ] Decorators de regra: `@Matches(regex)`, `@Min()`, `@Max()`, `@MinLength()`, `@MaxLength()`
- [ ] Saber que decorators rodam em tempo de execucao (nao em compilacao)

### class-transformer
- [ ] `@Exclude()` — omitir campo na resposta (ex: `passwordHash`)
- [ ] `@Expose()` — expor campo calculado
- [ ] `@Transform()` — transformar valor antes de usar

### DTO na pratica
- [ ] Por que DTO e classe e nao interface (interface some na compilacao, ValidationPipe precisa instanciar)
- [ ] A flag `emitDecoratorMetadata` no tsconfig — permite ao NestJS saber o tipo em runtime
- [ ] O DTO valida ANTES do controller executar — se falhar, o controller nem roda

### Tratamento de erros de validacao
- [ ] O que o NestJS retorna quando a validacao falha (400 com array de mensagens)
- [ ] Como customizar mensagens de erro nos decorators (`{ message: 'texto' }`)
