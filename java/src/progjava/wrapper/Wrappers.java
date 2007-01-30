/*
 * Wrappers.java vers�o 1.0 16/10/2003 
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.wrapper;

public class Wrappers {
    public static void main(String[] args) {
        Float f1 = new Float(1.0f);
        Float f2 = new Float(1.0D);
        Float f3 = new Float(f2.toString());

        assert f1.floatValue() == f2.floatValue();
        assert f2.floatValue() != f3.floatValue();
    }
}
