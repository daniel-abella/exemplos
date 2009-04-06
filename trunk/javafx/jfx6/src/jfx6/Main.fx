package jfx6;

var numeros:Integer[] = [1..10];
var pares = numeros[value | value mod 2 == 0];
println(pares);