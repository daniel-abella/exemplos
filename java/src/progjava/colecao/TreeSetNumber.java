package progjava.colecao;

import java.util.TreeSet;

public class TreeSetNumber {
	public static void main(String[] args) {
		TreeSet<Number> tree = new TreeSet<Number>();
		tree.add(108);
		tree.add(Integer.valueOf("-1"));
		tree.add((byte)1);
		tree.add(3.14);
	}
}
