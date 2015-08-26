### Onde obter ###
http://exemplos.googlecode.com/svn/trunk/ejb3/jpaZero/


Exemplo: [próximo](http://code.google.com/p/exemplos/wiki/jpaUm).

# Introdução #

Em Java, quando se cria uma instância de uma classe, conforme aquela fornecida abaixo, o objeto correspondente passa a existir na memória da máquina virtual Java onde foi criado.

```
package zero;

public class Pessoa {
    private String nome;
	
    public Pessoa(String nome) {
        this.nome = nome;
    }
	
    public String toString() {
	return nome;
    }
}
```

Se a aplicação em questão não persistir o objeto criado explicitamente, então quando esta aplicação for encerrada, o objeto correspondente também deixa de existir. De fato, antes mesmo da aplicação ser encerrada, o _garbage collector_ pode remover o referido objeto, caso não seja possível ter acesso ao mesmo. O programa abaixo ilustra esta situação.

```
package zero;

public class PessoaApplicacao {
    public static void main(String... args) {
	Pessoa p = new Pessoa("Pedro Silva Souza da Silva");
	System.out.println(p);
	p = null;		
        System.out.println(p);
    }
}
```

Observe que após exibido o nome da pessoa cuja instância é criada na primeira linha, segue a atribuição de **null** para a única referência do objeto criado. Em conseqüência, a partir desta atribuição, não mais é possível recuperar a instância que acabou de ser criada. É possível, em conseqüência, que o _garbage collector_ simplesmente remova o objeto correspondente da memória. Mesmo que isto não ocorra é certa a impossibilidade de recuperar este objeto, pois a aplicação é terminada logo em seguida e, desta forma, estará perdido para sempre o objeto recém-criado.

Em Java, se um objeto deve persistir entre execuções de uma aplicação, então este deve ser explicitamente armazenado em meio estável como disco, possivelmente por meio de um arquivo ou registro em banco de dados, entre outras opções.

# Considerações finais #

Não deixe de consultar outros exemplos da [série](http://code.google.com/p/exemplos/wiki/ejbPersistence) sobre persistência empregando JPA.