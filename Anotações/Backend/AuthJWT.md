# Autenticação com JWT

## Conceito: 
É como uma "pulseira de balada". O usuário mostra o RG (login/senha) na entrada, ganha a pulseira (token JWT) e depois só precisa mostrar a pulseira para pedir bebidas (acessar rotas), sem precisar mostrar a pulseira de novo toda hora. 

## O que é: 
JWT (JSON Web Token) é um padrão para transmitir informações de forma segura entre duas partes. No NestJS, usamos junto com o Passapot e Guards. 

## Fluxo
1. **Login:** Usuário envia `email` e `senha`.
2. **Validação:** Backend confere no banco. Se bater, gera um **Token** (uma string criptografada).
3. **Uso:** O Frontend (Vue) guarda esse token e o envia no `Header` de cada requisição (`Authorization: Bearer <token>`).
4. **Proteção:** O Backend verifica se o token é válido antes de responder.