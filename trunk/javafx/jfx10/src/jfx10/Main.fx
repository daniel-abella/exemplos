package jfx10;

var a1 = 10;
var a2 = 20;
var a3 = bind soma();

bound function soma() : Integer {
    return a1 + a2;
}

println(a3);
a1 = 20;
println(a3);