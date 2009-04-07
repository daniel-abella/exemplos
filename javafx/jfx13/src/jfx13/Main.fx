package jfx13;

/*
    Exibe argumentos fornecidos na linha de comandos.
*/
function run(args : String[]) : Void {
    if (sizeof args == 0) {
        println("Nenhum argumento fornecido!");
    } else {
        for (argumento in args)
            println(argumento);
    }
}