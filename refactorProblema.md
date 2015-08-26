Reorganização (Fábio Nogueira de Lucena)

# Introdução #

A presente página e outras correspondentes foram elaboradas
sobre o conteúdo do capítulo 1 do livro _Refactoring: Improving the Design of
Existing Code_, Martin Fowler, Addion-Wesley, 1999. Isto significa que os
créditos do exemplo são do livro citado e ilustram a habilidade do
correspondente autor, Martin Fowler. **Tanto os modelos quanto o
código, exceto quando dito o contrário, seguem as versões originais fornecidas no livro supracitado.** Há, contudo, várias diferenças.

Esta e demais páginas têm propósito similar ao do capítulo referenciado, ou
seja, introduzir o assunto _refactoring_ por meio de exemplos. Aqui é
empregado o termo _reorganização_ com a acepção de _refactoring_. A
alternativa ao texto aqui criada não tem o propósito de substituir a
anterior. Experiências com o ensino, contudo, revelam que algumas explanações
adicionais, aqui fornecidas, são relevantes para o entendimento, o que motiva
este texto e o torna único.

# O problema ([v0](http://exemplos.googlecode.com/svn/tags/refactoring-v0/)) #

Software para calcular a "situação" de um cliente de uma vídeo locadora. Por
situação entenda quanto deve ser pago pelo cliente da vídeo locadora para um
conjunto de vídeos alugados, cada um deles por determinado período. O cálculo
também leva em consideração o tipo do vídeo e determina a quantidade de pontos
que o cliente recebe, o que depende do filme ser uma novidade ou não.

Abaixo segue o diagrama que ilustra este modelo.

![http://exemplos.googlecode.com/svn/tags/refactoring-v0/images/v0.png](http://exemplos.googlecode.com/svn/tags/refactoring-v0/images/v0.png)

A implementação inicial de cada uma destas classes também se encontra disponível: [Movie.java](http://exemplos.googlecode.com/svn/tags/refactoring-v0/src/Movie.java), [Customer.java](http://exemplos.googlecode.com/svn/tags/refactoring-v0/src/Customer.java) e [Rental.java](http://exemplos.googlecode.com/svn/tags/refactoring-v0/src/Rental.java).

Conforme Martin Fowler descreve, o código fornecido por estas classes certamente não é orientado a objeto e, convém ressaltar, não há nenhum problema com ele dado que se trata de um _software_ de aplicação muito restrita. Contudo, se esta é uma parte representativa de um sistema, então existem problemas reais com este código.

Uma dificuldade com este código fica clara com o contexto onde os clientes desejam, por exemplo, que a situação de um cliente também seja fornecida em HTML (**mudança 1**). Percebe-se que, conforme está, haverá significativa duplicação de código para simplesmente transformar a sentença corrente em uma versão HTML correspondente. Neste caso, observe que, quando uma mudança ocorrer na estratégia de comercialização, teremos que efetuar mudanças correspondentes em mais de um único local.

Uma outra mudança (**mudança 2**) é alterar a forma de classificação dos filmes. Clientes ainda não possuem claramente o que deverá ser alterado, mas já se sabe que teremos alteração na forma em que os filmes serão classificados.

Estas duas mudanças irão repercutir no método `statement()`. Antes das mudanças, contudo, é preciso dispor de testes de unidade, para assegurar que mudanças não introduziram erros.

A página de [testes](refactorTestes.md) introduz os testes de unidade.

# Primeira mudança ([v1](http://exemplos.googlecode.com/svn/tags/refactoring-v1/)) #
O método `statement()` é muito longo, conseqüência das várias atividades que desempenha. Dividi-lo, portanto, não é um começo ruim. Não é difícil perceber que o `switch` é um candidato forte e será este o principal corpo do método a ser criado `amountFor()`. Veja o resultado desta alteração em [Customer.java](http://exemplos.googlecode.com/svn/tags/refactoring-v1/src/Customer.java).

Após a alteração a primeira orientação é para a execução dos testes de unidade que, neste caso, ressaltam uma falha. A falha pode ser identificada sem muita dificuldade. O método `amountFor()` define a variável `thisAmount` com o tipo `int`, enquanto o correto é o tipo `double`. Ao fazer esta alteração temos código que, após a modificação, passa nos testes criados. Veja a versão resultante da classe `Customer` após as mudanças em [Customer.java](http://exemplos.googlecode.com/svn/tags/refactoring-v2/src/Customer.java).

# Segunda mudança ([v2](http://exemplos.googlecode.com/svn/tags/refactoring-v2/)) #
Alguns identificadores empregados no método `amountFor()` podem ser mais claros. Por exemplo, `each` é menos preciso que `aRental`, assim como `thisAmount` não é tão esclarecedor quanto `result`. Estas alterações conduzem à nova versão disponível em [Customer.java](http://exemplos.googlecode.com/svn/tags/refactoring-v3/src/Customer.java).

Conforme Martin Fowler ressalta na página 15, "Qualquer tolo pode escrever código que um computador pode compreender. Bons programadores escrevem código que seres humanos podem compreender".


# Terceira mudança ([v3](http://exemplos.googlecode.com/svn/tags/refactoring-v3/)) #
Quando se observa o método `amountFor()` em [Customer.java](http://exemplos.googlecode.com/svn/tags/refactoring-v3/src/Customer.java), nota-se que nenhuma informação pertinente a cliente é empregada por este método. Esta é uma sugestão de que talvez o método esteja em classe errada. Todas as informações empregadas por este método encontram-se na classe `Rental` e, portanto, é para lá que este método será movido.

Para mover este método, primeiro faça a cópia do mesmo para o local de destino. Aproveite para renomeá-lo para `getCharge()`. Conforme ilustrado, o argumento também foi removido. Após estas alterações, verifique se o novo método criado funciona. Ou seja, substitua o corpo do método `amountFor(Rental aRental)` por `return aRental.getCharge()`. Em seguida, teste para certificar-se de que nenhum engano foi cometido nestas mudanças.

Se os testes foram executados satisfatoriamente, então é o momento de substituir todas as referências à `amountFor()` por aquelas correspondentes ao novo método `getCharge()`. Após esta mudança, o modelo correspondente é fornecido abaixo.

![http://exemplos.googlecode.com/svn/tags/refactoring-v4/images/v4.png](http://exemplos.googlecode.com/svn/tags/refactoring-v4/images/v4.png)

Novamente os testes deverão ser executados. Caso os testes sejam executados satisfatoriamente, o método `amountFor()` poderá ser removido. Caso seja um método empregado por outros componentes, talvez ela deve permanecer como _deprecated_, mesmo com o corpo que é uma mera delegação para o novo método criado. Em Java, pode-se informar que há uma alternativa melhor para um método, ou que um determinado método não mais deverá ser empregado por meio da anotação **@Deprecated**.

Após esta mudança ficará fácil perceber que a variável `thisAmount` é iniciada e só depois o valor nela depositado é obtido de `getCharge()`. Naturalmente, estas duas operações podem ser feitas em uma única linha sem prejuízo de legibilidade. Portanto, a variável pode ser definida e iniciada em uma única linha com o valor obtido de `getCharge()`.

Após a mudança acima, uma possível mudança é remover a variável local `thisAmount`. Ela é empregada em apenas dois únicos pontos do método. Estes pontos podem ser substituídos pela chamada à `getCharge()`. Com esta mudança, a variável `thisAmount` não mais será útil e pode ser removida. Naturalmente há um preço que, neste caso, é a execução duplicada deste método. Variáveis locais, por outro lado, tendem a obscurecer o código. Por fim, desempenho não é a questão observada no momento.

Após tais mudanças as versões finais de cada uma das classes é [Customer.java](http://exemplos.googlecode.com/svn/tags/refactoring-v4/src/Customer.java) e [Rental.java](http://exemplos.googlecode.com/svn/tags/refactoring-v4/src/Rental.java).

# Quarta mudança ([v4](http://exemplos.googlecode.com/svn/tags/refactoring-v4/)) #
Ao se observar o método `statement()`, nota-se que a obtenção do total de pontos por aluguéis freqüentes (_frequent renter points_) também é trecho de código que diz respeito à classe `Rental`. Em conseqüência, método correspondente a tal trecho de código, `getFrequentRenterPoints`, deve ser criado na classe `Rental`. Para estes passos, a sugestão é criar inicialmente este método na classe `Customer` e posteriormente transferi-lo para a classe `Rental`. Após a criação do método, lembre-se de executar os testes. Após copiar o método criado para a classe `Rental`, altere o método da classe `Customer` de tal forma que o corpo deste simplesmente delegue a requisição para o método copiado para a classe `Rental`. Novamente execute os testes. O resultado final encontra-se em: [Customer.java](http://exemplos.googlecode.com/svn/tags/refactoring-v5/src/Customer.java) e [Rental.java](http://exemplos.googlecode.com/svn/tags/refactoring-v5/src/Rental.java).

# Quinta mudança ([v5](http://exemplos.googlecode.com/svn/tags/refactoring-v5/)) #
Variáveis temporárias estimulam a criação de métodos longos. Se seguirmos esta observação veremos que o método `statement()` possui duas variáveis locais, `totalAmount` e `frequentRentalPoints` que podem ser eliminadas conforme feito anteriormente. Ou seja, o objetivo é obter cada um destes valores por método próprio. Ainda convém ressaltar que isto será útil tanto para a sentença fornecida em texto simples quanto a versão obtida em HTML. Para a variável `totalAmount` crie o método `getTotalCharge()` e para a variável `frequentRentalPoints` crie o método `getTotalFrequentRenterPoints()`.

Tais mudanças, quando aplicadas, resultam na nova versão em [Customer.java](http://exemplos.googlecode.com/svn/tags/refactoring-v6/src/Customer.java).

# Sexta mudança ([v6](http://exemplos.googlecode.com/svn/tags/refactoring-v6/)) #
Esta alteração trata-se de acrescentar o método `htmlStatement()`, ou seja, a versão que produz saída em HTML correspondente ao método `statement()`. Ao se acrescentar este método, testes correspondentes também devem ser acrescentados. As classes alteradas são [Customer.java](http://exemplos.googlecode.com/svn/tags/refactoring-v7/src/Customer.java) e [CustomerTest.java](http://exemplos.googlecode.com/svn/tags/refactoring-v7/teste/CustomerTest.java).

# Sétima mudança ([v7](http://exemplos.googlecode.com/svn/tags/refactoring-v7/)) #
Não é uma boa idéia fazer um `switch` baseado em dados de outro objeto. Este é exatamente o cenário na classe `Rental`. O método em questão, `getCharge()`, portanto, deve ser transferido para a classe `Movie`. Uma situação análoga ocorre com o método `getFrequentRenterPoints()` que, portanto, também deve ser transferido para a classe `Movie`. Pode-se argumentar que, na nova versão sugerida, métodos da classe `Movie` precisam de informação da classe `Rental`, enquanto no caso anterior, a dependência era em outro sentido, de `Rental` para `Movie`, ou seja, qual a diferença? Neste caso, mudanças no tipo em um filme, situação que provavelmente irá ocorrer, não causará um efeito colateral em outra classe, mas ficarão contidas na classe `Movie`. Observe que, no caso anterior, teríamos que alterar duas classes.

As novas versões: [Rental.java](http://exemplos.googlecode.com/svn/tags/refactoring-v8/src/Rental.java) e [Movie.java](http://exemplos.googlecode.com/svn/tags/refactoring-v8/src/Movie.java).

# Oitava mudança ([v8](http://exemplos.googlecode.com/svn/tags/refactoring-v8/)) #
Esta é a mudança mais significativa quando comparada com aquelas acima. Apresentada de forma simples, trata-se de substituir o `switch` pelo uso de polimorfismo. O processo desta mudança e os benefícios decorrentes, contudo, não são tão simples quanto a definição. Para ilustrar esta mudança segue o diagrama abaixo.


![http://exemplos.googlecode.com/svn/tags/refactoring-v9/images/v9.png](http://exemplos.googlecode.com/svn/tags/refactoring-v9/images/v9.png)

Observe que `Movie` passa a ter uma referência `price` para um objeto que implementa a classe abstrata `Price`. O objetivo é fazer com que esta referência esteja indicando um objeto do tipo `RegularPrice`, `ChildrensPrice` ou `NewReleasePrice`, conforme o tipo do filme em questão. Desta forma, cada uma destas subclasses concretas implementa a política de custo correspondente ao tipo em questão. Dado que cada filme é de apenas um tipo, definido pelo objeto referenciado por `price`, é suficiente que cada subclasse implemente adequadamente a política de custo para o tipo em questão. Isto tornará desnecessária a sentença `switch`. Conforme anteriormente alertada, este não é um processo tão simples de ser compreendido e, portanto, será feito em vários passos.

## Primeiro passo ##
Procurar por todos os acessos ao tipo de um filme e assegurar que os métodos get/set são empregados para esta finalidade. A única mudança decorrente é no construtor de `Movie`, que antes fazia acesso direto à variável `_priceCode` e agora passa a fazer uso de `setPriceCode(int priceCode)`.

## Segundo passo ##
Adicionar as classes incluídas no modelo da figura acima. Ou seja, as classes `Price`, `NewReleasePrice`, `RegularPrice` e `ChildrensPrice`.

## Terceiro passo ##
Fazer com que a classe `Movie` agora faça uso dos métodos get/set para o atributo `_priceCode` compatíveis com a referência para um objeto que implementa `Price`.

## Quarto passo ##
O método `getCharge()` da classe `Movie` agora pode ir para a classe `Price`.
O resultado pode ser notado na classe `Movie`, que agora não possui mais código correspondente à estratégia de preço conforme o tipo do filme.

## Quinto passo ##
A transferência do método `getCharge()` para `Price` não faz desaparecer a sentença `switch`. Para tal, primeiro será necessário criar o método `getCharge(int daysRented)` em cada classe concreta que implementa `Price`. A implementação deste método será, naturalmente, correspondente ao tipo de filme em questão. Em verdade, trata-se de copiar o trecho de código de cada `case` para a classe correspondente no método citado acima.

O resultado é que cada implementação de `Price` agora possui o método `getCharge(int daysRented)` que implementa a política de preço para o tipo em questão.

## Quinto passo ##
Finalmente, após o passo anterior, podemos remover o `switch` que nos incomodava inicialmente. Em verdade, substitua o método `getCharge(int daysRented)` por uma declaração abstrata deste método. Dessa forma, toda vez que uma referência para `Price` receber a mensagem `getCharge(int daysRented)` esta será executada pelo método correspondente ao tipo em questão.

O resultado final da oitava mudança, após a execução dos passos acima, encontra-se em:
[Rental.java](http://exemplos.googlecode.com/svn/tags/refactoring-v9/src/Rental.java), [Movie.java](http://exemplos.googlecode.com/svn/tags/refactoring-v9/src/Movie.java),
[Price.java](http://exemplos.googlecode.com/svn/tags/refactoring-v9/src/Price.java),
[NewReleasePrice.java](http://exemplos.googlecode.com/svn/tags/refactoring-v9/src/NewReleasePrice.java),
[ChildrensPrice.java](http://exemplos.googlecode.com/svn/tags/refactoring-v9/src/ChildrensPrice.java) e
[Price.java](http://exemplos.googlecode.com/svn/tags/refactoring-v9/src/RegularPrice.java). Observe que a classe `Customer` não foi alterada em todo este conjunto de passos ([Customer.java](http://exemplos.googlecode.com/svn/tags/refactoring-v9/src/Customer.java)), assim como também não foram alterados os testes ([CustomerTest.java](http://exemplos.googlecode.com/svn/tags/refactoring-v9/src/CustomerTest.java))

# Nona mudança ([v9](http://exemplos.googlecode.com/svn/tags/refactoring-v9/)) #
Esta mudança é análoga à anterior, exceto que agora o alvo é o método `getFrequentRenterPoints()`. O modelo final é exibido no diagrama abaixo.

![http://exemplos.googlecode.com/svn/tags/refactoring-v10/images/v10.png](http://exemplos.googlecode.com/svn/tags/refactoring-v10/images/v10.png)

O código final, após esta mudança, que deve seguir passos análogos àqueles da oitava mudança, fornecida acima, é formado por:
[Rental.java](http://exemplos.googlecode.com/svn/tags/refactoring-v10/src/Rental.java), [Movie.java](http://exemplos.googlecode.com/svn/tags/refactoring-v10/src/Movie.java),
[Price.java](http://exemplos.googlecode.com/svn/tags/refactoring-v10/src/Price.java),
[NewReleasePrice.java](http://exemplos.googlecode.com/svn/tags/refactoring-v10/src/NewReleasePrice.java),
[ChildrensPrice.java](http://exemplos.googlecode.com/svn/tags/refactoring-v10/src/ChildrensPrice.java) e
[Price.java](http://exemplos.googlecode.com/svn/tags/refactoring-v10/src/RegularPrice.java). Observe que a classe `Customer` não foi alterada em todo este conjunto de passos ([Customer.java](http://exemplos.googlecode.com/svn/tags/refactoring-v10/src/Customer.java)), assim como também não foram alterados os testes ([CustomerTest.java](http://exemplos.googlecode.com/svn/tags/refactoring-v10/src/CustomerTest.java))

# Décima e última mudança ([v10](http://exemplos.googlecode.com/svn/tags/refactoring-v10/)) #
Os métodos não empregados foram eliminados. A coleção que fazia uso de _Vector_ passou a empregar _generics_, recurso da versão 5.0 de Java por meio da interface `List`. Isto, combinado ao uso do recurso _for_ estendido trouxe um resultado mais simples e menor em termos de código. Todas estas mudanças ocorreram na classe `Customer` ([Customer.java](http://exemplos.googlecode.com/svn/tags/refactoring-v11/src/Customer.java)).

# Considerações finais #
As mudanças efetuadas acima e o código correspondente, bem como a idéia e seqüência apresentados são de autoria de Martin Fowler, no livro _Refactoring: Improving the Design of Existing Code_, Addison-Wesley, 1999. Convém deixar claro e atribuir os méritos devidos ao autor e à referência citados. Apenas a décima e última mudança não se encontram na referência citada. Por outro lado, é possível que diferenças sejam encontradas em relação ao texto original. Cabe ao leitor a observância desta fonte com aquela e verificar as possíveis repercussões destas diferenças.

Todas as mudanças apresentadas têm o propósito de introduzir a noção de _refactoring_ e fornecer uma visão geral do que se trata este assunto. No livro supracitado são fornecidos dezenas de padrões de _refactoring_, ou seja, abordagens que já se mostraram satisfatórias para problemas recorrentes. São ferramentas de grande utilidade para desenvolvedores de software. A consulta a esta seminal referência é aconselhada para detalhes.

