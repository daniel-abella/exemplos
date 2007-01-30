package progjava.heranca.overriding;

import java.io.FileNotFoundException;
import java.io.IOException;

class Base {
    
    public void fazia() {}
    
    static Base faz() throws IOException {
        return new Base();
    }
}

abstract class AbstractBase1 extends Base {
    
    static protected AbstractBase1 faz() {
        return new Base11();
    }
}

class Base11 extends AbstractBase1 {
    static public Base11 faz() throws RuntimeException {
        return new Base11();
    }
}

class Base2 extends Base {
    static public Base2 faz() throws FileNotFoundException {
        return new Base2();
    }    
}

public class E01 {
    
    public static void main(String... args) throws Exception {
        Base b2 = new Base2();
        System.out.println(Base2.faz().getClass().getName());
    }
}
