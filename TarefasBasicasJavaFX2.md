# Exercícios #

  1. Edite, compile, execute e compreenda o trecho de código abaixo:
```
class Ponto {
    var x : Integer;
    var y : Integer;

    public override function toString() : String {
        "({x},{y})"
    }
}

println(new Ponto());
println(Ponto { x : 10 y : 20 });
```
  1. Edite, compile, execute e compreenda o trecho de código abaixo:
```
class Aluno {
    var nome : String;
    var nota1 : Float;
    var nota2 : Float;

    public function media() : Float {
        (nota1 + nota2) / 2;
    }

    public override function toString() : String {
        "{nome} ({media()})"
    }
}

def aluno : Aluno = Aluno { nome: "Fulano" nota1: 5 nota2: 10 }

println(aluno);
aluno.nota1 = 10;
println(aluno);
```
  1. Edite, compile, execute e compreenda o trecho de código abaixo:
```
var x = 1;
def fx = bind x + 10;
println(fx);
x = 2;
println(fx);
```
  1. Edite, compile, execute e compreenda o trecho de código abaixo:
```
var x = 1;
def dobro = bind "O dobro de {x} é {2*x}";
println(dobro);
x = 2;
println(dobro);
```
  1. Edite, compile, execute e compreenda o trecho de código abaixo:
```
var piso = 1;
var horasExtras = 2;
var custoPorHoraExtra = 3;
def salario = bind
        if (horasExtras < 10) {
            piso + horasExtras * custoPorHoraExtra;
        } else {
            if (horasExtras < 40) {
                piso * 2;
            } else {
                0;
            }
        };

println(salario);
piso = 20;
println(salario);
```
  1. Edite, compile, execute e compreenda o trecho de código abaixo:
```
import java.util.Calendar;

var usr = "Fulano";
def msg = bind
        {
            var c =  Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
            if (c < 12) "Bom dia"
            else if (c < 18) "Boa tarde"
            else "Boa noite";
        }

println("{msg}, {usr}");
```
  1. Edite, compile, execute e compreenda o trecho de código abaixo:
```
class Aluno {
    var nome: String;
    public override function toString() : String { nome }
}

class Entrada {
    var aluno: Aluno;
    var notas: Float[];

    public function aprovado(): Boolean {
        var total: Float = 0;
        for (n in notas) total += n;
        if (total / sizeof notas > 5.0) true
        else false;
    }

}

class Turma {
    var entradas: Entrada[];

    public function aprovados() : Aluno[] {
        var felizes = entradas[e | e.aprovado()];
        for (f in felizes) f.aluno;
    }
}

def alunos = [ Aluno { nome: "Fulano" }, Aluno { nome: "Ciclano" }];
def provas : Float[] = [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ];
def matriculas = [ Entrada { aluno: alunos[0] notas: provas[0..4] },
                   Entrada { aluno: alunos[1] notas: provas[5..] } ];
def turma = Turma { entradas: matriculas };
println(turma.aprovados());
turma.entradas[0].notas[0] = 100;
println(turma.aprovados());
```
  1. Edite, compile, execute e compreenda o trecho de código abaixo:
```
class Aluno {
    var nome: String;
    public override function toString(): String { nome }
}

class Entrada {
    var aluno: Aluno;
    var notas: Float[];
    var aprovado: Boolean = bind { media(notas) >= 5.0 }

    public function media(notas: Float[]): Float {
        var total: Float = 0;
        for (n in notas) total += n;
        total / sizeof notas
    }
}

class Turma {
    var entradas: Entrada[];
    var aprovados : Aluno[] = bind {
        var felizes = entradas[e | e.aprovado];
        for (f in felizes) f.aluno;
    }
}

def alunos = [Aluno {nome: "Fulano" }, Aluno {nome: "Ciclano" }];
def turma = Turma {
    entradas: [ Entrada {aluno: alunos[0] notas: [4.5, 5] },
                Entrada {aluno: alunos[1] notas: [5.5, 6] }
    ];
}
def aprovados = bind turma.aprovados;

println(aprovados);

turma.entradas[0].notas[0] = 5;
println(aprovados);

turma.entradas[1].notas[0] = 0;
println(aprovados);
```
  1. Edite, compile, execute e compreenda o trecho de código abaixo:
```
var fahrenheit : Float = 78;
var celcius : Float = bind (fahrenheit - 32) * 5 / 9;

println(celcius);
fahrenheit = 100;
println(celcius);
```
  1. Edite, compile, execute e compreenda o trecho de código abaixo:
```
function toFahrenheit(celcius: Float) : Float {
    9.0 / 5 * celcius + 32;
}

var celcius : Float = 100;
var fahrenheit : Float = bind toFahrenheit(celcius);


println(fahrenheit);
```
  1. Edite, compile, execute e compreenda o trecho de código abaixo:
```
class Ponto {
    var x : Integer;
    var y : Integer;
    public override function toString() : String { "({x},{y})" }
    init { println("instancia criada..."); }
}

var vx : Integer = 0;;

var p1 = bind Ponto { x: 0 y: 0 }
var p2 = bind Ponto { x: bind vx y: 2 }

println(p1);
println(p2);

vx = 10;
println(p1);
println(p2);
```
  1. Edite, compile, execute e compreenda o trecho de código abaixo:
```
var hoje = new java.util.Date();
def msg = bind "{%td hoje}/{%tm hoje}/{%tY hoje}";
println(msg);
```
  1. Edite, compile, execute e compreenda o trecho de código abaixo:
```
var x = 10;
var y = bind x with inverse;

println(x);
println(y);
y = 3;
println(x);
```
  1. Edite, compile, execute e compreenda o trecho de código abaixo:
```
class X {

    var x: Integer;

    override function equals(o: Object): Boolean {
        if (not (o instanceof X)) {
            return false;
        }
        var outroX: X = o as X;
        if (outroX.x == x) {
            true;
        } else {
            false;
        }
    }
}

var x1 : X = X { x : 1 }
var x2 : X = X { x : 2 }

println(x1.equals(x2));
x2.x = 1;
println(x1.equals(x2));
println(x1 == x2);
```
  1. Edite, compile, execute e compreenda o trecho de código abaixo:
```
class Ancestral {    
    init { println("construtor Ancestral"); }
    postinit { println("postinit Ancestral"); }
}

class Derivada extends Ancestral {
    init { println("construtor Derivada"); }
    postinit { println("postinit Derivada"); }
}

Derivada {}
```
  1. Edite, compile, execute e compreenda o trecho de código abaixo:
```
class Exemplo {
    var x : Integer;
    var str : String = "casa";
    var status : Boolean;

    public function analise() : Void {
        if (not isInitialized(x)) {
            println("x não inicializada");
        }

        if (not isInitialized(str)) {
            println("str não inicializada");
        }

        if (not isInitialized(status)) {
            println("status não inicializada");
        }       
    }
}

Exemplo{}.analise();
Exemplo { x : 2 status : true }.analise();
```
  1. Edite, compile, execute e compreenda o trecho de código abaixo:
```
// Possível equação para cálculo de média
var mediaSimples = function(notas : Float[]) : Float {
    var total = 0.0;
    for (n in notas) {
        total += n;
    }
    total / sizeof notas;
}

// Possível equação para cálculo de média
var professorX = function(notas : Float[]) : Float {
    notas[0] + 0.3 * notas[1] + 0.8 * notas[2];
}

// Equação empregada no cálculo definida por equacao
var equacao : function(Float[]) : Float = mediaSimples;

// Média para um dado aluno (conforme equação e notas)
var media : Float = bind equacao(algumasNotas);

var algumasNotas : Float[] = [ 1, 2, 3 ]; // Notas hipotéticas
println(media);

algumasNotas[0] = 10; // Altera uma nota
println(media);       // Média é alterada

equacao = professorX; // Altera forma de cálculo
println(media);       // Média também é alterada
```
  1. Edite, compile, execute e compreenda o trecho de código abaixo:
```
// Possível equação para cálculo de média
var mediaSimples = function(notas : Float[]) : Float {
    var total = 0.0;
    for (n in notas) {
        total += n;
    }
    total / sizeof notas;
}

// Possível equação para cálculo de média
var professorX = function(notas : Float[]) : Float {
    notas[0] + 0.3 * notas[1] + 0.8 * notas[2];
}

function calculaMedia(notas : Float[], 
    expressao : function(n : Float[]) : Float) : Float {
    if (sizeof notas == 0)
        0
    else
        expressao(notas);
}

var equacao : function(:Float[]) : Float = mediaSimples;

// Média para um dado aluno (conforme equação e notas)
var media : Float = bind calculaMedia(algumasNotas, equacao);

var algumasNotas : Float[] = [ 1, 2, 3 ]; // Notas hipotéticas
println(media);

algumasNotas[0] = 10; // Altera uma nota
println(media);       // Média é alterada

equacao = professorX; // Altera forma de cálculo
println(media);       // Média também é alterada
```
  1. Edite, compile, execute e compreenda o trecho de código abaixo (o que ele faz?):
```
import java.io.File;
import java.lang.System;

function busca(dir: File, search: String): Void {
    var files: File[] = dir.listFiles();
    for (f: File in files) {
        if (f.isFile() and f.getName().endsWith(search)) {
            println(f.getAbsoluteFile());
        } else if (f.isDirectory()) {
            busca(f, search);
        }
    }
}

var raiz: File = new File(System.getProperty("user.dir"));

busca(raiz, FX.getArguments()[0]);
```
  1. Modifique o código abaixo de tal forma que a função executada sobre **f.getAbsoluteFile()** seja fornecida como argumento para a função **busca**.
```
import java.io.File;
import java.lang.System;

function busca(dir: File, search: String): Void {
    var files: File[] = dir.listFiles();
    for (f: File in files) {
        if (f.isFile() and f.getName().endsWith(search)) {
            println(f.getAbsoluteFile());
        } else if (f.isDirectory()) {
            busca(f, search);
        }
    }
}

var raiz: File = new File(System.getProperty("user.dir"));

busca(raiz, FX.getArguments()[0]);
```
  1. Edite, compile, execute e compreenda o trecho de código abaixo:
```
var x = 0;
var y = if (x >= 0) "positivo" else "negativo";
println(y);
```
  1. Edite, compile, execute e compreenda o trecho de código abaixo:
```
for (p in [1..9]) {
    for (s in [1..9]) {
        println("{p} x {s} = {p*s}");
    }
    println("");
}
```
  1. Edite, compile, execute e compreenda o trecho de código abaixo:
```
for (p in [1..9], s in [1..9]) {
    println("{p} x {s} = {p*s}{if (s == 9) '\n' else ' '}");
}
```
  1. Edite, compile, execute e compreenda o trecho de código abaixo:
```
import java.io.File;
import java.lang.System;

function busca(dir: File, search: String): Void {
    var files: File[] = dir.listFiles();
    for (f: File in files where f.isFile() or f.isDirectory()) {
        if (f.isDirectory())
            busca(f, search)
        else if (f.getName().endsWith(search)) {
            println(f.getAbsoluteFile());
        }
    }
}

var raiz: File = new File(System.getProperty("user.dir"));

busca(raiz, FX.getArguments()[0]);
```
  1. Edite, compile, execute e compreenda o trecho de código abaixo:
```
var x = 10 on replace old = novoValor {
    println("Antigo: {old} Novo: {novoValor}");
}

x = 11;
```
  1. Edite, compile, execute e compreenda o trecho de código abaixo:
```
var x = 0;
try {
    println(50/x);
} catch (e:java.lang.Exception) {
    println(e);
} finally {
    println("Finalmente...");
}
```