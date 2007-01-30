package progjava.literal;

public class Literal3 {
    public static void main(String[] args) {
        int i = -2147483648;
        int f = -2147483648 + 1000;
        System.out.println(i + f);
        
        // 100 - 2147483648 causaria erro de compila��o!
        int x = 1000 + -2147483648;
        System.out.println(x);
    }
}