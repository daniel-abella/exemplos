# Roteiro #

## 1. Orientação ##
Em [página](tutorialJee.md) anterior foram fornecidos passos básicos para o desenvolvimento empregando JEE. O que segué são novos passos e um objetivo estendido que dependem do que foi realizado anteriormente. Em conseqüência, é sugirido fortemente ambientação com o anterior antes de prosseguir com os passos deste tutorial.

## 2. Objetivo ##
Enquanto o exemplo [anterior](tutorialJee.md) limitava-se a converter os caracteres para maiúsculas, a presente aplicação é ligeiramente diferente. Na anterior, quando argumento não é fornecido na caixa de texto, simplesmente a seqüência vazia era empregada. Nesta versão da aplicação, desejamos que a última seqüência não vazia seja empregada, caso esta exista. De forma resumida, se for fornecida uma seqüência não nula, então converta-a para maiúsculas. Se a seqüência for nula, não conter nenhum caractere, então fazer uso da última seqüência não nula fornecida, caso esta exista.

## 3. Arquitetura ##
Teremos uma _client tier_ onde estará em execução o browser do usuário. Teremos a _web tier_ onde páginas JSP e Servlets serão responsáveis por capturar as intenções dos usuários, disparar a execução de serviço correspondente e, no sentido inverso, capturar os resultados produzidos e formatá-los para a satisfação do usuário. Ainda teremos a _EJB tier_, responsável pelo processamento propriamente dito, neste caso, trivial.

## 4. Projeto detalhado ##
A implementação faz uso de três projetos Eclipse (ear2, ejb2 e web2). Respectivamente representam: a aplicação (formada por um EJB Project e um aplicação web), o _stateful bean_ e a aplicação web (interação com o usuário). Observe que ear2 "apenas" reúne os componentes da aplicação em um todo, o que facilita, por exemplo, a implantação correspondente.

### Aplicação web ###
A página inicial é [index.jsp](http://exemplos.googlecode.com/svn/trunk/scbcd/second/web2/WebContent/index.jsp). Esta página contém um simples formulário que compreende uma caixa de texto (**entrada**) e um botão (**EXECUTE**). Ao se pressionar o botão a ação **servico** é enviada para o servidor. Esta ação é tratada pelo Servlet de nome **StringBeanClientServlet** (veja [web.xml](http://exemplos.googlecode.com/svn/trunk/scbcd/second/web2/WebContent/WEB-INF/web.xml) para detalhes), cuja classe correspondente é [StringBeanClientServlet](http://exemplos.googlecode.com/svn/trunk/scbcd/second/web2/src/StringBeanClientServlet.java). À semelhança do exemplo anterior, esta aplicação web também contém uma página JSP para exibição dos resultados ([saida.jsp](http://exemplos.googlecode.com/svn/trunk/scbcd/second/web2/WebContent/WEB-INF/jsp/saida.jsp)). Em relação a outras aplicações web que fazem uso exclusivo de Servlets/JSPs, por exemplo, observe que o servlet [StringBeanClientServlet](http://exemplos.googlecode.com/svn/trunk/scbcd/second/web2/src/StringBeanClientServlet.java) contém a anotação **@EJB**. Este é o único elemento desta aplicação web que a distingue de outras, que não empregam EJB. Esta anotação informa que será da responsabilidade do contêiner em que o Servlet estiver em execução, injetar, no momento em que uma instância do Servlet for criada, a referência para o _bean_ correspondente. Isto é tudo o que é necessário para tornar esta aplicação web cliente de um EJB. Observe que este Servlet nem mesmo sabe se se trata de um _stateful_ ou _stateless_ EJB.

### Enterprise JavaBean ###
A criação de um EJB exige a criação de uma interface ([StringBeanLocal](http://exemplos.googlecode.com/svn/trunk/scbcd/second/ejb2/ejbModule/second/StringBeanLocal.java)) e a implementação correspondente ([StringBean](http://exemplos.googlecode.com/svn/trunk/scbcd/second/ejb2/ejbModule/second/StringBean.java)). A interface faz uso da anotação **@Local**. Isto habilita acesso ao _bean_ correspondente à objetos em execução na mesma instância da máquina virtual Java em que o contêiner é executado. Neste caso, observe que estamos empacotando tanto a aplicação web quanto o EJB em um EAR, ou seja, ambos estarão em execução no mesmo contêiner. Veremos que habilitar o acesso remoto exige apenas que **@Local** seja substituído por **@Remote**. Observe que nenhuma outra exigência é feita sobre a interface, ou seja, nenhum código adicional, nenhuma herança específica ou outra. Tem-se apenas a anotação.

À semelhança do caso anterior, a implementação do EJB também faz uso de uma única anotação, neste caso, **@Stateful**. Nenhum outro recurso é necessário, não é preciso herdar de uma classe específica, não é preciso implementar uma daterminada interface. Tudo o que é necessário é fornecido por meio desta anotação.

Veremos, posteriormente, que muitos outros recursos poderão ser explorados além do comportamento padrão fornecido pelas anotações **@Local** e **@Stateful**. Contudo, este é o mínimo necessário para criar um EJB.

### Enterprise Application Archive (EAR) ###
Um arquivo jar com extensão **ear** empacota uma aplicação composta por vários componentes EJB. Este é o mecanismo empregado para reunir, em um único arquivo, vários componentes, por exemplo, EJBs e até aplicações web que, de outra forma, teriam que ser implantados um a um. Felizmente, caixas de diálogo são suficientes para configurar um EAR quando se emprega o Eclipse.

## 5. Considerações finais ##
Exemplos posteriores irão explorar recursos alternativas e funcionalidades oferecidas pelo contêiner JEE.