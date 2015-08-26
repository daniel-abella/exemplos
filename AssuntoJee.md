# Introdução #
Exemplos e exercícios apresentados abaixo fazem uso do [Glassfish](http://glassfish.dev.java.net) (_application server_ que implementa a especificação Java EE 5). Siga o link para detalhes, documentos, tudoriais e outros. Uma coleção de links pertinentes pode ser encontrada [aqui](http://del.icio.us/kyriosdata/jee).

Aprendendo por fases...
  * Introdução a JEE ([introdução](tutorialJeeIntroducao.md))
  * Primeiro contato com JEE ([stateless](tutorialJee.md))
  * Segundo contato com JEE ([stateful](tutorialJeeStateful.md))
  * Outro exemplo ([terceiro](http://exemplos.googlecode.com/svn/trunk/scbcd/third/))
  * Enviando ([SendMsg.java](http://exemplos.googlecode.com/svn/trunk/ejb3/jms1/src/jms/SendMsg.java)) e recebendo ([ReceiveMsg.java](http://exemplos.googlecode.com/svn/trunk/ejb3/jms1/src/jms/ReceiveMsg.java)) mensagem via JMS ([projeto que inclui ambas as aplicações](http://exemplos.googlecode.com/svn/trunk/ejb3/jms1)). Para executar estas aplicações é necessário acrescentar ao classpath: javaee.jar, appserv-rt.jar, appserv-admin.jar e imqjmsra.jar (todos disponíveis na distribuição do Glassfish). Adicionalmente, se o Glassfish estiver em execução em máquina diferente daquela em que executado uma destas aplicações, então será necessário fornecer a opção **-Dorg.omg.CORBA.ORBInitialHost=host-aqui**. Se ocorrer a exceção UnknownHostException, é bem provável que tenha que editar o arquivos /etc/hosts ou c:\WINNT\system32\drivers\etc\hosts para acrescentar o nome em questão e o respectivo endereço IP.

Dicas
  * Ao executar o **appclient**, além da opção **-client**, a opção **-xml** permite especificar um arquivo de configuração. Dentre outras possibilidades, este arquivo permite indicar o servidor (host) onde se encontra  em execução o servidor de aplicações que contém os EJBs requisitados pelo cliente. O elemento correspondente é **target-server** e a propriedade é **address**.
  * Ao execultar _standalone java client_ sem o uso de **appclient**, ou seja, em vez de usar injeção de dependência será empregado JNDI, então convém observar o seguinte.
    * Explicitamente forneça o nome do bean, algo como: **@Stateless(mappedBy="MeuEJB")**
    * O código cliente deve ser parecido com o seguinte
```
InitialContext ctx = new InitialContext();
SessionRemote sr = (SessionRemote) ctx.lookup("MeuEJB");
System.out.println(sr.toUpper("teste"));
```
    * Para executar código que contém o trecho acima, será necessário acrescentar ao classpath do aplicativo três jars (**appserv-rt.jar**, **javaee.jar** e **seuEjb.jar**) e o diretório onde se encontra as classes da aplicação. Os dois primeiros jars podem ser encontrados no diretório **lib**, que se encontra no diretório de instalação do Glassfish. O terceiro contém a interface empregada, neste caso, **SessionRemote**.
    * Se a aplicação for executada de máquina diferente daquela onde o Glassfish está em execução, então será necessário acrescentar **-Dorg.omg.CORBA.ORBInitialHost=host-glassfish**.
  * Para executar MDBs é necessário a criação da fábrica de conexões e destino correspondentes. Isto pode ser feito pelo administrador. Vá em Resources->JMS Resources. Observe que há duas entradas: uma para "Connection Factories" e outra para "Destination Resources". Ao clicar em cada uma destas será possível adicionar tanto uma fábrica de conexões quanto um destino, respectivamente. Em tempo, lembre-se de que a entrada **JNDI Name**, fornecido em ambas as entradas é referenciada em código, por meio da anotação **@Resource** e atributo **mappedName**. Ou seja, o mesmo nome empregado para identificar **JNDI Name** deve ser aquele do atributo **mappedName** em código.
  * Se o bean é definido simplesmente como **@Stateless** ou **@Stateful**, então o nome JNDI empregado é o nome completo da interface correspondente.