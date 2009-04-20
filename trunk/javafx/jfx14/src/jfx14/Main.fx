package jfx14;

/**
    Sequência de todos os divisores do número fornecido.
*/
function divisores(n:Integer):Integer[] {
    [1..n][k | n mod k == 0]
}

function primo(n:Integer):Boolean {
    sizeof divisores(n) == 2;
}

print("4: "); println(divisores(4));
print("5: "); println(divisores(5));
print("16: "); println(divisores(16));

println("2: {primo(2)}");
println("3: {primo(3)}");
println("4: {primo(4)}");

