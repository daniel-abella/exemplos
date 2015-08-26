# Um problema simples #
Você recebe uma atribuição, usuários desejam uma _declaração de inscrição em curso_. Sem mais considerações, apenas para manter o foco no Eclipse. Você define o modelo abaixo.

![http://exemplos.googlecode.com/svn/trunk/eclipse/tipico/docs/images/modelo.png](http://exemplos.googlecode.com/svn/trunk/eclipse/tipico/docs/images/modelo.png)

Voltando ao requisito do usuário, a impressão de uma declaração de inscrição em um dado curso exige que se conheça os cursos nos quais um dado aluno encontra-se inscrito. A operação **cursosEmAndamento** é definida para retornar todos os cursos nos quais um dado aluno encontra-se inscrito. Afinal, para qualquer um destes uma declaração poderá ser emitida. Esta não é, naturalmente, a única forma de interpretar e resolver este problema. Na ausência de um contexto mais detalhado, trata-se de uma alternativa possível.

# Implementação usando o Eclipse #

  1. Execute o Eclipse. Isto é tão simples quando executar o arquivo **eclipse.exe** (Windows) ou apenas **eclipse** (Linux).
  1. Abrir a perspectiva Java, caso não seja esta aquela já aberta. No canto superior direito ou por meio do menu Window->Open perspective, esta operação poderá ser realizada.
  1. Crie um novo projeto (projeto Java).
  1. Crie os diretórios **src** e **test** para guardar os fontes e os testes correspondentes.
  1. Crie o pacote **escola** tanto em **src** quanto em **test**
  1. Crie a classe de teste **InscricaoTeste**. Testes de unidade nesta classe deverão assegurar que, dado uma instância de Aluno, todos os nomes de cursos nos quais este aluno está inscrito são obtidos.
  1. Você provavelmente terá que acrescentar a biblioteca do JUnit para a criação desta classe. Para isto, selecione o projeto na visão **Package Explorer** (lado esquerdo da janela do Eclipse). Clique o botão direito do mouse e selecione a última opção do menu, ou seja, a opção **Properties**. Na caixa de diálogo que irá se abrir selecione **Java Build Path** e, em seguida, a aba **Libraries**. No lado direito há uma seqüência de botões, clique no botão **Add Library...**. Uma das opções disponíveis na caixa de diálogo que se abre é **JUnit**. Selecione-a e clique em **Next**. Em seguida selecione a versão do JUnit a ser empregada. Sugiro **JUnit 4**. Finalmente clique em **Finish** e depois em **OK**.
  1. No pacote **escola** em **test** crie e implemente as classes Aluno, Curso e Inscricao, conforme o modelo acima.
  1. Execute os testes de unidade e verifique que a implementação realizada passa nos testes. Selecione a classe de teste em **Package Explorer** e, clique o botão direito do mouse sobre a classe de teste. Então selecione a opção **Run As** e, finalmente, **JUnit Test**.

Você poderá fazer obter a implementação resultante dos passos acima do repositório Subversion com o comando
```
svn co http://exemplos.googlecode.com/svn/trunk/eclipse/tipico/ tipico
```

Este repositório também inclui o projeto Eclipse correspondente. Ou seja, você poderá "importar" o projeto que será depositado no diretório criado (**tipico**).

# Tarefas a serem realizadas #
  1. Crie o método **inscritoEm(String curso)** onde é fornecido o nome de um curso e o valor _true_ é retornado se e somente se o aluno em questão está inscrito no curso. Observe que deve estar vigente a inscrição, ou seja, um curso que já terminou deverá retornar _false_.
  1. Crie código que testa o método criado acima.
  1. O Eclipse está organizado em várias visões. Uma delas é **Tasks**. Para abri-la, selecione no menu **Window**, a opção **Show View** e, em seguida, a opção **Tasks**. Observe que, para o projeto fornecido pela URL indicada acima, há uma tarefa para ser realizada. Execute-a conforme as instruções.