package jfx6;

var numeros:Integer[] = [1..10];
var pares = numeros[value | value mod 2 == 0];
println(pares);
println("Tamanho: {sizeof pares}");

var pares2 = pares;
println("Iguais? {pares2 == pares}");

pares2[0] = 1;
println("Iguais? {pares2 == pares}");
println("Original: {pares[0]}  Cópia: {pares2[0]}");