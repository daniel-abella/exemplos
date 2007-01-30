package progjava.colecao;

import java.util.ArrayList;
import java.util.List;

public class AlgumasOperacoes {
	public static void main(String[] args) {
		List<Integer> li = new ArrayList<Integer>();
		System.out.println(li.contains(1));
		System.out.println(li.indexOf(1));
		li.add(1);
		System.out.println(li.contains(1));
		System.out.println(li.indexOf(1));
	}
}
