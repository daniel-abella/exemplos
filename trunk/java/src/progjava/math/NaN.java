/*
 * NaN.java vers�o 1.0 16/10/2003 
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.math;

public class NaN {
    public static void main(String[] args) {
        double d1 = Double.NaN;
        double d2 = d1;

        if (d1 == d2) {
            System.out.println("OK");
        } else {
            assert false : "NaN != NaN";
        }
    }
}
