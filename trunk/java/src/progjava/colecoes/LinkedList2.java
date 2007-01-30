package progjava.colecoes;
import java.util.*;
public class LinkedList2 {
    static public void main(String ... args) {
	LinkedList ll = new LinkedList();
	System.out.println(ll.size());
	ll.addAll(Arrays.asList(1,1,1,1));
	System.out.println(ll.size());
    }
}
