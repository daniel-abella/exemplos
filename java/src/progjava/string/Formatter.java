package progjava.string;

public class Formatter {
    public static void main(String [] args) {
	java.util.Formatter f = new java.util.Formatter();
	f.format("%S","a beleza da vida");
	System.out.println(f);
    }
}
