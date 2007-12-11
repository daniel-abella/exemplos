package progjava.enumeration;

enum MyEnum { a, $, _ }

public class Enum3 {
	public static void main(String[] args) {
		
		
		for (MyEnum e : MyEnum.values())
			System.out.println(e.ordinal() + " " + e);
		MyEnum m1 = MyEnum.a;
		MyEnum m2 = MyEnum.$;
		MyEnum m3 = MyEnum._;
		MyEnum[] ms = { m1, m2, m3 };
		for (Object o : ms)
			System.out.print(o + " ");

		System.out.println();
		System.out.println(m1);
		System.out.println(m1.toString());
		System.out.println(m1.equals(m2));
		System.out.println(m1 == m2);
		System.out.println(m1.equals(MyEnum.a));
	}
}; // no problem
