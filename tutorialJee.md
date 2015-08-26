# Roteiro #

## 1. Instale o servidor de aplicações JEE ##
Há várias opções, sugiro que faça uso do [Glassfish](http://glassfish.dev.java.net).

## 2. Verifique a instalação do contêiner ##
Após iniciá-lo (use o comando **asadmin start-domain domain1** para o Glassfish), visite a página http://localhost:8080. Alternativamente, a página de administração do contêiner http://localhost:4848 também pode ser consultada. Neste último caso, a conta de administrador tem como usuário **admin** e senha padrão **adminadmin**.

## 3. Instalar o adaptador do Glassfish para o Eclipse ##
Para que você possa iniciar, parar e implantar uma aplicação a partir do Eclipse, é necessário um adaptador para o contêiner instalado. Observe que há várias implementações de JEE e, dessa forma, o Eclipse não optou por nenhuma delas, mas uma abordagem que permite que o Eclipse possa ser empregado independentemente da implementação empregada.

Para instalar o adaptador do Glassfish para o Eclipse vá em Window->Preferences->Server->Installed Runtimes->Add. Verifique se na caixa de diálogo que se abre há o Glassfish como opção. Caso exista, não há o que fazer neste passo, pois a instalação empregada do Eclipse já possui o adaptador. Caso não exista a pasta (opção) Glassfish, clique em _Download additional server adapters_, no canto superior direito. Este processo pode ser relativamente longo, aguarde até que a opção Glassfish apareça. Selecione-a e requisite a instalação. Ao final, será requisitado que o Eclipse seja reiniciado.

## 4. Adicionando o servidor Glassfish ##
Vá até Window->Preferences->Server->Installed Runtimes->Add. Selecione Glassfish e, em particular, **GlassFish V2 Java EE 5**. Na janela que se abre, forneça o JRE a ser empregado e, em seguida, informe o diretório onde está instalado o Glassfish.

## 5. Compreenda a organização da "aplicação" (estudo de caso) ##
Estes passos fazem uso de uma "aplicação" trivial com o propósito de introduzir elementos fundamentais e permitir que outras questões possam, posteriormente, serem contempladas sem a reapresentação dos passos aqui executados.

### Objetivo da aplicação ###
A "aplicação" web oferece ao usuário uma caixa de texto para que uma seqüência de caracteres possa ser fornecida e um botão que, quando acionado, fará com que a seqüência fornecida seja convertida em outra, contendo apenas letras maiúsculas. Esta seqüência resultante é exibida em página própria que destaca a entrada fornecida e o resultado da conversão para maiúsculas.

### Arquitetura ###
Faremos uso de EJB, não porque o problema exige (lembre-se que isto é um tutorial). Neste caso, teremos uma camada (_tier_) cliente, na qual estará em execução o browser do usuário.  Ao interagir com o browser, o usuário irá disparar a execução de serviço que, será recebida pela camada (_tier_) web, por meio de um Servlet. Este Servlet desempenhará o papel de um controlador e, portanto, não executa a funcionalidade requisitada, mas a transfere para quem tem a devida competência, neste caso um _session bean_, em execução na camada (_tier_) EJB. Neste caso, tanto a camada web quanto a EJB estarão em execução em uma mesma máquina, no mesmo contêiner (Glassfish). O problema não demanda acesso a dados persistentes nem conexão com outros sistemas de informação e, portanto, não há necessidade de outra camada.

### Projeto detalhado ###
Do objetivo fornecido anteriormente e da arquitetura acima, passaremos diretamente, nos parágrafos seguintes, para os detalhes de implementação.

A interação com o usuário ocorrerá exclusivamente por meio de duas páginas. A página principal, [index.jsp](http://exemplos.googlecode.com/svn/trunk/scbcd/first/web/WebContent/index.jsp), responsável por capturar a seqüência de entrada e a página responsável por exibir o resultado da requisição disparada por meio da página anterior. A página que exibe os resultados é [saida.jsp](http://exemplos.googlecode.com/svn/trunk/scbcd/first/web/WebContent/WEB-INF/jsp/saida.jsp). Ambas são páginas simples. A primeira usa a ação **maiuscula** para tratar a requisição resultante. A segunda simplesmente recupera o valor do parâmetro **entrada** assim como o valor do atributo **resultado** e os exibe. Observe que, até o momento, tudo é exatamente como uma aplicação web convencional, ou seja, que não faz uso de um contêiner JEE para execução.

Para tratar a requisição gerada pela página inicial tem-se o Servlet [MaiusculaServlet](http://exemplos.googlecode.com/svn/trunk/scbcd/first/web/src/servlets/MaiusculaServlet.java). Este Servlet recupera o valor da seqüência fornecida como argumento na primeira página (inicial) por maio do parâmetro **entrada**. Em seguida, faz uso da referência **meuBean** para enviar a mensagem _maiuscula(entrada)_. O retorno é registrado como atributo da requisição e denominado **resultado**. Imediatamente a seguir a requisição é redirecionada para a página [saida.jsp](http://exemplos.googlecode.com/svn/trunk/scbcd/first/web/WebContent/WEB-INF/jsp/saida.jsp). A página, conforme comentado anteriormente, simplesmente recupera o valor do parâmetro **entrada** e o valor do atributo **resultado**. Sabemos que este último é, ao consultar [MaiusculaServlet](http://exemplos.googlecode.com/svn/trunk/scbcd/first/web/src/servlets/MaiusculaServlet.java) que se trata da resposta fornecida ao se fazer uso do EJB referenciado por **meuBean**.

Adicionalmente ao conteúdo do método **doGet**, convém observar a anotação **@EJB**, fornecida para a variável de instância **meuBean**, do tipo [SpringBeanLocal](http://exemplos.googlecode.com/svn/trunk/scbcd/first/ejb/ejbModule/utils/StringBeanLocal.java). Esta interface contém uma única operação, _String maiuscula(String entrada)_ e segue anotada por **@Local**. Isto significa que o acesso a uma implementação desta interface será feita na mesma máquina virtual Java. Por ora, é suficiente destacar que isto assegura o acesso a uma implementação desta interface por _injeção de dependência_. Tal injeção será executada pelo contêiner JEE, neste caso, o Glassfish. Quem será beneficiado por tal injeção? Já sabemos, trata-se do Servlet [MaiusculaServlet](http://exemplos.googlecode.com/svn/trunk/scbcd/first/web/src/servlets/MaiusculaServlet.java). Observe que, neste Servlet, **meuBean** segue anotado por **@EJB**. Isto é suficiente para que o contêiner JEE empregado injete, ao criar uma instância deste Servlet, uma referência que implementa esta interface.

## 6. Experimentação ##
Obtenha os projetos Eclipse correspondentes ao exemplo acima. O URL do repositório é http://exemplos.googlecode.com/svn/trunk/scbcd/first/. Este exemplo compreende três projetos: ear, ejb e web. O projeto web implementa a camada web, o projeto ejb implementa a camada ejb e o projeto ear reúne os dois projetos anteriores em uma aplicação corporativa pronta para ser implantada em um servidor JEE.

Após criar cópia de trabalho correspondentes, importe estes projetos no Eclipse e, usando o Eclipse, inicie o servidor JEE e experimente a aplicação correspondente.