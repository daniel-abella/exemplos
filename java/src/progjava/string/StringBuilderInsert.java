package progjava.string;
public class StringBuilderInsert {
    public static void main(String[] args) {
	StringBuilder s = new StringBuilder("a");
	for (int i = 2; i < 6; i++)
	    s.append("a");
	
	for (int i = s.length() + 1; i >= -1; i--)
	    try {
		s.insert(i,"#");
	    } catch (Exception e) {
		System.out.printf("\ninsert(%d,\"#\")",i);
	    }
	System.out.println("\n" + s);
    }
}
