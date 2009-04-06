package jfx9;

class Aluno {
    var nome:String;
    var nota:Double;

    override function toString() : String {
        return "{nome} ({nota})";
    }
}

def objeto = bind Aluno {
    nome: objNome
    nota: objNota
}

var objNome = "João";
var objNota = 6.7;

println(objeto);
objNota = 10.0;
println(objeto);