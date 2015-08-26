# Crie testes de unidade para os cenários abaixo #

## Concatenação de Strings ##
  1. Crie a classe _Formato_. Esta classe deve possuir o método `toString(List<Integer>)`, que retorna uma String obtida da concatenação dos inteiros fornecidos na lista (em ordem decrescente). Ou seja, para os inteiros 1, 2 e -5, a ordem correta deve ser 2, 1 e -5.
  1. Adicionalmente, os valores devem ser separados por ';' e sem espaços entre eles. Ou seja, a real saída desejada é "2;1;-5".
  1. A classe _Formato_ ainda possui o método `contaCaracteres(char c, String str)` que retorna a quantidade de caracteres _c_ na seqüência _str_.
  1. Implemente código correspondente aos itens anteriores e testes de unidade que verificam a implementação realizada. Observação: situações excepcionais não foram definidas, por exemplo, o comportamento dos métodos quando o argumento for null. Nestes e outros cenários semelhantes, defina os casos excepcionais, implemente-os e também forneça código que os testa.

## Operação de "ordenação" de elementos de um array ##
  1. A classe Calculo possui o método `paresPrimeiros` que recebe como argumento um array de bytes e reordena os valores contidos neste array de tal forma que todos os valores pares ocupam as primeiras posições, ou seja, se existe um valor ímpar, então este necessariamente aparece após todo e qualquer valor par fornecido no array. Nenhuma outra restrição é conhecida.
  1. O método acima, quando chamado com um valor null deve gerar a exceção `IllegalArgumentException`.
  1. O método `paresPrimeiros` é considerado "errado" (ou com implementação a ser melhorada, caso o tempo de retorno para um array de até 1000 entradas seja superior ou igual a 1 segundo.

## Propriedade 30+25 ##
O número 3025 possui uma propriedade curiosa, 3025 é a composição de 30 e 25 (3025). Adicionalmente, 30+25 = 55 e o quadrado de 55 é exatamente o valor 3025. Implemente o método _boolean propriedade3025(int)_ que recebe um inteiro como entrada e retorna o valor verdadeiro se e somente se o inteiro fornecido satisfaz tal propriedade. Observe que se um valor negativo for fornecido, então o método deve retornar falso. Se o valor for menor que 1000 ou maior que 9999, o método também deve retornar falso. Adicionalmente, crie testes de unidade para verificar a implementação.

## Propriedade dos cubos ##
O número 153 pode ser obtido como a soma dos cubos dos seus dígitos. Crie o método _cubos(String)_ que retorna verdadeiro se e somente se o número fornecido (por meio de uma String) satisfaz esta propriedade. O método não deve gerar exceção. Crie testes de unidade para verificar a implementação.

## Notas ##
Em um sistema acadêmico cada estudante recebe uma nota por disciplina. O nome de cada estudante é único, assim como o código de cada disciplina. Implemente funcionalidade que permita obter a média das notas de todas as disciplinas cursadas por um estudante, ou seja, implemente o método _media(String estudante)_ onde o argumento é o nome de um estudante. Adicionalmente, implemente a média por disciplina, ou seja, o método _media(int disciplina)_ retorna a média das notas de todos os estudantes que cursaram a disciplina cujo código é fornecido como argumento. Crie testes de unidade para verificar a implementação.