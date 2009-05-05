package jfx2;

// Define constantes (def)
def raio = 3.2 / 2;
def pi = 3.1415926536;
def altura = 30;

// Define variáveis (var)
var area = pi * raio * raio;

// Efeito similar a System.out.println
// Observe que não há concatenação.
// Valores são "embutidos", como a variável 'area'
FX.println("Área: {area}");

// Não é necessário fornecer a classe FX
println("Volume (em litros): {area * altura * 1000}");