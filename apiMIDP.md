# MIDP 2.0 #

A API MIDP 2.0 oferece um conjunto de classes e interfaces para criação de programas J2ME. Na figura abaixo, tem-se sua estrutura em alto nível, de acordo com a JSR 118:

![http://img515.imageshack.us/img515/9108/pacoteskl1.png](http://img515.imageshack.us/img515/9108/pacoteskl1.png)

Como se pode ver, existem diferentes pacotes para tratamento do “que é básico” para programação J2ME, provendo interface para tratamento de multimídia, E/S, persistência, interface gráfica e Certificados.
A utilidade de cada pacote é a seguinte:

**Interface gráfica**
|**Pacote**|**Descrição**|
|:---------|:------------|
|javax.microedition.lcdui|Interface de usuário padrão.|
|javax.microedition.lcdui.game|Interface avançada, inclusive para jogos.|

**Persistência**
|**Pacote**|**Descrição**|
|:---------|:------------|
|javax.microedition.rms|Persistência de dados.|

**Ciclo de vida da aplicação**
|**Pacote**|**Descrição**|
|:---------|:------------|
|javax.microedition.midlet|Controle e interação da aplicação.|

**Conexão**
|**Pacote**|**Descrição**|
|:---------|:------------|
|javax.microedition.io|Conexão web padrão.|

**Audio**
|**Pacote**|**Descrição**|
|:---------|:------------|
|javax.microedition.media|Acesso a multimída, de acordo com a JSR-135.|
|javax.microedition.media.control|Tipos de controle a serem usados em multimídia.|

**Chaves Públicas**
|**Pacote**|**Descrição**|
|:---------|:------------|
|javax.microedition.pki|Gerenciamento de certificados para conexões web.|

**Core**
|**Pacote**|**Descrição**|
|:---------|:------------|
|java.io   |E/S de fluxo de dados.|
|java.lang |Provê classes base para programação.|
|java.util |Provê classes de utilidade na programação.|

Mais informações podem ser vistas na API do MIDP 2.0 + JSR-118
([AQUI](http://java.sun.com/javame/reference/apis/jsr118/)) .