package progjava.arrays;

import java.util.Arrays;
import java.util.List;

public class AnotherArrayAsList {
	static List<Object> faz(Object... objs) {
		return Arrays.asList(objs);
	}
	
	public static void main(String[] args) {
		List<?> x;
		x = faz(1,"a", new AnotherArrayAsList(), true, void.class);
		for (Object obj : x)
			System.out.println(obj.getClass().getName());
	}
}
