/*
 * ComparaReferencias.java vers�o 1.0 17/10/2003
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.igualdade;

class A { int a = 1; }
class B { int a = 2; }

public class ComparaReferencias {
    public static void main(String[] args) {
        if ((Object)new A() == new B()) {
            System.out.println("IGUAIS");
        } else {
            System.out.println("DIFERENTES");
        }
    }
}
