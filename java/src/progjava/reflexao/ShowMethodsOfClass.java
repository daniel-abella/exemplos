package progjava.reflexao;

import java.lang.reflect.Method;

public class ShowMethodsOfClass extends Object {

	public static void main(String[] args) {
		Method[] m = String.class.getDeclaredMethods();
		for (Method method : m)
			System.out.println(method);
	}
}