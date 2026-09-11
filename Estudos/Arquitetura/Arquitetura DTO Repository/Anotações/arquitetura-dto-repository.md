# Arquitetura (DTO e Repository)

**O que é e qual o seu papel:** Aplicação prática da separação de responsabilidades.
**Tempo Estimado:** 3 a 5 dias

## Topicos para Estudar

### DTO
- [ ] O que e e pra que serve (contrato de entrada — define campos aceitos)
- [ ] Decorators de validacao (`@IsEmail`, `@IsString`, `@Matches`)
- [ ] Quem roda a validacao: o ValidationPipe, nao o controller

### Controller
- [ ] Papel: mapear rota -> extrair dados -> delegar pro service
- [ ] Nunca ter logica de negocio

### Service
- [ ] Papel: regras de negocio, orquestrar dependencias
- [ ] Excecoes HTTP: `NotFoundException`, `ConflictException`, `BadRequestException`

### Repository / Prisma
- [ ] Papel: unica camada que toca o banco de dados
- [ ] No SayPlus, o PrismaService faz o papel do Repository

### Injecao de dependencia
- [ ] Como as camadas se conectam via constructor (ver anotacao de InjecaoDeDependencia)

### Comunicacao entre as camadas (ordem fixa)
- [ ] Controller -> Service -> Repository/Prisma (nunca pular camadas)
