/*
 * Base.java vers�o 1.0 07/10/2003 
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.oo;

public class Base {
    public void faz() {}
}

class Derivada extends Base {
    public void faz(int i) {}
}

class TestaHeranca {
    public static void main(String[] args) {
        Base d = new Derivada();
        d.faz();
    }
}
