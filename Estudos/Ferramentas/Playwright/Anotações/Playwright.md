# Playright

## O que é

Playright é uma ferramenta de automação de navegadores criada pela Microsoft.

Ela é muito usada para testes E2E, simulando ações reais de um usuário dentro de aplicação

## Pra que serve

Serve para testar fluxo completos, por exemplo:

- Login
- Cadastro
- Navegação entre páginas
- Preenchimento de formulários
- Upload de arquivos
- Validação de mensagens

A ideia é validar se o sistema realmente funciona do começo ao fim.

## Como funciona

O Playright controla navegadores como:

- Chromium
- Firefox
- Webkit

Ele consegue:

- Abrir uma página;
- Clicar em botões;
- Preencher inputs;
- Navegar;
- Esperar requisições

## Fluxo Básico

Playright -> abre o navegador -> acessa a aplicação -> executa ações -> verifica o resultado esperado

## Exemplo

import { test, expect } from '@playwright/test';

test('usuário consegue fazer login', async ({ page }) => {
  await page.goto('/login');

  await page.getByLabel('Email').fill('teste@email.com');
  await page.getByLabel('Senha').fill('123456');

  await page.getByRole('button', {
    name: 'Entrar',
  }).click();

  await expect(page).toHaveURL('/dashboard');
});

## O que eu preciso lembrar

- Playright é muito usado em testes E2E
- Ele automatiza um mavegador real
- Testa o sistema de uma forma próxima ao usuário
- page representa uma aba do navegador
- locator é uma forma de encontrar elementos na tela
- expect valida o comportamento esperado
- Evitar waitForTime() quando possível
- Preferir esperar por estados reais da aplicação

## Onde vi isso

Testes automatizados durante desenvolvimento no trabalho

## Assuntos relacionados

- Locators
- Assertions
- Fixtures
- Hooks
- Mock de API
- Interceptação de requests
- Page Object Model
- Testes paralelos
- Trace Viewer
