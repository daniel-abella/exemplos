/*
 * Widening.java vers�o 1.0 27/09/2003 
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.casting;

public class Widening {
    public static void main(String[] args) {
        long i = 1234556789012345l;
        double d = i;
        System.out.println(i - (long)d);
    }
}
