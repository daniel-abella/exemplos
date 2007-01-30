import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class UsoSimples {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Forneca URL e nome da classe");
			return;
		}

		IRestricao ir = null;
		Class c = null;
		try {
			System.out.println("Usando url:    " + args[0]);
			URL[] url = { new URL(args[0]) };
			System.out.println("Usando classe: " + args[1]);
			URLClassLoader loader = new URLClassLoader(url);
			c = loader.loadClass(args[1]);
		} catch (MalformedURLException e) {
			System.out.println("URL invalido");
		} catch (ClassNotFoundException e) {
			System.out.println("classe nao encontrada");
		}

		try {
			ir = (IRestricao) c.newInstance();
		} catch (InstantiationException e) {
			System.out.println("Erro na criação da instancia");
		} catch (IllegalAccessException e) {
			System.out.println("Acesso ilegal");
		}

		System.out.println(ir.satisfaz("Senha"));
	}
}
