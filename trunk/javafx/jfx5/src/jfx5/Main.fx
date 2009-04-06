package jfx5;

def numeros:Number[] = [ 1, 2, 3, 4, 5 ];
println(numeros);
println({var total = 0; for (n in numeros) total+=n; total});

def muitos:Integer[] = [1..100];

function soma(v:Integer[]) : Integer {
    var total:Integer = 0;
    for (n in v) total+=n;
    total; // mesmo que "return total;"
}

println(soma(muitos));

