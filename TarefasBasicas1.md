# Tarefas Básicas 1 #

  1. Ambiente-se com o portal [JavaFX](http://javafx.com). Veja vários exemplos em See. O aprendizado é coberto em Learn. Se você quer obter o JavaFX SDK, dentre outras opções, então siga o link Get. Em See um dos itens relevantes é a API (biblioteca de serviços).
  1. Obtenha o exemplo de JavaFX pelo comento `svn export http://exemplos.googlecode.com/svn/trunk/javafx/jfx1 jfx1` Isto criará o diretório **jfx1** no diretório onde este comando for executado. No diretório criado execute `javafxc -d ~/tmp src/jfx1/Main.fx` para compilar o exemplo e, para executá-lo `javafx -cp ~/tmp jfx1.Main`. O resultado pode incluir caracteres não devidamente acentuados. Neste caso, em vez de usar o comando de compilação acima, empregue `javafxc -d ~/tmp -encoding ISO-8859-1 src/jfx1/Main.fx`. Ao executar o código gerado por esta nova compilação, os acentos serão grafados corretamente.
  1. Edite, compile, execute e explique o funcionamento do código abaixo:
```
def nome = "Fulano da Silva";
def saidaFormatada = "Meu nome é {nome}";
println(saidaFormatada);
```
  1. Edite, compile, execute e explique o funcionamento do código abaixo:
```
class X { var x: Integer; }
def varX: X = X {
    x: 10;
}

println(varX.x);
varX.x = 20;
println(varX.x);
```
  1. Edite, compile, execute e explique o funcionamento do código abaixo:
```
def str : String = "A vida é bela!";
def obj : Object = str;
println(obj as String);
println(str as Object);
```
  1. Edite, compile, execute e explique o funcionamento do código abaixo:
```
def str:Object = "teste";
println("{(str as String).toUpperCase()}");
```
  1. Edite, compile, execute e explique o funcionamento do código abaixo:
```
def long:Long = 0xFFFF;
def int:Object = long as Integer;
println(int);
println(int instanceof Integer);
println(int instanceof Long);
```
  1. Edite, compile, execute e explique o funcionamento do código abaixo:
```
println("{%h 16}");
```
  1. Qual a classe em Java que fornece detalhes para tais conversões, como aquela ilustrada acima?
  1. Edite, compile, execute e explique o funcionamento do código abaixo:
```
def hoje = new java.util.Date();
println("Hoje é {%tA hoje}");
```
  1. Edite, compile, execute e explique o funcionamento do código abaixo:
```
import java.util.Locale;

Locale.setDefault(new Locale("pt","BR"));

def hoje = new java.util.Date();
println("Hoje é {%tA hoje}");
```
  1. Edite, compile, execute e explique o funcionamento do código abaixo:
```
println("Usain Bolt (100m em 9.58s)");

var velocidade = 100 / 9.58s.toMillis();
print("Equivale a {%.4f velocidade}m/ms");
println(" ou {%.2f velocidade * 1h.toSeconds()}Km/h");
```
  1. Edite, compile, execute e explique o funcionamento do código abaixo:
```
var nome = [ "Fulano", "Silva" ];
println("Primeiro nome: {nome[0]}");
println("Sobrenome: {nome[1]}");
nome[1] = "da Silva";
println("Sobrenome: {nome[1]}");
println(nome[-1]);
println(nome[67]);
```
  1. Edite, compile, execute e explique o funcionamento do código abaixo:
```
def grande = 1000 * 1000 * 1000;
var n = [1..grande];
println(sizeof n);
var z = for (x in [1..grande]) {
    x
}
```
  1. Edite, compile, execute e explique o funcionamento do código abaixo:
```
var seq = [444 .. 555];
println(sizeof seq);
var seq2 = seq[0..10];
println(sizeof seq2);
println(seq2);
```
  1. Edite, compile, execute e explique o funcionamento do código abaixo:
```
var x : java.util.Date = null;
var y : Integer = null;
```