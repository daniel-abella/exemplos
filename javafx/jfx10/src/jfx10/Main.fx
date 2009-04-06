package jfx10;

var a1 = 10;
var a2 = 20;
var a3 = bind a2 with inverse;
var a4 = bind soma();

bound function soma() : Integer {
    return a1 + a2 + a3;
}

println(a4); // 50
a1 = 20;
println(a4); // 60
a2 = 0;
println(a4); // 20
a3 = 10;
println(a4); // 40