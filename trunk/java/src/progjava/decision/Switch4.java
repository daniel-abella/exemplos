package progjava.decision;
/*
 * Switch4.java vers�o 1.0 30/09/2003
 * Copyright (c) 2003 F�bio Lucena
 */

public class Switch4 {
    public static void main(String[] args) {
        double x = 3;
        switch ((int) x) {
        default:
            System.out.println("NEM 2 NEM 3");
        case 1:
            System.out.println("3");
            break;
        case (byte) 2:
            System.out.println(".2");
            break;
        }
    }
}
