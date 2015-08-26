# Conteúdo #



# Introdução #

Nesta página você encontrará uma seqüência de exemplos que empregam a JPA (Java Persistence API) voltados para o aprendizado desta significativa parte de EJB 3.

Na ordem, primeiro segue onde informações adicionais podem ser obtidas. Isto permitirá que inúmeros detalhes, aqui não fornecidos, possam ser localizados em outras fontes. Ferramentas necessárias para a execução satisfatória dos exemplos comentados são fornecidos em seguida.


## Referências sobre JPA ##

  * Java Persistence API ([home](http://java.sun.com/javaee/technologies/persistence.jsp))
  * Panda et al., _[EJB 3 In Action](http://www.amazon.com/EJB-3-Action-Debu-Panda/dp/1933988347/ref=pd_bbs_sr_1?ie=UTF8&s=books&qid=1197657357&sr=8-1)_, Manning, 2007.
  * Conjunto de portais pertinentes ([kyriosdata/jpa](http://del.icio.us/kyriosdata/jpa))

## Ferramentas necessárias ##
Não interprete as ferramentas sugeridas abaixo para emprego em produção, tampouco as desconsidere por causa desta observação. Para o autor, fornecem um conjunto útil para emprego didático.

  * SGBD ([HSQLDB](http://hsqldb.sf.net))
  * Criação de executáveis, execução de testes, ... ([Ant](http://ant.apache.org))
  * Compilador e máquina virtual Java ([JDK](http://java.sun.com/products/jdk))
  * Testes de unidade ([JUnit](http://junit.org))
  * Carga de dados em SGBD e outras operações de teste ([DBUnit](http://dbunit.sourceforge.net))
  * Injeção de dependência e testes ([Spring](http://springframework.org))
  * É necessário um _persistence provider_. Os exemplos fornecidos neste "tutorial" empregam o Hibernate:
    * Hibernate ([Hibernate](http://hibernate.org)). Serão necessários os componentes conhecidos por: Hibernate Core, Hibernate Annotations, Hibernate EntityManager e Hibernate Tools.

**Instalação e uso**: reserve tempo para a instalação e ambientação com estas ferramentas. Doravante é suposto que estejam devidamente instaladas e disponíveis para uso. Os exemplos fazem uso do arquivo Ant (**build.xml**) que deverá ser devidamente modificado para refletir os diretórios de instalação destas ferramentas.

### Outros _persistence providers_ ###
Além do Hibernate, citado acima, existem vários outros _persistence providers_ que podem ser empregados. Convém observar que, embora ambos implementem JPA, cada um deles possui um conjunto de ferramentas próprio. Tais ferramentas são úteis a desenvolvedores e podem decidir pela escolha de qual implementação empregar.
  * [EclipseLink](http://www.eclipse.org/eclipselink/)
  * [Oracle TopLink](http://www.oracle.com/technology/products/ias/toplink/jpa/index.html).

## OBSERVAÇÃO IMPORTANTE ##
Para todos os exemplos seguem a versão anotada (emprega anotações) juntamente com o documento XML que também pode ser empregado para representar o mapeamento correspondente. Para fazer com que o documento XML seja considerado, em detrimento das anotações, basta substituir o nome do arquivo empregado **mapeamento.xml** para **orm.xml**. Este último é consultado por padrão. Naturalmente, há como fornecer o nome de um documento XML que não seja **orm.xml**. Isto é feito no arquivo **persistence.xml**. Por simplicidade, a mera alteração do nome do arquivo é suficiente, sem que nenhuma outra mudança tenha que ser realizada.

# Exemplos iniciais (primeiros contatos) #
Abaixo segue uma seqüência de pequenos exemplos, comentados, que permitem, paulatinamente, agregar informações relevantes sobre a persistência de objetos em Java usando entidades EJB. A primeira seqüência de exercícios tem como propósitos:
  * ambientação com o processo necessário para persistir objetos Java usando entidades EJB (Java Persistence API)
  * ambientação com estrutura do código (arquivos a serem gerados) e ferramentas.

A sugestão é que siga cada um dos exercícios abaixo na ordem em que aparece.

  * Exemplo da classe Pessoa ([sem persistência](jpaZero.md))
  * Instância de Pessoa é persistida ([sem endereço](jpaUm.md))
  * Instância de Pessoa é persistida com endereço ([por atributos](jpaDois.md))
  * Pessoa e Endereco ([por classe embutida](jpaTres.md))
  * Pessoa  e Endereco ([associação simples 1:1](jpaQuatro.md))
  * Pessoa e várias instâncias de Endereco ([associação para lista 1:N](jpaCinco.md))
  * Classes PessoaFisica e PessoaJuridica estendem Pessoa ([herança](jpaSeis.md))

# Casos típicos #

  * Evitando persistir um atributo ([transient](jpaSete.md))
  * Forma de persistência baseada em campo ou propriedade ([forma](jpaOito.md))
  * Produto possui, possivelmente, uma referência para ProdutoInfo ([1->0..1](jpaNove.md))
  * Produto necessariamente possui referência para ProdutoInfo ([1->1](jpaDez.md))
  * Relacionamento bidirecional 1:1 ([1:1](jpaOnze.md))
  * Relacionamento 1:N (1 turma vários alunos) ([1:N](jpaDoze.md))
  * Relacionamento bidirecional 1:N (1 turma vários alunos, cada aluno "sabe" sua turma) ([1:N](jpaTreze.md))
  * Relacionamento bidirecional N:N ([N:N](jpaQuatorze.md))

# Detalhes #
  * Tabela ([tabela](jpaQuinze.md))
  * Coluna ([coluna](jpaDezesseis.md))
  * Tipos enumerados ([enum](jpaDezessete.md))
  * BLOB e CLOB ([Lob](jpaDezoito.md))
  * Informações temporais ([@Temporal](jpaDezenove.md))
  * Chaves ([@Id](jpaVinte.md))

# Relacionamentos entre entidades #
  * [1->1](http://exemplos.googlecode.com/svn/trunk/ejb3/jpa21/) (Pessoa->Endereco) (chave em Pessoa)
  * [1->1](http://exemplos.googlecode.com/svn/trunk/ejb3/jpa22/) (Pessoa->Endereco) (chave específica em Pessoa)
  * [1->1](http://exemplos.googlecode.com/svn/trunk/ejb3/jpa23/) (Pessoa->Endereco) (Pessoa e Endereco com mesma chave)

# EntityManager, consultas e DBUnit #
Cada um dos projetos abaixo contém exemplos do emprego da interface **EntityManager** e de consultas usando a _Java Persistence Query Language_. Experimente alternativas e variações para as aplicações e exemplos fornecidos.

  * [dbunit](http://exemplos.googlecode.com/svn/trunk/ejb3/dbunit/)
  * [em1](http://exemplos.googlecode.com/svn/trunk/ejb3/em1/)
  * [em2](http://exemplos.googlecode.com/svn/trunk/ejb3/em2/)
  * [em3](http://exemplos.googlecode.com/svn/trunk/ejb3/em3/) (motivação para CascadeType)

# Tarefas #
Elabore, para cada um dos itens abaixo, pelo menos dois exemplos onde: (a) um deles ilustra uma aplicação que não faz uso do recurso CASCADE; (b) o outro emprega este recurso e (c) tais exemplos sejam elucidativos quanto ao funcionamento deste recurso. Ou seja, deve ser claro, para o leitor das duas aplicações, as diferenças de funcionamento derivadas do emprego ou não de tal recurso. A tabela abaixo pode ser útil.

  * **CascadeType.MERGE**. Operações de merge são propagadas para as entidades relacionadas ao objeto em questão.
  * **CascadeType.PERSIST**. Operações persist são propagadas para as entidades relacionadas.
  * **CascadeType.REFRESH**. Operações refresh são propagadas para as entidades relacionadas.
  * **CascadeType.REMOVE**. Operações remove são propagadas para as entidades relacionadas.
  * **CascadeType.ALL**. Todas as operações são propagadas para as entidades relacionadas.