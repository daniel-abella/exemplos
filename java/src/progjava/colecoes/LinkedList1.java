package progjava.colecoes;
import java.util.LinkedList;
import java.util.List;

public class LinkedList1 {
    public static void main(String[] args) {
	List<Integer> l = new LinkedList<Integer>();
	l.add(1);
	l.add(2);
	l.add(1);
	l.add(2);
	l.add(null);
	l.add(null);
	System.out.println(l.size());
    }
}
