/*
 * BitwiseComplement.java vers�o 1.0 18/09/2003
 * Copyright (c) 2003 F�bio Lucena
 */

package progs.bitwise;

public class BitwiseComplement {
    public static void main(String[] args) {
        boolean b = true;
        for (byte i = -128; i != 127; i++) {
            b &= (~i == ((-i) - 1));
        }
        System.out.println(b);
    }
}
