package progjava.string;

import java.util.ArrayList;
import java.util.List;

public class StringOutOfMemory {	
	public static void main(String[] args) {
		String str = "";
		List<Byte> set = new ArrayList<Byte>();
		for (int l = 0; l < 10000 * 10000; l++) {
			str = new String(String.valueOf(l));
			str = str.toUpperCase();
			if (l % 1000 == 0) 
				System.out.println(set.size());
			set.add((byte)l);
		}
	}
}
