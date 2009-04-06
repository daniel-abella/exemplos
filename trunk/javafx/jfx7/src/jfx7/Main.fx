package jfx7;

var numeros = [1..5];
insert 6 into numeros;
println(numeros);

delete 2 from numeros;
println(numeros);

delete numeros[2];
delete numeros[3];
print("Só ímpares: ");
println(numeros);

println(numeros == [1..<6 step 2]);