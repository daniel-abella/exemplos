package progjava.modificador;


class Passageira {
    int x = 1;
    int y = 5;

    boolean igual() {
    	// static n�o pode ser modificador de vari�vel local!
    	// final pode ser modificador de vari�vel local.
        final int y = 2;
        return (this.x != (y - 1));
    }
}