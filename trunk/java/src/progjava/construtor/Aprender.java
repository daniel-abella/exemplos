/*
 * Aprender.java vers�o 1.0 07/10/2003
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.construtor;

public class Aprender {
    Aprender() {
        super();
        System.out.print("A");
    }

    Aprender(int i) {
        this();
        System.out.print("A");
    }

    public static void main(String[] args) {
        new Aprender(1);
    }
}
