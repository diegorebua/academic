Princípios e Requisitos da Segurança da Informação

Autenticação: Validação da identidade do usuário e de seus privilégios de acesso (podendo exigir um ou mais fatores).

Integridade: Garantia de que a informação seja completa, exata e não sofra alterações indevidas por pessoas não autorizadas.

Disponibilidade: Garantia de que os dados, serviços e sistemas estejam acessíveis sempre que solicitados por usuários autorizados.

Confidencialidade: Proteção contra o acesso e a divulgação indevida de informações.

Não repúdio (Irretratabilidade): Garantia de que um indivíduo não possa negar falsamente ter realizado uma ação no sistema.

Fundamentos de Redes e Arquitetura TCP/IP

Camadas e Endereçamento:

Camada de Transporte (TCP/UDP): Utiliza portas lógicas para identificar e entregar os dados às aplicações e serviços corretos dentro de um computador.

Camada de Internet (IP): Utiliza endereços IP para identificar as máquinas e rotear os pacotes entre redes diferentes.

Protocolo TCP: Protocolo orientado a conexão e confiável. Utiliza o processo de Three-Way Handshake (segmentos SYN, SYN-ACK, ACK) para estabelecer conexão e verifica a integridade/sequência dos pacotes.

Protocolo UDP: Protocolo não orientado a conexão, mais rápido, porém sem garantia de entrega (não utiliza Three-way handshake ou confirmação de recebimento).

Dispositivos de Rede:

Switch: Opera na camada de enlace (camada 2), utiliza tabela de endereços MAC para direcionar o tráfego seletivamente apenas para a porta de destino correta e suporta VLANs/QoS.

Hub: Dispositivo burro (camada 1) que apenas duplica o sinal para todas as portas (broadcast).

Roteador: Opera na camada de rede (camada 3), conectando diferentes redes usando endereços IP.

Topologia em Estrela: Organização física baseada em switches que restringe nativamente o tráfego de pacotes entre a origem e o destino, aumentando a eficiência e segurança.

Ameaças e Ataques Cibernéticos

Ataques de Negação de Serviço Distribuído (DDoS):

Têm como alvo o pilar da Disponibilidade.

Funcionam sobrecarregando os recursos do servidor (banda larga e processamento) com tráfego massivo.

Utilizam redes de máquinas comprometidas (botnets) e falsificação de IP (IP Spoofing) para ocultar a origem.

Sequestro de Sessão TCP (TCP Session Hijacking):

Exploração dos números de sequência (SYN e ACK) de uma conexão em andamento.

O atacante injeta pacotes falsificados que o servidor aceita como legítimos.

Causa a dessincronização da comunicação para o usuário legítimo, resultando na queda da sua conexão original.

ARP Spoofing (Envenenamento ARP) e Man-in-the-Middle (MITM):

O protocolo ARP (que traduz IP para MAC) não possui autenticação nativa.

O invasor clona os endereços MAC para enganar as máquinas da rede (ex: a vítima e o roteador).

Isso permite que o atacante se posicione "no meio" da conexão (MITM), quebrando a proteção natural da topologia em estrela para desviar e interceptar todo o tráfego.

Sniffing: Captura e análise de pacotes na interface de rede com o objetivo de roubar informações confidenciais trafegadas em texto claro.
