/*
 * Roupa.java vers�o 1.0 07/10/2003 
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.construtor;

public class Roupa {
    Roupa() {
        System.out.print("R");
    }
}

class Costura {
    Roupa r = new Roupa();

    Costura() {
        System.out.print("C");
    }
}

class Cabide extends Costura {
    Roupa r = new Roupa();

    Cabide() {
        System.out.print("B");
    }
}

class Ordem {
    public static void main(String[] args) {
        new Cabide();
    }
}