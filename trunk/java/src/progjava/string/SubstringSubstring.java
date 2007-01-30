/*
 * SubstringSubstring.java vers�o 1.0 14/10/2003 
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.string;

public class SubstringSubstring {
    public static void main(String[] args) {
        boolean b;
        String sub;
        sub = "casa".substring(1);
        b = sub.equals("casa".substring(3) + "casa".substring(2,4));
        System.out.println(b);
        System.out.println("casa".substring(4).equals(""));
        System.out.println("casa".substring(3,4).equalsIgnoreCase("A"));
    }
}
