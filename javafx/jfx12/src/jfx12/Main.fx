package jfx12;

import java.lang.Math;

var a = 3;
var b = 4;
var c = bind Math.sqrt(a*a + b*b);
println(c);
a = 2;
println(c);

var d = bind if (a == b) then "iguais" else "diferentes";
println(d);
a = b;
println(d);