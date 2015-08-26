#Descrição da arquitetura da Plataforma J2ME.

# Arquitetura da Plataforma J2ME #
A tecnologia J2ME é baseada em três elementos apoiados sobre a máquina virtual Java do dispositivo:
  * Configurações;
  * Perfis;
  * Pacotes opcionais.

Veja figura abaixo:

[![](http://img219.imageshack.us/img219/9504/archsm0.jpg)](http://www.javaworld.com/)

<sub>Imagem retirada do site www.javaworld.com.</sub>


# KVM, a máquina virtual J2ME #

KVM (K Virtual Machine) é uma máquina virtual Java “desnudada”, projetada para memória pequena, recursos limitados e conexão de dispositivos móveis à web.
Suas principais características são:

  * Bibliotecas de classe com código objeto de tamanho reduzido em 50-80 Kb;
  * Pequena utilização de memória;
  * Performance efetiva em processadores de 16-32 bits;
  * Portabilidade;
  * Multithreading e coleta de lixo independentes do sistema;
  * Configurabilidade de componentes através de suítes.

# Configuração #

Uma configuração é um conjunto de funcionalidades para que as aplicações J2ME possam “se comunicar com a JVM”, dada certa gama de aparelhos. Essa camada é menos visível aos usuários, mas é muito importante para implementadores de profiles. Existem configurações básicas: CDC e CLDC.

## CDC (Connected Device Configuration) ##
Supõe dispositivos com mais capacidade, tais como settop boxes digitais, screen-phones, Nokia Communicator e alguns PDAs mais poderosos.

Mais informações em http://java.sun.com/javame/technology/cdc/.

## CLDC (Connected Limited Device Configuration) ##
Supõe dispositivos mais simples, com mais limitações, como telefones celulares e pagers. Hoje, é a mais usada para programação J2ME.
O hardware requerido para seu processamento tem mínimo de 160KB de memória para Java, um processador de no mínimo 16 bits com baixo consumo (adequado a baterias típicas de um celular) e conexão de rede (neste caso wireless – 9.6Kbps, 144Kbps ou 2Mbps).
A sua segurança está baseada no chamado “Sandbox Security Model”, isto é, a máquina virtual terá um espaço de memória independente do restante das outras aplicações (tais como agenda, tons, imagens, etc.).

Mais informações em http://java.sun.com/products/cldc/.

# Perfil #

Profile, ou perfil, define uma API disponível para uma família específica de aparelhos. É implementado sobre uma configuração particular e as aplicações escritas no mesmo são portáveis para qualquer outro aparelho que o dê suporte. São quatro os tipos de perfis mais famosos: MIDP, personal, basis e foundation.

É importante entender a diferença entre Configuração e Perfil. A primeira descreve de forma geral uma família de dispositivos, enquanto o Perfil fica mais específico para um tipo particular de aparelho em uma dada família.

## Personal, basis e foundation ##
APIs baseadas na CDC. A Foundation provê biblioteca de classes básica, sem interface gráfica. A Basis provê interface gráfica simples, baseada no modelo ‘xlet’(http://interactivetvweb.org/tutorials/javatv/xlet_intro). Já a pessoal provê API mais complexa, inclusive com componentes do modelo AWT e suporte a applets. Os três perfis têm suporte a JDBC e RMI.

## MIDP (Mobile Information Device Profile) ##
Conjunto de APIs baseadas na CLDC, com suporte a interface gráfica, persistência e acesso a web. É o perfil mais popular e será o alvo do nosso estudo. A versão atual é a 2.0, que tem seus detalhes especificados em http://java.sun.com/products/midp/overview.html.

# Sintaxe #
A sintaxe J2ME é similar a EE/SE, com algumas modificações. Diferentemente das outras versões da Java, ela não é naturalmente “standalone” e não é executada através de um método main, mas sim através de um conjunto de métodos de um midlet, o que será visto posteriormente.

O programador J2ME tem acesso somente a uma reduzida parte das classes da API “clássica”. Não há API embutida para sistema de arquivos, interfaces AWT/Swing, JDBC, JNDI ou RMI.
Porém, há APIs específicas que substituem algumas, como o pacote javax.microedition.io.lcdui, que provê interface gráfica com componentes simplificados e javax.microedition.io, que provê implementação do protocolo HTTP.

Além disso, o garbage collector é simplificado, não havendo, por exemplo, chamadas ao método finalize().