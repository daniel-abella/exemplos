
package progjava.object;
public class O3 {
    public static void main(String[] args) {
        O3 o = new O3();
        System.out.println(o);
        
        String className = o.getClass().getName();
        String hexHashCode = Integer.toHexString(o.hashCode());
		String myToString = className + "@" + hexHashCode;
		System.out.println(myToString);
    }
}