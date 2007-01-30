package progjava.string;

public class JLS29 {
	public static void main(String[] args) {
		String llo = "llo";
		String hello = "Hello";
		String hell2 = "He" + llo;
		String hell3 = hell2.intern();

		System.out.println(hello == hell2);
		System.out.println(hell2 == hell3);
		System.out.println("Hello" == "He" + llo);
		System.out.println("Hello" == ("He" + llo).intern());
	}
}
