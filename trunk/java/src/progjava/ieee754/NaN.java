/*
 * NaN.java vers�o 1.0 04/10/2003 
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.ieee754;

public class NaN {
    public static void main(String[] args) {
        float nan = Float.NaN;
        float f = 0.0f/0;

        System.out.println(nan);
        System.out.println(f);
    }
}
