/*
 * Instrumento.java vers�o 1.0 07/10/2003 
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.construtor;

public class Instrumento {
    Instrumento() {
        System.out.print("I");
    }
}
class Cirurgico extends Instrumento {
    Cirurgico() {
        System.out.print("C");
    }
}

class UsaInstrumento {
    public static void main(String[] args) {
        new Instrumento();
        new Cirurgico();
        new UsaInstrumento();
    }
}
