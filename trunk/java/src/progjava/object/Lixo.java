package progjava.object;

public class Lixo {
    int n;
    
    public Lixo(int n) {
        this.n = n;
    }
    
    protected void finalize() {
        System.out.println(n);
    }
}