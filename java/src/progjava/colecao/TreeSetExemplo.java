package progjava.colecao;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExemplo {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<String>();
        ts.add("Capivara");
        ts.add("Anta");
        ts.add("Gato");
        
        for (Iterator i = ts.iterator(); i.hasNext(); ) {
            System.out.println(i.next());
        }
    }
}
