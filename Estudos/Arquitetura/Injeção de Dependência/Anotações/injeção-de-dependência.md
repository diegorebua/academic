# Injeção de dependência

## O que é?
- É um padrão de projeto que define como os componentes internos do seu próprio código recebem as dependências de que precisam.

## Ideia central
- Ao invés de uma classe criar as coisas que ela precisa, ela recebe essas coisas prontas.

## Por que usar?
- Testes mais fáceis - Você pode dar versões "falsas" das dependências;
- Código desacoplado - Trocar implementações sem quebrar nada;
- Reutilização - A mesma instância pode ser compartilhada;
- Manutenção - Mudanças de configuração não afetam quem usa.

## Topicos para Estudar
- [ ] O que e `@Injectable()` e por que o service precisa dele
- [ ] Declarar dependencias no constructor — o framework cria e entrega
- [ ] Diferenca entre `new PrismaService()` (acoplado) e receber via constructor (desacoplado)
- [ ] O papel do Module: `imports` traz modulos de fora, `providers` registra o que crio, `exports` libera pra outros
- [ ] Como o NestJS resolve: ve o tipo no constructor -> procura quem fornece -> injeta
- [ ] Por que facilita testes: trocar o service real por um mock sem mudar codigo
- [ ] Modulo global vs modulo importado (PrismaModule e global, PasswordModule precisa de import)

## Pergunta que responde:
- Como um objeto dentro do meu código obtém as instâncias de outros objetos dos quais ele depende?

	Uma dependência ocorre quando uma classe precisa de outra para executar suas tarefas. Basicamente a classe "main" é desacoplada podendo fazer alterações futuras, como por exemplo o banco de dados.