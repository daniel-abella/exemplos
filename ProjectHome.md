Este projeto oferece vasta quantidade de pequenos exemplos voltados para o aprendizado de  tecnologias pertinentes a Java. Usuários deste material incluem estudantes do curso de [Graduação em Engenharia de Software](http://engenhariadesoftware.inf.br) do Instituto de Informática da UFG. Em boa parte o conteúdo é consequência de disciplinas ministradas por Fábio Nogueira de Lucena (apoio Kyriosdata (r)).



# Como obter código e outros arquivos? #
Você precisará do Subversion (se você precisa de ajuda acerca do Subversion, clique [aqui](http://code.google.com/p/exemplos/#Subversion)). Na linha de comandos execute
```
svn co <URL> <destino>
```

onde `<URL>` deverá ser substituído pelo conteúdo que se deseja obter e `<destino>` o nome do diretório onde o conteúdo será depositado.

# Linguagem de Programação Java #
A casa de Java (e tecnologias pertinentes) é http://java.sun.com. Neste portal você encontrará um vasto conjunto de informações sobre o assunto. Entre eles, talvez você esteja interessado em um [tutorial](http://java.sun.com/docs/books/tutorial/index.html).

## Links ##
  * Java Almanac ([aqui](http://www.javaalmanac.com))
  * Java Examples ([aqui](http://www.jexamples.com))
  * Java Doc Online ([aqui](http://www.javadoconline.com))
  * Java Practices ([aqui](http://www.javapractices.com))
  * Java Source (open source Java projects) ([aqui](http://www.java-source.net))
  * Encontre Jar em que se encontra uma classe ([aqui](http://www.jarfinder.com))
  * Convenções para nomes em Java ([convenções](http://java.sun.com/blueprints/code/namingconventions.html))


# Prática elementar de Java com Orientação a Objetos #
Noções de modelagem orientada a objetos ([AQUI](http://www.inf.ufg.br/~fabio/manual-modelagem.pdf)).

Exemplos de aplicações web "ricas" (RIA) usando ICEfaces. Os exemplos não são originais e possuem como único propósito a ambientação com esta ferramenta.
  * Práticas: ([1](http://engenhariadesoftware.inf.br/docs/poo01.pdf)) ([2](http://engenhariadesoftware.inf.br/docs/poo02.pdf)) ([3](http://engenhariadesoftware.inf.br/docs/poo03.pdf)) ([4](http://engenhariadesoftware.inf.br/docs/poo04.pdf)) ([5](http://engenhariadesoftware.inf.br/docs/poo05.pdf)) ([6](http://engenhariadesoftware.inf.br/docs/poo06.pdf)) ([7](http://engenhariadesoftware.inf.br/docs/poo07.pdf)) ([8](http://engenhariadesoftware.inf.br/docs/poo08.pdf)) ([9](http://engenhariadesoftware.inf.br/docs/poo09.pdf)) ([10](http://engenhariadesoftware.inf.br/docs/poo10.pdf)) ([10-extras](http://engenhariadesoftware.inf.br/docs/poo10-extras.pdf))

# Tecnologias #


## Ant ##
Para o _checkout_ de todos os exemplos abaixo, use o URL para o subversion _http://exemplos.googlecode.com/svn/trunk/ant_

Os exercícios abaixo estão em ordem crescente de complexidade.

  * Possui dois alvos, ambos exibem apenas uma mensagem ([1.xml](http://exemplos.googlecode.com/svn/trunk/ant/1.xml))
  * Um alvo cria um diretório, o outro o remove ([2.xml](http://exemplos.googlecode.com/svn/trunk/ant/2.xml))
  * Uma propriedade é empregada para indicar o diretório a ser criado/removido ([3.xml](http://exemplos.googlecode.com/svn/trunk/ant/3.xml))
  * Fornece o diretório onde se encontra um determinado arquivo ([4.xml](http://exemplos.googlecode.com/svn/trunk/ant/4.xml))
  * Vários alvos (variantes) que falham ([5.xml](http://exemplos.googlecode.com/svn/trunk/ant/5.xml))
  * Obtém arquivo a partir de um dado URL e o armazena em arquivo específico ([6.xml](http://exemplos.googlecode.com/svn/trunk/ant/6.xml))
  * Ilustra dependências entre alvos ([7.xml](http://exemplos.googlecode.com/svn/trunk/ant/7.xml))
  * Ilustra como obter informações do usuário (linha de comandos) ([8.xml](http://exemplos.googlecode.com/svn/trunk/ant/8.xml))
  * Obtém o tamanho de um dado arquivo fornecido ([9.xml](http://exemplos.googlecode.com/svn/trunk/ant/9.xml))
  * Envia email ([10.xml](http://exemplos.googlecode.com/svn/trunk/ant/10.xml))
  * Executa comandos do Subversion ([11.xml](http://exemplos.googlecode.com/svn/trunk/ant/11.xml))
  * Compilando arquivos em Java ([12.xml](http://exemplos.googlecode.com/svn/trunk/ant/12.xml))
  * Compilando arquivos em Java e testes de unidade no JUnit ([13.xml](http://exemplos.googlecode.com/svn/trunk/ant/13.xml))
  * Executando testes de unidade no JUnit ([14.xml](http://exemplos.googlecode.com/svn/trunk/ant/14.xml))

## Cobertura ##
A criação de testes de unidade é uma prática comum atualmente. Em geral, esta prática é acompanhada do uso de uma ferramenta adicional que permita verificar _quanto_ do código testado está sendo exercitado pelos testes de unidade. A isto dá-se o nome de _cobertura_.  A ferramenta [Cobertura](http://cobertura.sourceforge.net), dentre outras, tem como propósito avaliar o quanto de código testado é exercitado por um dado conjunto de testes de unidade. Siga o [link](toolCobertura.md) para uma prática envolvendo a Cobertura.

## Eclipse ##
O ambiente integrado de desenvolvimento para Java preferido por muitos é o Eclipse (http://eclipse.org). Siga o [link](ideEclipse.md) para uma prática envolvendo o Eclipse.

## HTML & JavaScript ##
  * Exemplos
    * ([ex1](http://exemplos.googlecode.com/svn/trunk/javascript/ex1)) ([teste.html](http://especializacao.info/docs/ex1/teste.html)) ([teste-modificada.html](http://especializacao.info/docs/ex1/teste-modificada.html))
  * Links relevantes
    * [W3C](http://www.w3c.org)
    * [Validator (HTML, CSS,...)](http://validator.w3.org/)

## Java Persistence API (JPA) ##
EJB 3.0 inclui três tipos de componentes: beans de sessão (_statefull_ e _stateless_), beans orientados a mensagens (_message-driven beans_) e entidades (_entities_). Entidades são empregadas para persistência. Esta série de [exemplos](ejbPersistence.md) fornece uma elucidativa introdução a persistência de objetos Java usando a JPA.

## JavaFX ##
JavaFX é uma tecnologia para o desenvolvimento de clientes ricos. Inclui: linguagem de programação declarativa denominada JavaFX Script; vários runtimes para computadores e dispositivos e ferramentas de desenvolvimento de aplicações
JavaFX. Também está disponível uma sequência de passos e exemplos didáticos sobre [JavaFX](JavaFX.md).

## JME ##
A programação em Java para dispositivos com restrições de recursos (memória e capacidade de processamento, por exemplo), tem ganhado interesse, principalmente pela significativa quantidade de PDAs, celulares e outros que implementam Java ou, mais especificamente, JME. Neste [wiki](http://code.google.com/p/exemplos/wiki/j2meHome) você encontrará uma introdução ao assunto.
  * [Introdução](http://code.google.com/p/exemplos/wiki/j2meHome)
  * [Alguns utilitários](j2meApps.md)

## JEE ##
Siga o [link](AssuntoJee.md) para questões pertinentes a Java Enterprise Edition.

## JNDI ##
  * Identificar IP a partir de domínio usando servidor DNS por [JNDI](http://exemplos.googlecode.com/svn/trunk/jndi/dns.java)

## JUnit 4 (e testes de unidade) ##
Abaixo segue uma "trilha" para os primeiros contatos com testes de unidadem empregando o JUnit.

  * [Introdução ao JUnit 4](JUnit.md)
  * [Anotações associadas ao JUnit](JUnitAnotations.md)
  * [Organização típica de código de teste usando o JUnit](JUnitUso.md)
  * [Exceção gerada por Assert.\*](JUnitAssertion.md)

Os itens acima apresentam os principais componentes necessários ao emprego do JUnit, que é uma ferramenta. Ou seja, também precisamos saber como empregá-la (assunto dos itens abaixo).

  * [O que testar?](JUnitTestes.md)
  * [Propriedades de bons testes](JUnitBom.md)

Este é um bom momento para experimentar. Resolva os exercícios a seguir.

  * [Exercícios](JUnitExercicios.md)
  * [Exercício](JUnitExercicio.md)

Novos exercícios
  * [Notas](JUnitNotas.md)
  * Implemente a interface [CsvService](http://exemplos.googlecode.com/svn/trunk/tarefas/junit/doc/index.html) e os testes de unidade pertinentes.

## OSGi ##
  * [introdução](equinox.md)
  * [serviços](services.md)

## RIA ##
Exemplos de aplicações web "ricas" (RIA) usando ICEfaces. Os exemplos não são originais e possuem como único propósito a ambientação com esta ferramenta.

Links relevantes:
  * ICEfaces ([home page](http://www.icefaces.org))
  * ICEfaces ([tutoriais](http://www.icefaces.org/main/resources/tutorials.iface))
  * ICEfaces Componentes ([api](http://www.icefaces.org/docs/v1_7_0/javadocs/components/api/index.html))
  * ICEfaces ([taglib](http://www.icefaces.org/docs/v1_7_0/tld/index.html))
  * ICEfaces Componentes ([suite](http://www.icefaces.org/docs/v1_7_0/components/index.html))
  * ICEfaces ([api](http://www.icefaces.org/docs/v1_7_0/javadocs/icefaces/api/index.html))
  * JavaServer Faces ([api](http://java.sun.com/javaee/javaserverfaces/1.2_MR1/docs/api/index.html))

## Segurança ##
  * [Protótipo de biblioteca de segurança](http://exemplos.googlecode.com/svn/trunk/seguranca/biblioteca)
  * [HDIV](segurancaHdiv.md)
  * [Spring Security](segurancaSpringSecurity.md)

## Servlet/JSP ##
As tecnologias Servet e JSP são empregadas para estender a funcionalidade de servidores web. É por meio destas tecnologias que páginas podem ser dinamicamente geradas da perspectiva de Java. Esta [série](servletHome.md) de exemplos permite o domínio gradativo destas tecnologias.

## Swing ##
Aplicação trivial que ilustra a criação de "console gráfico" que permite o acréscimo de mensagens ([aqui](http://exemplos.googlecode.com/svn/trunk/swing/console)).

## Reorganização (_refactoring_) ##
  * [Problema](refactorProblema.md)
  * [Testes de unidade](refactorTestes.md)

## Subversion ##
  * Introdução ao Subversion ([aqui](http://code.google.com/p/exemplos/wiki/Subversion))
  * Manual do Usuário do Subversion ([aqui](http://engenhariadesoftware.inf.br/publico/subversion.pdf))
  * Ao longo do tempo software é liberado, em geral, na forma de versões, por exemplo, 1.0, 2.0 e assim por diante. Quando se está próximo da liberação de uma versão é necessário fazez ajustes como mudanças finais na documentação do usuário e outras, enquanto o restante da equipe deveria continuar trabalhando no trunk. Veja o [processo](subversionLiberacao.md).
  * Erros são encontrados pelos usuários e demandam correções. Veja o [processo](subversionErroSimples.md).
  * Alguns erros são complexos, o que exige um [processo](subversionErroComplexo.md) conhecido e empregado por toda a equipe.
  * [Exercícios](subversionExercicios.md)
