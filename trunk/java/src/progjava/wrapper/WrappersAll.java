package progjava.wrapper;
public class WrappersAll {
    public static void main(String[] args) {
	Number[] n = { new Byte((byte)1), new Short((short)1), new Integer(1),
		       new Long(1), new Float(1f), new Double(1d) };

	for (Number a : n)
	    for (Number b : n)
		if (a.equals(b))
		    System.out.println(a.getClass().getName() 
				       + " " + b.getClass().getName());
    }
}
