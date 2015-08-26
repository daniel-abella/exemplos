# Questões #

  1. Quais os parâmetros fornecidos ao método Servlet.service()?
    1. HttpServletRequest
    1. HttpServletConfig
    1. HttpServletResponse
    1. HttpServletContext
  1. Marque métodos da classe HttpServletResponse
    1. getWriter()
    1. getContentType()
    1. setContentType()
    1. setCharacterEncoding()
  1. O método getWriter() retorna um objeto do tipo PrinterWriter?
    1. sim
    1. não
  1. "text/plain" e "image/jpeg" são MIME types que podem ser empregados pelo método setContentType()?
    1. sim
    1. não
  1. Pode-se fazer uma requisição HTTP empregando o método GET por meio de uma aplicação em Java?
    1. sim
    1. não
  1. Pode-se fazer uma requisição HTTP empregando o método POST por meio de uma aplicação em Java?
    1. sim
    1. não
  1. O contêiner web é responsável pela criação de instâncias de servlets?
    1. sim
    1. não
  1. O que se pode dizer do método Service.init(ServletConfig)?
    1. Não existe
    1. É chamado quando se inicia o contêiner web
    1. Todos os servlets que já trataram requisições necessariamente receberam esta mensagem
    1. Todo servlet necessariamente implementa tal método
  1. Em um descritor de aplicação (web.xml), o que se pode dizer de 

&lt;init-param&gt;

?
    1. Não existe
    1. Permite fornecer informações de inicialização para o servlet
    1. Os valores podem ser recuperados via getInitParameter(String name)
  1. Toda informação que pode ser enviada empregando o método GET também pode ser enviada empregando o método POST?
    1. sim
    1. não

# Respostas #

  1. 1 e 3
  1. 1, 2, 3 e 4
  1. 2 (o correto é java.io.PrintWriter)
  1. 1
  1. 1
  1. 1
  1. 1
  1. 3 e 4
  1. 2 e 3
  1. 1