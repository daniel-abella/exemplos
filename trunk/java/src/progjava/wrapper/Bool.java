/*
 * Bool.java vers�o 1.0 16/10/2003 
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.wrapper;

public class Bool {
    public static void main(String[] args) {
        System.out.println(Boolean.parseBoolean("fabio"));
        System.out.println(Boolean.parseBoolean("trUe"));
        System.out.println(Boolean.parseBoolean("TRuE"));
        System.out.println(Boolean.parseBoolean("false"));
        System.out.println(Boolean.parseBoolean("2.3"));
    }
}
