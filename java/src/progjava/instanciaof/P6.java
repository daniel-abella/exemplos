package progjava.instanciaof;

import java.io.File;

public class P6 {
    Object[] objs = { new File(""), "", new Long("1") };
    
    public boolean eUmaString(int i) {
        return (this.objs[i] instanceof String);
    }
    
    public static void main(String[] args) {
        int i = 0;
        P6 obj = new P6();
        while (i < obj.objs.length) {
            System.out.println(obj.eUmaString(i++));
        }
    }
}