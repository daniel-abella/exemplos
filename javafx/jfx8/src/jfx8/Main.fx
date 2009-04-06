package jfx8;

var referenciado = 4;
var referencia = bind referenciado;
println(referencia);

referenciado = 5;
println(referencia);