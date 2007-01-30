package progjava.fim;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class List1 {
	static void faz(List l) {
		Map<Number, String> ln = (Map) l;
	}

	public static void main(String[] args) {
		ArrayList<Integer> ali = new ArrayList<Integer>();
		List<Integer> li = ali;
		List<String> ln = (List) li;
		List<List<Double>> ln2 = (List) ali;
		List<Number> lln = (List) li;
		faz(li);
		faz(ali);
	}
}
