package progjava.colecao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDuplicata {
    public static void main(String[] args) {
        List<String> al = new ArrayList<String>();
        al.add("Gato");
        al.add("Gato");
        
        for (Iterator<String> i = al.iterator(); i.hasNext(); ) {
            System.out.println(i.next().length());
        }
        
        for (String s : al) {
        	System.out.println(s);
        }
    }
}
