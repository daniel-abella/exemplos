package exp2;

import java.util.HashMap;
import java.util.Map;

public class FrequenciaPalavras {
	private static Map<String, Integer> m = null;
	
	public static int getTotalPalDistintas() {
		return m.size();
	}
	
	public static int getFrequencia(String str) {
		Integer quantidade = m.get(str);
		return quantidade == null ? 0 : quantidade.intValue();
	}
	
	public static void getFrequencia(String[] args) {
		m = new HashMap<String, Integer>();
		
		Integer freq;
		for (int i = 0; i < args.length; i++) {
			freq = m.get(args[i]);
			if (freq == null) { // Primeira ocorrência de args[i]
				freq = 1;
			} else {
				freq++;
			}
			m.put(args[i], freq);
		}
	}
}