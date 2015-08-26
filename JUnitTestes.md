# Introdução #
A experiência em programação facilitará, com o tempo, a identificação do que deve ser testado. O livro _Pragmatic Unit Testing: In Java with JUnit_, Andrew Hunt e David Thomas, da editora The Pragmatic Programmers, 2003, inclui uma valiosa orientação neste sentido.
O que segue nesta página é o que este livro sugere, onde detalhes podem ser obtidos.

# O que deve ser testado? #
O livro _Pragmatic Unit Testing: In Java with JUnit_, Andrew Hunt e David Thomas, da editora The Pragmatic Programmers, 2003, estabelece a seguinte estratégia para facilitar a identificação do que deverá ser testado. Conforme apresentado abaixo, isto é fornecido por meio de perguntas:

  * Os resultados estão corretos?
  * As condições de fronteira estão corretas?
  * O inverso pode ser verificado?
  * Resultados podem ser verificados por mais de um método?
  * Situações de erro podem ser provocadas?
  * As características de execução estão dentro dos limites?

Abaixo, cada uma destas perguntas é apresentada por meio de um exemplo. Se você ainda não possui ampla prática com testes de unidade, estas perguntas podem ser úteis e funcionar como uma lista de verificação, com o propósito de assegurar que o que é relevante foi testado.

## Os resultados estão corretos? ##
Naturalmente, o que mais se espera é que o resultado esperado de um processamento forneça o que foi especificado para ser produzido. Por exemplo, se a média em uma disciplina significa um valor entre zero e dez com duas casas decimais, resultante do cálculo da média aritmética simples, então as notas 2 e 8 devem produzir a nota 5.

## As condições de fronteira estão corretas? ##
No caso do cálculo da média em uma disciplina, qual a média para uma nota negativa? Ou melhor, o que é esperado caso um valor negativo seja fornecido? As condições de fronteira incluem: (a) as duas casas decimais estão sendo fornecidas corretamente? (b) os valores estão ordenados ou não ordenados como esperado? (c) os resultados estão dentro dos valores mínimo e máximo? (d) há referência para elemento externo que não está sob controle direto do código testado? (e) o valor esperado existe e está disponível, por exemplo, está presente em uma lista, não é nulo? (f) há valores suficientes conforme esperado, ou seja, a cardinalidade está correta? (g) as ações estão ocorrendo na ordem correta? No momento correto? No instante esperado?

## O inverso pode ser verificado? ##
Ao se calcular a média aritmética de uma disciplina e de posse de uma das notas, pode-se obter a outra nota e, dessa forma, verificar o cálculo da média. Ao se calcular a raiz quadrada pode-se verificar o resultado multiplicando-o por ele próprio. Se uma operação deve acrescentar um elemento em determinada lista e em determinada posição, então pode-se, após a operação, verificar se um novo elemento foi acrescentado na posição apropriada.

## Resultados podem ser verificados por mais de um método? ##
Uma operação que visa produzir a raiz quadrada de um número pode ser testada conforme sugerido no exemplo acima ou, opcionalmente, entre outras, comparando-se este resultado com aquele produzido por **Math.sqrt()**.

## Situações de erro podem ser provocadas? ##
Alguns contextos onde código deve ser testado são elaborados para serem produzidos. Tais contextos incluem situações como: falta de memória, falta de espaço em disco, questões com tempo (relógio da máquina), disponibilidade de conexão com rede, carga do sistema e outras. Em geral, tais contextos são criados por meio de mock objects. Veja jMock (http://jmock.org) para detalhes.

## As características de desempenho estão dentro dos limites? ##
O desempenho do código sofre grandes variações com o tamanho da entrada fornecida? Se alguma mudança no código pode tornar a execução "muito" lenta da perspectiva dos usuários, não seria conveniente escrever teste que permita verificar se os limites de desempenho estão sendo satisfeitos?

# Considerações finais #
Quando se decide pela importância de testes de unidade e esforço é alocado para que sejam construídos, surge a questão: o que deve ser testado? O texto acima baseou-se nas orientações fornecidas no livro _Pragmatic Unit Testing: In Java with JUnit_, Andrew Hunt e David Thomas, da editora The Pragmatic Programmers, 2003. As orientações orientam o desenvolvedor a escrever testes de unidade que responda cada uma das questões apresentadas de forma satisfatória. Exemplos foram fornecidos para ilustrar cada uma das orientações fornecidas no livro.