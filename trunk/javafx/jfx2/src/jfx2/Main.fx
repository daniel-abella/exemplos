package jfx2;

// Define constantes (def)
def raio = 3.2 / 2;
def pi = 3.1415926536;
def altura = 30;

// Define vari�veis (var)
var area = pi * raio * raio;

// Efeito similar a System.out.println
// Observe que n�o h� concatena��o.
// Valores s�o "embutidos", como a vari�vel 'area'
FX.println("�rea: {area}");

// N�o � necess�rio fornecer a classe FX
println("Volume (em litros): {area * altura * 1000}");