package progjava.arrays;

import java.util.Arrays;
import java.util.Comparator;

class Invertido implements Comparator<Byte> {
    public int compare(Byte a, Byte b) {
        return a.equals(b) ? 0 : b - a;
    }
}

class Normal implements Comparator<Byte> {
    public int compare(Byte a, Byte b) {
        return a.equals(b) ? 0 : a - b;
    }
}

public class ArraysSort {
    public static void main(String... args) {
        Byte[] b = { 1, 2, 3, 4, 5 };
        System.out.println(b);
        System.out.println(Arrays.toString(b));
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));
        
        Arrays.sort(b,new Invertido());
        System.out.println(Arrays.toString(b));
        
        Arrays.sort(b, new Normal());
        System.out.println(Arrays.toString(b));
        
        byte[] b1 = { 5, 4, 1, 3, 2, 4, 1, 2, 3, 5 };
        Arrays.sort(b1);
        System.out.println(Arrays.toString(b1));
        
    }
}
