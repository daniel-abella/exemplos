import java.util.*;

public class LinkedHashMap1 {
    public static void main(String[] args) {
	Map<String,String> lhm = new LinkedHashMap<String,String>(10,.7f,true);
	lhm.put("a","cantor a");
	lhm.put("b","cantor b");
	lhm.put("c","cantor c");
	lhm.put("d","cantor d");

	// LRU: a b c d

	lhm.get("b");
	lhm.get("c");

	// LRU: a d b c
	// MRU: c b d a (reverse order of above)

	List<String> ls2 = new LinkedList<String>(lhm.keySet());
	Collections.reverse(ls2);
	Queue<String> q = (Queue) ls2;
	String str = null;
	while (q.size() > 0) {
	    System.out.println(q.element());
	    q.remove();
	}
    }
}
