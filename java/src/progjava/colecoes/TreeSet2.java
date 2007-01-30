package progjava.colecoes;
import java.util.Set;
import java.util.TreeSet;

public class TreeSet2 {
    public static void main(String[] args) {
	Set<String> s = new TreeSet<String>();
	s.add("a");
	s.add("x");
	s.add("t");
	for (String str : s)
	    System.out.println(str);

	Object[] os = s.toArray();
	for (Object str : os)
	    System.out.println(str);
    }
}
