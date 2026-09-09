# Introdução ao android

- Estrutura:
- Ambiente de desenvolvimento:
- Principais conceitos

Android é desenvolvido pela Google e é baseado no Kernel do Linux

*Linux Kernel é a base do sistema Android*

Trabalho acadêmico abordando de maneira abrangente e acessivel os fundamentos do Kernel Linux: https://app.uff.br/riuff/handle/1/5443

#

# Tópico 1: Instrucao ao android e sua estrurura
## Android Runtime (ART)

Android Runtime (ART) é o componente responsavel pela execucao dos aplicativos Androidno dispositivo. Ele converte os códigos Java em codigo da maquina no momento da instalacao do aplicativo. Um dos beneficios do Android Runtime (ART) é a otimizacao de memoria alocada, usando tecnicas de alocacao e coleta de lixo.

## Camada de Aplicativos

A camada de aplicativos é a camada superior da *estrutura* do sistema Android. Nela residem os aplicativos necessarios do sistema para o funcionamento do dispositivo. Os principios de cama de aplicativos android sao:

1. Execucao dos aplicativos
2. Seguranca e isolamento de processos
3. Aplicativos do sistema e de terceiros

## Ponto de fixacao

- O ART utiliza a compilacao AOT (Ahead-of-time) para converter o bytecode do aplicativo em código de maquina, específico do dispositivo durante a instalacao, ao contrario do Dalvik, que realiza a conversao JUT (Just-in-Time) no momento da execucao do codigo.
