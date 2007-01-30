/*
 * Grupo.java vers�o 1.0 07/10/2003
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.construtor;

public class Grupo {
    Grupo(int n) {
        System.out.print(n);
    }
}

class Torcida extends Grupo {
    Torcida() {
        super(1);
        System.out.print("Torcida");
    }
}
