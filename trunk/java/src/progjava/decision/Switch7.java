package progjava.decision;
/*
 * Switch7.java vers�o 1.0 02/10/2003
 * Copyright (c) 2003 F�bio Lucena
 */

public class Switch7 {
    public static void main(String[] args) {
        char c = 'b';
        switch (c) {
        case 'b':
            System.out.print("2");
        default:
            System.out.print("default"); break;
        case 250:
            System.out.print("2");
        }
    }
}
