package progjava.initialization;

class X {
    X(long i) {
        System.out.println(i);
    }
}

public class Ordem extends X {
    int l;
    
    Ordem() {
        super((byte) 2);
        l = 2;
    }

}
