/*
 * Poligono.java vers�o 1.0 07/10/2003 
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.oo;

public class Poligono {
    public void fazAlgumaCoisa(Poligono p) {
        System.out.print("P");
    }
}

class Triangulo extends Poligono {
    public void fazAlgumaCoisa(Triangulo t) {
        System.out.print("T");
    }
}

class Teste {
    public static void main(String[] args) {
        Triangulo t = new Triangulo();
        t.fazAlgumaCoisa(new Poligono());
        t.fazAlgumaCoisa(t);
    }
}
