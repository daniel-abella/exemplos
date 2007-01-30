package progjava.colecao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListInsercao {
    
    public static void insercoes(List<String> l) {
        for (int i = 0; i < 1000 * 10; i++) {
            l.add(0,String.valueOf(i));
        }
    }
    
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        insercoes(new ArrayList<String>());
        long fim = System.currentTimeMillis();
        System.out.println("ArrayList: " + (fim - inicio));
        
        inicio = fim;
        insercoes(new LinkedList<String>());
        fim = System.currentTimeMillis();
        System.out.println("LinkedList: " + (fim - inicio));               
    }
}
