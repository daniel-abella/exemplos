package progjava.string;

public class MetodosPrincipais {
	public static void main(String[] args) {
		String str = args.length > 0 ? args[0] : "0123456789";
		String cpyStr = "";
		
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));
			cpyStr = cpyStr.concat("" + str.charAt(i));
		}
		
		System.out.printf("\n%s\n",cpyStr);
		assert str.equalsIgnoreCase(cpyStr) : "erro";
		
		char[] cars = new char[str.length()];
		int i = 0;
		for (char c : cars)
			cars[i] = cpyStr.charAt(i++);
		
		String cpy2Str = new String(cars);
		for (int j = 0; j < cars.length; j++) ;
		System.out.println(cpy2Str);
		
		String cpy3Str = "";
		i = 0;
		for (char c : cars)
			cpy3Str += cpy2Str.substring(i, i++ + 1);
		
		System.out.println(cpy3Str);
		
		System.out.println("     ".trim().equals(""));
	}
}
