# 🏗️ Estrutura Ideal de Projeto NestJS (Baseada no Roadmap)

Com base no seu roadmap focado em arquitetura e numa stack profissional para microsserviços, a organização ideal do projeto divide-se em **configurações globais**, **infraestrutura** e **módulos orientados a domínio** (onde entram os 5 Pilares).

Abaixo, um modelo de como a árvore de arquivos de um projeto profissional em NestJS deve se parecer:

```text
meu-microsservico/
├── .husky/                   # Husky (pre-commit, pre-push - Qualidade)
├── k8s/                      # Kubernetes & Helm (Deploy e DevOps)
│   └── helm-chart/           # ArgoCD vai ler este diretório no repositório
├── docker/                   # Dockerfiles (Infraestrutura)
│   ├── dev.Dockerfile
│   └── prod.Dockerfile
├── test/                     # Testes e2e (Jest + Supertest + Testcontainers)
│   ├── app.e2e-spec.ts
│   └── jest-e2e.json
├── src/                      # Código Fonte Principal
│   ├── main.ts               # Ponto de entrada (Swagger, Pino Logger, ValidationPipe)
│   ├── app.module.ts         # Módulo raiz (Importa os outros módulos)
│   ├── config/               # Variáveis de ambiente e configs globais
│   ├── common/               # Recursos compartilhados
│   │   ├── decorators/
│   │   ├── filters/          # Exception Filters (tratamento de erros global)
│   │   ├── interceptors/
│   │   ├── middlewares/
│   │   └── logger/           # Config do Pino e OpenTelemetry (Observabilidade)
│   ├── database/             # Persistência (TypeORM)
│   │   ├── migrations/       # Migrations para versionar o banco
│   │   └── data-source.ts    # Configuração do TypeORM CLI
│   └── modules/              # Domínios de Negócio (ex: Usuários, Pedidos)
│       └── users/
│           ├── users.module.ts
│           ├── controllers/
│           │   └── users.controller.ts     # 1- Controller ("O Atendente" - Swagger docs aqui)
│           ├── services/
│           │   └── users.service.ts        # 2- Service ("O Gerente" - Regras de negócio)
│           ├── repositories/
│           │   └── users.repository.ts     # 3- Repository ("O Estoquista" - TypeORM/DAO)
│           ├── entities/
│           │   └── user.entity.ts          # 4- Entity ("A Ficha Técnica" - Mapeia a tabela)
│           └── dtos/
│               ├── create-user.dto.ts      # 5- DTO ("A Vitrine" - Validado com class-validator)
│               └── update-user.dto.ts
├── docker-compose.yml        # Sobe o PostgreSQL (e outras dependências) localmente
├── package.json
├── tsconfig.json
├── .eslintrc.js              # 🧹 ESLint (Qualidade)
├── sonar-project.properties  # 📊 SonarJS (Qualidade)
└── jest.config.js            # 🧪 Testes Unitários e ArchUnit
```

---

## 🔗 Conectando a Estrutura com seu Roadmap

### 1. A Base e Framework (`src/modules/*`)
Toda a aplicação é escrita em **TypeScript** e baseada em **Módulos do NestJS**. Cada módulo (ex: `users`) contém a implementação dos **5 Pilares da Arquitetura** que você definiu. Essa separação garante que, caso o projeto cresça muito, você possa extrair a pasta `users` facilmente para um microsserviço à parte.

### 2. Banco de Dados e Persistência (`src/database/` e `docker-compose.yml`)
O `docker-compose.yml` na raiz serve para rodar sua instância do **PostgreSQL** de forma prática. O TypeORM gerencia a conexão no NestJS e a pasta `src/database/migrations` garante que as mudanças no banco sejam aplicadas sequencialmente em qualquer ambiente.

### 3. Validação e Documentação (`src/modules/*/dtos/` e `src/main.ts`)
Nos **DTOs**, você usará o `class-validator` e o `class-transformer` para barrar requisições inválidas antes mesmo de chegarem no Controller. O **Swagger** é configurado no `main.ts` e anota os Controllers/DTOs para gerar a documentação viva (geralmente na rota `/api-docs`).

### 4. Testes (`test/` e arquivos `*.spec.ts`)
*   **Unitários:** Ficam ao lado dos arquivos que testam (ex: `users.service.spec.ts` dentro de `src/modules/users/services/`). Utilizam **Jest**.
*   **E2E (Ponta a Ponta):** Ficam na pasta `test/`. Com o **Supertest**, eles chamam as rotas HTTP de verdade. Aqui entra o **Testcontainers**, subindo um banco temporário apenas para rodar a suíte de testes e depois destruindo.

### 5. Qualidade (`.eslintrc.js`, `.husky/`, `sonar-project.properties`)
O **ESLint** padroniza o código. O **Husky** impede commits se houver erro no linter ou testes quebrando. O **SonarJS** pode ser acoplado no CI para detectar complexidade e bugs de segurança antes do merge.

### 6. Observabilidade (`src/common/logger/`)
A substituição do logger nativo pelo **Pino** para gerar logs em formato JSON, ideais para o Datadog, ElasticSearch ou CloudWatch. O **OpenTelemetry** ajuda no rastreamento (_tracing_) da requisição quando ela navega por vários microsserviços.

### 7. Infraestrutura, Deploy e DevOps (`docker/` e `k8s/`)
A imagem da sua aplicação é gerada pelo **Docker** (pasta `docker/`). Para rodar em produção (geralmente via **Kubernetes**), os arquivos de deploy ficam na pasta `k8s/` ou num repositório separado, onde ferramentas de GitOps (como o **ArgoCD**) leem o **Helm chart** e aplicam automaticamente as mudanças no cluster.
