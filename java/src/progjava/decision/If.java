/*
 * If.java vers�o 1.0 30/09/2003 
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.decision;

public class If {
    private static boolean funcao(int i) {
        return (i % 2 == 0) ? true : false;
    }

    public static void main(String[] args) {
        int i = 3;
        if (funcao(i))
            if (i < 5)
                System.out.println("A");
        else
            System.out.println("B");
    }
}
