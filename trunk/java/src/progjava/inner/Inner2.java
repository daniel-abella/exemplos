package progjava.inner;

class Externa {
    class Interna {
        public void fazAlgo() {
            System.out.println(++x);
        }
    }
    
    int x = 3;
}

public class Inner2 {
    public static void main(String[] args) {
        new Externa().new Interna().fazAlgo();
    }
}
