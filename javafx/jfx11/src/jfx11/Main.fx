package jfx11;

var primo = 5 on replace valorAnterior {
    println("Corrente: {primo} Anterior: {valorAnterior}");
}

var outro = bind primo on replace {
    println("variável outro foi alterada para {outro}");
};

var terceira = bind primo with inverse;

primo = 7;
terceira = 2;