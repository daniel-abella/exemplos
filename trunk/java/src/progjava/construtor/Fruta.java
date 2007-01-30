/*
 * Fruta.java vers�o 1.0 08/10/2003 
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.construtor;

public class Fruta {
	Fruta() {}  // Se removido, provoca erro de compila��o!
    Fruta(int i) { this(); }
}

class Laranja extends Fruta {
    Laranja() {
        super(1);
        System.out.println("Laranja");
    }
    public static void main(String[] args) {
        new Laranja();
    }
}
