package progjava.array;

public class Array12 {
    public static void main(String[] args) {
        byte b[][] = {{-1, 20, -30, 3}, {}, {1, 2, 1}, {3, 4, 5}};
        
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i].length);
        }
    }
}
