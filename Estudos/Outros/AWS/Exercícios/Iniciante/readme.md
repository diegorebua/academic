# 🎯 AWS — Iniciante

**Total de exercícios neste nível:** 30

## 📝 Lista de Exercícios

- [01 S3 Bucket Estático](./01%20S3%20Bucket%20Estático): Crie um bucket S3, habilite hospedagem de site estático e suba um HTML simples.
- [02 IAM Usuários Grupos](./02%20IAM%20Usuários%20Grupos): Crie usuários IAM, grupos e políticas. Entenda o princípio do menor privilégio.
- [03 Ec2 Instância Básica](./03%20Ec2%20Instância%20Básica): Suba uma instância EC2 t3.micro, conecte via SSH e instale o nginx.
- [04 Security Groups](./04%20Security%20Groups): Configure Security Groups para permitir apenas tráfego HTTP e SSH de IPs específicos.
- [05 Elastic IP](./05%20Elastic%20IP): Associe um Elastic IP à sua EC2 para ter um IP público fixo.
- [06 S3 Versionamento](./06%20S3%20Versionamento): Habilite versionamento no S3. Faça upload de versões do mesmo arquivo e restaure uma versão anterior.
- [07 Cloudfront Cdn](./07%20Cloudfront%20Cdn): Configure o CloudFront em frente ao seu bucket S3 para distribuição global de conteúdo.
- [08 RDS Free Tier](./08%20RDS%20Free%20Tier): Crie uma instância RDS PostgreSQL no free tier e conecte usando DBeaver ou psql.
- [09 VPC Básica](./09%20VPC%20Básica): Crie uma VPC com subnets públicas e privadas, Internet Gateway e route tables.
- [10 Elb Básico](./10%20Elb%20Básico): Configure um Application Load Balancer (ALB) na frente de duas instâncias EC2.
- [11 Auto Scaling Group](./11%20Auto%20Scaling%20Group): Crie um Auto Scaling Group que escala EC2 baseado em uso de CPU.
- [12 Cloudwatch Alarmes](./12%20Cloudwatch%20Alarmes): Configure alarmes no CloudWatch para notificar via SNS quando o CPU ultrapassar 80%.
- [13 SNS SQS Básico](./13%20SNS%20SQS%20Básico): Publique uma mensagem no SNS e receba-a via SQS. Entenda fan-out.
- [14 Lambda Hello](./14%20Lambda%20Hello): Crie uma função Lambda em Node.js que retorna 'Olá, Mundo!' e analise a execução nos logs.
- [15 API Gateway Lambda](./15%20API%20Gateway%20Lambda): Exponha sua função Lambda via API Gateway REST e teste com curl.
- [16 Dynamodb Básico](./16%20Dynamodb%20Básico): Crie uma tabela DynamoDB, insira, leia e delete itens usando o console e SDK.
- [17 Cognito Básico](./17%20Cognito%20Básico): Configure o Cognito User Pool para autenticação e crie um fluxo de cadastro/login.
- [18 Route53 Dns](./18%20Route53%20Dns): Configure o Route 53 para apontar um domínio para seu CloudFront ou EC2.
- [19 Certificate Manager](./19%20Certificate%20Manager): Emita um certificado SSL gratuito com o ACM e associe ao CloudFront e ALB.
- [20 Systems Manager](./20%20Systems%20Manager): Use o SSM Session Manager para se conectar a EC2 sem abrir a porta 22.
- [21 S3 Lifecycle](./21%20S3%20Lifecycle): Configure regras de ciclo de vida no S3: mover para Glacier após 30 dias, deletar após 1 ano.
- [22 Billing Budgets](./22%20Billing%20Budgets): Configure alertas de faturamento no Billing e Budgets para evitar surpresas na conta.
- [23 Cloudtrail Básico](./23%20Cloudtrail%20Básico): Habilite o CloudTrail para auditar todas as chamadas de API feitas na sua conta.
- [24 Parameter Store](./24%20Parameter%20Store): Armazene segredos (senha de banco, chave de API) no Parameter Store e acesse da Lambda.
- [25 Ecr Docker](./25%20Ecr%20Docker): Crie um repositório no ECR, faça o build de uma imagem Docker e faça push.
- [26 Ecs Fargate Simples](./26%20Ecs%20Fargate%20Simples): Rode um container Docker no ECS Fargate com uma task definition simples.
- [27 Step Functions Básico](./27%20Step%20Functions%20Básico): Crie um workflow simples no Step Functions que encadeia duas funções Lambda.
- [28 Glue Básico](./28%20Glue%20Básico): Use o AWS Glue Crawler para catalogar um dataset CSV no S3 e consultar com Athena.
- [29 Kinesis Básico](./29%20Kinesis%20Básico): Crie um Kinesis Data Stream e produza/consuma mensagens com o SDK.
- [30 Well Architected Review](./30%20Well%20Architected%20Review): Avalie sua arquitetura usando o AWS Well-Architected Framework (os 6 pilares).
