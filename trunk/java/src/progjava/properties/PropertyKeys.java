package progjava.properties;

import java.util.Set;
import java.util.Arrays;

public class PropertyKeys {
    public static void main ( String  args[]  ) {
	Set s = System.getProperties().keySet();
	Object[] chaves = s.toArray();
	Arrays.sort(chaves);
	for (Object o : chaves)
	    System.out.println(o);
    }
}
