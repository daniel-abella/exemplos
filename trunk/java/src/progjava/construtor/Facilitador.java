/*
 * Facilitador.java vers�o 1.0 07/10/2003 
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.construtor;

public class Facilitador {
    Facilitador(int idade) {
        System.out.println(idade);
    }
}

class Professor extends Facilitador {
    Professor() {
        super(getIdade());
    }

    public static int getIdade() {
        return 25;
    }
}
