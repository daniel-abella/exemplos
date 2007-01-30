package progjava.array;

/**
 * Copyright (c) 2003
 * Fábio Nogueira de Lucena
 * Date: 02/08/2003
 * Time: 11:56:59
 */
public class Array10 {
    public static void main(String[] args) {
        System.out.println(new int[2].toString());
        System.out.println(new int[]{}.length);
        
        byte b[] = new byte[10];
        byte bb[][] = new byte[2][];
        b[9] = 1;
        bb[0] = b;
        bb[0][8] = 2;
        System.out.println(bb[1] == null);
        
        // bb = b; Provoca erro!
        // bb[0][0] = b; Provoca erro!
        
        for (int x : bb[0])
        	System.out.print(x + " ");
    }
}
