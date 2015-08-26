# Introdução #

Em _Pragmatica Unit Testing: In Java with JUnit_, Andrew Hunt e David Thomas definem teste de unidade como "código escrito por um desenvolvedor que exercita um trecho de código pequeno e de uma área específica da funcionalidade do código que está sendo testado". Eles ainda acrescentam que testes de unidade são desenvolvidos para provar que um trecho de código faz o que o desenvolvedor imagina que deveria fazer. Confuso? À medida que realizar exercícios isto se tornará mais claro. Ou seja, mantenha a calma.

Nesta breve introdução são fornecidos os passos básicos para uso do JUnit para a confecção de testes de unidade em Java. O foco, portanto, está na ferramenta (métodos, técnicas e outros elementos são apresentados em outras páginas).

# Onde obter? #
Em http://www.junit.org você poderá obter a versão mais recente, assim como tutoriais acerca do emprego do JUnit. No momento em que este texto é escrito, a versão mais recente é a versão 4.4, fornecido pelo arquivo **junit4.4.zip**.

# Instalação #
Obtenha o arquivo **junit4.4.zip** ou versão mais recente no endereço fornecido acima. Descomprima este arquivo. Será criado o diretório **junit4.4**. Neste diretório criado encontra-se o arquivo **junit-4.4.jar**. Este arquivo **.jar** é empregado tanto para compilar quanto para executar testes de unidade usando o JUnit. Em tempo, os passos que seguem não fazem uso de um ambiente integrado de desenvolvimento como o Eclipse e o NetBeans (tais ferramentas já oferecem suporte ao JUnit sem a necessidade destes passos).

# Primeiro exemplo (cenário trivial) #
Abaixo segue uma classe contendo uma única propriedade e três (3) métodos públicos. O método `adiciona(int valor)` deve acrescentar ao valor retido pela propriedade de instância **valor** o valor fornecido como argumento a este método (em um cenário real provavelmente você não estará criando testes de unidade para tal método, contudo, é suficiente para ilustrar o emprego do JUnit).

```
public class Valor {
    private int valor;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
	
    public void adiciona(int valor) {
        this.valor += valor;
    }
}
```

O teste que verifica se o método `adiciona(int valor)` faz o que deveria estar fazendo é fornecido abaixo. Neste código há duas sentenças `import`. A primeira permite o uso da chamada `assertEquals` no corpo do método de teste `testAdiciona()`. A outra sentença `import` declara a anotação `Test`. É o emprego desta anotação que identifica métodos de teste. Na classe `ValorTest` há apenas um método acompanhado desta anotação e, portanto, há um único teste de unidade implementado por meio do método `testAdiciona`. Todos os métodos de teste devem possuir esta assinatura, ou seja, devem ser públicos, retornar `void` e não recebem nenhum valor como argumento. Não é necessário usar o prefixo `test`, conforme empregado, qualquer nome de método pode ser empregado.

```
import static org.junit.Assert.*;
import org.junit.Test;

public class ValorTest {

    @Test
    public void testAdiciona() {
        Valor v1 = new Valor();
	v1.setValor(1);
        v1.adiciona(2);
	assertEquals(3, v1.getValor());
    }
}
```

O método `assertEquals(int,int)` empregado apenas verifica se o valor esperado `3` é aquele retornado pela operação `v1.getValor()`. Há significativa sobrecarga deste método (veja detalhes [aqui](http://junit.sourceforge.net/javadoc_40/org/junit/Assert.html)).

Conforme comentado acima, `@Test` indica que o método que segue é um teste de unidade, qualquer que seja o nome do método. Contudo, deve ser público, retornar `void` e não deve receber nenhum valor como argumento. É o conteúdo deste método que exercita o código a ser testado e, adicionalmente, verifica se o resultado obtido é o esperado.

Neste exemplo, uma instância de `Valor` é criada, o valor `1` atributo à instância e, em seguida, adicionado o valor `2`. Em conseqüência, é esperado que a propriedade da instância criada possua o valor `3`. É exatamente este resultado esperado que é testado pelo método `assertEquals`.

Até agora simplemente criamos os testes, mas não foi mostrado como testá-los (executá-los). O que é feito a seguir.

# Como executar os testes? #
Será necessário compilar a classe `Valor` e a classe `ValorTest`. Notou o sufixo `Test`? Não é necessário, mas uma convenção geralmente empregada. Situação similar ocorre com o método de teste com o prefixo `test`. Assumindo que os arquivos `Valor.java` e `ValorTest.java` estão disponíveis no diretório corrente, e que o arquivo **junit-4.4.jar** encontra-se no diretório **dir**, então o comando abaixo é suficiente para compilar tais classes (ambiente Windows).

```
javac -cp dir\junit-4.4.jar;. *.java
```

Em Linux,

```
javac -cp dir/junit-4.4.jar:. *.java
```

Para executar os testes é necessário executar o comando seguinte (ambiente Windows)

```
java -cp dir\junit-4.4.jar;. org.junit.runner.JUnitCore ValorTest
```

Em ambiente Linux

```
java -cp dir/junit-4.4.jar:. org.junit.runner.JUnitCore ValorTest
```

A execução dos testes de unidade é realizada pela classe `org.junit.runner.JUnitCore`. O que deve ser executado deve ser fornecido como argumento, ou seja, o nome da classe contendo os testes, neste caso, `ValorTest`. A saída produzida é fornecida abaixo:

```
JUnit version 4.3.1
.
OK (1 test)
```

Neste caso, informa que um único teste foi realizado de forma satisfatória. Naturalmente, para verificar o que o JUnit informa em caso de erro, basta fazer uso de um método assert que falha, por exemplo, `assertEquals(2,3)`. Enquanto esta sentença sempre falha, em cenário real, são os resultados do código testado que possivelmente irão falhar.

# Considerações finais #
Este breve texto introduziu elementos básicos do desenvolvimento e execução de testes de unidade empregando a ferramenta JUnit. Vários outros recursos estão disponíveis, além daqueles apresentados acima. Consulte a documentação disponível tão logo esteja ambientado com o conteúdo aqui apresentado. O livro fornecido na Introdução deste texto também é uma referência sugerida para consulta posterior.