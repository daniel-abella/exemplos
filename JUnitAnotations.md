# Introdução #

Testes de unidade escritos com o apoio do JUnit fazem uso de algumas anotações de uso geral:

  * **@Test**. Principal anotação. Indica que o método anotado contém testes.
  * **@After**. Identifica método para ser executado após cada método de teste, indicado pela anotação **@Test**. Efeito simétrico à anotação **@Before**.
  * **@AfterClass**. Identifica método _static_ para ser executado após a execução de todos os métodos de teste da classe em questão. Ou seja, é executado uma única vez para cada instância da classe de teste, após a execução de todos os métodos de teste.
  * **@Before**. Identifica método a ser executado antes da execução de todo método de teste. Ou seja, será executado quantas vezes forem o número de métodos de teste (uma vez antes de cada teste). Efeito simétrico à anotação **@After**.
  * **@BeforeClass**. Identifica método _static_ que será executado uma única vez por instância da classe que contém os testes e antes da execução de qualquer método de teste. Efeito simétrico ao da anotação **@AfterClass**.


# Exemplo #

Abaixo segue o código contido em [Anotacoes.java](http://exemplos.googlecode.com/svn/trunk/junit/src/Anotacoes.java). A classe abaixo tem o único propósito de ilustrar didaticamente como anotações podem ser empregadas em favor dos testes de unidade usando o JUnit. A execução desta classe irá apenas facilitar a compreensão das funções de cada anotação.

```
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Anotacoes {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Uma única vez antes de qualquer teste");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Uma única vez após todos os testes");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Antes de todo teste");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Após todo teste");
    }
	
    @Test
    public void testSimples() {
        System.out.println("Teste propriamente dito");
    }
	
    @Test(expected=Exception.class)
    public void testOutro() throws Exception {
        System.out.println("Um outro teste");
        throw new Exception();
    }
}
```

A execução irá produzir na saída padrão (_o que não é boa prática de teste_) a mensagem "Uma única vez antes de qualquer teste", decorrente da execução do método `setUpBeforeClass()`. Observe que o método pode ter outro identificador. Sabe-se que esta mensagem será exibida antes de qualquer outra ação porque esta é a única sentença do método que será executado antes de qualquer teste da classe, o que é indicado pela anotação **@BeforeClass**.

Em seguida é exibida a mensagem "Antes de todo teste". Esta mensagem é impressa pelo método `setUp()`. Este método, que poderia possuir outro identificador, está anotado por **@Before**, o que significa que o método em questão será executado uma vez antes da execução de cada teste da classe. Imediatamente após esta classe é executado um método anotado por **@Test**. Neste caso, o método `testSimples()`.

Após a execução de `testSimples()` segue a execução do método `tearDown()`. Este método será executado após a execução de todo método de teste, ou seja, todo método anotado por **@Test**. Isto ocorre porque `tearDown()` está anotado por **@After**, o que indica que deve ser executado após a execução de todo teste da classe.

A execução dos métodos anotados por **@Before** e **@After** ocorre, respectivamente, antes e após a execução de todo método de teste, anotado por **@Test**. Quando não mais existirem métodos de teste a serem executados, será executado o método `tearDownAfterClass()`. Este é o método executado não por este identificador, mas porque está anotado por **@AfterClass**.

# Considerações finais #
Anotações são úteis para indicar atividades que devem ser executadas em momentos distintos da execução dos testes. Quando devem ser empregadas? Sempre que se fizerem necessárias. Ou seja, não há nenhum problema com uma classe de testes que possuem apenas métodos de teste, ou seja, métodos anotados por **Test**.