#Passos para instalação do ambiente de desenvolvimento J2ME.

# WTK - Wireless Toolkit #

Para a disciplina, será abordada a configuração CLDC. Portanto, só precisamos nos preocupar com MIDP.

No [site do J2ME](http://java.sun.com/javame/index.jsp) podem ser encontradas ferramentas que permitem gerar os arquivos necessários para rodar aplicações em aparelhos compatíveis com a plataforma. A maioria já está integrada ao Wireless Tool Kit (WTK), da Sun, que pode ser [instalado](http://java.sun.com/products/sjwtoolkit/download.html) em seu computador. A atual versão e a 2.5.2\_01.

Após o download, o WTK, basta rodar o arquivo de instalação:
  * No Windows, execute o “.exe”;
  * No Linux, execute o “.bin”.

Após a execução do arquivo de instalação, já está a sua disposição toda a plataforma, no que se diz respeito à ferramentas de desenvolvimento e debug, a última versão da especificação ME, à partir do CLDC 1.0 e MIDP 1.0 e diferentes emuladores para testar seu código.

# Pacote Mobility do NetBeans #

Para desenvolver em J2ME pelo NetBeans, basta instalar o pacote [Mobility](http://www.netbeans.org/features/javame/index.html) , que já vem instalado no NetBeans 6.1+ (Completo). Para a versão 5.5.1 da plataforma, siga os passos de instalação [AQUI](http://www.netbeans.org/community/releases/55/1/mobilitycdc-install_pt_BR.html#prerequisites).

Para criar um projeto para dispositivos móveis no NetBeans, siga o tutorial ([AQUI](http://exemplos.googlecode.com/svn/trunk/me/tutoriais/project_mobility_netBeans.pdf));