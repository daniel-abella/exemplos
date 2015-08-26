# Introdução #

Código de teste, em geral, está organizado da seguinte forma:

  * Criação do "contexto" para execução do teste
  * Experimentação do código a ser testado
  * Verificar se a experimentação produz os resultados esperados
  * Remoção do "contexto" criado para teste

# Detalhes #

A criação do contexto do teste pode ser feito por método ou para todos os testes de uma classe. No primeiro caso, basta anotar o método que estabelece o contexto com a anotação **@Before**. Caso contrário, a criação do contexto pode ser anotada por método com a anotação **@BeforeClass**. Observe que, caso nenhuma destas anotações seja empregada, então será necessário criar o contexto antes da execução de cada teste.

Para ilustrar, imagine que o teste de determinada classe faz uso de extensa seqüência de caracteres devidamente elaborada e armazenada em um arquivo. Para testar tal código, o método que lê a seqüência de caracteres do arquivo e a guarda em memória pode ser anotado por **@BeforeClass**. Antes que cada método faça alterações destrutivas na seqüência lida do arquivo, o que obrigaria uma nova leitura antes de cada teste, um método anotado por **@Before** pode copiar a seqüência lida para a seqüência que será de fato manipulada pelo teste. O esboço abaixo ilustra este exemplo.

```
public class CaracteresManipulacaoTest {
    private String sequenciaOriginal;
    private StringBuffer sequencia; // Modificada a cada teste

    @BeforeClass
    public static void leSequenciaExtensaDeArquivo() {
        // Lê seqüência e deposita em 'sequenciaOriginal'
    }

    @Before
    public void copiaSequenciaOriginal() {
        // Copia seqüência original para 'sequencia'
    }

    @Test
    public void testPropriamenteDito() {
        // Teste que usa 'sequencia' original e altera seu conteúdo
        // Após experimentação, métodos assert são esperados
    }

    @Test 
    public void testOutroTeste() {
        // Usa 'sequencia' com o conteúdo original e não aquele
        // disponível após a execução de outros testes
        // Após experimentação, métodos assert são esperados
    }
}
```

O exemplo acima faz uso dos métodos **leSequenciaExtensaDeArquivo()** e **copiaSequenciaOriginal()** para estabelecer o contexto para os testes em **testPropriamenteDito()** e **testOutroTeste()**. Observe que após o contexto estabelecido, neste caso, disponibilizar em **sequencia** a seqüência de caracteres empregada para teste, o código que manipula esta seqüência deverá ser experimentado e, logo em seguida, os resultados verificados. Esta verificação é feita por meio de métodos **assert**. São as execuções destes métodos que garantem o comportamento esperado ou reportam que o resultado esperado não foi obtido.

Após a verificação dos resultados, o contexto criado deve ser removido. Neste caso não há muito o que fazer, pois a memória empregada para armazenar a seqüência será eliminada pelo _garbage collector_ de Java, não restando mais o que fazer. Observe, contudo, que se tivéssemos empregando, por exemplo, uma conexão com um banco de dados, este seria o momento oportuno para fechar a conexão.

# Considerações finais #
Criar código de teste significa não apenas exercitar o código testado e verificar os resultados. Em geral, antes que possa ser executado, todo um "contexto" deve ser criado, variáveis iniciadas com valores apropriados, arquivos abertos e outras. Após a execução dos testes, também é apropriado remover o contexto criado, ou seja, fechar arquivos, fechar conexões com SGBD e/ou outras operações que foram necessárias para a execução do teste e que agora precisam ser terminadas. Usando o JUnit, tem-se as anotações **@Before** para estabelecer o contexto antes de cada teste, ou seja, método anotado por **@Test**, e **@BeforeClass** para estabelecer o contexto para a execução de todos os testes de uma determinada classe, conforme foi ilustrado. A remoção do contexto pode ser realizada por métodos anotados por **@After** e **@AfterClass**.