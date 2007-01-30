package progjava.colecoes;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Set;

public class TreeSet1 implements Comparable<TreeSet1> {
    public int compareTo(TreeSet1 o) {
	System.out.print("# ");
	return 0;
    }

    public static void main(String[] args) {
	Set<TreeSet1> ts = new TreeSet<TreeSet1>();
	ts.add(new TreeSet1());
	ts.add(new TreeSet1());
	System.out.println("\n" + ts.size());

	Set<TreeSet1> s = new HashSet<TreeSet1>();
	s.add(new TreeSet1());
	s.add(new TreeSet1());
	System.out.println("\n" + s.size());
    }
}
    
