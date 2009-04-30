package jfx15;

function acumulados(capital : Number, taxa : Number, meses : Number) : Number {
    var total = capital;
    var contador = meses;
    while (contador > 0) {
        total = total + (total * taxa);
        contador = contador - 1;
    }

    return total;
}

println(acumulados(1,0.02,1));