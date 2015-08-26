# Questões #

  1. Marque todas as opções onde um servlet é executado.
    1. Browser
    1. Servlet contêiner
    1. Cliente
    1. Servlet engine
    1. Servidor
    1. Firefox
  1. O que é um servlet? (marque todas as opções apropriadas)
    1. Componente web que faz uso da Servlet API para estender servidor
    1. página HTML
    1. documentação de como gerar uma página HTML
    1. extensão de servidor web
    1. usa o protocolo FTP para se comunicar com um browser, em geral.
    1. classe Java que implementa a interface Servlet.
  1. Um servlet contêiner pode ser executado em processo distinto do servidor web?
    1. Sim
    1. Não
    1. Sim, o Tomcat, por exemplo, geralmente é executado como processo distinto do servidor web Apache.
  1. O desenvolvimento e a experimentação de um servlet exige (marque todas que se aplicam):
    1. Compilador Java
    1. Depurador Java
    1. Máquina virtual Java
    1. Contêiner web
  1. Marque as variáveis de ambiente que devem estar disponíveis em um ambiente de desenvolvimento de aplicações web usando Servlets e o contêiner Tomcat.
    1. KAD\_LIBS
    1. CATALINA\_HOME
    1. JAVA\_HOME
    1. CLASSPATH
    1. TOMCAT\_HOME
    1. TOMCAT\_LIBS
  1. O comando "javac MeuServlet.java", assumindo que a variável CLASSPATH não está definida, é suficiente para compilar o servlet fornecido no arquivo MeuServlet.java?
    1. Não
    1. Sim
  1. Pelo menos quantos diretórios devem ser criados para uma aplicação web usando servlets?
    1. 0
    1. 1
    1. 2
    1. 3
    1. 4
  1. A Servlet API está dividida em quantos pacotes java?
    1. 0
    1. 1
    1. 2
    1. 3
  1. O pacote javax.servlet.http é independente de qualquer protocolo.
    1. Sim
    1. Não
  1. Todo servlet, direta ou indiretamente, implementa a interface javax.servlet.http.Servlet?
    1. Sim
    1. Não
  1. A interface javax.servlet.Servlet é implementada pela classe javax.servlet.http.HttpServlet?
    1. Sim
    1. Não
  1. A classe javax.servlet.GenericServlet implementa a interface javax.servlet.Servlet?
    1. Sim
    1. Não
  1. Os pacotes javax.servlet e javax.servlet.http compreendem toda a Servlet API?
    1. Sim
    1. Não
  1. A interface Servlet faz parte do pacote javax.servlet.http?
    1. Sim
    1. Não
  1. O método service() é necessariamente chamado pelo contêiner para toda e qualquer requisição para um dado servlet?
    1. Sim
    1. Não
  1. Um servlet permite (marque todas as verdadeiras):
    1. Que resposta para uma requisição seja produzida dinamicamente, em tempo de execução e conforme argumentos recebidos da requisição.
    1. Retornar uma página estática ou conteúdo estático como um arquivo.
    1. Que a resposta seja formada por texto (html) e conteúdo binário.
  1. Quando um browser envia uma requisição http? (marque todas as verdadeiras)
    1. Quando o usuário clica em um link em página HTML
    1. Quando o usuário modifica a fonte da letra empregada pelo browser como padrão
    1. Quando o usuário preenche um formulário e clica em botão que o remete ao servidor.
    1. Quando o usuário fornece um URL no campo endereço e pressiona enter.
    1. Quando o usuário fecha o browser.
  1. Quais dos itens abaixo são métodos HTTP?
    1. GET
    1. TRACE
    1. OPTION
    1. POST
    1. DELETE
    1. PUT
    1. HEADER
  1. Para cada método HTTP há um método correspondente na classe javax.servlet.http.HttpServlet no formato do<Método>.
    1. Sim
    1. Não
  1. Selecione as verdadeiras.
    1. Todo servlet que estende HttpServlet deve sobrescrever cada um dos métodos no formato do<Método HTTP> herdados de HttpServlet.
    1. Todo servlet deve necessariamente sobrescrever o método service() caso este seja herdado de HttpServlet.
    1. Pelo menos o método doGet(<argumentos omitidos>) deve ser sobrescrito quando o servlet herda de HttpServlet.
    1. O método doGet(<argumentos omitidos>) é chamado para uma requisição HTTP que faz uso do método GET, mesmo que o servlet sobrescreva um dos métodos service(<argumentos omitidos>) quando o servlet estende HttpServlet.

# Respostas #

  1. 2, 4 e 5
  1. 1, 3 e 6
  1. 1 e 3
  1. 1. 3 e 4
  1. 2 e 3
  1. 1
  1. 4
  1. 3
  1. 2
  1. 2
  1. 1
  1. 1
  1. 1
  1. 2
  1. 1
  1. 1 e 3
  1. 1, 3 e 4
  1. 1, 2, 4, 5 e 6 (outros OPTIONS e HEAD)
  1. 1
  1. Nenhuma resposta é verdadeira