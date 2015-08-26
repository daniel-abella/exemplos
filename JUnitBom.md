# Introdução #

Em _Pragmatic Unit Testing: In Java with JUnit_, editora The Pragmatic Programmers, 2003, Andrew Hunt e David Thomas estabelecem cinco propriedades desejáveis em testes de unidade:

  * Automáticos
  * Abrangentes
  * Repetíveis
  * Independentes
  * Profissionais

## Testes devem ser automáticos ##
Ou seja, não devem exigir a presença de um ser humano para executá-los e nem para verificar os resultados.

## Testes devem ser abrangentes ##
Ou seja, se existe uma possibilidade do código produzir um resultado inadequado, então este cenário deveria ser coberto pelos testes.

## Testes devem ser repetíveis ##
Ou seja, um teste deve ser executado quantas vezes forem necessárias e o resultado em cada uma das execuções deve ser o mesmo.

## Testes devem ser independentes ##
Ou seja, a execução de um teste não pode depender da execução prévia de um outro teste, nem da ordem em que testes foram executados, nem de resultados parciais produzidos ou complementados por outros testes, nem supor que, em seguida, um outro teste será executado.

## Testes devem ser profissionais ##
Ou seja, código de teste deve ser escrito com a mesma qualidade do código que está sendo testado. Noutras palavras, boas práticas de projeto do código também devem ser seguidas para a confecção do código de testes.

# Considerações finais #
Não é suficiente escrever testes de unidade. Se eles não forem adequadamente produzidos, então isto se tornará um estímulo ao seu não emprego, principalmente devido aos custos associados. Embora muitas vezes não é explicitamente dito, quando se fala em teste, automaticamente pense _testes automáticos, abrangentes, repetíveis, independentes e profissionais_.