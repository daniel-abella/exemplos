package progjava.iteracao;

public class ForSimples {
	public static void main(String[] args) {
		for (int x = 2; ++x < 4; System.out.println(x));
		
		for (int i = 0; i < args.length; i++)
			System.out.println(args[i]);
		
		// Código abaixo não compila.
		// i é visível apenas no corpo do laço
		// System.out.println(i);
		
		for (String str : args) 
			System.out.println(str);
		
		// Linha abaixo não compila.
		// str é visível apenas no corpo do for
		//System.out.println(str);
	}
}
