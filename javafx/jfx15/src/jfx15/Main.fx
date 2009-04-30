package jfx15;
import java.lang.Math;

function acumulados(capital : Number, taxa : Number, meses : Number) : Number {
    var total = capital;
    var contador = meses;
    while (contador > 0) {
        total = total + (total * taxa) + 1;
        contador = contador - 1;
    }

    return total;
}

println(acumulados(1,0.02,55));
println(700000 / Math.pow(1+0.006,43));
