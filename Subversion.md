# Introdução #

Subversion é um sistema robusto de controle de versões open source conhecido como o sucessor do famoso CVS.

Podendo ser trabalhado em diferentes cenários, o SVN (Subversion) tem dentre suas funções básicas:
  * Gerenciamento de arquivos e diretórios ao longo do tempo, por um grupo de usuários definido;
  * Acompanhamento de alterações (número da alteração, quem a fez, quando a fez) ;
  * Gerenciamento de conflitos de versões, com uso da ferramenta DIff.

# Passos iniciais (Checkout de Projeto do assembla) #

Antes de fazer checkout, tenha certeza que sua máquina tem o [subversion instalado](SubversionInstall.md).

Para manipular os arquivos de um repositório, é necessária a url do servidor, nome de usuário (login) e senha.

Com nome de usuário e senha já cadastrados no site (ex: Assembla), siga os passos abaixo:

  1. Entre no portal [Assembla](http://code.google.com/);
  1. Selecione a opção "Login" e entre com seu usuário e senha;
  1. Ao fazer login com sucesso, será aberta sua página inicial;
  1. Na região "My Spaces", clique no projeto a ser baixado (ex: Kraho);
  1. Com a página do projeto aberta, selecione a tab (aba) "Trac/SVN";
  1. Copie o endereço indicado como "SVN Url";

Guarde tal endereço, pois será através dele que seu cliente SVN encontrará o servidor.

# Criação de cópia de trabalho #
Com o endereço do servidor SVN em mãos, use o comando abaixo para fazer download dos arquivos do repositório. Em inglês, o termo é _checkout_.

`svn co <url> <pastaAlvo>`

  * 

&lt;url&gt;

 = endereço do servidor SVN;
  * 

&lt;pastaAlvo&gt;

 = nome da pasta onde a versão será descarregada.

Ex: svn co http://svn.assembla.com/svn/abc copia

Obs: Caso seja necessário, entre com nome de usuário e senha.

A versão descarregada será a última ("_head revision_"). Caso queira descarregar uma revisão específica, use o parâmetro `-r`, seguido do número da versão requerida.

`svn co -r <numRevisao> <url> <pastaAlvo>`

  * 

&lt;url&gt;

 = endereço do servidor SVN;
  * 

&lt;pastaAlvo&gt;

 = nome da pasta onde a versão será descarregada;
  * 

&lt;numRevisao&gt;

 = número da revisão.

Ex: svn co -r 34 http://svn.assembla.com/svn/abc copia

Em programas que usam interface gráfica, coloque a url do servidor, escolha o local de gravação dos arquivos localmente, marque a revisão que necessita ("_head revision_" para a última) e confirme.


# Alterando o repositório #
Com sua cópia local dos arquivos modificada, o usuário pode abrir uma shell na pasta da cópia local e efetuar tais mudanças pelo comando abaixo. O termo em inglês é _commit_.

`svn ci -m "<mensagem>"`

  * 

&lt;mensagem&gt;

 = Campo opcional para descrição das mudanças ocorridas.

Ex: svn ci -m "Correção do erro na tela de login"

As mudanças ocorridas nos arquivos existentes serão enviadas para o repositório de dados, que será atualizado.

Em ferramentas gráficas, basta escolher a pasta e selecionar a opção _commit_.

Antes de cada _commit_, é recomendado fazer uma atualização da revisão atual, pois a mesma pode não estar sincronizada com o número de revisão do repositório. Ex: Enquanto você mudava sua cópia local, outras pessoas atualizaram o repositório.

# Adicionando um arquivo ou pasta ao repositório subversion #
Caso queira inserir uma pasta ou arquivo,colocado na cópia de trabalho, ao repositório subversion, use o comando abaixo. O termo em inglês é _add_.

`svn add <nome>`

  * 

&lt;nome&gt;

 = Nome do arquivo ou pasta a ser inserido.

Ex: svn add Teste.java

# Atualizando a cópia de trabalho #
Caso o usuário pense que há novas mudanças no repositório e queira atualizar sua cópia de trabalho, o mesmo deve efetuar na shell, dentro da pasta do projeto, o comando abaixo. O termo em inglês é _commit_.

`svn up`

A ação irá atualizar o número da revisão e todos os arquivos modificados em relação ao repositório.

Em ferramentas gráficas, basta escolher a opção _update_.

# Mais opções #

Caso queira aprofundar mais ou resolver algum problema relativo ao subversion, pesquise no
[Manual do Subversion](http://svnbook.red-bean.com/en/1.4/svn-book.html).