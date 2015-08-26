#Exceção gerada por Assert.**(Fábio Nogueira de Lucena)**

# Introdução #

A classe `org.junit.Assert` possui vários métodos estáticos, boa parte deles na forma `assert*`, por exemplo `assertTrue` e `assertEquals`. Há ainda dois métodos `fail`. Ambos forçam uma falha, indicando que o código em questão não deveria ser executado. Um dos métodos `fail(String)` exibe a mensagem fornecida como argumento.

# O que há de especial nestes métodos? #

Os métodos de `org.junit.Assert` podem gerar um _erro_. Noutras palavras, geram um objeto da classe `java.lang.Error`, ou mais especificamente, uma instância de `java.lang.AssertionError`. Dado que se trata de um erro, não se espera que as exceções causadas por estes métodos sejam tratadas. Ao contrário de _erros_, exceções do tipo `java.lang.Exception` são tratadas.

Em conseqüência do exposto acima, testes de unidade escritos empregando o JUnit não terão dificuldades para verificar a ocorrência ou não de exceções, pois o que código em geral trata são objetos do tipo `java.lang.Exception`. Ou seja, será possível continuar verificando a ocorrência de exceções deste tipo. As exceções não tratadas são aquelas do tipo `java.lang.Error`, dentre eleas, `java.lang.AssertionError`, que é a exceção gerada pelo JUnit quando um método `assert*` falha. Dado que `java.lang.AssertionError` está em uma hierarquia distinta de `java.lang.Exception`, não haverá nenhum problema na detecção de exceções geradas pelo JUnit e naquelas geradas pelo código testado, se a convenção de não tratar _erros_ for seguida.

O trecho de código abaixo ilustra o exposto:
```
try {
    "".charAt(0);
    fail("Não gerou exceção conforme especificação");
} catch (IndexOutOfBoundsException ioobe) {
    assertTrue(true);
} catch (Exception exp) {
    fail("Não deveria ter gerado exceção diferente de IndexOutOfBoundsException");
}
```

O código acima verifica que o método `java.lang.String.charAt()` se comporta como especificado. A primeira sentença do bloco `try` deve gerar uma exceção. Caso não seja gerada, a sentença seguinte é executada, o que resulta em uma falha (_erro_). Observe que a exceção gerada `java.lang.AssertionError` não é tratada por este código, como é de se esperar por qualquer código em Java, ou seja, não tratar exceções do tipo `java.lang.Error`, conforme comentado acima. Se a exceção for gerada, conforme a especificação, então o `assertTrue(true)` apenas marca que a execução se deu normalmente. Por outro lado, se for gerada alguma outra exceção, `java.lang.Exception`, então temos uma não conformidade em relação à especificação e, portanto, uma falha deve ocorrer, conforme o trecho de código acima.

# Testando geração de exceções à partir do JUnit 4 #

Nas versões do JUnit posteriores à 4.0 (incluindo a mesma), pode-se verificar o lançamento de exceções de forma mais enxuta usando o argumento **expected**. Veja o código abaixo:

```
@Test (expected=IndexOutOfBoundsException.class)
public void elementAt() {
  int[] intArray = new int[10];
  
  int i = intArray[11]; // Should throw IndexOutOfBoundsException
}
```

Como se pode ver acima, o argumento _expected_, da anotação @Test, indica qual é exatamente a classe de exceção esperada.Se a exceção for gerada, conforme a especificação, não será reportada nenhuma falha e o teste "passará". Se não for gerada nenhuma exceção ou  alguma outra não especificada, então temos uma não conformidade em relação ao esperado e, portanto, uma falha deve ocorrer.

É importante destacar que o valor para esse argumento deve ser uma classe que estenda [Throwable](http://java.sun.com/javase/6/docs/api/java/lang/Throwable.html).

# Conclusão #
Exceções podem ser "normais", ou seja, aquelas do tipo `java.lang.Exception` ou _erros_, aquelas do tipo `java.lang.Error`. Estas últimas não são tratadas. Não se escreve código, em geral, que as captura (embora ninguém irá impedi-lo). Esta convenção é empregada pelo JUnit, que gera exceções do tipo `java.lang.Error`, especificamente, `java.lang.AssertionError`. Em conseqüência, dado que código testado não deveria estar capturando tais exceções, nem mesmo o próprio código do teste de unidade, elas não irão se misturar com as demais exceções, aquelas que devem ser tratadas e são do tipo `java.lang.Exception`.