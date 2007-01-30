/*
 * ConcatenateSB.java vers�o 1.0 14/10/2003
 * Copyright (c) 2003 F�bio Lucena
 */

package progjava.string;

import java.io.IOException;

public class ConcatenateSB {
    public static void main(String[] args) throws IOException {
        StringBuffer buffer = new StringBuffer("guarda");
        StringBuilder builder = new StringBuilder("guarda");
        
        Appendable ap1 = buffer;
        Appendable ap2 = builder;
        
        ap1.append("-chuva".subSequence(0, 6));
        ap2.append("-chuva".subSequence(0, 6));
        
        System.out.println(((CharSequence)ap1));
        System.out.println(((CharSequence)ap2));
    }
}
