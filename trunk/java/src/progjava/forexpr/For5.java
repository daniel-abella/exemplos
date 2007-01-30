package progjava.forexpr;

public class For5 {
    int x = 0;
    { x = 1; }
    
    For5() {
        System.out.println(x);
        x += 2;
        System.out.println(x);
    }
    
    public static void main(String[] args) {
        For5 o = new For5();
    }
}
