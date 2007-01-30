package progjava.colecao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListIteracao {
    public static void insercoes(List<String> l) {
        for (int i = 0; i < 10000; i++) {
            l.add(0,String.valueOf(i));
        }
    }
    
    public static long iteracao(List l) {
        long inicio = System.currentTimeMillis();
        for (Iterator i = l.iterator(); i.hasNext(); ) {
            i.next();
        }
        return (System.currentTimeMillis() - inicio);
    }
    
    public static void main(String[] args) {
        List<String> l = new ArrayList<String>();
        insercoes(l);
        System.out.println("ArrayList: " + iteracao(l));
        
        System.gc();
        l = new LinkedList<String>();
        insercoes(l);
        System.out.println("LinkedList: " + iteracao(l));               
    }
}