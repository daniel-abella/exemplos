package progjava.boxing;

import java.util.HashSet;
import java.util.Set;

public class CachingObjects {
	public static void main(String[] args) {
		Set<Number> set = new HashSet<Number>();
		long naoAdicionou = 0;
		for (long l = 0; l < 1000 * 1000; l++) {
			if (!set.add(Short.valueOf((short)l)))
				++naoAdicionou;
		}
		System.out.printf("Tamanho: %d (Não adicionados: %2$d", set.size(), naoAdicionou);
	}
}
